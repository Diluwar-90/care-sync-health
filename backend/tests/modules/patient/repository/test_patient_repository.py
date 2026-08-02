from datetime import date

import pytest

from app.modules.patient.domain.entities import Patient
from app.modules.patient.domain.enums import Gender
from app.modules.patient.infrastructure.repository.patient_repository import (
    SQLAlchemyPatientRepository,
)

import uuid

unique = uuid.uuid4().hex[:8]


@pytest.mark.asyncio
async def test_create_patient(db_session) -> None:
    repository = SQLAlchemyPatientRepository(db_session)

    patient = Patient(
        first_name="Diluwar",
        last_name="Hossain",
        gender=Gender.MALE,
        date_of_birth=date(1992, 6, 15),
        mobile_number=f"999{unique[:7]}",
        email=f"test-{unique}@example.com",
)

    created = await repository.create(patient)

    await db_session.commit()

    assert created.id is not None