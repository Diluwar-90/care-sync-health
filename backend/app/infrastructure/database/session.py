from sqlalchemy.ext.asyncio import AsyncEngine, AsyncSession, async_sessionmaker

from app.infrastructure.database.config import create_database_engine
from collections.abc import AsyncGenerator


engine: AsyncEngine = create_database_engine()

SessionLocal = async_sessionmaker(
    bind=engine,
    class_=AsyncSession,
    expire_on_commit=False,
)

async def get_db_session() -> AsyncGenerator[AsyncSession, None]:
    """Provide a database session."""

    async with SessionLocal() as session:
        yield session