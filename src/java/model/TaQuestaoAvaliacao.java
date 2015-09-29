package model;
// Generated 23/09/2015 18:27:47 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TaQuestaoAvaliacao generated by hbm2java
 */
@Entity
@Table(name="ta_questao_avaliacao"
    ,catalog="bd_sge"
)
public class TaQuestaoAvaliacao  implements java.io.Serializable {


     private Integer idtQuestaoAvaliacao;
     private TdQuestao tdQuestao;
     private int codAvaliacao;
     private int notaQuestao;

    public TaQuestaoAvaliacao() {
    }

    public TaQuestaoAvaliacao(TdQuestao tdQuestao, int codAvaliacao, int notaQuestao) {
       this.tdQuestao = tdQuestao;
       this.codAvaliacao = codAvaliacao;
       this.notaQuestao = notaQuestao;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idt_questao_avaliacao", unique=true, nullable=false)
    public Integer getIdtQuestaoAvaliacao() {
        return this.idtQuestaoAvaliacao;
    }
    
    public void setIdtQuestaoAvaliacao(Integer idtQuestaoAvaliacao) {
        this.idtQuestaoAvaliacao = idtQuestaoAvaliacao;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_questao", nullable=false)
    public TdQuestao getTdQuestao() {
        return this.tdQuestao;
    }
    
    public void setTdQuestao(TdQuestao tdQuestao) {
        this.tdQuestao = tdQuestao;
    }
    
    @Column(name="cod_avaliacao", nullable=false)
    public int getCodAvaliacao() {
        return this.codAvaliacao;
    }
    
    public void setCodAvaliacao(int codAvaliacao) {
        this.codAvaliacao = codAvaliacao;
    }
    
    @Column(name="nota_questao", nullable=false)
    public int getNotaQuestao() {
        return this.notaQuestao;
    }
    
    public void setNotaQuestao(int notaQuestao) {
        this.notaQuestao = notaQuestao;
    }




}

