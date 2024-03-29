<%-- 
    Document   : formUsuario
    Created on : 14/02/2022, 08:40:36 AM
    Author     : SENA
--%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="../pieycuerpo/menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="page-section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-6 py-3 wow fadeInUp">
            <h2 class="title-section">Get in Touch</h2>
            <div class="divider"></div>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.<br> Laborum ratione autem quidem veritatis!</p>
  
            <ul class="contact-list">
              <li>
                <div class="icon"><span class="mai-map"></span></div>
                <div class="content">123 Fake Street, New York, USA</div>
              </li>
              <li>
                <div class="icon"><span class="mai-mail"></span></div>
                <div class="content"><a href="#">info@digigram.com</a></div>
              </li>
              <li>
                <div class="icon"><span class="mai-phone-portrait"></span></div>
                <div class="content"><a href="#">+00 1122 3344 55</a></div>
              </li>
            </ul>
          </div>
          <div class="col-lg-6 py-3 wow fadeInUp">
            <div class="subhead">Contact Us</div>
            <h2 class="title-section">Drop Us a Line</h2>
            <div class="divider"></div>
            
         
           <form:form commandName="usuarios" method="post" enctype="multipart/form-data">
             <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
       
            
            <form:label path="cedula" required="required">Cedula</form:label> <br>
            <form:input class="form-control" path="cedula" required="required"/>Cedula <br><br>
                        
            <form:label path="nombres" required="required">nombre</form:label> <br>
            <form:input path="nombres" class="form-control" required="required"></form:input><br><br>
            
            <form:label path="telefono" required="required">telefono</form:label> <br>
            <form:input path="telefono" class="form-control" required="required"></form:input><br><br>
            
            <form:label path="email" required="required">email</form:label> <br>
            <form:input path="email" class="form-control" required="required"></form:input><br><br>
            <img src='<u:url value="${usuarios.foto}" />' whidth="50px" height="50px"/>
            <form:label path="foto" required="required" >foto</form:label> <br>
            <form:input path="foto" class="form-control" type="file" required="required"></form:input><br><br>
           
            <br>
            <br>
            <input class="btn btn-warning" type="submit" name="btnCrearUsuario"  value="CrearUsuario"/> <br><br>
            <a class="btn btn-darger" href="../index.jsp"><input class="btn btn-danger" type="button" value="Regresar" name="btnRegresar"/></a>
            <a class="btn btn-darger" href="listarClientes.htm"><input class="btn btn-danger" type="button" value="lista Cliente" name="btnRegresar"/></a>

               </div>
        </form:form>
             </div>
           </div>
       </div>
    </div>
</body>

</html>
     <%@include file ="../pieycuerpo/pie.jsp" %>
