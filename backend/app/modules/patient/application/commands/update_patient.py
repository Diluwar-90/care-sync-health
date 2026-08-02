from dataclasses import dataclass
from uuid import UUID

from app.modules.patient.application.dto.update_patient_dto import (
    UpdatePatientDTO,
)


@dataclass(slots=True, frozen=True)
class UpdatePatientCommand:
    """Command to update a patient."""

    patient_id: UUID
    patient: UpdatePatientDTO