package miniblog.model;

import java.sql.Time;
import java.util.Date;

public class BlogMensagem {
    private int    id;
    private String mensagem;
    private Date   dataMensagem;
    private Time   horaMensagem;
    private Usuario usuario;
    

    public BlogMensagem() {
        dataMensagem = new Date();
        horaMensagem = new Time( new Date().getTime());
    }

    public Date getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(Date dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    public Time getHoraMensagem() {
        return horaMensagem;
    }

    public void setHoraMensagem(Time horaMensagem) {
        this.horaMensagem = horaMensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
