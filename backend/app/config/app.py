from pydantic import Field
from pydantic_settings import BaseSettings, SettingsConfigDict

from app.config.environment import Environment
from typing import Literal
from datetime import datetime

    
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

    log_level: Literal[
         "DEBUG",
        "INFO",
        "WARNING",
        "ERROR",
        "CRITICAL",
    ] = Field(
    default="INFO",
    alias="APP_LOG_LEVEL",
    )

    app_name: str = Field(
    default="Care Sync Health API",
    )

    app_description: str = Field(
        default="Production-grade FastAPI backend for the Care Sync Health platform.",
    )

    app_version: str = Field(
      default="0.1.0",
    )

    started_at: datetime = Field(
    default_factory=datetime.utcnow,
    
    )

    docs_url: str = "/docs"

class DatabaseSettings(BaseSettings):
    """Database configuration."""

    model_config = SettingsConfigDict(
        env_file=".env",
        extra="ignore",
    )

    url: str = Field(
        default="postgresql+asyncpg://postgres:postgres@localhost:5433/care_sync_health",
        alias="DATABASE_URL",
    )