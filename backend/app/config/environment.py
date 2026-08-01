from enum import StrEnum


class Environment(StrEnum):
    """Application runtime environments."""

    DEVELOPMENT = "development"
    TESTING = "testing"
    STAGING = "staging"
    PRODUCTION = "production"