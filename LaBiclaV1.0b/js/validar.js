function validar(){
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!document.getElementById("email").value.match(mailformat)){
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



