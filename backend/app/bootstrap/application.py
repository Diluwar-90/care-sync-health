from fastapi import FastAPI

from app.api.v1.router import router as api_router
from app.config.settings import Settings


def create_application(settings: Settings) -> FastAPI:
    app = FastAPI(
        title="Care Sync Health API",
        description="Production-grade FastAPI backend for the Care Sync Health platform.",
        version="0.1.0",
        debug=settings.app.debug,
    )

    app.include_router(api_router)

    return app