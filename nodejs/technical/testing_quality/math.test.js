const test = require("node:test");
const assert = require("node:assert/strict");
const { sum } = require("./math");

test("sum adds two numbers", () => {
  assert.equal(sum(2, 3), 5);
});

test("sum handles negative values", () => {
  assert.equal(sum(-1, 1), 0);
});
