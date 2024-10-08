<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Perfil - Notificación de Me Gusta</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perfil.css"/>
    <style>
        body {
            margin: 0;
            padding: 0;
            min-height: 100vh;
            background: url('img.jpg') no-repeat;
            display: flex;
            flex-direction: column; /* Alineación vertical */
            align-items: center;
            font-family: "Poppins", sans-serif;
            position: relative; /* Para el botón de inicio */
        }
        .menu-buttons {
            display: flex;
            justify-content: center; /* Centra los botones */
            margin-bottom: 20px; /* Espaciado inferior */
            width: 100%; /* Asegura que ocupa el ancho completo */
            padding: 10px; /* Espaciado interno */
            background-color: #fff; /* Fondo blanco */
            border-radius: 10px; /* Bordes redondeados */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra */
        }
        .menu-buttons button {
            border: none;
            padding: 10px 15px; /* Espaciado interno */
            border-radius: 5px; /* Bordes redondeados */
            font-size: 16px;
            cursor: pointer;
            margin: 0 10px; /* Espaciado horizontal entre botones */
            transition: background-color 0.3s; /* Transición suave */
        }
        .menu-buttons button:hover {
            background-color: #e7e7e7; /* Color al pasar el ratón */
        }
        .container {
            display: flex;
            flex-direction: column; /* Apilar verticalmente */
            align-items: center; /* Centrará los paneles horizontalmente */
            width: 100%;
            max-width: 500px;
            padding: 20px;
        }
        .panel {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            text-align: center;
            margin-bottom: 20px;
        }
        .profile-pic {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-color: #ddd;
            margin: 0 auto 10px auto;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 24px;
            color: white;
        }
        .user-info {
            margin-bottom: 20px;
            font-size: 18px;
        }
        .panel button {
            border: none;
            padding: 10px 20px;
            border-radius: 50px;
            font-size: 16px;
            cursor: pointer;
            margin: 5px;
            width: 100px;
        }
        .accept-btn {
            background-color: #28a745;
            color: white;
        }
        .reject-btn {
            background-color: #dc3545;
            color: white;
        }
        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 10px;
        }
        .no-likes-message {
            color: #dc3545;
            font-size: 18px;
            text-align: center;
        }
        /* Estilo para el botón de inicio */
        .home-button {
            position: absolute; /* Posiciona el botón de forma absoluta */
            top: 20px; /* Ajusta según sea necesario */
            right: 20px; /* Ajusta según sea necesario */
            background-color: #007bff; /* Color de fondo del botón */
            color: white; /* Color del texto */
            border: none; /* Sin borde */
            border-radius: 5px; /* Bordes redondeados */
            padding: 10px 15px; /* Espaciado interno */
            font-size: 16px; /* Tamaño de fuente */
            cursor: pointer; /* Cambia el cursor al pasar el ratón */
            transition: background-color 0.3s; /* Transición suave */
        }
        .home-button:hover {
            background-color: #0056b3; /* Color al pasar el ratón */
        }
    </style>
</head>
<body>
    <!-- Botón de inicio -->
    <button class="home-button"><a href="home" style="color: white; text-decoration: none;">Inicio</a></button>

    <!-- Contenedor de botones de menú -->
    <div class="menu-buttons">
        <button id="btn-enviados"><a href="megustaenviado">Lista Enviados</a></button>
        <button id="btn-rechazados"><a href="megustarechazado">Lista de Rechazados</a></button>
    </div>

    <!-- Contenedor general para centrar los paneles -->
    <div class="container">
        <!-- Verificamos si la lista de personas está vacía -->
        <s:if test="personas.size() == 0">
            <div class="panel no-likes-message">
                <h2>No tienes ningún "Me Gusta"</h2>
                <p>Vuelve más tarde para ver tus notificaciones.</p>
            </div>
        </s:if>
        
        <!-- Iteramos sobre la lista de personas -->
        <s:else>
            <s:iterator value="personas">
                <div class="panel">
                    <h2>Te dieron un Me Gusta</h2>
                    <div class="profile-pic">
                        <s:if test="fotoPerfilBase64 != null">
                            <img src="data:image/jpeg;base64,<s:property value='fotoPerfilBase64'/>" alt="Foto de Perfil" style="width: 100%; height: 100%; border-radius: 50%;">
                        </s:if>
                        <s:else>
                            <i class="fas fa-user"></i>
                        </s:else>
                    </div>
                    <div class="user-info">
                        <s:property value="nombre"/> <s:property value="apellido"/>
                    </div>
                    <div class="button-container">
                        <s:form action="aceptar" method="post">
                            <s:hidden name="idUsuarioAceptado" value="%{iduser}"/>
                            <button type="submit" class="accept-btn">Aceptar</button>
                        </s:form>
                        <s:form action="rechazar" method="post">
                            <s:hidden name="idUsuarioAceptado" value="%{iduser}"/>
                            <button type="submit" class="reject-btn">Rechazar</button>
                        </s:form>
                    </div>
                </div>
            </s:iterator>
        </s:else>
    </div>
</body>
</html>
