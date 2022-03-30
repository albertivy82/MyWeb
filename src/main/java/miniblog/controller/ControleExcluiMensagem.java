package miniblog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import miniblog.model.BlogMensagem;
import miniblog.model.Usuario;



@WebServlet(name = "ControleExcluiMensagem", urlPatterns = {"/ControleExcluiMensagem"})
public class ControleExcluiMensagem extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	ServletContext context = getServletContext();
        List<BlogMensagem>blogMessages = (ArrayList<BlogMensagem>) context.getAttribute("BEAN_LISTA");
        Long id = Long.valueOf(request.getParameter("idchave"));
        blogMessages.removeIf(b->b.getId()==(id));
        context.setAttribute("messageList", blogMessages);
        request.getRequestDispatcher("/miniblog/blog.jsp").forward(request, response);
    	
        
    }

   
    }
