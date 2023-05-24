<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <h1>Nuevo Registro</h1>
        <form action="Inicio" method="POST">
            <input type="hidden" name="id" value ="${producto.id}"/>
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${producto.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" name="cantidad" value ="${producto.cantidad}" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="number" name="precio" step="0.01" value="${producto.precio}" /></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td>
                        <input type="text" name="categoria" value="${producto.categoria}" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
            
            
        </form>
        </div>
    </center>
    </body>
</html>
