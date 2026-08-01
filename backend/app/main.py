from app.bootstrap.application import create_application
from app.config.settings import get_settings

settings = get_settings()

app = create_application(settings)