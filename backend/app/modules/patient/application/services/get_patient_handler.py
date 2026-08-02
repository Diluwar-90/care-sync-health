from app.modules.patient.application.dto.patient_dto import PatientDTO
from app.modules.patient.application.queries.get_patient_query import (
    GetPatientQuery,
)
from app.modules.patient.domain.interfaces import PatientRepository


class GetPatientHandler:
    """Handle get patient use case."""

    def __init__(
        self,
        repository: PatientRepository,
    ) -> None:
        self._repository = repository

    async def execute(
        self,
        query: GetPatientQuery,
    ) -> PatientDTO | None:
        patient = await self._repository.get_by_id(
            query.patient_id,
        )

        if patient is None:
            return None

        return PatientDTO(
            id=patient.id,
            first_name=patient.first_name,
            last_name=patient.last_name,
            gender=patient.gender,
            date_of_birth=patient.date_of_birth,
            mobile_number=patient.mobile_number,
            email=patient.email,
        )