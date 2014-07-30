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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdClasse", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.findByNumClasse", query = "SELECT c FROM Classe c WHERE c.numClasse = :numClasse"),
    @NamedQuery(name = "Classe.findByNumSubclasse", query = "SELECT c FROM Classe c WHERE c.numSubclasse = :numSubclasse"),
    @NamedQuery(name = "Classe.findByEspecClasse", query = "SELECT c FROM Classe c WHERE c.especClasse = :especClasse")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_classe")
    private Integer idClasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_classe")
    private int numClasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_subclasse")
    private int numSubclasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "espec_classe")
    private String especClasse;
    @OneToMany(mappedBy = "idClasse")
    private Collection<Produto> produtoCollection;

    public Classe() {
    }

    public Classe(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Classe(Integer idClasse, int numClasse, int numSubclasse, String especClasse) {
        this.idClasse = idClasse;
        this.numClasse = numClasse;
        this.numSubclasse = numSubclasse;
        this.especClasse = especClasse;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public int getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(int numClasse) {
        this.numClasse = numClasse;
    }

    public int getNumSubclasse() {
        return numSubclasse;
    }

    public void setNumSubclasse(int numSubclasse) {
        this.numSubclasse = numSubclasse;
    }

    public String getEspecClasse() {
        return especClasse;
    }

    public void setEspecClasse(String especClasse) {
        this.especClasse = especClasse;
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
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.Classe[ idClasse=" + idClasse + " ]";
    }

}
