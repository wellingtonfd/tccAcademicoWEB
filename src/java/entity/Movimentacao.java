/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idMovimentacao = :idMovimentacao"),
    @NamedQuery(name = "Movimentacao.findByDtPrevista", query = "SELECT m FROM Movimentacao m WHERE m.dtPrevista = :dtPrevista"),
    @NamedQuery(name = "Movimentacao.findByDtEntrega", query = "SELECT m FROM Movimentacao m WHERE m.dtEntrega = :dtEntrega"),
    @NamedQuery(name = "Movimentacao.findByDtSaida", query = "SELECT m FROM Movimentacao m WHERE m.dtSaida = :dtSaida"),
    @NamedQuery(name = "Movimentacao.findByQuantFuncionarios", query = "SELECT m FROM Movimentacao m WHERE m.quantFuncionarios = :quantFuncionarios"),
    @NamedQuery(name = "Movimentacao.findByResponsavel", query = "SELECT m FROM Movimentacao m WHERE m.responsavel = :responsavel"),
    @NamedQuery(name = "Movimentacao.findByTempoPrevisto", query = "SELECT m FROM Movimentacao m WHERE m.tempoPrevisto = :tempoPrevisto"),
    @NamedQuery(name = "Movimentacao.findByDuracao", query = "SELECT m FROM Movimentacao m WHERE m.duracao = :duracao")})
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimentacao")
    private Integer idMovimentacao;
    @Column(name = "dt_prevista")
    @Temporal(TemporalType.DATE)
    private Date dtPrevista;
    @Column(name = "dt_entrega")
    @Temporal(TemporalType.DATE)
    private Date dtEntrega;
    @Column(name = "dt_saida")
    @Temporal(TemporalType.DATE)
    private Date dtSaida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "quant_funcionarios")
    private String quantFuncionarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "tempo_previsto")
    @Temporal(TemporalType.TIME)
    private Date tempoPrevisto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracao")
    @Temporal(TemporalType.TIME)
    private Date duracao;
    @JoinColumn(name = "id_tipo_solicitacao", referencedColumnName = "id_tipo_solicitacao")
    @ManyToOne
    private TipoSolicitacao idTipoSolicitacao;
    @JoinColumn(name = "id_tipo_equipamento", referencedColumnName = "id_tipo_equipamento")
    @ManyToOne
    private TipoEquipamento idTipoEquipamento;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne
    private Produto idProduto;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne
    private Funcionario idFuncionario;
    @JoinColumn(name = "id_endarmazem", referencedColumnName = "id_endarmazem")
    @ManyToOne
    private EndArmazem idEndarmazem;
    @JoinColumn(name = "id_detalhe_nota", referencedColumnName = "id_detalhe_nota")
    @ManyToOne
    private DetNota idDetalheNota;
    @JoinColumn(name = "id_armazem", referencedColumnName = "id_armazem")
    @ManyToOne
    private Armazem idArmazem;

    public Movimentacao() {
    }

    public Movimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Movimentacao(Integer idMovimentacao, String quantFuncionarios, String responsavel, Date duracao) {
        this.idMovimentacao = idMovimentacao;
        this.quantFuncionarios = quantFuncionarios;
        this.responsavel = responsavel;
        this.duracao = duracao;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Date getDtPrevista() {
        return dtPrevista;
    }

    public void setDtPrevista(Date dtPrevista) {
        this.dtPrevista = dtPrevista;
    }

    public Date getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public String getQuantFuncionarios() {
        return quantFuncionarios;
    }

    public void setQuantFuncionarios(String quantFuncionarios) {
        this.quantFuncionarios = quantFuncionarios;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getTempoPrevisto() {
        return tempoPrevisto;
    }

    public void setTempoPrevisto(Date tempoPrevisto) {
        this.tempoPrevisto = tempoPrevisto;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public TipoSolicitacao getIdTipoSolicitacao() {
        return idTipoSolicitacao;
    }

    public void setIdTipoSolicitacao(TipoSolicitacao idTipoSolicitacao) {
        this.idTipoSolicitacao = idTipoSolicitacao;
    }

    public TipoEquipamento getIdTipoEquipamento() {
        return idTipoEquipamento;
    }

    public void setIdTipoEquipamento(TipoEquipamento idTipoEquipamento) {
        this.idTipoEquipamento = idTipoEquipamento;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public EndArmazem getIdEndarmazem() {
        return idEndarmazem;
    }

    public void setIdEndarmazem(EndArmazem idEndarmazem) {
        this.idEndarmazem = idEndarmazem;
    }

    public DetNota getIdDetalheNota() {
        return idDetalheNota;
    }

    public void setIdDetalheNota(DetNota idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public Armazem getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Armazem idArmazem) {
        this.idArmazem = idArmazem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentacao != null ? idMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.idMovimentacao == null && other.idMovimentacao != null) || (this.idMovimentacao != null && !this.idMovimentacao.equals(other.idMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movimentacao[ idMovimentacao=" + idMovimentacao + " ]";
    }

}
