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
            .edit-button {
                background-color: #4CAF50; /* Color del botón */
                color: white; /* Color del texto */
                padding: 10px 20px; /* Espaciado interno */
                border: none; /* Sin borde */
                cursor: pointer; /* Cambia el cursor al pasar por encima */
                border-radius: 5px; /* Bordes redondeados */
                font-size: 16px; /* Tamaño de la fuente */
                margin-top: 20px; /* Margen superior */
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

                        <!-- Botón para editar el perfil -->
                        <button id="editButton" class="edit-button" >Editar</button>
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
            // Si es necesario añadir funcionalidad adicional para el botón editar, aquí se puede agregar
        </script>
    </body>
</html>
