var modal1 = document.getElementById("modal1");
var modal2 = document.getElementById("modal2");
var button1 = document.getElementById("button1");
var button2 = document.getElementById("button2");

button1.onclick = function() {
  modal1.style.display = "block";
}

button2.onclick = function() {
  modal2.style.display = "block";
}

var closeButtons = document.getElementsByClassName("close");
for (var i = 0; i < closeButtons.length; i++) {
  closeButtons[i].onclick = function() {
    var modal = this.parentElement.parentElement;
    modal.style.display = "none";
  }
}

window.onclick = function(event) {
  if (event.target == modal1 || event.target == modal2) {
    event.target.style.display = "none";
  }
}


