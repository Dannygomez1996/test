function init(){
    solicitarDatosMatricula("ServicioMatricula", "cursosMatriculados");
    solicitarDatos("ServicioCursos", "cursosDisponibles");
}

function solicitarDatosMatricula(file, tabla){
    fetch(file).then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarTablaMatricula(tabla, datosJSON);
            }
            );
}

function solicitarDatos(file, tabla){
    fetch(file).then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarTabla(tabla, datosJSON);
            }
            );
}

function cargarTabla(tabla, datosJSON){
    var refTabla = document.getElementById(tabla);
    
    if(refTabla){
        
        for(var i = 0; i < datosJSON.cursosDisponibles.length; i++){
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.cursosDisponibles[i].codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.cursosDisponibles[i].nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.cursosDisponibles[i].creditos;
        }
    }
}

function cargarTablaMatricula(tabla, datosJSON){
    var refTabla = document.getElementById(tabla);
    
    if(refTabla){
        
        for(var i = 0; i < datosJSON.cursosMatriculados.length; i++){
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.cursosMatriculados[i].codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.cursosMatriculados[i].nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.cursosMatriculados[i].creditos;
        }
    }
    
}

function seleccionadoDisponibles(){
    var tabla = gdocument.getElementById("tablaMatriculados"); 
    tabla.onclick = highlight;  
    
    fetch(file).then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarTabla(tabla, datosJSON);
            }
            );
}

function doSubmit() 
{ 
window.transfer("register.jsp","_self"); 
} 

var inicializarHora = function(){
    var fechaActual = new Date();
    var tiempoHoras = fechaActual.getHours();
    var tiempoMinutos = fechaActual.getMinutes();
    var tiempoSegundos = fechaActual.getSeconds();
    
    var mesActual = fechaActual.getMonth();
    var diaActual=fechaActual.getDay();
    var diadelMesActual=fechaActual.getDate();
    var aActual=fechaActual.getFullYear();
    var amOpm;
    
    document.getElementById("fec").innerHTML = tiempoHoras+":"+tiempoMinutos+":"+tiempoSegundos;
    
    }
    inicializarHora();
    setInterval(inicializarHora, 1000);