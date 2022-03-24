<%-- 
    Document   : formUsuario
    Created on : 14/02/2022, 08:40:36 AM
    Author     : SENA
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="../pieycuerpo/menu.jsp" %>

<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="copyright" content="MACode ID, https://macodeid.com">

  <title>DigiGram - Free Agency Template</title>

  <link rel="stylesheet" href="public/vendor/animate/animate.css">

  <link rel="stylesheet" href="public/css/bootstrap.css">

  <link rel="stylesheet" href="public/css/maicons.css">

  <link rel="stylesheet" href="public/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="public/css/theme.css">
    </head>
 
</html>
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
            
           <form:form commandName="usuarioBean" method="post" enctype="multipart/form-data">
             <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
       
           
            
            <form:label path="cedula">Cedula</form:label> <br>
            <form:input class="form-control" path="cedula"/>Cedula <br><br>
                        
            <form:label path="nombres" >nombre</form:label> <br>
            <form:input path="nombres" class="form-control"></form:input><br><br>
            
            <form:label path="telefono" >telefono</form:label> <br>
            <form:input path="telefono" class="form-control"></form:input><br><br>
            
            <form:label path="email" >email</form:label> <br>
            <form:input path="email" class="form-control"></form:input><br><br>
            
            <form:label path="foto" >foto</form:label> <br>
            <form:input path="foto" class="form-control" type="file"></form:input><br><br>
           <br>
            <br>
            <input class="btn btn-warning" type="submit" name="btnCrearUsuario"  value="CrearUsuario"/> <br><br>
            <a class="btn btn-darger" href="../index.jsp"><input class="btn btn-danger" type="button" value="Regresar" name="btnRegresar"/></a>
            <a class="btn btn-darger" href="listarClientes.htm"><input class="btn btn-danger" type="button" value="lista Cliente" name="btnRegresar"/></a>

               </div>
        </form:form>
            
        </div>
        </div>
      </div> <!-- .container -->
    </div> <!-- .page-section -->
        <%@include file ="../pieycuerpo/pie.jsp" %>