from datetime import date

from pydantic import BaseModel, ConfigDict, EmailStr, Field

from app.modules.patient.domain.enums import Gender


class CreatePatientRequest(BaseModel):
    """Request body for creating a patient."""

    model_config = ConfigDict(
        extra="forbid",
    )

    first_name: str = Field(
        min_length=2,
        max_length=100,
    )

    last_name: str = Field(
        min_length=2,
        max_length=100,
    )

    gender: Gender

    date_of_birth: date

    mobile_number: str = Field(
        min_length=10,
        max_length=20,
    )

    email: EmailStr | None = None