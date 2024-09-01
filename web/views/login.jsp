<%-- 
    Document   : login
    Created on : 31 ago. 2024, 3:51:09 p. m.
    Author     : GRABIEL
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f0f0f0;
            }

            /* Carrusel */
            .carousel {
                width: 100%;
                max-width: 400px;
                margin: auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            /* Diapositiva individual */
            .slide {
                text-align: center;
            }

            /* Estilos del formulario */
            form {
                display: flex;
                flex-direction: column;
            }

            label {
                margin: 10px 0 5px;
            }

            input {
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .button {
                background-color: #4CAF50; /* Color de fondo por defecto */
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 4px;
                transition: background-color 0.3s ease; /* Transición suave para el cambio de color */
            }

            .button:active {
                background-color: #FF5733; /* Color de fondo cuando se presiona */
            }

            button:hover {
                background-color: #0056b3;
            }

            /* Enlaces de alternancia (registro/inicio de sesión) */
            .toggle {
                margin-top: 15px;
            }

            .toggle a {
                color: #007BFF;
                text-decoration: none;
                cursor: pointer;
            }

            .toggle a:hover {
                text-decoration: underline;
            }

        </style>

    </head>

    <body>

        <div class="carousel">
            <div class="slides">
                <!-- Sección de Iniciar Sesión -->
                <div class="slide" id="login-section">
                    <h2>Iniciar Sesión</h2>

                    <s:form action="home" method="post">
                        <s:label value="Correo Electrónico" cssClass="label" />
                        <s:textfield name="email" cssClass="input" />
                        <s:label value="Contraseña" cssClass="label" />
                        <s:password name="password" cssClass="input" />
                        <s:submit value="Ingresar" cssClass="button" title="Ingresar"/>
                    </s:form>


                    <p class="toggle">¿No tienes una cuenta? <a href="#" id="show-register">Registrarse</a></p>
                </div>

                <!-- Sección de Registro: Correo -->
                <div class="slide" id="register-section-email" style="display: none;">
                    <h2>Registrarse</h2>
                    <s:form action="r1" method="post">
                        <s:label value="Correo Electrónico" cssClass="label" />
                        <s:textfield name="email" cssClass="input" />
                        <s:submit value="Siguiente" cssClass="button" />
                    </s:form>
                    <p class="toggle">¿Ya tienes una cuenta? <a href="#" id="show-login">Inicia sesión</a></p>
                </div>

                <!-- Sección de Registro: Código -->
                <div class="slide" id="register-section-code" style="display: none;">
                    <h2>Registrarse</h2>
                    <s:form action="r2" method="post">
                        <s:label value="Código de Verificación" cssClass="label" />
                        <s:textfield name="cod" cssClass="input" />
                        <s:submit value="Siguiente" cssClass="button" />
                    </s:form>
                </div>

                <!-- Sección de Registro: Contraseña -->
                <div class="slide" id="register-section-password" style="display: none;">
                    <h2>Registrarse</h2>
                    <s:form action="r3" method="post">
                        <s:label value="Contraseña" cssClass="label" />
                        <s:password name="password" cssClass="input" />
                        <s:submit value="Siguiente" cssClass="button" />
                    </s:form>
                </div>

                <!-- Sección de Registro: Datos Personales -->
                <div class="slide" id="carousel-section-personal" style="display: none;">
                    <h2>Información Personal</h2>
                    <s:form action="r4" method="post">
                        <s:label value="Nombre" cssClass="label" />
                        <s:textfield name="nombre" cssClass="input" />
                        <s:label value="Apellido" cssClass="label" />
                        <s:textfield name="apellido" cssClass="input" />
                        <s:label value="Fecha de Nacimiento" cssClass="label" />
                        <s:textfield name="fechaN" cssClass="input" />
                        <s:label value="Género" cssClass="label" />
                        <s:radio name="gender" list="{'Masculino', 'Femenino'}" cssClass="input" />
                        <s:submit value="Siguiente" cssClass="button" />
                    </s:form>
                </div>

                <!-- Sección de Registro: Fotos -->
                <div class="slide" id="carousel-section-photos" style="display: none;">
                    <h2>Fotos</h2>
                    <s:form action="r5" method="post" enctype="multipart/form-data">
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
                    <s:form action="r6" method="post">
                        <s:label value="Ubicación" cssClass="label" />
                        <s:textfield name="ubicacion" cssClass="input" />
                        <s:label value="Intereses" cssClass="label" />
                        <s:textfield name="intereses" cssClass="input" />
                        <s:label value="Descripción" cssClass="label" />
                        <s:textfield name="descripcion" cssClass="input" />
                        <s:submit value="Finalizar Registro" cssClass="button" />
                    </s:form>
                </div>
            </div>
        </div>
        <script>
           document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('show-register').addEventListener('click', function (event) {
        event.preventDefault();
        switchSection('login-section', 'register-section-email');
    });

    document.getElementById('show-login').addEventListener('click', function (event) {
        event.preventDefault();
        switchSection('register-section-email', 'login-section');
    });

    document.querySelectorAll('form').forEach(form => {
        form.addEventListener('submit', function (event) {
            const currentSection = this.closest('.slide');
            let nextSection = null;

            if (currentSection.id === 'login-section') {
                // Permitir que el formulario se envíe normalmente (no usar preventDefault)
                return;
            }

            event.preventDefault(); // Evitar que se envíe el formulario automáticamente

            if (currentSection.id === 'register-section-email') {
                nextSection = 'register-section-code';
            } else if (currentSection.id === 'register-section-code') {
                nextSection = 'register-section-password';
            } else if (currentSection.id === 'register-section-password') {
                nextSection = 'carousel-section-personal';
            } else if (currentSection.id === 'carousel-section-personal') {
                nextSection = 'carousel-section-photos';
            } else if (currentSection.id === 'carousel-section-photos') {
                nextSection = 'carousel-section-additional';
            } else {
                return; // Fin del proceso de registro
            }

            switchSection(currentSection.id, nextSection);
        });
    });

    function switchSection(currentId, nextId) {
        document.getElementById(currentId).style.display = 'none';
        document.getElementById(nextId).style.display = 'block';
    }
});

        </script>

    </body>

</html>
