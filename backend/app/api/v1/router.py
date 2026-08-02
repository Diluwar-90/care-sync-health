from fastapi import APIRouter
from app.config import settings
from app.shared.logging.logger import logger
from app.config.settings import get_settings
from datetime import datetime, UTC
from typing import Any
from app.api.v1.schemas import (
    ApiInformationResponse,
    HealthResponse,
    LivenessResponse,
    ReadinessResponse,
)

router = APIRouter(prefix="/api/v1", tags=["Health"])

@router.get("/", summary="API Information")
async def api_information() -> ApiInformationResponse:
    """Return basic API information."""
    settings = get_settings()

    return ApiInformationResponse(
    service=settings.app.app_name,
    version=settings.app.app_version,
    docs=settings.app.docs_url,
)

@router.get(
    "/health",
    summary="Health Check",
    response_model=HealthResponse,
)
async def health_check() -> HealthResponse:
    """Return the application health status."""

    settings = get_settings()
    uptime = datetime.now(UTC) - settings.app.started_at.replace(tzinfo=UTC)

#     logger.info(
#     "health_check_requested",
#     endpoint="/api/v1/health",
#     method="GET",
    
# )
    logger.info(
    "database_configuration_loaded",
    database_url=settings.database.url,
)
    logger.debug(
    "health_check_debug",
    endpoint="/api/v1/health",
)
            
    return HealthResponse(
    status="healthy",
    started_at=settings.app.started_at,
    uptime_seconds=int(uptime.total_seconds()),
    )

@router.get("/ready", summary="Readiness Check")
async def readiness_check() -> ReadinessResponse:
    """Return the application readiness status."""

    logger.info(
        "readiness_check_requested",
        endpoint="/api/v1/ready",
        method="GET",
    )

    return ReadinessResponse(
    status="ready",
)

@router.get(
    "/live",
    summary="Liveness Check",
    response_model=LivenessResponse,
)
async def liveness_check() -> LivenessResponse:
    """Return the application liveness status."""

    logger.info(
        "liveness_check_requested",
        endpoint="/api/v1/live",
        method="GET",
    )

    return LivenessResponse(
    status="alive",
)