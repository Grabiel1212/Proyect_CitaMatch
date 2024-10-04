<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/styles/registro.css" type="text/css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <title>CitasPasion/registro</title>  


        <style>
            /* Estilo del contenedor de la animación */
            .loading-overlay {
                position: fixed; /* Cambiado a fixed para cubrir toda la pantalla */
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: rgba(0, 0, 0, 0.6);
                display: none;
                justify-content: center;
                align-items: center;
                z-index: 1000; /* Asegura que esté por encima de otros elementos */
            }

            /* Estilo del reloj (animación) */
            .spinner {
                border: 5px solid #f3f3f3;
                border-radius: 50%;
                border-top: 5px solid #3498db;
                width: 40px;
                height: 40px;
                animation: spin 1s linear infinite;
            }

            /* Animación de giro */
            @keyframes spin {
                0% {
                    transform: rotate(0deg);
                }
                100% {
                    transform: rotate(360deg);
                }
            }

            /* Estilo del mensaje de "Cargando" */
            .loading-text {
                color: white;
                margin-top: 10px;
            }

            #disco {
                width: 100px; /* Ajusta el tamaño del disco */
                transition: transform 1s; /* Transición para el giro */
                position: absolute; /* Permite posicionarlo en la esquina */
                top: 20px; /* Espacio de 20px desde la parte superior */
                left: 20px; /* Espacio de 20px desde la izquierda */
            }

            .girar {
                animation: girar 2s linear infinite; /* Giro continuo */
            }
            @keyframes girar {
                from {
                    transform: rotate(0deg);
                }
                to {
                    transform: rotate(360deg);
                }
            }
            #gif {
                display: none; /* Ocultar el GIF por defecto */
                width: 300px; /* Ajusta el tamaño del GIF */
                margin-top: 20px; /* Espacio entre el disco y el GIF */
            }
        </style>
    </head>
    <body>
        <div>
            <img id="disco" src="assets/img/disco.png" alt="Disco" onclick="controlarSiguienteCancion()" ondblclick="controlarMusica()">
            <img id="gif" src="assets/img/anime.gif" alt="Chica bailando"> <!-- GIF de la chica bailando -->
        </div>
        <!-- Animación de carga -->
        <div id="loading" class="loading-overlay">
            <div class="spinner"></div>
            <div class="loading-text">Cargando...</div>
        </div>
        <div class="wrapper">    
            <h1>Registrarse</h1>
            <s:form action="registrar" method="post" enctype="multipart/form-data" id="registro-form">

                <!-- Sección de Registro: Correo -->
                <div class="input-box" id="register-section-email">
                    <s:label value="Correo Electrónico" cssClass="label" />
                    <s:textfield name="bean.email" cssClass="input" id="email-input" placeholder="Ingrese su correo" />
                    <div id="error-message" class="error-message" style="display: none;"></div>
                    <!-- Botón con animación de carga -->
                    <button type="button" class="btn" onclick="validarCorreo(); mostrarAnimacion();">Siguiente</button>
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
                    <s:label value="Fecha de Nacimiento" cssClass="label" />
                    <s:textfield name="bean.fechaN" cssClass="input" type="date" />

                    <s:label value="Género" cssClass="label" />
                    <s:radio name="bean.genero" list="{'Masculino', 'Femenino'}" cssClass="input" />
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
                        function mostrarAnimacion() {
                            var overlay = document.getElementById('loading');
                            overlay.style.display = 'flex'; // Muestra la animación
                        }

                        function ocultarAnimacion() {
                            var overlay = document.getElementById('loading');
                            overlay.style.display = 'none'; // Oculta la animación
                        }

                        function validarCorreo() {
                            var email = document.getElementById('email-input').value;
                            var errorMessageDiv = document.getElementById('error-message');

                            if (email === '') {
                                errorMessageDiv.innerHTML = 'Por favor, ingrese su correo electrónico.';
                                errorMessageDiv.style.display = 'block';
                                setTimeout(function () {
                                    errorMessageDiv.style.display = 'none';
                                }, 3000);
                                ocultarAnimacion();
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
                                ocultarAnimacion(); // Ocultar animación después de recibir la respuesta
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

                        let indiceCancion = 0; // Índice para llevar la cuenta de la canción actual
                        const canciones = [
                            "assets/aud/1.mp3",
                            "assets/aud/2.mp3",
                            "assets/aud/3.mp3",
                            "assets/aud/4.mp3",
                            "assets/aud/5.mp3",
                            "assets/aud/6.mp3",
                            "assets/aud/7.mp3",
                            "assets/aud/8.mp3",
                            "assets/aud/9.mp3",
                            "assets/aud/10.mp3",
                            "assets/aud/11.mp3",
                            "assets/aud/12.mp3"
                          
                        ];
                        let audio = new Audio(canciones[indiceCancion]); // Inicializar el objeto Audio

                        // Función para controlar la reproducción y pausa de la música
                        function controlarMusica() {
                            const disco = document.getElementById('disco');
                            const gif = document.getElementById('gif');

                            if (audio.paused) {
                                // Si la música está pausada, reproducir
                                disco.classList.add('girar'); // Iniciar el giro
                                gif.style.display = 'block'; // Mostrar el GIF
                                audio.play();
                            } else {
                                // Si la música está reproduciendo, pausar
                                disco.classList.remove('girar'); // Detener el giro
                                gif.style.display = 'none'; // Ocultar el GIF
                                audio.pause();
                            }
                        }

                        // Función para avanzar a la siguiente canción
                        function controlarSiguienteCancion() {
                            // Avanza a la siguiente canción
                            if (!audio.paused) {
                                audio.pause(); // Pausa la música actual antes de cambiar
                            }
                            indiceCancion++; // Avanza al siguiente índice
                            // Reinicia el índice si se llegó al final
                            if (indiceCancion >= canciones.length) {
                                indiceCancion = 0;
                            }
                            audio.src = canciones[indiceCancion]; // Cambiar la fuente de audio
                            audio.load(); // Cargar la nueva canción
                            audio.play(); // Reproduce la siguiente canción

                            // Mostrar el GIF y girar el disco
                            document.getElementById('gif').style.display = 'block'; // Mostrar el GIF
                            document.getElementById('disco').classList.add('girar'); // Iniciar el giro
                        }

                        // Controlar el fin de la canción
                        audio.onended = function () {
                            controlarSiguienteCancion();
                        };

                        // Quitar la clase de giro cuando la música se detiene
                        audio.onpause = function () {
                            const disco = document.getElementById('disco');
                            const gif = document.getElementById('gif');
                            disco.classList.remove('girar'); // Detener el giro
                            gif.style.display = 'none'; // Ocultar el GIF
                        };

                        // Asegúrate de que se cargue la primera canción al inicio
                        audio.load();
        </script>
    </body>
</html>
