from datetime import UTC, datetime

from sqlalchemy import DateTime
from sqlalchemy.orm import Mapped, mapped_column


class SoftDeleteMixin:
    """Provides soft delete support."""

    deleted_at: Mapped[datetime | None] = mapped_column(
        DateTime(timezone=True),
        nullable=True,
        default=None,
        index=True

    )

    @property
    def is_deleted(self) -> bool:
        """Return True if the entity has been soft deleted."""
        return self.deleted_at is not None

    def mark_deleted(self) -> None:
        """Mark the entity as soft deleted."""
        self.deleted_at = datetime.now(UTC)