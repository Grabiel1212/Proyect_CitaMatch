<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Enlace a tu hoja de estilos -->
        <link rel="stylesheet" href="<%= request.getContextPath()%>/styles/loginPrincipal.css">
        <!-- Fuente de Google -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="styles/loginPrincipal.css">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <ul>
            <li>P</li>
            <li>A</li>
            <li>S</li>
            <li>I</li>
            <li>O</li>
            <li>N</li>
            
        </ul>
        <!-- Contenedor principal -->
        <div class="wrapper">
            <!-- Título -->
            <h1>Iniciar Sesión</h1>

            <!-- Formulario de login -->
            <s:form action="loginAction" method="post">
                <!-- Caja de entrada de correo -->
                <div class="input-box">
                    <s:label value="Correo Electrónico" cssClass="label" />
                    <s:textfield name="email" cssClass="input" />
                </div>
                
                <!-- Caja de entrada de contraseña -->
                <div class="input-box">
                    <s:label value="Contraseña" cssClass="label" />
                    <s:password name="password" cssClass="input" />
                </div>

                <!-- Recordar y enlace para contraseña olvidada -->
                <div class="remember-forgot">
                    <label><input type="checkbox"> Recordarme</label>
                    <a href="#">¿Olvidaste tu contraseña?</a>
                </div>

                <!-- Botón para ingresar -->
                <div class="input-box">
                    <s:submit value="Ingresar" cssClass="btn" />
                </div>
            </s:form>

            <!-- Enlace para registrarse -->
            <div class="register-link">
                <p>¿No tienes una cuenta? <a href="registrarse.jsp">Registrarse</a></p>
            </div>
        </div>

        <!-- Script opcional si lo necesitas -->
        <script src="<%= request.getContextPath()%>/scripts/login.js"></script>
    </body>
</html>

