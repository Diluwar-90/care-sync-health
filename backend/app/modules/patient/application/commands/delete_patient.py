from dataclasses import dataclass
from uuid import UUID


@dataclass(slots=True, frozen=True)
class DeletePatientCommand:
    """Delete patient."""

    patient_id: UUID  