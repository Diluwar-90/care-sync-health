from fastapi import APIRouter

router = APIRouter(prefix="/api/v1", tags=["API"])


@router.get("/health", summary="Health Check")
async def health_check() -> dict[str, str]:
    """Return the application health status."""
    return {
         "status": "healthy",
         "service": "care-sync-health-backend",
         "version": "0.1.0"
}