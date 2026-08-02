from abc import ABC, abstractmethod


class UnitOfWork(ABC):
    """Transaction boundary."""

    @abstractmethod
    async def commit(self) -> None:
        """Commit current transaction."""
        raise NotImplementedError

    @abstractmethod
    async def rollback(self) -> None:
        """Rollback current transaction."""
        raise NotImplementedError