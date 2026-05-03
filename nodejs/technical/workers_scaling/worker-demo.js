const { Worker } = require("node:worker_threads");
const path = require("node:path");

const worker = new Worker(path.join(__dirname, "fibonacci-worker.js"), {
  workerData: 20,
});

worker.on("message", (message) => {
  console.log("worker result =", message);
});

worker.on("error", (error) => {
  console.error("worker error", error);
});
