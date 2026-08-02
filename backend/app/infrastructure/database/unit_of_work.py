from sqlalchemy.ext.asyncio import AsyncSession

from app.shared.uow.unit_of_work import UnitOfWork


class SQLAlchemyUnitOfWork(UnitOfWork):
    """SQLAlchemy implementation of Unit of Work."""

    def __init__(
        self,
        session: AsyncSession,
    ) -> None:
        self._session = session

    async def commit(self) -> None:
        """Commit current transaction."""

        await self._session.commit()

    async def rollback(self) -> None:
        """Rollback current transaction."""

        await self._session.rollback()