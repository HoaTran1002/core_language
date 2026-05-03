import cProfile
import pstats


def count_primes(limit: int) -> int:
    count = 0
    for number in range(2, limit + 1):
        is_prime = True
        divisor = 2
        while divisor * divisor <= number:
            if number % divisor == 0:
                is_prime = False
                break
            divisor += 1
        if is_prime:
            count += 1
    return count


if __name__ == "__main__":
    profiler = cProfile.Profile()
    profiler.enable()
    result = count_primes(5000)
    profiler.disable()
    print("prime_count =", result)
    stats = pstats.Stats(profiler)
    stats.sort_stats("cumtime").print_stats(5)
