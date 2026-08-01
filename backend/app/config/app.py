from pydantic import Field
from pydantic_settings import BaseSettings, SettingsConfigDict

from app.config.environment import Environment


class AppSettings(BaseSettings):
    """Application configuration."""

    model_config = SettingsConfigDict(
        env_file=".env",
        extra="ignore",
    )

    env: Environment = Field(
        default=Environment.DEVELOPMENT,
        alias="APP_ENV",
    )

    debug: bool = Field(
        default=True,
        alias="APP_DEBUG",
    )