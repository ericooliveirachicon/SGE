package br.sge.faculdadeMB;

import br.sge.faculdadeDAO.TbFaculdadeDAO;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbFaculdade;

/**
 *
 * @author alex
 */


@ManagedBean
@ViewScoped
public class FaculdadeMB {

    private TbFaculdade selecionado;
    private List<TbFaculdade> listaTbFaculdade;
    private Integer idtFaculdade;
    private String nmeFaculdade;
    private String sglFaculdade;
    private String endFaculdade;
    private String telFaculdade;
    private String emailFaculdade;
    private String telSecFaculdade;
    private Integer noConvenioFaculdade; // NÚMERO CONVENIO
    private Date dtaValidadeConvenioFaculdade;

    public FaculdadeMB() {

        selecionado = new TbFaculdade();
        idtFaculdade = 0;
        nmeFaculdade = "";
        sglFaculdade = "";
        endFaculdade = "";
        telFaculdade = "";
        emailFaculdade = "";
        telSecFaculdade = "";
        noConvenioFaculdade = 0;
        dtaValidadeConvenioFaculdade = null; // PERGUNTAR SE ASSIM FUNCIONA PARA O HIRAGI
        TbFaculdadeDAO dao = new TbFaculdadeDAO();
        listaTbFaculdade = dao.consultarTodos();
        
        filtrar();
    }

    public void filtrar() {
        TbFaculdadeDAO dao = new TbFaculdadeDAO();
        setListaTbFaculdade(dao.consultarPorNme(getNmeFaculdade()));
    }

    public void novo() {
        setSelecionado(new TbFaculdade());
        getSelecionado().setIdtFaculdade(0);
        idtFaculdade = 0;
    }

   public void salvar() {
        TbFaculdadeDAO dao = new TbFaculdadeDAO();
        if (getSelecionado().getIdtFaculdade() == 0) {
            getSelecionado().setIdtFaculdade(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public void excluir() {
        TbFaculdadeDAO dao = new TbFaculdadeDAO();
        if (getSelecionado().getIdtFaculdade() != 0) {
            if (dao.excluir(getSelecionado().getIdtFaculdade())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão", "Exclusão efetuada com sucesso.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusao", "Não foi possível excluir.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        filtrar();
    }
    
    
    public TbFaculdade getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbFaculdade selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbFaculdade> getListaTbFaculdade() {
        return listaTbFaculdade;
    }

    public void setListaTbFaculdade(List<TbFaculdade> listaTbFaculdade) {
        this.listaTbFaculdade = listaTbFaculdade;
    }

    public Integer getIdtFaculdade() {
        return idtFaculdade;
    }

    public void setIdtFaculdade(Integer idtFaculdade) {
        this.idtFaculdade = idtFaculdade;
    }

    public String getNmeFaculdade() {
        return nmeFaculdade;
    }

    public void setNmeFaculdade(String nmeFaculdade) {
        this.nmeFaculdade = nmeFaculdade;
    }

    public String getSglFaculdade() {
        return sglFaculdade;
    }

    public void setSglFaculdade(String sglFaculdade) {
        this.sglFaculdade = sglFaculdade;
    }

    public String getEndFaculdade() {
        return endFaculdade;
    }

    public void setEndFaculdade(String endFaculdade) {
        this.endFaculdade = endFaculdade;
    }

    public String getTelFaculdade() {
        return telFaculdade;
    }

    public void setTelFaculdade(String telFaculdade) {
        this.telFaculdade = telFaculdade;
    }

    public String getEmailFaculdade() {
        return emailFaculdade;
    }

    public void setEmailFaculdade(String emailFaculdade) {
        this.emailFaculdade = emailFaculdade;
    }

    public String getTelSecFaculdade() {
        return telSecFaculdade;
    }

    public void setTelSecFaculdade(String telSecFaculdade) {
        this.telSecFaculdade = telSecFaculdade;
    }

    public Integer getNoConvenioFaculdade() {
        return noConvenioFaculdade;
    }

    public void setNoConvenioFaculdade(Integer noConvenioFaculdade) {
        this.noConvenioFaculdade = noConvenioFaculdade;
    }

    public Date getDtaValidadeConvenioFaculdade() {
        return dtaValidadeConvenioFaculdade;
    }

    public void setDtaValidadeConvenioFaculdade(Date dtaValidadeConvenioFaculdade) {
        this.dtaValidadeConvenioFaculdade = dtaValidadeConvenioFaculdade;
    }
    
    
    
    
}
