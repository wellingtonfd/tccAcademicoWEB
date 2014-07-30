/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "armazem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armazem.findAll", query = "SELECT a FROM Armazem a"),
    @NamedQuery(name = "Armazem.findByIdArmazem", query = "SELECT a FROM Armazem a WHERE a.idArmazem = :idArmazem"),
    @NamedQuery(name = "Armazem.findByTipoArmazem", query = "SELECT a FROM Armazem a WHERE a.tipoArmazem = :tipoArmazem"),
    @NamedQuery(name = "Armazem.findByCapacidadeArmazem", query = "SELECT a FROM Armazem a WHERE a.capacidadeArmazem = :capacidadeArmazem"),
    @NamedQuery(name = "Armazem.findByCertificacaoArmazem", query = "SELECT a FROM Armazem a WHERE a.certificacaoArmazem = :certificacaoArmazem"),
    @NamedQuery(name = "Armazem.findByEspecArmazem", query = "SELECT a FROM Armazem a WHERE a.especArmazem = :especArmazem"),
    @NamedQuery(name = "Armazem.findByEstoqueMax", query = "SELECT a FROM Armazem a WHERE a.estoqueMax = :estoqueMax"),
    @NamedQuery(name = "Armazem.findByEstoqueMin", query = "SELECT a FROM Armazem a WHERE a.estoqueMin = :estoqueMin"),
    @NamedQuery(name = "Armazem.findByIdStatusArmazem", query = "SELECT a FROM Armazem a WHERE a.idStatusArmazem = :idStatusArmazem"),
    @NamedQuery(name = "Armazem.findByIdLocalOper", query = "SELECT a FROM Armazem a WHERE a.idLocalOper = :idLocalOper")})
public class Armazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_armazem")
    private Integer idArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_armazem")
    private String tipoArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "capacidade_armazem")
    private String capacidadeArmazem;
    @Size(max = 45)
    @Column(name = "certificacao_armazem")
    private String certificacaoArmazem;
    @Size(max = 45)
    @Column(name = "espec_armazem")
    private String especArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estoque_max")
    private String estoqueMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estoque_min")
    private String estoqueMin;
    @Column(name = "id_status_armazem")
    private Integer idStatusArmazem;
    @Column(name = "id_local_oper")
    private Integer idLocalOper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armazemIdArmazem")
    private Collection<Produto> produtoCollection;
    @OneToMany(mappedBy = "idArmazem")
    private Collection<TipoSolicitacao> tipoSolicitacaoCollection;
    @OneToMany(mappedBy = "idArmazem")
    private Collection<Movimentacao> movimentacaoCollection;
    @JoinColumn(name = "status_armazem_id_status_armazem", referencedColumnName = "id_status_armazem")
    @ManyToOne(optional = false)
    private StatusArmazem statusArmazemIdStatusArmazem;
    @JoinColumn(name = "local_operacao_id_local_oper", referencedColumnName = "id_local_oper")
    @ManyToOne(optional = false)
    private LocalOperacao localOperacaoIdLocalOper;
    @JoinColumn(name = "id_endarmazem", referencedColumnName = "id_endarmazem")
    @ManyToOne
    private EndArmazem idEndarmazem;

    public Armazem() {
    }

    public Armazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public Armazem(Integer idArmazem, String tipoArmazem, String capacidadeArmazem, String estoqueMax, String estoqueMin) {
        this.idArmazem = idArmazem;
        this.tipoArmazem = tipoArmazem;
        this.capacidadeArmazem = capacidadeArmazem;
        this.estoqueMax = estoqueMax;
        this.estoqueMin = estoqueMin;
    }

    public Integer getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public String getTipoArmazem() {
        return tipoArmazem;
    }

    public void setTipoArmazem(String tipoArmazem) {
        this.tipoArmazem = tipoArmazem;
    }

    public String getCapacidadeArmazem() {
        return capacidadeArmazem;
    }

    public void setCapacidadeArmazem(String capacidadeArmazem) {
        this.capacidadeArmazem = capacidadeArmazem;
    }

    public String getCertificacaoArmazem() {
        return certificacaoArmazem;
    }

    public void setCertificacaoArmazem(String certificacaoArmazem) {
        this.certificacaoArmazem = certificacaoArmazem;
    }

    public String getEspecArmazem() {
        return especArmazem;
    }

    public void setEspecArmazem(String especArmazem) {
        this.especArmazem = especArmazem;
    }

    public String getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(String estoqueMax) {
        this.estoqueMax = estoqueMax;
    }

    public String getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(String estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public Integer getIdStatusArmazem() {
        return idStatusArmazem;
    }

    public void setIdStatusArmazem(Integer idStatusArmazem) {
        this.idStatusArmazem = idStatusArmazem;
    }

    public Integer getIdLocalOper() {
        return idLocalOper;
    }

    public void setIdLocalOper(Integer idLocalOper) {
        this.idLocalOper = idLocalOper;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<TipoSolicitacao> getTipoSolicitacaoCollection() {
        return tipoSolicitacaoCollection;
    }

    public void setTipoSolicitacaoCollection(Collection<TipoSolicitacao> tipoSolicitacaoCollection) {
        this.tipoSolicitacaoCollection = tipoSolicitacaoCollection;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public StatusArmazem getStatusArmazemIdStatusArmazem() {
        return statusArmazemIdStatusArmazem;
    }

    public void setStatusArmazemIdStatusArmazem(StatusArmazem statusArmazemIdStatusArmazem) {
        this.statusArmazemIdStatusArmazem = statusArmazemIdStatusArmazem;
    }

    public LocalOperacao getLocalOperacaoIdLocalOper() {
        return localOperacaoIdLocalOper;
    }

    public void setLocalOperacaoIdLocalOper(LocalOperacao localOperacaoIdLocalOper) {
        this.localOperacaoIdLocalOper = localOperacaoIdLocalOper;
    }

    public EndArmazem getIdEndarmazem() {
        return idEndarmazem;
    }

    public void setIdEndarmazem(EndArmazem idEndarmazem) {
        this.idEndarmazem = idEndarmazem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArmazem != null ? idArmazem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armazem)) {
            return false;
        }
        Armazem other = (Armazem) object;
        if ((this.idArmazem == null && other.idArmazem != null) || (this.idArmazem != null && !this.idArmazem.equals(other.idArmazem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.Armazem[ idArmazem=" + idArmazem + " ]";
    }

}
