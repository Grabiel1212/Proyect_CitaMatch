<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/styles/registro.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <title>CitasPasion/registro</title>
    </head>
    <body>
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

            <s:form action="registrar" method="post" enctype="multipart/form-data" id="registro-form">

                <!-- Sección de Registro: Correo -->
                <div class="input-box" id="register-section-email">
                    <s:label value="Correo Electrónico" cssClass="label" />
                    <s:textfield name="bean.email" cssClass="input" id="email-input" placeholder="Ingrese su correo" />
                    <!-- Botón con función AJAX para validar correo -->
                    <button type="button" class="btn" onclick="validarCorreo();">Siguiente</button>
                </div>

                <!-- Sección de Registro: Código de Verificación -->
                <div class="input-box" style="display: none;" id="register-section-code">
                    <s:label value="Código de Verificación" cssClass="label" />
                    <s:textfield name="bean.CodigoVeri" cssClass="input" id="codigo-input" placeholder="Ingrese su código de verificación" />
                    <p>¿Volver a Reenviar el codigo? <a href="registrar">Reenviar</a></p>
                    <!-- Botón para validar código -->
                    <button type="button" class="btn" onclick="validarCodigo();">Siguiente</button>
                </div>

                <!-- Sección de Registro: Contraseña -->
                <div class="input-box" style="display: none;" id="register-section-password">
                    <s:label value="Contraseña" cssClass="label" />
                    <s:password name="bean.password" cssClass="input" placeholder="Ingrese su contraseña" />
                    <s:submit value="Siguiente" cssClass="btn" onclick="showNextSection('register-section-password', 'carousel-section-personal'); return false;" />
                </div>

                <!-- Sección de Registro: Datos Personales -->
                <div class="input-box" style="display: none;" id="carousel-section-personal">
                    <s:label value="Nombre" cssClass="label" />
                    <s:textfield name="bean.nombre" cssClass="input" placeholder="Ingrese su nombre" />
                    <s:label value="Apellido" cssClass="label" />
                    <s:textfield name="bean.apellido" cssClass="input" placeholder="Ingrese su apellido" />
                    <s:label value="Fecha de Nacimiento" cssClass="label" />
                    <s:textfield name="bean.fechaN" cssClass="input" placeholder="AAAA/MM/DD" />
                    <s:label value="Edad" cssClass="label" />
                    <s:textfield name="bean.edad" cssClass="input" placeholder="Ingrese su edad" />
                    <s:label value="Género" cssClass="label" />
                    <s:radio name="bean.genero" list="{'M', 'F'}" cssClass="input" />
                    <s:submit value="Siguiente" cssClass="btn" onclick="showNextSection('carousel-section-personal', 'carousel-section-photos'); return false;" />
                </div>

                <!-- Sección de Registro: Fotos -->
                <div class="input-box" style="display: none;" id="carousel-section-photos">
                    <s:label value="Foto de Perfil" cssClass="label" />
                    <s:file name="bean.fotoPerfil" cssClass="form-control" />
                    <s:label value="Foto de Portada" cssClass="label" />
                    <s:file name="bean.fotoPortada" cssClass="form-control"/>
                    <s:submit value="Siguiente" cssClass="btn" onclick="showNextSection('carousel-section-photos', 'carousel-section-additional'); return false;" />
                </div>

                <!-- Sección de Registro: Información Adicional -->
                <div class="input-box" style="display: none;" id="carousel-section-additional">
                    <s:label value="Ubicación" cssClass="label" />
                    <s:textfield name="bean.ubicacion" cssClass="input" placeholder="Ingrese su ubicación" />
                    <s:label value="Intereses" cssClass="label" />
                    <s:textfield name="bean.intereses" cssClass="input" placeholder="Ingrese sus intereses" />
                    <s:label value="Descripción" cssClass="label" />
                    <s:textfield name="bean.descripcion" cssClass="input" placeholder="Ingrese una breve descripción" />
                    <s:submit value="Registrar" cssClass="btn btn-primary"/>
                </div>
            </s:form>
        </div>

        <!-- Mostrar mensajes de error -->
        <div id="error-message" style="color: red; display: none;"></div>

        <script src="assets/scripts/registrar.js"></script>
        <script>
            function validarCorreo() {
                var email = document.getElementById('email-input').value;
                if (email === '') {
                    document.getElementById('error-message').innerHTML = 'Por favor, ingrese su correo electrónico.';
                    document.getElementById('error-message').style.display = 'block';
                    return;
                }
                var xhr = new XMLHttpRequest();
                xhr.open('POST', '${pageContext.request.contextPath}/ValidarCorreo', true);
                xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                xhr.onload = function () {
                    if (xhr.status === 200) {
                        if (xhr.responseText === 'validado') {
                            document.getElementById('error-message').style.display = 'none';
                            document.getElementById('register-section-email').style.display = 'none';
                            document.getElementById('register-section-code').style.display = 'block';
                        } else if (xhr.responseText === 'input') {
                            document.getElementById('error-message').innerHTML = 'El correo ya está registrado. Por favor, intente con otro.';
                            document.getElementById('error-message').style.display = 'block';
                        } else {
                            document.getElementById('error-message').innerHTML = 'Ocurrió un error al validar el correo.';
                            document.getElementById('error-message').style.display = 'block';
                        }
                    }
                };
                xhr.send('bean.email=' + encodeURIComponent(email));
            }

            function validarCodigo() {
                var codigo = document.getElementById('codigo-input').value;
                if (codigo === '') {
                    document.getElementById('error-message').innerHTML = 'Por favor, ingrese el código de verificación.';
                    document.getElementById('error-message').style.display = 'block';
                    return;
                }
                var xhr = new XMLHttpRequest();
                xhr.open('POST', '${pageContext.request.contextPath}/ValidarCodigoVerificacion', true);
                xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                xhr.onload = function () {
                    if (xhr.status === 200) {
                        if (xhr.responseText === 'correcto') {
                            document.getElementById('error-message').style.display = 'none';
                            document.getElementById('register-section-code').style.display = 'none';
                            document.getElementById('register-section-password').style.display = 'block';
                        } else if (xhr.responseText === 'codigo_incorrecto') {
                            document.getElementById('error-message').innerHTML = 'El código de verificación es incorrecto.';
                            document.getElementById('error-message').style.display = 'block';
                        } else {
                            document.getElementById('error-message').innerHTML = 'Ocurrió un error al validar el código.';
                            document.getElementById('error-message').style.display = 'block';
                        }
                    }
                };
                xhr.send('bean.codigoVeri=' + encodeURIComponent(codigo));
            }
        </script>
    </body>
</html>
