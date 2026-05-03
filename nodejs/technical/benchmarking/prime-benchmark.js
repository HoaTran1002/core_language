function countPrimes(limit) {
  let count = 0;

  for (let i = 2; i <= limit; i++) {
    let isPrime = true;
    const sqrt = Math.floor(Math.sqrt(i));

    for (let j = 2; j <= sqrt; j++) {
      if (i % j === 0) {
        isPrime = false;
        break;
      }
    }

    if (isPrime) count++;
  }

  return count;
}

function runBenchmark(limit, iterations, warmup) {
  // Warm-up
  for (let i = 0; i < warmup; i++) {
    countPrimes(limit);
  }

  const times = [];
  let result = 0;

  for (let i = 0; i < iterations; i++) {
    const start = process.hrtime.bigint();
    result = countPrimes(limit);
    const end = process.hrtime.bigint();

    const elapsedMs = Number(end - start) / 1_000_000;
    times.push(elapsedMs);
  }

  const avg = times.reduce((a, b) => a + b, 0) / times.length;
  const min = Math.min(...times);
  const max = Math.max(...times);

  console.log("Node.js Benchmark");
  console.log("Prime count =", result);
  console.log("Times (ms) =", times.map((v) => v.toFixed(3)).join(", "));
  console.log("Avg (ms)   =", avg.toFixed(3));
  console.log("Min (ms)   =", min.toFixed(3));
  console.log("Max (ms)   =", max.toFixed(3));
}

const LIMIT = 200000;
const ITERATIONS = 5;
const WARMUP = 3;

runBenchmark(LIMIT, ITERATIONS, WARMUP);
