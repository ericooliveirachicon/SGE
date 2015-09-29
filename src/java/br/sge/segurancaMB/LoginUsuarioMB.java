package br.sge.segurancaMB;

import br.sge.segurancaDAO.TbUsuarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbUsuario;

/**
 *
 * @author alex
 */

@ManagedBean
@ViewScoped
public class LoginUsuarioMB extends TbUsuarioMB{
   
     private List<TbUsuario> listaTbUsuario;
     private TbUsuarioMB user;
     private String loginUsuario;
     private String senhaUsuario;
    
    public String logar() {
        try{
            
        TbUsuarioDAO dao = new TbUsuarioDAO();
        listaTbUsuario = dao.consultarLoginSenha(getLoginUsuario(), getSenhaUsuario());

        if (listaTbUsuario.isEmpty()) {
           
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(loginUsuario, new FacesMessage("Usuário ou senha invalidos"));
            return "login.xhtml?faces-redirect=true";
        }
        
        SessionContext.getInstance().setAttribute("usuarioLogin", listaTbUsuario);
        return "index.xhtml?faces-redirect=true";
       
       
        
        }catch(Exception e){
           FacesContext.getCurrentInstance().validationFailed();
        return "";
        }
    }
    
    public String logout(){
        SessionContext.getInstance().encerrarSessao();  
        return "login.xhtml?faces-redirect=true";
        }
    
    public TbUsuarioMB getTbUsuarioMB(){
        return (TbUsuarioMB) SessionContext.getInstance().getUsuarioLogado();
    }

    public TbUsuarioMB getUser() {
        return user;
    }

    public void setUser(TbUsuarioMB user) {
        this.user = user;
    }
    
    
}
