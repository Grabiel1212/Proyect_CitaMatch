<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/styles/home.css"/>
        <title>Perfiles - CitaMatch</title>
    </head>
    <body>
        <div class="container">
            <div class="profile-card">
                <div class="image">
                    <!-- Mostrar la foto del perfil -->
                    <img src="assets/styles/9.jpg" alt="Foto de perfil" class="profile-photo">
                </div>
                <div class="details">
                    <h2><s:property value="perfil.nombre"/> <s:property value="perfil.apellido"/></h2>
                    <p>Edad: <s:property value="perfil.edad"/></p>
                    <p>Intereses: <s:property value="perfil.intereses"/></p>
                </div>
                <div class="actions">
                    <button class="dislike" onclick="passProfile()">❌</button>
                    <button class="like" onclick="likeProfile()">❤️</button>
                </div>
            </div>
        </div>

        <script>
            function passProfile() {
                // Redirigir al backend para pasar de perfil
                window.location.href = 'pasarPerfil';
            }

            function likeProfile() {
                // Redirigir al backend para dar 'like' al perfil actual
                window.location.href = 'likePerfil';
            }
        </script>
    </body>
</html>
