from pydantic_settings import BaseSettings, SettingsConfigDict


class BaseAppSettings(BaseSettings):
    """Base class for all application settings."""

    model_config = SettingsConfigDict(
        env_file=".env",
        extra="ignore",
    )