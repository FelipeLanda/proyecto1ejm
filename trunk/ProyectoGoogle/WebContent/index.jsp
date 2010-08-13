<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="edu.fcle.proyectogoogle.persistence.dao.ClienteDao"%>
<%@page import="edu.fcle.proyectogoogle.model.bean.Cliente"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aplicacion 1</title>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
</head>
<script type="text/javascript" src="js/Util.js"></script>


<body>
	<f:view>
		<h:messages style="color:red"></h:messages>
		<h:form id="formLogin">
			<h:panelGrid columns="2">
				<h:outputText>usuario</h:outputText>
				<h:inputText id="txtUsuario" value="#{loginController.login.usuario}" required="true"></h:inputText>
				<h:outputText>clave</h:outputText>
				<h:inputSecret id="txtClave" value="#{loginController.login.clave}" required="true"></h:inputSecret>
				<h:outputText></h:outputText>
				<h:commandButton id="btnIngresar" value="ingresar" action="#{loginController.validarUsuario}"></h:commandButton>
			
			</h:panelGrid>
		
		
		</h:form>
	</f:view>
</body>
</html>