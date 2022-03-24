<%-- 
    Document   : listarClientes
    Created on : 24/02/2022, 07:32:46 AM
    Author     : SENA
--%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        
        <script>
$(document).ready(function() {
    $('#example').DataTable();
} );</script>

        <title>JSP Page</title>
    </head>
    <body>
        
        
        <div>
            <a href="agregar_mascota.htm"><button class="btn btn-light border-dark">registrar Nueva Persona</button></a>
        
        <table id="example" class="table table-striped table-bordered" style="width:100%" name="example">
        <thead>
           
            <tr>
                <th>id</th>
                <th>cedula</th>
                <th>nombre</th>
                <th>telefono</th>
                <th>email</th>
                <th>acciones</th>
                
            </tr>
        </thead>
        <tbody>
             <u:forEach items="${adopcion}" var="mascotas">
            <tr> 
                <td><u:out value="${adopcion.cod}"></u:out></td>
                <td><u:out value="${adopcion.fecha}"></u:out></td>
                <td><u:out value="${adopcion.id_mascota}"></u:out></td>
                <td><u:out value="${adopcion.id_usuario}"></u:out></td>
                <td><a href="delete_adopcion.htm?cod=${adopcion.cod}"><button>delete</button></a> </td>
                <td><a href="update_adopcion.htm?cod=${adopcion.cod}"><button>update</button></a> </td>
                
            </tr>
             </u:forEach>
        </tfoot>
        
    </table>
       
        
            </div>
        
       
        
        
       
       
    </body>
</html>



