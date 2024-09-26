<%-- 
    Document   : PruevaRegistro
    Created on : 26 set. 2024, 1:51:22 p. m.
    Author     : juang
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/styles/registro.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="styles/registro.css">
        <title>CitasPasion/registro</title>
    </head>
    <body>
         <div class="wrapper">
            <h1>Registro</h1>

            <!-- Formulario de registro -->
            <s:form action="registrar" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <s:textfield name="bean.email" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <s:password name="bean.password" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <s:textfield name="bean.nombre" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <s:textfield name="bean.apellido" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="genero">Género:</label>
                    <s:textfield name="bean.genero" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="fechaN">Fecha de Nacimiento:</label>
                    <s:textfield name="bean.fechaN" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group">
                    <label for="fotoPerfil">Foto de Perfil:</label>
                    <s:file name="bean.fotoPerfil" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="fotoPortada">Foto de Portada:</label>
                    <s:file name="bean.fotoPortada" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="ubicacion">Ubicación:</label>
                    <s:textfield name="bean.ubicacion" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="intereses">Intereses:</label>
                    <s:textfield name="bean.intereses" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="descripcion">Descripción:</label>
                    <s:textarea name="bean.descripcion" cssClass="form-control"/>
                </div>

                <s:submit value="Registrar" cssClass="btn btn-primary"/>
            </s:form>
        </div>
    </body>
</html>
