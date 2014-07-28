/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByNomeGenerico", query = "SELECT p FROM Produto p WHERE p.nomeGenerico = :nomeGenerico"),
    @NamedQuery(name = "Produto.findByOrigem", query = "SELECT p FROM Produto p WHERE p.origem = :origem"),
    @NamedQuery(name = "Produto.findByRotuloProduto", query = "SELECT p FROM Produto p WHERE p.rotuloProduto = :rotuloProduto"),
    @NamedQuery(name = "Produto.findByPainelSeguranca", query = "SELECT p FROM Produto p WHERE p.painelSeguranca = :painelSeguranca"),
    @NamedQuery(name = "Produto.findByNumRisco", query = "SELECT p FROM Produto p WHERE p.numRisco = :numRisco"),
    @NamedQuery(name = "Produto.findByAcoesEmerg", query = "SELECT p FROM Produto p WHERE p.acoesEmerg = :acoesEmerg"),
    @NamedQuery(name = "Produto.findByNLote", query = "SELECT p FROM Produto p WHERE p.nLote = :nLote"),
    @NamedQuery(name = "Produto.findByDtFab", query = "SELECT p FROM Produto p WHERE p.dtFab = :dtFab"),
    @NamedQuery(name = "Produto.findByDtVal", query = "SELECT p FROM Produto p WHERE p.dtVal = :dtVal"),
    @NamedQuery(name = "Produto.findByComposicao", query = "SELECT p FROM Produto p WHERE p.composicao = :composicao"),
    @NamedQuery(name = "Produto.findByDescProduto", query = "SELECT p FROM Produto p WHERE p.descProduto = :descProduto"),
    @NamedQuery(name = "Produto.findByFormulaProduto", query = "SELECT p FROM Produto p WHERE p.formulaProduto = :formulaProduto"),
    @NamedQuery(name = "Produto.findByOdorProduto", query = "SELECT p FROM Produto p WHERE p.odorProduto = :odorProduto"),
    @NamedQuery(name = "Produto.findByIdEstFisico", query = "SELECT p FROM Produto p WHERE p.idEstFisico = :idEstFisico"),
    @NamedQuery(name = "Produto.findByIdArmazem", query = "SELECT p FROM Produto p WHERE p.idArmazem = :idArmazem")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nome_generico")
    private String nomeGenerico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "origem")
    private String origem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "rotulo_produto")
    private String rotuloProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "painel_seguranca")
    private String painelSeguranca;
    @Column(name = "num_risco")
    private Integer numRisco;
    @Size(max = 80)
    @Column(name = "acoes_emerg")
    private String acoesEmerg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_lote")
    private int nLote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_fab")
    @Temporal(TemporalType.DATE)
    private Date dtFab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_val")
    @Temporal(TemporalType.DATE)
    private Date dtVal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "composicao")
    private String composicao;
    @Size(max = 60)
    @Column(name = "desc_produto")
    private String descProduto;
    @Size(max = 2147483647)
    @Column(name = "formula_produto")
    private String formulaProduto;
    @Size(max = 25)
    @Column(name = "odor_produto")
    private String odorProduto;
    @Column(name = "id_est_fisico")
    private Integer idEstFisico;
    @Column(name = "id_armazem")
    private Integer idArmazem;
    @JoinColumn(name = "id_num_onu", referencedColumnName = "id_num_onu")
    @ManyToOne
    private NumOnu idNumOnu;
    @JoinColumn(name = "id_num_cas", referencedColumnName = "id_num_cas")
    @ManyToOne
    private NumCas idNumCas;
    @JoinColumn(name = "id_legenda_compatibilidade", referencedColumnName = "id_legenda_compatibilidade")
    @ManyToOne
    private LegendaCompatibilidade idLegendaCompatibilidade;
    @JoinColumn(name = "id_endarmazem", referencedColumnName = "id_endarmazem")
    @ManyToOne
    private EndArmazem idEndarmazem;
    @JoinColumn(name = "id_embalagem", referencedColumnName = "id_embalagem")
    @ManyToOne(optional = false)
    private Embalagem idEmbalagem;
    @JoinColumn(name = "id_compatibilidade", referencedColumnName = "id_compatibilidade")
    @ManyToOne(optional = false)
    private Compatibilidade idCompatibilidade;
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne
    private Classe idClasse;
    @JoinColumn(name = "armazem_id_armazem", referencedColumnName = "id_armazem")
    @ManyToOne(optional = false)
    private Armazem armazemIdArmazem;
    @OneToMany(mappedBy = "idProduto")
    private Collection<Movimentacao> movimentacaoCollection;
    @OneToMany(mappedBy = "idProduto")
    private Collection<DetNota> detNotaCollection;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String nomeGenerico, String origem, String rotuloProduto, String painelSeguranca, int nLote, Date dtFab, Date dtVal, String composicao) {
        this.idProduto = idProduto;
        this.nomeGenerico = nomeGenerico;
        this.origem = origem;
        this.rotuloProduto = rotuloProduto;
        this.painelSeguranca = painelSeguranca;
        this.nLote = nLote;
        this.dtFab = dtFab;
        this.dtVal = dtVal;
        this.composicao = composicao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeGenerico() {
        return nomeGenerico;
    }

    public void setNomeGenerico(String nomeGenerico) {
        this.nomeGenerico = nomeGenerico;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getRotuloProduto() {
        return rotuloProduto;
    }

    public void setRotuloProduto(String rotuloProduto) {
        this.rotuloProduto = rotuloProduto;
    }

    public String getPainelSeguranca() {
        return painelSeguranca;
    }

    public void setPainelSeguranca(String painelSeguranca) {
        this.painelSeguranca = painelSeguranca;
    }

    public Integer getNumRisco() {
        return numRisco;
    }

    public void setNumRisco(Integer numRisco) {
        this.numRisco = numRisco;
    }

    public String getAcoesEmerg() {
        return acoesEmerg;
    }

    public void setAcoesEmerg(String acoesEmerg) {
        this.acoesEmerg = acoesEmerg;
    }

    public int getNLote() {
        return nLote;
    }

    public void setNLote(int nLote) {
        this.nLote = nLote;
    }

    public Date getDtFab() {
        return dtFab;
    }

    public void setDtFab(Date dtFab) {
        this.dtFab = dtFab;
    }

    public Date getDtVal() {
        return dtVal;
    }

    public void setDtVal(Date dtVal) {
        this.dtVal = dtVal;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getFormulaProduto() {
        return formulaProduto;
    }

    public void setFormulaProduto(String formulaProduto) {
        this.formulaProduto = formulaProduto;
    }

    public String getOdorProduto() {
        return odorProduto;
    }

    public void setOdorProduto(String odorProduto) {
        this.odorProduto = odorProduto;
    }

    public Integer getIdEstFisico() {
        return idEstFisico;
    }

    public void setIdEstFisico(Integer idEstFisico) {
        this.idEstFisico = idEstFisico;
    }

    public Integer getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public NumOnu getIdNumOnu() {
        return idNumOnu;
    }

    public void setIdNumOnu(NumOnu idNumOnu) {
        this.idNumOnu = idNumOnu;
    }

    public NumCas getIdNumCas() {
        return idNumCas;
    }

    public void setIdNumCas(NumCas idNumCas) {
        this.idNumCas = idNumCas;
    }

    public LegendaCompatibilidade getIdLegendaCompatibilidade() {
        return idLegendaCompatibilidade;
    }

    public void setIdLegendaCompatibilidade(LegendaCompatibilidade idLegendaCompatibilidade) {
        this.idLegendaCompatibilidade = idLegendaCompatibilidade;
    }

    public EndArmazem getIdEndarmazem() {
        return idEndarmazem;
    }

    public void setIdEndarmazem(EndArmazem idEndarmazem) {
        this.idEndarmazem = idEndarmazem;
    }

    public Embalagem getIdEmbalagem() {
        return idEmbalagem;
    }

    public void setIdEmbalagem(Embalagem idEmbalagem) {
        this.idEmbalagem = idEmbalagem;
    }

    public Compatibilidade getIdCompatibilidade() {
        return idCompatibilidade;
    }

    public void setIdCompatibilidade(Compatibilidade idCompatibilidade) {
        this.idCompatibilidade = idCompatibilidade;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public Armazem getArmazemIdArmazem() {
        return armazemIdArmazem;
    }

    public void setArmazemIdArmazem(Armazem armazemIdArmazem) {
        this.armazemIdArmazem = armazemIdArmazem;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    @XmlTransient
    public Collection<DetNota> getDetNotaCollection() {
        return detNotaCollection;
    }

    public void setDetNotaCollection(Collection<DetNota> detNotaCollection) {
        this.detNotaCollection = detNotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produto[ idProduto=" + idProduto + " ]";
    }

}
