from enum import StrEnum


class Gender(StrEnum):
    """Supported patient genders."""

    MALE = "male"
    FEMALE = "female"
    OTHER = "other"