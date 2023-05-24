<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    List<Producto> producto = (List<Producto>)request.getAttribute("producto");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Estilo.css" media="screen" />
        <title>Productos</title>
    </head>
    <body>
    <center>
        <div class="principal">
            
            <div class="cabecera">
                    SEGUNDO PARCIAL TEM-742<br>
                    Nombre: Neustan Eliezer Choque Mamani<br>
                    Carnet: 9947416<br>
            </div>
            <h1>Géstion de Productos</h1>
            <p><a href="Inicio?action=add">Nuevo</a></p>
            <table border="1" class="content-table">
                <tr>
                    <th>Id</th>
                    <th>Descripcion</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                     <th>Categoria</th>
                     <th></th>
                     <th></th>
                </tr>
                <c:forEach var="item" items="${producto}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">Editar</a> </td>

                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro?'))">Eliminar</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </center>
    </body>
</html>
