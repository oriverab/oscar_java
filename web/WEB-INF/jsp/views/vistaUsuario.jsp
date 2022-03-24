<%-- 
    Document   : vistaUsuario
    Created on : 14/02/2022, 09:58:49 AM
    Author     : SENA
--%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lista usuario</h1>
        <%--
        <p>nombre</p>: /**<% String id = (String)request.getAttribute("id");%>
        <% String cedula = (String)request.getAttribute("cedula");%>
        <% String nombre = (String)request.getAttribute("nombre");%>
        <% String telefono = (String)request.getAttribute("telefono");%>
        <% String email = (String)request.getAttribute("email");%>
        
        
        <%= id%>
        <%= cedula%>
        <%= nombre%>
        <%= telefono%>
        <%= email%> 
        --%>
        <h1>Hello World!</h1>
        <u:out value="${id}"></u:out>
        <u:out value="${cedula}"></u:out>
        <u:out value="${nombre}"></u:out>
        <u:out value="${telefono}"></u:out>
        <u:out value="${email}"></u:out>
    </body>
</html>
