const os = require("node:os");
const path = require("node:path");

console.log("platform =", os.platform());
console.log("cwd =", process.cwd());
console.log("current file =", path.basename(__filename));
console.log("node version =", process.version);
