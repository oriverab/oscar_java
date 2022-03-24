<%-- 
    Document   : agregar_Adopcion
    Created on : 3/03/2022, 07:49:36 PM
    Author     : alexi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
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
            
            <form:form commandName="listaradopciones" method="post">
              <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
            <div class="form-group">
           
                        
            <form:label path="cod">codigo de la consulta</form:label> <br>
            <form:input path="cod" readonly="true"></form:input><br><br>
            
            <form:label path="fecha">fecha</form:label> <br>
            <form:input path="fecha" type="date"></form:input><br><br>
            <form:label  path="id_usuario" >Nombre usuario</form:label>
            <br>
            <form:select  path="id_usuario">
                      <u:forEach var="datosus" items="${listarusuario}">
                            <option value="${datosus.id}">${datosus.nombres}</option> 
                       </u:forEach>
            </form:select>
            <br><br>
            
            <form:label  path="id_mascota" >Nombre </form:label>
            <br>
            <form:select  path="id_mascota" >
                      <u:forEach var="datos" items="${listarMascotas}">
                            <option value="${datos.id}">${datos.nombre}</option> 
                       </u:forEach>
            </form:select>
        
            <form:button name="enviar" Class="btn btn-warning">enviar</form:button> <br><br>
            <br>
            <br>
            
               </div>
        </form:form>
          
            
        </div>
        </div>
      </div> <!-- .container -->
    </div> <!-- .page-section -->
    
    <%@include file ="../pieycuerpo/pie.jsp" %>