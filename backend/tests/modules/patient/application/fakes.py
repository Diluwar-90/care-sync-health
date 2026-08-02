import uuid

from app.modules.patient.domain.entities import Patient
from app.modules.patient.domain.interfaces import PatientRepository


class FakePatientRepository(PatientRepository):
    """In-memory patient repository for unit tests."""

    def __init__(self) -> None:
        self.patients: list[Patient] = []

    async def create(
        self,
        patient: Patient,
    ) -> Patient:
        if patient.id is None:
            patient.id = uuid.uuid4()

        self.patients.append(patient)

        return patient

    async def get_by_id(
        self,
        patient_id: uuid.UUID,
    ) -> Patient | None:
        for patient in self.patients:
            if patient.id == patient_id:
                return patient

        return None

    async def get_by_mobile_number(
        self,
        mobile_number: str,
    ) -> Patient | None:
        for patient in self.patients:
            if patient.mobile_number == mobile_number:
                return patient

        return None