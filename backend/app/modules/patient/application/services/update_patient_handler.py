from app.modules.patient.application.commands.update_patient import (
    UpdatePatientCommand,
)
from app.modules.patient.application.dto.patient_dto import PatientDTO
from app.modules.patient.domain.interfaces import PatientRepository


class UpdatePatientHandler:
    """Handle update patient."""

    def __init__(
        self,
        repository: PatientRepository,
    ) -> None:
        self._repository = repository

    async def execute(
        self,
        command: UpdatePatientCommand,
    ) -> PatientDTO | None:

        patient = await self._repository.get_by_id(
            command.patient_id,
        )

        if patient is None:
            return None

        patient.first_name = command.patient.first_name
        patient.last_name = command.patient.last_name
        patient.gender = command.patient.gender
        patient.date_of_birth = command.patient.date_of_birth
        patient.mobile_number = command.patient.mobile_number
        patient.email = command.patient.email

        patient = await self._repository.update(patient)

        return PatientDTO(
            id=patient.id,
            first_name=patient.first_name,
            last_name=patient.last_name,
            gender=patient.gender,
            date_of_birth=patient.date_of_birth,
            mobile_number=patient.mobile_number,
            email=patient.email,
        )