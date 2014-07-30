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
@Table(name = "local_operacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalOperacao.findAll", query = "SELECT l FROM LocalOperacao l"),
    @NamedQuery(name = "LocalOperacao.findByIdLocalOper", query = "SELECT l FROM LocalOperacao l WHERE l.idLocalOper = :idLocalOper"),
    @NamedQuery(name = "LocalOperacao.findByDescLocalOper", query = "SELECT l FROM LocalOperacao l WHERE l.descLocalOper = :descLocalOper"),
    @NamedQuery(name = "LocalOperacao.findByLocalOper", query = "SELECT l FROM LocalOperacao l WHERE l.localOper = :localOper")})
public class LocalOperacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_local_oper")
    private Integer idLocalOper;
    @Size(max = 45)
    @Column(name = "desc__local_oper")
    private String descLocalOper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "local_oper")
    private String localOper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localOperacaoIdLocalOper")
    private Collection<Armazem> armazemCollection;

    public LocalOperacao() {
    }

    public LocalOperacao(Integer idLocalOper) {
        this.idLocalOper = idLocalOper;
    }

    public LocalOperacao(Integer idLocalOper, String localOper) {
        this.idLocalOper = idLocalOper;
        this.localOper = localOper;
    }

    public Integer getIdLocalOper() {
        return idLocalOper;
    }

    public void setIdLocalOper(Integer idLocalOper) {
        this.idLocalOper = idLocalOper;
    }

    public String getDescLocalOper() {
        return descLocalOper;
    }

    public void setDescLocalOper(String descLocalOper) {
        this.descLocalOper = descLocalOper;
    }

    public String getLocalOper() {
        return localOper;
    }

    public void setLocalOper(String localOper) {
        this.localOper = localOper;
    }

    @XmlTransient
    public Collection<Armazem> getArmazemCollection() {
        return armazemCollection;
    }

    public void setArmazemCollection(Collection<Armazem> armazemCollection) {
        this.armazemCollection = armazemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalOper != null ? idLocalOper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalOperacao)) {
            return false;
        }
        LocalOperacao other = (LocalOperacao) object;
        if ((this.idLocalOper == null && other.idLocalOper != null) || (this.idLocalOper != null && !this.idLocalOper.equals(other.idLocalOper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.LocalOperacao[ idLocalOper=" + idLocalOper + " ]";
    }

}
