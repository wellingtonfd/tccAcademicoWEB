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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "embalagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Embalagem.findAll", query = "SELECT e FROM Embalagem e"),
    @NamedQuery(name = "Embalagem.findByIdEmbalagem", query = "SELECT e FROM Embalagem e WHERE e.idEmbalagem = :idEmbalagem"),
    @NamedQuery(name = "Embalagem.findByEspecEmabalagem", query = "SELECT e FROM Embalagem e WHERE e.especEmabalagem = :especEmabalagem")})
public class Embalagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_embalagem")
    private Integer idEmbalagem;
    @Size(max = 40)
    @Column(name = "espec_emabalagem")
    private String especEmabalagem;
    @JoinColumn(name = "id_material", referencedColumnName = "id_material")
    @ManyToOne
    private TipoMaterial idMaterial;
    @JoinColumn(name = "id_grupo_embalagem", referencedColumnName = "id_grupo_embalagem")
    @ManyToOne
    private GrupoEmbalagem idGrupoEmbalagem;
    @JoinColumn(name = "id_compatibilidade", referencedColumnName = "id_compatibilidade")
    @ManyToOne
    private Compatibilidade idCompatibilidade;
    @JoinColumn(name = "id_capacidade", referencedColumnName = "id_capacidade")
    @ManyToOne(optional = false)
    private Capacidade idCapacidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmbalagem")
    private Collection<Produto> produtoCollection;

    public Embalagem() {
    }

    public Embalagem(Integer idEmbalagem) {
        this.idEmbalagem = idEmbalagem;
    }

    public Integer getIdEmbalagem() {
        return idEmbalagem;
    }

    public void setIdEmbalagem(Integer idEmbalagem) {
        this.idEmbalagem = idEmbalagem;
    }

    public String getEspecEmabalagem() {
        return especEmabalagem;
    }

    public void setEspecEmabalagem(String especEmabalagem) {
        this.especEmabalagem = especEmabalagem;
    }

    public TipoMaterial getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(TipoMaterial idMaterial) {
        this.idMaterial = idMaterial;
    }

    public GrupoEmbalagem getIdGrupoEmbalagem() {
        return idGrupoEmbalagem;
    }

    public void setIdGrupoEmbalagem(GrupoEmbalagem idGrupoEmbalagem) {
        this.idGrupoEmbalagem = idGrupoEmbalagem;
    }

    public Compatibilidade getIdCompatibilidade() {
        return idCompatibilidade;
    }

    public void setIdCompatibilidade(Compatibilidade idCompatibilidade) {
        this.idCompatibilidade = idCompatibilidade;
    }

    public Capacidade getIdCapacidade() {
        return idCapacidade;
    }

    public void setIdCapacidade(Capacidade idCapacidade) {
        this.idCapacidade = idCapacidade;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmbalagem != null ? idEmbalagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Embalagem)) {
            return false;
        }
        Embalagem other = (Embalagem) object;
        if ((this.idEmbalagem == null && other.idEmbalagem != null) || (this.idEmbalagem != null && !this.idEmbalagem.equals(other.idEmbalagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Embalagem[ idEmbalagem=" + idEmbalagem + " ]";
    }

}
