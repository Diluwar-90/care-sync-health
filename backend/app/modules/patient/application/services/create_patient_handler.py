from app.modules.patient.application.commands.create_patient import (
    CreatePatientCommand,
)
from app.modules.patient.domain.entities import Patient
from app.modules.patient.domain.exceptions import (
    PatientAlreadyExistsError,
)
from app.modules.patient.domain.interfaces import PatientRepository
from app.modules.patient.application.dto.patient_dto import PatientDTO


class CreatePatientHandler:
    """Handle patient registration."""

    def __init__(
        self,
        repository: PatientRepository,
    ) -> None:
        self._repository = repository

    async def execute(
        self,
        command: CreatePatientCommand,
    ) -> PatientDTO:
        """Execute the create patient use case."""

        dto = command.patient

        existing_patient = await self._repository.get_by_mobile_number(
            dto.mobile_number,
        )

        if existing_patient:
            raise PatientAlreadyExistsError()

        patient = Patient(
            first_name=dto.first_name,
            last_name=dto.last_name,
            gender=dto.gender,
            date_of_birth=dto.date_of_birth,
            mobile_number=dto.mobile_number,
            email=dto.email,
        )

        patient = await self._repository.create(patient)

        return PatientDTO(
            id=patient.id,
            first_name=patient.first_name,
            last_name=patient.last_name,
            gender=patient.gender,
            date_of_birth=patient.date_of_birth,
            mobile_number=patient.mobile_number,
                                            email=patient.email,
)