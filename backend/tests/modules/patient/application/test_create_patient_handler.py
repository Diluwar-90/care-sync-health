from datetime import date

import pytest

from app.modules.patient.application.commands.create_patient import (
    CreatePatientCommand,
)
from app.modules.patient.application.dto.create_patient_dto import (
    CreatePatientDTO,
)
from app.modules.patient.application.services.create_patient_handler import (
    CreatePatientHandler,
)
from app.modules.patient.domain.enums import Gender

from .fakes import FakePatientRepository

from app.modules.patient.domain.entities import Patient
from app.modules.patient.domain.exceptions import (
    PatientAlreadyExistsError,
)



@pytest.mark.asyncio
async def test_create_patient_success() -> None:
    """Should create a patient."""

    repository = FakePatientRepository()

    handler = CreatePatientHandler(repository)

    command = CreatePatientCommand(
        patient=CreatePatientDTO(
            first_name="Diluwar",
            last_name="Hossain",
            gender=Gender.MALE,
            date_of_birth=date(1992, 6, 15),
            mobile_number="9876543210",
            email="diluwar@example.com",
        )
    )

    patient = await handler.execute(command)

    assert patient.first_name == "Diluwar"

    assert patient.last_name == "Hossain"

    assert patient.mobile_number == "9876543210"

    assert len(repository.patients) == 1

@pytest.mark.asyncio
async def test_create_patient_duplicate_mobile_number() -> None:
    """Should raise exception when mobile number already exists."""

    repository = FakePatientRepository()

    existing_patient = Patient(
        first_name="Existing",
        last_name="Patient",
        gender=Gender.MALE,
        date_of_birth=date(1990, 1, 1),
        mobile_number="9876543210",
        email="existing@example.com",
    )

    await repository.create(existing_patient)

    handler = CreatePatientHandler(repository)

    command = CreatePatientCommand(
        patient=CreatePatientDTO(
            first_name="Diluwar",
            last_name="Hossain",
            gender=Gender.MALE,
            date_of_birth=date(1992, 6, 15),
            mobile_number="9876543210",
            email="diluwar@example.com",
        )
    )

    with pytest.raises(PatientAlreadyExistsError):
        await handler.execute(command)