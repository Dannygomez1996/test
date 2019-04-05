
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head id="wrapper">
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="default.css" rel="stylesheet" type="text/css"/>
         
    </head>
    <body id="wrapper">
        <% HttpSession sesionActual;
           sesionActual = request.getSession(true);
           sesionActual.invalidate(); %>
        <div id="header" class="div">
            <p class="pheader">EIF209 Programacion 4 - Examen Parcial</p>
            <p class="pheader">1er ciclo 2019</p>
        </div>
        <div id="ing" class="div">
            <div class="pIngreso">
                <p id="ingreso">Ingreso</p>
            </div>
        </div>
        <section>
            <form action="ServicioLogin" method="post" name="loginForm">
                <div id="containerForm">
                    <label for="username">Id usuario:</label>
                    <input type="text" name="username" required><br>
                    <label for="password">Clave de acceso:</label>
                    <input type="password" name="password" required><br>
                    <button type="submit">Ingresar</button><br>
                </div>
            </form>
        </section>
        
        <div id="fec"></div>
      
    </body>
</html>

