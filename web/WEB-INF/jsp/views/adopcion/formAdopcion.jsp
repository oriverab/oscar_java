<%-- 
    Document   : formMascota
    Created on : 14/02/2022, 09:54:16 AM
    Author     : SENA
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-8">
          
              
          <h1>FORMULARIO MASCOTA</h1>  
                   
          <form:form commandName="mascota" method="post">
              <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
            <div class="form-group">
           
                        
            <form:label path="nombre">nombre</form:label> <br>
            <form:input path="nombre"></form:input><br><br>
            
            <form:label path="raza">raza</form:label> <br>
            <form:input path="raza"></form:input><br><br>
            
            <form:label path="tipo_animal">email</form:label> <br>
            <form:input path="tipo_animal"></form:input><br><br>
           
            <form:button name="enviar" Class="btn btn-warning">enviar</form:button> <br><br>
            <br>
            <br>
            
               </div>
        </form:form>
           <a class="btn btn-darger" href="index.htm"><input class="btn btn-danger" type="button" value="Regresar" name="btnRegresar"/></a>
       
             </div>
           </div>
       </div>
    </body>
</html>
