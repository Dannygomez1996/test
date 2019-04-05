
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Datos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="default.css" rel="stylesheet" type="text/css"/>
        <script src="script.js" type="text/javascript"></script>
    </head>
    <body>
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
        <h2 id="tit">Datos Personales</h2>
        <div id="dat">
              <jsp:useBean class="modelo.dao.GestorEstudiantes" id="g1"></jsp:useBean>
              ${g1.datosEstudiante}
        </div>
        
        <div id="fec" class="div"></div>
    </body>
</html>
