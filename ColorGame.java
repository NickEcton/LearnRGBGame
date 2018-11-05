// var rgb1 = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";
// var rgb2 = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";
// var rgb3 = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";
// var rgb4 = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";
// var rgb5 = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";
// var rgb6 = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";

// var colors = [
// 	rgb1,
// 	rgb2,
// 	rgb3,
// 	rgb4,
// 	rgb5,
// 	rgb6
// ]
var numSquares = 6;
var colors = generateRandomColors(numSquares);
var squares = document.querySelectorAll(".square");
var pickedColor = pickColor();
var colorDisplay = document.getElementById("colorDisplay");
var messageDisplay = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetButton = document.querySelector("#reset");
var modeButtons = document.querySelectorAll(".mode");

// for(var i=0; i<modeButtons.length; i++) {
// 	modeButtons[i].addEventListener("click", function() {
// 		modeButtons[0].classList.remove("selected");
// 		modeButtons[1].classList.remove("selected");
// 		this.classList.add("selected");

// 		this.textContent === "EASY" ? numSquares = 3: numSquares = 6;
// 		reset();

	// 	if(this.textContent === "Easy") {
	// 		numSquares = 3;
	// 	} else {
	// 		numSquares = 6;
	// 	}
	// }
	

		//figure out how many squares to show

		//pick new colors

		//pick a new picked color

		//update page to reflect changes

// 	})
// }

function reset() {
	resetButton.textContent = "New Colors";
	messageDisplay.textContent = "";
	colors = generateRandomColors(numSquares);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for(var i=0; i< squares.length; i++) {
		if(color[i]) {
		squares[i].style.display = "block";
		squares[i].style.backgroundColor = colors[i];
	} else {
		squares[i].style.display = "none";
	}
	h1.style.backgroundColor = "steelblue";

	}
}


easyBtn.addEventListener("click", function() {
	easyBtn.classList.add("selected");
	hardBtn.classList.remove("selected");
	numSquares = 3;
	colors = generateRandomColors(numSquares);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for(var i=0; i<squares.length; i++) {
		if(colors[i]) {
			squares[i].style.backgroundColor = colors[i];
	} else {
		squares[i].style.display = "none";
	}
	}
})

hardBtn.addEventListener("click", function() {
	hardBtn.classList.add("selected");
	easyBtn.classList.remove("selected");
	numSquares = 6;
	colors = generateRandomColors(numSquares);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for(var i=0; i<squares.length; i++) {
		squares[i].style.backgroundColor = colors[i];
		squares[i].style.display = "block";
	}
})

resetButton.addEventListener("click", function() {
	resetButton.textContent = "New Colors";
	messageDisplay.textContent = "";
	colors = generateRandomColors(numSquares);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for(var i=0; i< squares.length; i++) {
		squares[i].style.backgroundColor = colors[i];
	}
	h1.style.backgroundColor = "steelblue";

})


colorDisplay.textContent = pickedColor;


for (var i = 0; i < squares.length; i++) {
	//add initial colors to squares
	squares[i].style.backgroundColor = colors[i];

	//add click listeners to squares
	squares[i].addEventListener("click", function() {
		var clickedColor = this.style.backgroundColor;

	//compares color to pickedColor
	if(clickedColor === pickedColor){
		messageDisplay.textContent = "Correct!";
		changeColors(clickedColor);
		resetButton.textContent = "Play Again?";
		h1.style.backgroundColor = clickedColor;
	} else {
		this.style.backgroundColor = "#232323";
		messageDisplay.textContent = "Try Again";
	}
	})


}

function changeColors(color) {
	for (var i = 0; i < squares.length; i++) {
		squares[i].style.backgroundColor = color;
}
}

function pickColor() {
	var random = Math.floor(Math.random() * colors.length);
	return colors[random];
}

function crazy() {
	var newColor = Math.floor(Math.random() * 256)
	return newColor;
}

function generateRandomColors(num){
	var arr = [];
		for (i=0; i < num; i++) {
			arr[i] = "rgb(" + crazy() +", " + crazy() +", " + crazy() +")";
		}
	return arr;
}

