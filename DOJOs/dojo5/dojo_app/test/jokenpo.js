var expect    = require("chai").expect;
var jokenpo = require("../app/jokenpo");

  describe("Paper vs Rock", function(){
    it("Paper cover Rock", function(){
      expect(jokenpo.play("Rock", "Paper")).to.deep.equal("Paper");
    })
  })

  describe("Rock vs Scissors", function(){
    it("Rock smash Scissors", function() {
      expect(jokenpo.play("Rock","Scissors")).to.deep.equal("Rock");
    })
  })

  describe("Scissors vs Paper", function() {
    it("Scissors Cuts Paper", function() {
      expect(jokenpo.play("Scissors","Paper")).to.deep.equal("Scissors");
    })
  })

  describe("Paper vs Paper", function() {
    it("Paper vs Paper == draw", function() {
      expect(jokenpo.play("Paper", "Paper")).to.deep.equal("Draw");
    })
  })

  describe("Rock vs Rock", function() {
    it("Rock vs Rock == draw", function() {
      expect(jokenpo.play("Rock", "Rock")).to.deep.equal("Draw");
    })
  })

