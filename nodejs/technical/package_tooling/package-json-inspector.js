const examplePackage = {
  name: "core-language-demo",
  version: "1.0.0",
  scripts: {
    start: "node app.js",
    test: "node --test",
  },
};

console.log("package name =", examplePackage.name);
console.log("available scripts =", Object.keys(examplePackage.scripts).join(", "));
