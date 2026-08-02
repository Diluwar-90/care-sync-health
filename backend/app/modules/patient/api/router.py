from fastapi import APIRouter, Depends, status

from app.modules.patient.api.dependencies import (
    get_create_patient_handler,
)
from app.modules.patient.application.commands.create_patient import (
    CreatePatientCommand,
)
from app.modules.patient.application.dto.create_patient_dto import (
    CreatePatientDTO,
)
from app.modules.patient.application.services.create_patient_handler import (
    CreatePatientHandler,
)
from app.modules.patient.schemas.request import (
    CreatePatientRequest,
)
from app.modules.patient.schemas.response import (
    PatientResponse,
)

from app.modules.patient.api.dependencies import (
    get_create_patient_handler,
    get_unit_of_work,
)

from app.shared.uow.unit_of_work import UnitOfWork

from uuid import UUID

from fastapi import HTTPException

from app.modules.patient.application.queries.get_patient_query import (
    GetPatientQuery,
)
from app.modules.patient.application.services.get_patient_handler import (
    GetPatientHandler,
)
from app.modules.patient.api.dependencies import (
    get_get_patient_handler,
)

from app.modules.patient.application.queries.list_patients_query import (
    ListPatientsQuery,
)

from app.modules.patient.application.services.list_patients_handler import (
    ListPatientsHandler,
)

from app.modules.patient.api.dependencies import (
    get_list_patients_handler,
)

from app.modules.patient.application.commands.delete_patient import (
    DeletePatientCommand,
)

from app.modules.patient.application.services.delete_patient_handler import (
    DeletePatientHandler,
)

from app.modules.patient.api.dependencies import (
    get_delete_patient_handler,
)

router = APIRouter(
    prefix="/patients",
    tags=["Patients"],                      
)


@router.post(
    "",
    response_model=PatientResponse,
    status_code=status.HTTP_201_CREATED,
)
async def create_patient(                                                   
    request: CreatePatientRequest,
    handler: CreatePatientHandler = Depends(
        get_create_patient_handler,
    ),
    unit_of_work: UnitOfWork = Depends(
        get_unit_of_work,
    ),
) -> PatientResponse:
    """Create a new patient."""

    dto = CreatePatientDTO(
        first_name=request.first_name,
        last_name=request.last_name,
        gender=request.gender,
        date_of_birth=request.date_of_birth,
        mobile_number=request.mobile_number,
        email=request.email,
    )

    patient = await handler.execute(
        CreatePatientCommand(
            patient=dto,
        ),
    )

    await unit_of_work.commit()

    return PatientResponse.model_validate(
    patient,
    from_attributes=True,
)

@router.get(
    "",
    response_model=list[PatientResponse],
)
async def list_patients(
    handler: ListPatientsHandler = Depends(
        get_list_patients_handler,
    ),
) -> list[PatientResponse]:
    """Return all active patients."""

    patients = await handler.execute(
        ListPatientsQuery(),
    )

    return [
        PatientResponse.model_validate(
            patient,
            from_attributes=True,
        )
        for patient in patients
    ]

@router.get(
    "/{patient_id}",
    response_model=PatientResponse,
)
async def get_patient(
    patient_id: UUID,
    handler: GetPatientHandler = Depends(
        get_get_patient_handler,
    ),
) -> PatientResponse:
    """Get patient by id."""

    patient = await handler.execute(
        GetPatientQuery(
            patient_id=patient_id,
        ),
    )

    if patient is None:
        raise HTTPException(
            status_code=404,
            detail="Patient not found.",
        )

    return PatientResponse.model_validate(
        patient,
        from_attributes=True,
    )

@router.delete(
    "/{patient_id}",
    status_code=status.HTTP_204_NO_CONTENT,
)
async def delete_patient(
    patient_id: UUID,
    handler: DeletePatientHandler = Depends(
        get_delete_patient_handler,
    ),
    unit_of_work: UnitOfWork = Depends(
        get_unit_of_work,
    ),
) -> None:
    """Soft delete patient."""

    deleted = await handler.execute(
        DeletePatientCommand(
            patient_id=patient_id,
        ),
    )

    if not deleted:
        raise HTTPException(
            status_code=status.HTTP_404_NOT_FOUND,
            detail="Patient not found.",
        )

    await unit_of_work.commit()

