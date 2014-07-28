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
@Table(name = "grupo_embalagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoEmbalagem.findAll", query = "SELECT g FROM GrupoEmbalagem g"),
    @NamedQuery(name = "GrupoEmbalagem.findByIdGrupoEmbalagem", query = "SELECT g FROM GrupoEmbalagem g WHERE g.idGrupoEmbalagem = :idGrupoEmbalagem"),
    @NamedQuery(name = "GrupoEmbalagem.findByNomeGrupoEmbalagem", query = "SELECT g FROM GrupoEmbalagem g WHERE g.nomeGrupoEmbalagem = :nomeGrupoEmbalagem"),
    @NamedQuery(name = "GrupoEmbalagem.findByEspecGrupoEmbalagem", query = "SELECT g FROM GrupoEmbalagem g WHERE g.especGrupoEmbalagem = :especGrupoEmbalagem")})
public class GrupoEmbalagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_embalagem")
    private Integer idGrupoEmbalagem;
    @Size(max = 40)
    @Column(name = "nome_grupo_embalagem")
    private String nomeGrupoEmbalagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "espec_grupo_embalagem")
    private String especGrupoEmbalagem;
    @OneToMany(mappedBy = "idGrupoEmbalagem")
    private Collection<Embalagem> embalagemCollection;

    public GrupoEmbalagem() {
    }

    public GrupoEmbalagem(Integer idGrupoEmbalagem) {
        this.idGrupoEmbalagem = idGrupoEmbalagem;
    }

    public GrupoEmbalagem(Integer idGrupoEmbalagem, String especGrupoEmbalagem) {
        this.idGrupoEmbalagem = idGrupoEmbalagem;
        this.especGrupoEmbalagem = especGrupoEmbalagem;
    }

    public Integer getIdGrupoEmbalagem() {
        return idGrupoEmbalagem;
    }

    public void setIdGrupoEmbalagem(Integer idGrupoEmbalagem) {
        this.idGrupoEmbalagem = idGrupoEmbalagem;
    }

    public String getNomeGrupoEmbalagem() {
        return nomeGrupoEmbalagem;
    }

    public void setNomeGrupoEmbalagem(String nomeGrupoEmbalagem) {
        this.nomeGrupoEmbalagem = nomeGrupoEmbalagem;
    }

    public String getEspecGrupoEmbalagem() {
        return especGrupoEmbalagem;
    }

    public void setEspecGrupoEmbalagem(String especGrupoEmbalagem) {
        this.especGrupoEmbalagem = especGrupoEmbalagem;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoEmbalagem != null ? idGrupoEmbalagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoEmbalagem)) {
            return false;
        }
        GrupoEmbalagem other = (GrupoEmbalagem) object;
        if ((this.idGrupoEmbalagem == null && other.idGrupoEmbalagem != null) || (this.idGrupoEmbalagem != null && !this.idGrupoEmbalagem.equals(other.idGrupoEmbalagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GrupoEmbalagem[ idGrupoEmbalagem=" + idGrupoEmbalagem + " ]";
    }

}
