<%-- 
    Document   : contacto
    Created on : 30 ago. 2024, 10:26:49 a. m.
    Author     : GRABIEL
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Recibir Datos</h1>
    <ol>
        <li><s:property value="persona.nombre"/></li>
        <li><s:property value="persona.apellido"/></li>
        <li><s:property value="persona.email"/></li>
    </ol>
</body>
</html>
