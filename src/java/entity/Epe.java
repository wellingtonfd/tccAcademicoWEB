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
@Table(name = "epe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epe.findAll", query = "SELECT e FROM Epe e"),
    @NamedQuery(name = "Epe.findByIdEpe", query = "SELECT e FROM Epe e WHERE e.idEpe = :idEpe"),
    @NamedQuery(name = "Epe.findByNomeEpe", query = "SELECT e FROM Epe e WHERE e.nomeEpe = :nomeEpe"),
    @NamedQuery(name = "Epe.findByClasseEpe", query = "SELECT e FROM Epe e WHERE e.classeEpe = :classeEpe"),
    @NamedQuery(name = "Epe.findByAgenteEpe", query = "SELECT e FROM Epe e WHERE e.agenteEpe = :agenteEpe")})
public class Epe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_epe")
    private Integer idEpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_epe")
    private String nomeEpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "classe_epe")
    private String classeEpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "agente_epe")
    private String agenteEpe;
    @JoinColumn(name = "tipo_material_id_material", referencedColumnName = "id_material")
    @ManyToOne(optional = false)
    private TipoMaterial tipoMaterialIdMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epeIdEpe")
    private Collection<TipoEquipamento> tipoEquipamentoCollection;

    public Epe() {
    }

    public Epe(Integer idEpe) {
        this.idEpe = idEpe;
    }

    public Epe(Integer idEpe, String nomeEpe, String classeEpe, String agenteEpe) {
        this.idEpe = idEpe;
        this.nomeEpe = nomeEpe;
        this.classeEpe = classeEpe;
        this.agenteEpe = agenteEpe;
    }

    public Integer getIdEpe() {
        return idEpe;
    }

    public void setIdEpe(Integer idEpe) {
        this.idEpe = idEpe;
    }

    public String getNomeEpe() {
        return nomeEpe;
    }

    public void setNomeEpe(String nomeEpe) {
        this.nomeEpe = nomeEpe;
    }

    public String getClasseEpe() {
        return classeEpe;
    }

    public void setClasseEpe(String classeEpe) {
        this.classeEpe = classeEpe;
    }

    public String getAgenteEpe() {
        return agenteEpe;
    }

    public void setAgenteEpe(String agenteEpe) {
        this.agenteEpe = agenteEpe;
    }

    public TipoMaterial getTipoMaterialIdMaterial() {
        return tipoMaterialIdMaterial;
    }

    public void setTipoMaterialIdMaterial(TipoMaterial tipoMaterialIdMaterial) {
        this.tipoMaterialIdMaterial = tipoMaterialIdMaterial;
    }

    @XmlTransient
    public Collection<TipoEquipamento> getTipoEquipamentoCollection() {
        return tipoEquipamentoCollection;
    }

    public void setTipoEquipamentoCollection(Collection<TipoEquipamento> tipoEquipamentoCollection) {
        this.tipoEquipamentoCollection = tipoEquipamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEpe != null ? idEpe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epe)) {
            return false;
        }
        Epe other = (Epe) object;
        if ((this.idEpe == null && other.idEpe != null) || (this.idEpe != null && !this.idEpe.equals(other.idEpe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Epe[ idEpe=" + idEpe + " ]";
    }

}
