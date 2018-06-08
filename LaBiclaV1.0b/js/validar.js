function validar(){
	var u = document.getElementById("user").value;
	var p = document.getElementById("password").value;
	var invalidos = /'+|-+|"+/;
	var validCharsEmail = /[a-z0-9]+[_|.]?[a-z0-9]@[a-z]+.[a-z][a-z][a-z]?$/;
	var resUser = invalidos.test(u);
	var resPassword = invalidos.test(p);
	if(resPassword){
    	alert("Un campo contiene uno o mas caracteres invalidos."); 	
    }else if(!resUser){
    	alert("Formato de correo invalido, intentalo de nuevo");
    }else{
    	alert("Proced to login");
    	document.autenticar.action = "autenticar.controller";
    }
} 

function passIguales(){
	var x = document.getElementById("pass").value;
    var y = document.getElementById("confirmPass").value;
    if(x == y){
    	document.cambiar.action = "changePass.controller";
    }else{
    	alert("Las contraseñas no coinciden.");	
    	x.value = "";
    	y.value = "";
    }
}



