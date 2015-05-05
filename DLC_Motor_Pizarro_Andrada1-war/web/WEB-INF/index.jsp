<%-- 
    Document   : index
    Created on : 21/04/2015, 19:47:57
    Author     : Emiliano Andrada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estiloFondo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diseño de Lenguajes de Consulta</title>
    </head>
    <body>
        <h1>Buscador:</h1>
        
        <form method="post" name="buscador" action="http://localhost:8080/DLC_Motor_Pizarro_Andrada-war/buscador">
        
            <input name="buscador" type="text"></input>
            <button name="buscar">Buscar</button>
            
        </form>
        
    </body>
</html>
