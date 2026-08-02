from sqlalchemy.ext.asyncio import AsyncEngine, create_async_engine

from app.config.settings import get_settings


def create_database_engine() -> AsyncEngine:
    """Create the SQLAlchemy async engine."""

    settings = get_settings()

    return create_async_engine(
        settings.database.url,
        echo=False,
    )