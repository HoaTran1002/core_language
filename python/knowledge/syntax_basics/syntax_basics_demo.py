LANGUAGES = ["Java", "Node.js", "Python"]


def describe_language(name: str) -> str:
    return f"Learning {name} fundamentals"


if __name__ == "__main__":
    for language in LANGUAGES:
        print(describe_language(language))
