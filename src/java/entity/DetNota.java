/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "det_nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetNota.findAll", query = "SELECT d FROM DetNota d"),
    @NamedQuery(name = "DetNota.findByIdDetalheNota", query = "SELECT d FROM DetNota d WHERE d.idDetalheNota = :idDetalheNota"),
    @NamedQuery(name = "DetNota.findByNumNota", query = "SELECT d FROM DetNota d WHERE d.numNota = :numNota"),
    @NamedQuery(name = "DetNota.findByDtPedido", query = "SELECT d FROM DetNota d WHERE d.dtPedido = :dtPedido"),
    @NamedQuery(name = "DetNota.findByValorTotal", query = "SELECT d FROM DetNota d WHERE d.valorTotal = :valorTotal"),
    @NamedQuery(name = "DetNota.findByIdFornecedor", query = "SELECT d FROM DetNota d WHERE d.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "DetNota.findByIdTipoEquipamento", query = "SELECT d FROM DetNota d WHERE d.idTipoEquipamento = :idTipoEquipamento"),
    @NamedQuery(name = "DetNota.findByValorUnitario", query = "SELECT d FROM DetNota d WHERE d.valorUnitario = :valorUnitario")})
public class DetNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalhe_nota")
    private Integer idDetalheNota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "num_nota")
    private String numNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_pedido")
    @Temporal(TemporalType.DATE)
    private Date dtPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    @Column(name = "id_tipo_equipamento")
    private Integer idTipoEquipamento;
    @Column(name = "valor_unitario")
    private Integer valorUnitario;
    @OneToMany(mappedBy = "idDetalheNota")
    private Collection<Movimentacao> movimentacaoCollection;
    @JoinColumn(name = "tipo_equipamento_id_tipo_equipamento", referencedColumnName = "id_tipo_equipamento")
    @ManyToOne(optional = false)
    private TipoEquipamento tipoEquipamentoIdTipoEquipamento;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne
    private Produto idProduto;
    @JoinColumn(name = "fornecedor_id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorIdFornecedor;

    public DetNota() {
    }

    public DetNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public DetNota(Integer idDetalheNota, String numNota, Date dtPedido, BigDecimal valorTotal) {
        this.idDetalheNota = idDetalheNota;
        this.numNota = numNota;
        this.dtPedido = dtPedido;
        this.valorTotal = valorTotal;
    }

    public Integer getIdDetalheNota() {
        return idDetalheNota;
    }

    public void setIdDetalheNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public String getNumNota() {
        return numNota;
    }

    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdTipoEquipamento() {
        return idTipoEquipamento;
    }

    public void setIdTipoEquipamento(Integer idTipoEquipamento) {
        this.idTipoEquipamento = idTipoEquipamento;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public TipoEquipamento getTipoEquipamentoIdTipoEquipamento() {
        return tipoEquipamentoIdTipoEquipamento;
    }

    public void setTipoEquipamentoIdTipoEquipamento(TipoEquipamento tipoEquipamentoIdTipoEquipamento) {
        this.tipoEquipamentoIdTipoEquipamento = tipoEquipamentoIdTipoEquipamento;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Fornecedor getFornecedorIdFornecedor() {
        return fornecedorIdFornecedor;
    }

    public void setFornecedorIdFornecedor(Fornecedor fornecedorIdFornecedor) {
        this.fornecedorIdFornecedor = fornecedorIdFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalheNota != null ? idDetalheNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetNota)) {
            return false;
        }
        DetNota other = (DetNota) object;
        if ((this.idDetalheNota == null && other.idDetalheNota != null) || (this.idDetalheNota != null && !this.idDetalheNota.equals(other.idDetalheNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetNota[ idDetalheNota=" + idDetalheNota + " ]";
    }

}
