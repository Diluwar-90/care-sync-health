from abc import ABC, abstractmethod

from app.modules.patient.domain.entities import Patient
import uuid
from uuid import UUID
from app.modules.patient.domain.entities import Patient


class PatientRepository(ABC):
    """Patient repository contract."""

    @abstractmethod
    async def create(
        self,
        patient: Patient,
    ) -> Patient:
        """Persist a patient."""
        raise NotImplementedError

    @abstractmethod
    async def get_by_id(
        self,
        patient_id: UUID,
    ) -> Patient | None:
        """Return patient by id."""
        raise NotImplementedError

    @abstractmethod
    async def get_by_mobile_number(
        self,
        mobile_number: str,
    ) -> Patient | None:
        """Return patient by mobile number."""
        raise NotImplementedError

    @abstractmethod
    async def list(
    self,
    ) -> list[Patient]:
        """Return all active patients."""

    async def update(
    self,
    patient: Patient,
    ) -> Patient:
        """Update patient."""
        raise NotImplementedError

    async def delete(
    self,
    patient_id: UUID,
) -> bool:
        """Soft delete patient."""

