from fastapi import Depends
from sqlalchemy.ext.asyncio import AsyncSession

from app.infrastructure.database.session import get_db_session
from app.modules.patient.application.services.create_patient_handler import (
    CreatePatientHandler,
)
from app.modules.patient.domain.interfaces import PatientRepository
from app.modules.patient.infrastructure.repository.patient_repository import (
    SQLAlchemyPatientRepository,
)
from app.infrastructure.database.unit_of_work import SQLAlchemyUnitOfWork
from app.shared.uow.unit_of_work import UnitOfWork
from app.modules.patient.application.services.get_patient_handler import (
    GetPatientHandler,
)

from app.modules.patient.application.services.list_patients_handler import (
    ListPatientsHandler,
)

from app.modules.patient.application.services.delete_patient_handler import (
    DeletePatientHandler,
)


def get_patient_repository(
    session: AsyncSession = Depends(get_db_session),
) -> PatientRepository:
    """Return patient repository."""

    return SQLAlchemyPatientRepository(session)


def get_create_patient_handler(
    repository: PatientRepository = Depends(get_patient_repository),
) -> CreatePatientHandler:
    """Return create patient handler."""

    return CreatePatientHandler(repository)

def get_unit_of_work(
    session: AsyncSession = Depends(get_db_session),
) -> UnitOfWork:
    """Return Unit of Work."""

    return SQLAlchemyUnitOfWork(session)

def get_get_patient_handler(
    repository: PatientRepository = Depends(get_patient_repository),
) -> GetPatientHandler:
    """Return get patient handler."""

    return GetPatientHandler(repository)

def get_list_patients_handler(
    repository: PatientRepository = Depends(get_patient_repository),
) -> ListPatientsHandler:
    """Return list patients handler."""

    return ListPatientsHandler(repository)

def get_delete_patient_handler(
    repository: PatientRepository = Depends(
        get_patient_repository,
    ),
) -> DeletePatientHandler:
    """Return delete patient handler."""

    return DeletePatientHandler(repository)