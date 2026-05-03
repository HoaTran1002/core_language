const { performance } = require("node:perf_hooks");

const start = performance.now();
const data = Array.from({ length: 100000 }, (_, index) => index * 2);
const total = data.reduce((sum, value) => sum + value, 0);
const duration = performance.now() - start;

console.log("pid =", process.pid);
console.log("rss_mb =", (process.memoryUsage().rss / 1024 / 1024).toFixed(2));
console.log("duration_ms =", duration.toFixed(3));
console.log("total =", total);
