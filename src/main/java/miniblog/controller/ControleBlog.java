package miniblog.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniblog.model.BlogMensagem;
import miniblog.model.Usuario;


@WebServlet(name = "ControleBlog", urlPatterns = {"/ControleBlog"})
public class ControleBlog extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
       
        String msg = request.getParameter("mensagem");
        
        
        if (msg==null){
            request.getRequestDispatcher("/miniblog/blog.jsp").forward(request, response);
            return;
        }
       
        
        String nome = request.getParameter("nome");
           
        
        
        if (msg.trim().length() == 0) {
            request.setAttribute("ERRO_BEAN",
                    new String("ERRO: <b>A mensagem deve ser preenchida.</b>"));
            request.getRequestDispatcher("/miniblog/blog.jsp").forward(request, response);
            return;
        }

        
        BlogMensagem blogMsg = new BlogMensagem();
        blogMsg.setMensagem(msg);
        
        
        Usuario usuario = new Usuario(nome);
        blogMsg.setUsuario(usuario);
        
   
        ServletContext contextoObjetoBean = getServletContext();
      
        ArrayList<BlogMensagem> listaMsg = (ArrayList) contextoObjetoBean.getAttribute("BEAN_LISTA");
        
        
        if (listaMsg == null) {
            listaMsg = new ArrayList();
        }

        blogMsg.setId(recuperaUltimoId(listaMsg));
        listaMsg.add(blogMsg);
        
       
        contextoObjetoBean.setAttribute("BEAN_LISTA", listaMsg);
      
      
        request.getRequestDispatcher("/miniblog/blog.jsp").forward(request, response);
    }

    private int recuperaUltimoId(ArrayList<BlogMensagem> listaMsg) {
        int ultimoIndice = listaMsg.size();
        int idResposta = 1;
        if (ultimoIndice > 0) {
            ultimoIndice = ultimoIndice - 1;
            BlogMensagem blogMsg = listaMsg.get(ultimoIndice);
            idResposta = blogMsg.getId() + 1;
        }
        return idResposta;
    }
}
