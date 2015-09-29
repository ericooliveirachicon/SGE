package br.sge.segurancaMB;

import br.sge.segurancaDAO.TbPessoaDAO;
import br.sge.segurancaDAO.TbUsuarioDAO;
import java.util.Date;
import java.util.List;
import model.TbPessoa;
import model.TbUsuario;

/**
 *
 * @author alex
 */
public class TbUsuarioMB{

    private TbUsuario selecionado;
    private Integer idtUsuario;
    private List<TbUsuario> listaTbUsuario;
    private List<TbPessoa> listaTbPessoa;
    private String usrUsuarioCad;
    private Date dtaUsuarioCad;
    private String loginUsuario;
    private String senhaUsuario;
    
    public TbUsuarioMB() {

        selecionado = new TbUsuario();
        idtUsuario = 0;
        usrUsuarioCad = "";
        dtaUsuarioCad = null;
        loginUsuario = "";
        senhaUsuario = "";
        TbUsuarioDAO daoU = new TbUsuarioDAO();
        listaTbUsuario = daoU.consultarTodos();
        TbPessoaDAO daoP = new TbPessoaDAO();
        listaTbPessoa = daoP.consultarTodos();

    }


public TbUsuario getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbUsuario selecionado) {
        this.selecionado = selecionado;
    }

    public Integer getIdtUsuario() {
        return idtUsuario;
    }

    public void setIdtUsuario(Integer idtUsuario) {
        this.idtUsuario = idtUsuario;
    }

    public List<TbUsuario> getListaTbUsuario() {
        return listaTbUsuario;
    }

    public void setListaTbUsuario(List<TbUsuario> listaTbUsuario) {
        this.listaTbUsuario = listaTbUsuario;
    }

    public List<TbPessoa> getListaTbPessoa() {
        return listaTbPessoa;
    }

    public void setListaTbPessoa(List<TbPessoa> listaTbPessoa) {
        this.listaTbPessoa = listaTbPessoa;
    }

    public String getUsrUsuarioCad() {
        return usrUsuarioCad;
    }

    public void setUsrUsuarioCad(String usrUsuarioCad) {
        this.usrUsuarioCad = usrUsuarioCad;
    }

    public Date getDtaUsuarioCad() {
        return dtaUsuarioCad;
    }

    public void setDtaUsuarioCad(Date dtaUsuarioCad) {
        this.dtaUsuarioCad = dtaUsuarioCad;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
}
