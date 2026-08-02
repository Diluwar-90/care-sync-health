from dataclasses import dataclass


@dataclass(slots=True, frozen=True)
class ListPatientsQuery:
    """Query to list patients."""