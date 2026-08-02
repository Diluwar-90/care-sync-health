from fastapi import FastAPI

from app.api.v1.router import router as api_router
from app.config.settings import Settings
from app.shared.logging.config import configure_logging
from app.shared.logging.logger import logger
from app.shared.exceptions.handlers import register_exception_handlers


def create_application(settings: Settings) -> FastAPI:
    configure_logging(settings)
    logger.info("application_started")

    app = FastAPI(
        title=settings.app.app_name,
        description=settings.app.app_description,
        version=settings.app.app_version,
        debug=settings.app.debug,
        docs_url="/docs",
        redoc_url="/redoc",
        openapi_url="/openapi.json",
        openapi_tags=[
        {
          "name": "Health",
         "description": "Application health and monitoring endpoints.",
        },
    ]
    )
    
    register_exception_handlers(app)

    app.include_router(api_router)

    return app