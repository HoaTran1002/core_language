import asyncio


async def fetch_mock(name: str, delay: float) -> str:
    await asyncio.sleep(delay)
    return f"done: {name}"


async def main() -> None:
    results = await asyncio.gather(
        fetch_mock("docs", 0.2),
        fetch_mock("examples", 0.1),
    )
    print(results)


if __name__ == "__main__":
    asyncio.run(main())
