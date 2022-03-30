package miniblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniblog.model.Usuario;

/**
 * Servlet implementation class ControladorForm
 */
@WebServlet("/ControladorForm")
public class ControladorForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recupera o parâmetro que vem da solicitaçao 
		String nome = request.getParameter("nome");
		// instancia um objeto e salva o nome em um "bean" de sessão.
		if (nome.trim().length() <3) {
            request.setAttribute("ERRO_BEAN",
                    new String("ERRO: <b>Nome deve ter pelomenos três (03) caracteres</b>"));
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
		
		
		Usuario usuario = new Usuario(nome);
		request.getSession().setAttribute("USUARIO", usuario);
		//O dispatcher deve leválo para o blog
		request.getRequestDispatcher("miniblog/blog.jsp").forward(request, response);
	}

}
