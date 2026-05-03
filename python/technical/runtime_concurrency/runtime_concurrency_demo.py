from concurrent.futures import ThreadPoolExecutor
import time


def blocking_task(name: str, delay: float) -> str:
    time.sleep(delay)
    return f"finished {name}"


if __name__ == "__main__":
    with ThreadPoolExecutor(max_workers=2) as executor:
        futures = [
            executor.submit(blocking_task, "io-1", 0.2),
            executor.submit(blocking_task, "io-2", 0.1),
        ]
        for future in futures:
            print(future.result())
