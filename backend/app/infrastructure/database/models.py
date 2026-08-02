"""
Import all ORM models here so SQLAlchemy metadata is populated.

Alembic imports this module before generating migrations.
"""

from app.modules.patient.domain.entities import Patient

__all__ = [
    "Patient",
]