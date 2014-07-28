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
@Table(name = "tipo_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMaterial.findAll", query = "SELECT t FROM TipoMaterial t"),
    @NamedQuery(name = "TipoMaterial.findByIdMaterial", query = "SELECT t FROM TipoMaterial t WHERE t.idMaterial = :idMaterial"),
    @NamedQuery(name = "TipoMaterial.findByNomeMaterial", query = "SELECT t FROM TipoMaterial t WHERE t.nomeMaterial = :nomeMaterial"),
    @NamedQuery(name = "TipoMaterial.findByEspecMaterial", query = "SELECT t FROM TipoMaterial t WHERE t.especMaterial = :especMaterial"),
    @NamedQuery(name = "TipoMaterial.findByPtFulgor", query = "SELECT t FROM TipoMaterial t WHERE t.ptFulgor = :ptFulgor"),
    @NamedQuery(name = "TipoMaterial.findByPtEbuliO", query = "SELECT t FROM TipoMaterial t WHERE t.ptEbuliO = :ptEbuliO")})
public class TipoMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material")
    private Integer idMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_material")
    private String nomeMaterial;
    @Size(max = 60)
    @Column(name = "espec_material")
    private String especMaterial;
    @Size(max = 20)
    @Column(name = "pt_fulgor")
    private String ptFulgor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pt_ebuli\ufffd\ufffdo")
    private String ptEbuliO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMaterialIdMaterial")
    private Collection<Epe> epeCollection;
    @OneToMany(mappedBy = "idMaterial")
    private Collection<Embalagem> embalagemCollection;
    @OneToMany(mappedBy = "idMaterial")
    private Collection<Epi> epiCollection;

    public TipoMaterial() {
    }

    public TipoMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public TipoMaterial(Integer idMaterial, String nomeMaterial, String ptEbuliO) {
        this.idMaterial = idMaterial;
        this.nomeMaterial = nomeMaterial;
        this.ptEbuliO = ptEbuliO;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public String getEspecMaterial() {
        return especMaterial;
    }

    public void setEspecMaterial(String especMaterial) {
        this.especMaterial = especMaterial;
    }

    public String getPtFulgor() {
        return ptFulgor;
    }

    public void setPtFulgor(String ptFulgor) {
        this.ptFulgor = ptFulgor;
    }

    public String getPtEbuliO() {
        return ptEbuliO;
    }

    public void setPtEbuliO(String ptEbuliO) {
        this.ptEbuliO = ptEbuliO;
    }

    @XmlTransient
    public Collection<Epe> getEpeCollection() {
        return epeCollection;
    }

    public void setEpeCollection(Collection<Epe> epeCollection) {
        this.epeCollection = epeCollection;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
    }

    @XmlTransient
    public Collection<Epi> getEpiCollection() {
        return epiCollection;
    }

    public void setEpiCollection(Collection<Epi> epiCollection) {
        this.epiCollection = epiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMaterial)) {
            return false;
        }
        TipoMaterial other = (TipoMaterial) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoMaterial[ idMaterial=" + idMaterial + " ]";
    }

}
