from datetime import datetime

from pydantic import BaseModel


class HealthResponse(BaseModel):
    """Health check response."""

    status: str
    started_at: datetime
    uptime_seconds: int

class ReadinessResponse(BaseModel):
    """Readiness check response."""

    status: str

class LivenessResponse(BaseModel):
    """Liveness check response."""

    status: str

class ApiInformationResponse(BaseModel):
    """API information response."""

    service: str
    version: str
    docs: str

