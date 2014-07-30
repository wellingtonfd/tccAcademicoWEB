/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "tipo_solicitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSolicitacao.findAll", query = "SELECT t FROM TipoSolicitacao t"),
    @NamedQuery(name = "TipoSolicitacao.findByIdTipoSolicitacao", query = "SELECT t FROM TipoSolicitacao t WHERE t.idTipoSolicitacao = :idTipoSolicitacao"),
    @NamedQuery(name = "TipoSolicitacao.findByTipoSolicitacao", query = "SELECT t FROM TipoSolicitacao t WHERE t.tipoSolicitacao = :tipoSolicitacao"),
    @NamedQuery(name = "TipoSolicitacao.findByEspecTipoSolicitacao", query = "SELECT t FROM TipoSolicitacao t WHERE t.especTipoSolicitacao = :especTipoSolicitacao"),
    @NamedQuery(name = "TipoSolicitacao.findByIdFornecedor", query = "SELECT t FROM TipoSolicitacao t WHERE t.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "TipoSolicitacao.findBySolicitante", query = "SELECT t FROM TipoSolicitacao t WHERE t.solicitante = :solicitante")})
public class TipoSolicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_solicitacao")
    private Integer idTipoSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipo_solicitacao")
    private String tipoSolicitacao;
    @Size(max = 45)
    @Column(name = "espec_tipo_solicitacao")
    private String especTipoSolicitacao;
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "solicitante")
    private String solicitante;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne
    private Funcionario idFuncionario;
    @JoinColumn(name = "fornecedor_id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorIdFornecedor;
    @JoinColumn(name = "id_armazem", referencedColumnName = "id_armazem")
    @ManyToOne
    private Armazem idArmazem;
    @OneToMany(mappedBy = "idTipoSolicitacao")
    private Collection<Movimentacao> movimentacaoCollection;

    public TipoSolicitacao() {
    }

    public TipoSolicitacao(Integer idTipoSolicitacao) {
        this.idTipoSolicitacao = idTipoSolicitacao;
    }

    public TipoSolicitacao(Integer idTipoSolicitacao, String tipoSolicitacao, String solicitante) {
        this.idTipoSolicitacao = idTipoSolicitacao;
        this.tipoSolicitacao = tipoSolicitacao;
        this.solicitante = solicitante;
    }

    public Integer getIdTipoSolicitacao() {
        return idTipoSolicitacao;
    }

    public void setIdTipoSolicitacao(Integer idTipoSolicitacao) {
        this.idTipoSolicitacao = idTipoSolicitacao;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public String getEspecTipoSolicitacao() {
        return especTipoSolicitacao;
    }

    public void setEspecTipoSolicitacao(String especTipoSolicitacao) {
        this.especTipoSolicitacao = especTipoSolicitacao;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Fornecedor getFornecedorIdFornecedor() {
        return fornecedorIdFornecedor;
    }

    public void setFornecedorIdFornecedor(Fornecedor fornecedorIdFornecedor) {
        this.fornecedorIdFornecedor = fornecedorIdFornecedor;
    }

    public Armazem getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Armazem idArmazem) {
        this.idArmazem = idArmazem;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSolicitacao != null ? idTipoSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSolicitacao)) {
            return false;
        }
        TipoSolicitacao other = (TipoSolicitacao) object;
        if ((this.idTipoSolicitacao == null && other.idTipoSolicitacao != null) || (this.idTipoSolicitacao != null && !this.idTipoSolicitacao.equals(other.idTipoSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.TipoSolicitacao[ idTipoSolicitacao=" + idTipoSolicitacao + " ]";
    }

}
