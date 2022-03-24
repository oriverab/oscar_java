<%-- 
    Document   : listarClientes
    Created on : 24/02/2022, 07:32:46 AM
    Author     : SENA
--%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="../pieycuerpo/menu.jsp" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" rel="stylesheet" crossorigin="anonymous">
        <link href="https://cdn.datatables.net/1.11.4/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.js"  crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js" crossorigin="anonymous" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js" crossorigin="anonymous" type="text/javascript"></script>
        <script src="../../../public/JS/table.js" type="text/javascript"></script>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="copyright" content="MACode ID, https://macodeid.com">

  <title>DigiGram - Free Agency Template</title>

  <link rel="stylesheet" href="public/vendor/animate/animate.css">

  <link rel="stylesheet" href="public/css/bootstrap.css">

  <link rel="stylesheet" href="public/css/maicons.css">

  <link rel="stylesheet" href="public/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="public/css/theme.css">
        
        <script>
$(document).ready(function() {
    $('#example').DataTable();
} );</script>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="page-section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-6 py-3 wow fadeInUp">
            <h2 class="title-section">Get in Touch</h2>
            <div class="divider"></div>
            
        
        
        <div>
            <a href="agregar_mascota.htm"><button class="btn btn-light border-dark">registrar Nueva Persona</button></a>
        
        <table id="example" class="table table-striped table-bordered" style="width:80%" name="example">
        <thead>
           
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>raza</th>
                <th>tipo_animal</th>
                <th>foto</th>
                <th>acciones</th>
                <th>acciones</th>
                 
            </tr>
        </thead>
        <tbody>
             <u:forEach items="${mascotas}" var="mascotas">
            <tr> 
                <td><u:out value="${mascotas.id}"></u:out></td>
                <td><u:out value="${mascotas.nombre}"></u:out></td>
                <td><u:out value="${mascotas.raza}"></u:out></td>
                <td><u:out value="${mascotas.tipo_animal}"></u:out></td>
                <td><img src='<u:url value="${mascotas.fotos}"/>' whidth="50px" height="50px"/></td>     
                <td><a href="delete_mascota.htm?id=${mascotas.id}"><button>delete</button></a> </td>
                <td><a href="update_mascota.htm?id=${mascotas.id}&fotoOld=${mascotas.fotos}"><button>update</button></a> </td>
               
            </tr>
             </u:forEach>
        </tfoot>
        
    </table>
       
        
            </div>
        
                   
        </div>
        </div>
      </div> <!-- .container -->
    </div> <!-- .page-section -->
        
        
    <%@include file ="../pieycuerpo/pie.jsp" %>

       
    </body>
</html>

























 