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
@Table(name = "combustivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combustivel.findAll", query = "SELECT c FROM Combustivel c"),
    @NamedQuery(name = "Combustivel.findByIdCombustivel", query = "SELECT c FROM Combustivel c WHERE c.idCombustivel = :idCombustivel"),
    @NamedQuery(name = "Combustivel.findByNomeCombustivel", query = "SELECT c FROM Combustivel c WHERE c.nomeCombustivel = :nomeCombustivel"),
    @NamedQuery(name = "Combustivel.findByEspecCombustivel", query = "SELECT c FROM Combustivel c WHERE c.especCombustivel = :especCombustivel")})
public class Combustivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_combustivel")
    private Integer idCombustivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nome_combustivel")
    private String nomeCombustivel;
    @Size(max = 45)
    @Column(name = "espec_combustivel")
    private String especCombustivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCombustivel")
    private Collection<Veiculo> veiculoCollection;

    public Combustivel() {
    }

    public Combustivel(Integer idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public Combustivel(Integer idCombustivel, String nomeCombustivel) {
        this.idCombustivel = idCombustivel;
        this.nomeCombustivel = nomeCombustivel;
    }

    public Integer getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(Integer idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }

    public String getEspecCombustivel() {
        return especCombustivel;
    }

    public void setEspecCombustivel(String especCombustivel) {
        this.especCombustivel = especCombustivel;
    }

    @XmlTransient
    public Collection<Veiculo> getVeiculoCollection() {
        return veiculoCollection;
    }

    public void setVeiculoCollection(Collection<Veiculo> veiculoCollection) {
        this.veiculoCollection = veiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCombustivel != null ? idCombustivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combustivel)) {
            return false;
        }
        Combustivel other = (Combustivel) object;
        if ((this.idCombustivel == null && other.idCombustivel != null) || (this.idCombustivel != null && !this.idCombustivel.equals(other.idCombustivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.Combustivel[ idCombustivel=" + idCombustivel + " ]";
    }

}
