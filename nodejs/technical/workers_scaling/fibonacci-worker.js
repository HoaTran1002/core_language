const { parentPort, workerData } = require("node:worker_threads");

function fibonacci(n) {
  if (n < 2) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
}

parentPort.postMessage({
  input: workerData,
  output: fibonacci(workerData),
});
