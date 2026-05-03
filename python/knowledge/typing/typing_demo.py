from typing import Iterable, TypeVar

T = TypeVar("T")


def first_item(items: Iterable[T]) -> T:
    for item in items:
        return item
    raise ValueError("items must not be empty")


if __name__ == "__main__":
    print(first_item(["java", "nodejs", "python"]))
    print(first_item((1, 2, 3)))
