console.log("script start");

setTimeout(() => {
  console.log("setTimeout callback");
}, 0);

Promise.resolve().then(() => {
  console.log("promise microtask");
});

process.nextTick(() => {
  console.log("nextTick callback");
});

console.log("script end");
