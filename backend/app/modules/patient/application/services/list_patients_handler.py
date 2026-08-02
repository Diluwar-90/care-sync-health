from app.modules.patient.application.dto.patient_dto import PatientDTO
from app.modules.patient.application.queries.list_patients_query import (
    ListPatientsQuery,
)
from app.modules.patient.domain.interfaces import PatientRepository


class ListPatientsHandler:
    """Handle list patients."""

    def __init__(
        self,
        repository: PatientRepository,
    ) -> None:
        self._repository = repository

    async def execute(
        self,
        query: ListPatientsQuery,
    ) -> list[PatientDTO]:
        patients = await self._repository.list()

        return [
            PatientDTO(
                id=patient.id,
                first_name=patient.first_name,
                last_name=patient.last_name,
                gender=patient.gender,
                date_of_birth=patient.date_of_birth,
                mobile_number=patient.mobile_number,
                email=patient.email,
            )
            for patient in patients
        ]