var expect    = require("chai").expect;
var converter = require("../app/converter");

describe("Test group", function() {
  
  describe("Hex to RGB conversion", function() {
    it("converts the basic colors", function() {
      var red   = converter.hexToRgb("ff0000");
      var green = converter.hexToRgb("00ff00");
      var blue  = converter.hexToRgb("0000ff");

      expect(red).to.deep.equal([255, 0, 0]);
      expect(green).to.deep.equal([0, 255, 0]);
      expect(blue).to.deep.equal([0, 0, 255]);
    });
  });

  describe("test do test", function() {
    it("test 1", function() {
      expect(converter.testAb()).to.deep.equal(1);
    })
  });

});