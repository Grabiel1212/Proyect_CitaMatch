<%-- 
    Document   : Login
    Created on : 30 ago. 2024, 1:48:39 p. m.
    Author     : GRABIEL
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="<%= request.getContextPath()%>styles/login.css">
        <script src="<%= request.getContextPath()%>scripts/login.js"></script>

        <link rel="stylesheet" href="styles/login.css">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="carousel">
        <div class="slides">
            <!-- Sección de Iniciar Sesión -->
            <div class="slide" id="login-section">
                <h2>Iniciar Sesión</h2>
                <s:form action="loginAction" method="post">
                    <s:label value="Correo Electrónico" cssClass="label" />
                    <s:textfield name="email" cssClass="input" />
                    <s:label value="Contraseña" cssClass="label" />
                    <s:password name="password" cssClass="input" />
                    <s:submit value="Ingresar" cssClass="button" />
                </s:form>
                <p class="toggle">¿No tienes una cuenta? <a href="#" id="show-register">Registrarse</a></p>
            </div>

            <!-- Sección de Registro: Correo -->
            <div class="slide" id="register-section-email" style="display: none;">
                <h2>Registrarse</h2>
                <s:form action="registerAction" method="post">
                    <s:label value="Correo Electrónico" cssClass="label" />
                    <s:textfield name="email" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="button" />
                </s:form>
                <p class="toggle">¿Ya tienes una cuenta? <a href="#" id="show-login">Inicia sesión</a></p>
            </div>

            <!-- Sección de Registro: Código -->
            <div class="slide" id="register-section-code" style="display: none;">
                <h2>Registrarse</h2>
                <s:form action="registerAction" method="post">
                    <s:label value="Código de Verificación" cssClass="label" />
                    <s:textfield name="code" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="button" />
                </s:form>
            </div>

            <!-- Sección de Registro: Contraseña -->
            <div class="slide" id="register-section-password" style="display: none;">
                <h2>Registrarse</h2>
                <s:form action="registerAction" method="post">
                    <s:label value="Contraseña" cssClass="label" />
                    <s:password name="password" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="button" />
                </s:form>
            </div>

            <!-- Sección de Registro: Datos Personales -->
            <div class="slide" id="carousel-section-personal" style="display: none;">
                <h2>Información Personal</h2>
                <s:form action="registerAction" method="post">
                    <s:label value="Nombre" cssClass="label" />
                    <s:textfield name="firstName" cssClass="input" />
                    <s:label value="Apellido" cssClass="label" />
                    <s:textfield name="lastName" cssClass="input" />
                    <s:label value="Fecha de Nacimiento" cssClass="label" />
                    <s:textfield name="birthDate" cssClass="input" />
                    <s:label value="Género" cssClass="label" />
                    <s:radio name="gender" list="{'Masculino', 'Femenino'}" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="button" />
                </s:form>
            </div>

            <!-- Sección de Registro: Fotos -->
            <div class="slide" id="carousel-section-photos" style="display: none;">
                <h2>Fotos</h2>
                <s:form action="registerAction" method="post" enctype="multipart/form-data">
                    <s:label value="Foto de Perfil" cssClass="label" />
                    <s:file name="profilePhoto" cssClass="input" />
                    <s:label value="Foto de Portada" cssClass="label" />
                    <s:file name="coverPhoto" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="button" />
                </s:form>
            </div>

            <!-- Sección de Registro: Información Adicional -->
            <div class="slide" id="carousel-section-additional" style="display: none;">
                <h2>Información Adicional</h2>
                <s:form action="registerAction" method="post">
                    <s:label value="Ubicación" cssClass="label" />
                    <s:textfield name="location" cssClass="input" />
                    <s:label value="Intereses" cssClass="label" />
                    <s:textfield name="interests" cssClass="input" />
                    <s:label value="Descripción" cssClass="label" />
                    <s:textfield name="description" cssClass="input" />
                    <s:submit value="Finalizar Registro" cssClass="button" />
                </s:form>
            </div>
        </div>
    </div>
            <script src="scripts/login.js"></script>
    </body>
</html>
