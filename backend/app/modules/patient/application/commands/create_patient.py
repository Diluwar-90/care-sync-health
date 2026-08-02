from dataclasses import dataclass

from app.modules.patient.application.dto.create_patient_dto import (
    CreatePatientDTO,
)


@dataclass(slots=True, frozen=True)
class CreatePatientCommand:
    """Command to create a patient."""

    patient: CreatePatientDTO