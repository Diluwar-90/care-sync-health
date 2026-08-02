class PatientError(Exception):
    """Base exception for patient domain."""


class PatientAlreadyExistsError(PatientError):
    """Raised when a patient already exists."""


class PatientNotFoundError(PatientError):
    """Raised when a patient cannot be found."""