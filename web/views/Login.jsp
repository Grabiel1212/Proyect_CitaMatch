<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!-- Fuente de Google -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">


        <link rel="stylesheet" href="styles/loginPrincipal.css" crossorigin="anonymous">



        <title>PASION</title>
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
        <!-- Contenedor principal -->
        <div class="wrapper">
            <!-- Título -->
            <h1>Iniciar Sesión</h1>

            <!-- Caja de entrada de correo -->
            <s:form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <s:textfield name="email" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <s:password name="password" cssClass="form-control" required="true"/>
                </div>
                <s:submit value="Iniciar Sesión" cssClass="btn btn-primary"/>
            </s:form>

            <!-- Recordar y enlace para contraseña olvidada -->
            <div class="remember-forgot">
                <label><input type="checkbox"> Recordarme</label>
                <a href="#">¿Olvidaste tu contraseña?</a>
            </div>

            <div class="social-buttons">
    <button type="button" class="social-button google-button">
        <i class="bi bi-google"></i> Google
    </button>
    <button type="button" class="social-button facebook-button">
        <i class="bi bi-facebook"></i> Facebook
    </button>
</div>

            <!-- Enlace para registrarse -->
            <div class="register-link">
                <p>¿No tienes una cuenta? <a href="registrarse.jsp">Registrarse</a></p>
            </div>


            <!-- Script opcional si lo necesitas -->
            <script src="<%= request.getContextPath()%>/scripts/login.js"></script>
    </body>
</html>

