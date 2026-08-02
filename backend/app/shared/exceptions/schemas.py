from pydantic import BaseModel


class ErrorResponse(BaseModel):
    """Standard API error response."""

    detail: str