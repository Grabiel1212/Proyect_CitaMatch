<%-- 
    Document   : home
    Created on : 29 ago. 2024, 6:43:23 p. m.
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
        <h1>Insertar Datos</h1>
        
        <br><!-- comment -->
        <hr><!-- comment -->
        
      <s:form action="contacto">
    <s:div>
        <s:label value="Nombres" for="nombre" />
        <s:textfield id="nombre" name="per.nombre"/>
    </s:div>

    <s:div>
        <s:label value="Apellidos" for="apellido" />
        <s:textfield id="apellido" name="per.apellido"/>
    </s:div>

    <s:div>
        <s:label for="email">Email</s:label>
        <s:textfield id="email" name="per.email"/>
    </s:div>

    <s:div>
        <s:submit value="Enviar"/>
    </s:div>
</s:form>
    
    </body>
</html>
