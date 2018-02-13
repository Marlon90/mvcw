function appendText(input) {
	document.getElementById("customConsole").value += input;
}

function clearFields() {
	document.getElementById("articleNumber").value = "";
	document.getElementById("articleId").value = "";
	document.getElementById("articlePrice").value = "";
	document.getElementById("articleCost").value = "";
	document.getElementById("articleName").value = "";
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
	
	var articleId = document.getElementById("articleId");
	var articleName = document.getElementById("articleName");
	var articleNumber = document.getElementById("articleNumber");
	var articlePrice = document.getElementById("articlePrice");
	var articleCost = document.getElementById("articleCost");

	var string = e.target.parentNode.innerText;
	var split = string.split("	");
	var deleteId = split[0];
	var deleteNummer = split[1];
	var deleteName = split[2];
	var deleteCost = split[3];
	var deletePrice = split[4];

	articleId.value = deleteId;
	articleNumber.value = deleteNummer;
	articleName.value = deleteName;
	articleCost.value = deleteCost;
	articlePrice.value = deletePrice;
}
