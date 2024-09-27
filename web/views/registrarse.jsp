<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/styles/registro.css">
        <!-- Fuente de Google -->
        <link rel="stylesheet" href="assets/styles/registro.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <title>CitasPasion/registro</title>




    </head>
    <body>
        <!-- Logo y Título -->
        <ul>
            <li><i class="bi bi-fire" id="fire-icon"></i></li>
            <li>P</li>
            <li>A</li>
            <li>S</li>
            <li>I</li>
            <li>O</li>
            <li>N</li>
        </ul>

        <div class="wrapper">
            <h1>Registrarse</h1>

            <!-- Sección de Registro: Correo -->
            <div class="input-box" id="register-section-email">
                <s:form action="registerAction" method="post" onsubmit="event.preventDefault(); showNextSection('register-section-email', 'register-section-code');">
                    <s:label value="Correo Electrónico" cssClass="label" />
                    <s:textfield name="email" 
                                 cssClass="input" 
                                 placeholder="Ingrese su correo" 
                                 onfocus="this.placeholder = ''" 
                                 onblur="this.placeholder = 'Ingrese su correo'" />
                    <s:submit value="Siguiente" cssClass="btn" />
                </s:form>
            </div>

            <!-- Sección de Registro: Código de Verificación -->
            <div class="input-box" style="display: none;" id="register-section-code">
                <s:form action="registerAction" method="post" onsubmit="event.preventDefault(); showNextSection('register-section-code', 'register-section-password');">
                    <s:label value="Código de Verificación" cssClass="label" />
                    <s:textfield name="code" cssClass="input" placeholder="Ingrese su código de verificación" />
                    <s:submit value="Siguiente" cssClass="btn" />
                </s:form>
            </div>

            <!-- Sección de Registro: Contraseña -->
            <div class="input-box" style="display: none;" id="register-section-password">
                <s:form action="registerAction" method="post" onsubmit="event.preventDefault(); showNextSection('register-section-password', 'carousel-section-personal');">
                    <s:label value="Contraseña" cssClass="label" />
                    <s:password name="password" cssClass="input" placeholder="Ingrese su contraseña" />
                    <s:submit value="Siguiente" cssClass="btn" />
                </s:form>
            </div>

            <!-- Sección de Registro: Datos Personales -->
            <div class="input-box" style="display: none;" id="carousel-section-personal">
                <s:form action="registerAction" method="post" onsubmit="event.preventDefault(); showNextSection('carousel-section-personal', 'carousel-section-photos');">
                    <s:label value="Nombre" cssClass="label" />
                    <s:textfield name="firstName" cssClass="input" placeholder="Ingrese su nombre" />
                    <s:label value="Apellido" cssClass="label" />
                    <s:textfield name="lastName" cssClass="input" placeholder="Ingrese su apellido" />
                    <s:label value="Fecha de Nacimiento" cssClass="label" />
                    <s:textfield name="birthDate" cssClass="input" placeholder="DD/MM/AAAA" />
                    <s:label value="Género" cssClass="label" />
                    <s:radio name="gender" list="{'Masculino', 'Femenino'}" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="btn" />
                </s:form>
            </div>

            <!-- Sección de Registro: Fotos -->
            <div class="input-box" style="display: none;" id="carousel-section-photos">
                <s:form action="registerAction" method="post" enctype="multipart/form-data" onsubmit="event.preventDefault(); showNextSection('carousel-section-photos', 'carousel-section-additional');">
                    <s:label value="Foto de Perfil" cssClass="label" />
                    <s:file name="profilePhoto" cssClass="input" />
                    <s:label value="Foto de Portada" cssClass="label" />
                    <s:file name="coverPhoto" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="btn" />
                </s:form>
            </div>

            <!-- Sección de Registro: Información Adicional -->
            <div class="input-box" style="display: none;" id="carousel-section-additional">
                <s:form action="registerAction" method="post">
                    <s:label value="Ubicación" cssClass="label" />
                    <s:textfield name="location" cssClass="input" placeholder="Ingrese su ubicación" />
                    <s:label value="Intereses" cssClass="label" />
                    <s:textfield name="interests" cssClass="input" placeholder="Ingrese sus intereses" />
                    <s:label value="Descripción" cssClass="label" />
                    <s:textfield name="description" cssClass="input" placeholder="Ingrese una breve descripción" />
                    <s:submit value="Finalizar Registro" cssClass="btn" />
                </s:form>
            </div>
        </div>
        <script src="assets/scripts/registrar.js"></script>
    </body>
</html>