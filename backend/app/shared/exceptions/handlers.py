from fastapi import FastAPI, HTTPException, Request
from fastapi.responses import JSONResponse
from httpx import request
from app.config import app
from app.shared.logging.logger import logger
from fastapi.exceptions import RequestValidationError
from app.shared.exceptions.schemas import ErrorResponse


def register_exception_handlers(app: FastAPI) -> None:
    """Register global exception handlers."""

    @app.exception_handler(HTTPException)
    async def http_exception_handler(
        request: Request,
        exc: HTTPException,
    ) -> JSONResponse:
        """Handle FastAPI HTTP exceptions."""

        logger.warning(
        "http_exception_handled",
        status_code=exc.status_code,
        detail=exc.detail,
        path=request.url.path,
)

        return JSONResponse(
            status_code=exc.status_code,
            content=ErrorResponse(
            detail=str(exc.detail),
            ).model_dump(),
        )  

    @app.exception_handler(RequestValidationError)
    async def request_validation_exception_handler(
        request: Request,
        exc: RequestValidationError,
    ) -> JSONResponse:
        """Handle request validation errors."""

        logger.warning(
        "request_validation_failed",
        path=request.url.path,
    )

        return JSONResponse(
        status_code=422,
        content={
            "detail": exc.errors(),
        },
    )     