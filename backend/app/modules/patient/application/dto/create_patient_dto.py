from dataclasses import dataclass
from datetime import date

from app.modules.patient.domain.enums import Gender


@dataclass(slots=True, frozen=True)
class CreatePatientDTO:
    """Data required to create a patient."""

    first_name: str
    last_name: str
    gender: Gender
    date_of_birth: date
    mobile_number: str
    email: str | None = None