<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net"  prefix="display"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css" media="all">
            @import url("css/screen.css");
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body style="width: 800px"    >
        <h1>Miniblog!</h1>
        <h1>Bem vindo, ${USUARIO.nome}, o que você tem para nos contar?</h1>
        
 
        <span style="color: red">${ERRO_BEAN} </span>
        
        <form action="ControleBlog" method="POST">
            <textarea rows="3" cols="40" value=""  name="mensagem" size="120" 
                      style="height: 100%"></textarea>
                      <input type="hidden" name="nome" value="${USUARIO.nome}">
            <br> <input type="submit" value="ENVIAR" />
        </form>
        
        
        <br/> <a href="ControleBlog" > Atualizar mensagens </a>
        <display:table  name="${BEAN_LISTA}">
            <display:column property="id"  />
            <display:column property="mensagem" style="width: 85%;" />
            <display:column property="dataMensagem" title="Data"
                            format="{0,date,dd/MM/yyyy}" style="width: 10%;" />
            <display:column property="horaMensagem" title="Hora"
                            format="{0,date,HH:mm}" />
  			<display:column property="usuario.nome" title="Fofoqueiro" style="width: 85%;"/>
            
            <display:column  href="ControleExcluiMensagem" 
                            paramId="idchave" paramProperty="id">              
                <img alt="Excluir" src="img/exclui.jpeg" height="16px" width="16px">
            </display:column>
        </display:table>    

    </body>
</html>
