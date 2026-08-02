from unittest import result
import uuid

from sqlalchemy import select
from sqlalchemy.ext.asyncio import AsyncSession

from app.modules.patient.domain.entities import Patient
from app.modules.patient.domain.interfaces import PatientRepository

from uuid import UUID

from sqlalchemy import select

from tests.modules import patient

from datetime import UTC, datetime


class SQLAlchemyPatientRepository(PatientRepository):
    """SQLAlchemy implementation of PatientRepository."""

    def __init__(
        self,
        session: AsyncSession,
    ) -> None:
        self._session = session

    async def create(
        self,
        patient: Patient,
    ) -> Patient:
        """Persist a patient."""

        self._session.add(patient)

        await self._session.flush()

        await self._session.refresh(patient)

        return patient

    async def get_by_id(
        self,
        patient_id: UUID,
    ) -> Patient | None:
        """Return patient by id."""

        statement = select(Patient).where(
            Patient.id == patient_id,
            Patient.deleted_at.is_(None),
        )

        result = await self._session.execute(statement)

        return result.scalar_one_or_none()

    async def get_by_mobile_number(
        self,
        mobile_number: str,
    ) -> Patient | None:
        """Return patient by mobile number."""

        statement = select(Patient).where(
            Patient.mobile_number == mobile_number,
            Patient.deleted_at.is_(None),
        )

        result = await self._session.execute(statement)

        return result.scalar_one_or_none()


    async def list(
        self,
    ) -> list[Patient]:
        """Return all active patients."""

        statement = (
            select(Patient)
            .where(Patient.deleted_at.is_(None))
            .order_by(Patient.created_at.desc())
        )

        result = await self._session.execute(statement)

        return list(result.scalars().all())

    async def update(
    self,
    patient: Patient,
    ) -> Patient:
        """Update patient."""

        await self._session.flush()

        await self._session.refresh(patient)

        return patient

    async def delete(
    self,
    patient_id: UUID,
    ) -> bool:
        """Soft delete patient."""

        patient = await self.get_by_id(patient_id)

        if patient is None:
            return False

        patient.deleted_at = datetime.now(UTC)

        await self._session.flush()

        return True 