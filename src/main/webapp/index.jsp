<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1> Blog da FOFOCA</h1>
    <p> Hojé é     
        <%=new Date().toLocaleString() %>    
    </p>
    <hr>
    <h4>Bem Vindo, Fofoqueiro! Faça seu login e faça suas intrigas...</h4>
     <span style="color: red">${ERRO_BEAN} </span>
      
      <form action="ControladorForm">
            <label>Informe seu nome:
                <input type="text" name="nome">
            </label>
            <button type="submit">Entrar</button>
       </form>
</body>
</html>