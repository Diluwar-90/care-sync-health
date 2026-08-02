from app.infrastructure.database.base import Base
from app.infrastructure.database.mixins.soft_delete import SoftDeleteMixin
from app.infrastructure.database.mixins.timestamp import TimestampMixin
from app.infrastructure.database.mixins.uuid import UUIDPrimaryKeyMixin


class EntityBase(
    Base,
    UUIDPrimaryKeyMixin,
    TimestampMixin,
    SoftDeleteMixin,
):
    """Base class for all ORM entities."""

    __abstract__ = True