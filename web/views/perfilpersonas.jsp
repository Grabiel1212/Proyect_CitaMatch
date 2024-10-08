<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perfil.css"/>
        <style>
            /* Estilo por defecto del botón */
            .like-button {
                background-color: #ddd;
                color: black;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                font-size: 16px;
            }

            /* Estilo cuando está en modo "Me gusta" (rojo) */
            .liked {
                background-color: #ff4b5c;
                color: white;
            }

            /* Estilo del header con la foto de portada como fondo */
            header {
                width: 100%;
                height: 250px; /* Puedes ajustar el tamaño según necesites */
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
            }

            .no-portada {
                background-color: #f4f4f4;
            }

            /* Botón de regresar al Home */
            .home-button {
                position: fixed;
                top: 20px;
                right: 20px;
                background-color: #4CAF50;
                color: white;
                padding: 10px 15px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                font-size: 16px;
                text-decoration: none;
            }

            .home-button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <!-- Botón para regresar al Home -->
        <a href="${pageContext.request.contextPath}/home" class="home-button">Home</a>

        <div class="header__wrapper">
            <header 
                <s:if test="bean.fotoPortada != null">
                    style="background-image: url('data:image/jpeg;base64,<s:property value='bean.fotoPortada'/>');"
                </s:if>
                <s:else>
                    class="no-portada" <!-- Clase para cuando no hay foto de portada -->
                </s:else>
            >
            </header>
            <div class="cols__container">
                <div class="left__col">
                    <div class="img__container">
                        <!-- Mostrar la foto de perfil dinámicamente -->
                        <s:if test="bean.fotoPerfil != null">
                            <img src="data:image/jpeg;base64,<s:property value='bean.fotoPerfil'/>" alt="Foto de perfil" />
                        </s:if>
                        <span></span>
                    </div>

                    <!-- Mostrar nombre, apellido y edad del usuario -->
                    <h2><s:property value="bean.nombre"/> <s:property value="bean.apellido"/></h2>
                    <p>Edad: <s:property value="bean.edad"/> años</p>

                    <!-- Mostrar ubicación -->
                    <p>Ubicación: <s:property value="bean.ubicacion"/></p>

                    <!-- Mostrar intereses -->
                    <h3>Intereses</h3>
                    <ul class="intereses">
                        <!-- Iterar a través de la lista de intereses -->
                        <s:iterator value="bean.intereses" var="interes">
                            <li><s:property value="#interes"/></li>
                        </s:iterator>
                    </ul>

                    <!-- Mostrar descripción -->
                    <div class="content">
                        <h3>Descripción</h3>
                        <p><s:property value="bean.descripcion"/></p>
                    </div>
                </div>

                <div class="right__col">
                    <nav>
                        <ul>
                            <li><a href="">FOTOS</a></li>
                            <li><a href="">ÁLBUM</a></li>
                            <li><a href="">MÚSICA</a></li>
                            <li><a href="">INTERESES</a></li>
                        </ul>

                        <!-- Botón para dar me gusta -->
                        <button id="likeButton" class="like-button">Dar Me Gusta</button>
                    </nav>

                    <div class="photos">
                        <!-- Mostrar fotos adicionales -->
                        <s:if test="bean.foto1 != null">
                            <img src="data:image/jpeg;base64,<s:property value='bean.foto1'/>" alt="Foto 1" />
                        </s:if>
                        <s:if test="bean.foto2 != null">
                            <img src="data:image/jpeg;base64,<s:property value='bean.foto2'/>" alt="Foto 2" />
                        </s:if>
                        <s:if test="bean.foto3 != null">
                            <img src="data:image/jpeg;base64,<s:property value='bean.foto3'/>" alt="Foto 3" />
                        </s:if>
                    </div>
                </div>
            </div>
        </div>

        <!-- Script para cambiar el color del botón cuando se hace clic -->
        <script>
            document.getElementById('likeButton').addEventListener('click', function() {
                this.classList.toggle('liked');
                if (this.classList.contains('liked')) {
                    this.innerHTML = 'Me Gusta ❤️';  // Cambiar el texto cuando se da me gusta
                } else {
                    this.innerHTML = 'Dar Me Gusta';  // Cambiar el texto cuando se desactiva
                }
            });
        </script>
    </body>
</html>
