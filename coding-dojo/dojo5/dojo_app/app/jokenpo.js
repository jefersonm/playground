exports.play = function(player1, player2) {
	if (player1 == "Rock" && player2 == "Paper") {
		return "Paper";
	}

	if (player1 == "Rock" && player2 == "Scissors") {
		return "Rock";
	}

	if (player1 == "Scissors" && player2 == "Paper") {
		return "Scissors";
	}
	return "Draw";
};