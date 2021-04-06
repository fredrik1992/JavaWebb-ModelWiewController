

window.addEventListener('DOMContentLoaded', (event) => {
	console.log("before call to function")
assignChoiceToInput();

     
});



function assignChoiceToInput(){
let answer = window.confirm("This Website uses cookies is that alright ?");
if(answer){
	document.getElementById("cookieChoice").value = "yes";
	
}else document.getElementById("cookieChoice").value = "no";


}
