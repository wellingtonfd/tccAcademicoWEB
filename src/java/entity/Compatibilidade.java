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
@Table(name = "compatibilidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compatibilidade.findAll", query = "SELECT c FROM Compatibilidade c"),
    @NamedQuery(name = "Compatibilidade.findByIdCompatibilidade", query = "SELECT c FROM Compatibilidade c WHERE c.idCompatibilidade = :idCompatibilidade"),
    @NamedQuery(name = "Compatibilidade.findByGrupoCompatibilidade", query = "SELECT c FROM Compatibilidade c WHERE c.grupoCompatibilidade = :grupoCompatibilidade"),
    @NamedQuery(name = "Compatibilidade.findByDescCompatibilidade", query = "SELECT c FROM Compatibilidade c WHERE c.descCompatibilidade = :descCompatibilidade"),
    @NamedQuery(name = "Compatibilidade.findByCodClassifi", query = "SELECT c FROM Compatibilidade c WHERE c.codClassifi = :codClassifi")})
public class Compatibilidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compatibilidade")
    private Integer idCompatibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "grupo_compatibilidade")
    private String grupoCompatibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_compatibilidade")
    private String descCompatibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_classifi")
    private String codClassifi;
    @OneToMany(mappedBy = "idCompatibilidade")
    private Collection<Embalagem> embalagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompatibilidade")
    private Collection<Produto> produtoCollection;
    @JoinColumn(name = "id_legenda_compatibilidade", referencedColumnName = "id_legenda_compatibilidade")
    @ManyToOne
    private LegendaCompatibilidade idLegendaCompatibilidade;

    public Compatibilidade() {
    }

    public Compatibilidade(Integer idCompatibilidade) {
        this.idCompatibilidade = idCompatibilidade;
    }

    public Compatibilidade(Integer idCompatibilidade, String grupoCompatibilidade, String descCompatibilidade, String codClassifi) {
        this.idCompatibilidade = idCompatibilidade;
        this.grupoCompatibilidade = grupoCompatibilidade;
        this.descCompatibilidade = descCompatibilidade;
        this.codClassifi = codClassifi;
    }

    public Integer getIdCompatibilidade() {
        return idCompatibilidade;
    }

    public void setIdCompatibilidade(Integer idCompatibilidade) {
        this.idCompatibilidade = idCompatibilidade;
    }

    public String getGrupoCompatibilidade() {
        return grupoCompatibilidade;
    }

    public void setGrupoCompatibilidade(String grupoCompatibilidade) {
        this.grupoCompatibilidade = grupoCompatibilidade;
    }

    public String getDescCompatibilidade() {
        return descCompatibilidade;
    }

    public void setDescCompatibilidade(String descCompatibilidade) {
        this.descCompatibilidade = descCompatibilidade;
    }

    public String getCodClassifi() {
        return codClassifi;
    }

    public void setCodClassifi(String codClassifi) {
        this.codClassifi = codClassifi;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public LegendaCompatibilidade getIdLegendaCompatibilidade() {
        return idLegendaCompatibilidade;
    }

    public void setIdLegendaCompatibilidade(LegendaCompatibilidade idLegendaCompatibilidade) {
        this.idLegendaCompatibilidade = idLegendaCompatibilidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompatibilidade != null ? idCompatibilidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compatibilidade)) {
            return false;
        }
        Compatibilidade other = (Compatibilidade) object;
        if ((this.idCompatibilidade == null && other.idCompatibilidade != null) || (this.idCompatibilidade != null && !this.idCompatibilidade.equals(other.idCompatibilidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.Compatibilidade[ idCompatibilidade=" + idCompatibilidade + " ]";
    }

}
