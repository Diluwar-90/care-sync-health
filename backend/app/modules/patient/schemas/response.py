from datetime import date
from uuid import UUID

from pydantic import BaseModel, ConfigDict, EmailStr

from app.modules.patient.domain.enums import Gender


class PatientResponse(BaseModel):
    """Patient response."""

    model_config = ConfigDict(
        from_attributes=True,
    )

    id: UUID

    first_name: str

    last_name: str

    gender: Gender

    date_of_birth: date

    mobile_number: str

    email: EmailStr | None