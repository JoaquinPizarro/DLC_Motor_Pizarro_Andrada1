<%-- 
    Document   : Buscador
    Created on : 03/05/2015, 17:33:38
    Author     : Juaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" href="estiloFondo.css">
            <title>Motor de Busqueda</title>
        </head>
        <body>
            <h1><h:outputText value="Buscador: "/></h1>
            <form method="post" name="buscador" action="http://localhost:8080/DLC_Motor_Pizarro_Andrada-war/buscador">
        
            <input name="buscador" type="text"></input>
            <button name="buscar">Buscar</button>
            
        </form>
        </body>
    </html>
</f:view>
