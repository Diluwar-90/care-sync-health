from dataclasses import dataclass
from uuid import UUID


@dataclass(slots=True, frozen=True)
class GetPatientQuery:
    """Query to retrieve a patient."""

    patient_id: UUID