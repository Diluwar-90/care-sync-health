from app.modules.patient.application.commands.delete_patient import (
    DeletePatientCommand,
)
from app.modules.patient.domain.interfaces import (
    PatientRepository,
)


class DeletePatientHandler:
    """Delete patient."""

    def __init__(
        self,
        repository: PatientRepository,
    ) -> None:
        self._repository = repository

    async def execute(
        self,
        command: DeletePatientCommand,
    ) -> bool:
        return await self._repository.delete(
            command.patient_id,
        )