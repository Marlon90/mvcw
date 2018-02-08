function appendText(input) {
	document.getElementById("customConsole").value += input;
}

function checkform(form) {
	// get all the inputs within the submitted form
	var inputs = form.getElementsByTagName('input');
	for (var i = 0; i < inputs.length; i++) {
		// only validate the inputs that have the required attribute
		if (inputs[i].hasAttribute("required")) {
			if (inputs[i].value == "") {
				// found an empty field that is required
				alert("Please fill all required fields");
				return false;
			}
		}
	}
	return true;
}

function clearConsole() {

	var c = document.getElementById("customConsole");
	c.value = "";
}

function getRow(e) {
	var c = document.getElementById("customConsole");
	var string = e.target.parentNode.innerText;
	var split = string.split("	");
	var nummer = split[1];
	var name = split[2];

	c.value = "Ausgewählter Artikel: " + name + " mit Artikelnummer: " + nummer;
}

