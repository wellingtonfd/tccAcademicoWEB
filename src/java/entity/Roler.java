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
@Table(name = "roler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roler.findAll", query = "SELECT r FROM Roler r"),
    @NamedQuery(name = "Roler.findByIdRoler", query = "SELECT r FROM Roler r WHERE r.idRoler = :idRoler"),
    @NamedQuery(name = "Roler.findByNomeRoler", query = "SELECT r FROM Roler r WHERE r.nomeRoler = :nomeRoler")})
public class Roler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roler")
    private Integer idRoler;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nome_roler")
    private String nomeRoler;
    @OneToMany(mappedBy = "idRoler")
    private Collection<Usuario> usuarioCollection;

    public Roler() {
    }

    public Roler(Integer idRoler) {
        this.idRoler = idRoler;
    }

    public Roler(Integer idRoler, String nomeRoler) {
        this.idRoler = idRoler;
        this.nomeRoler = nomeRoler;
    }

    public Integer getIdRoler() {
        return idRoler;
    }

    public void setIdRoler(Integer idRoler) {
        this.idRoler = idRoler;
    }

    public String getNomeRoler() {
        return nomeRoler;
    }

    public void setNomeRoler(String nomeRoler) {
        this.nomeRoler = nomeRoler;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoler != null ? idRoler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roler)) {
            return false;
        }
        Roler other = (Roler) object;
        if ((this.idRoler == null && other.idRoler != null) || (this.idRoler != null && !this.idRoler.equals(other.idRoler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roler[ idRoler=" + idRoler + " ]";
    }

}
