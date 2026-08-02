from functools import lru_cache

from app.config.app import AppSettings, DatabaseSettings


class Settings:
    """Root application settings."""

    def __init__(self) -> None:
        self.app: AppSettings = AppSettings()
        self.database: DatabaseSettings = DatabaseSettings()

@lru_cache
def get_settings() -> Settings:
    """Return the cached application settings."""
    return Settings()
