<%-- 
    Document   : vistaMascota
    Created on : 14/02/2022, 11:49:53 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <u:out value="${id}"></u:out>
        <u:out value="${cedula}"></u:out>
        <u:out value="${nombre}"></u:out>
        <u:out value="${telefono}"></u:out>
        <u:out value="${email}"></u:out>
    </body>
</html>
