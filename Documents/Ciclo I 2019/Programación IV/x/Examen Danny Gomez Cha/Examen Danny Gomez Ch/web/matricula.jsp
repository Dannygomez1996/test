
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Matricula</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <script src="script.js" type="text/javascript"></script>
    </head>
    <body onload="init();">
        <div id="header" class="div">
            <p class="pheader">EIF209 Programacion 4 - Examen Parcial</p>
            <p class="pheader">1er ciclo 2019</p>
        </div>
        <div id="bot" class="div">
            <div class="block">
                <a href="index.jsp" class="button">Salir</a>
                <a href="datos.jsp" class="button">Datos Personales</a>
                <a href="matricula.jsp" class="button">Matricular</a>
            </div>
        </div>
        <p id="bot">Seleccione en la lista correspondiente para matricular o eliminar los cursos requeridos</p>
        <h2 id="bot">Matricula</h2>
        
        
        <div id="container">
            <div id="matricular">
                <form action="ServicioMatricula" method = "post">
                    <p>Ingrese curso a matricular: </p>
                    <input type="text" name="codigo">
                    <button type="submit">Matricular</button>
                </form>
            </div>
                
            <div id="desmatricular">
                <form action="ServicioMatricula" method = "post">
                    <p>Ingrese curso a desmatricular: </p>
                    <input type="text" name="desmatricula">
                    <button type="submit">Desmatricular</button>
                </form>
            </div>
        </div>
        <div id="contenedor">
            
            <h3 id="cat1">Cursos Disponibles</h3>
        <h4 id="cat">Cursos Matriculados</h4>
       
        <table id="tablaDisponibles" class="tablaDatos">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Creditos</th>
                   
                </tr>
            </thead>
            <tbody id="cursosDisponibles"> </tbody>
        </table>
            
    
            <table id="tablaMatriculados" class="tablaDatos">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Creditos</th>
                </tr>
            </thead>
            <tbody id="cursosMatriculados"> </tbody>
        </table>
        </div>
    </body>


