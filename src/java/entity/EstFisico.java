/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Entity
@Table(name = "est_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstFisico.findAll", query = "SELECT e FROM EstFisico e"),
    @NamedQuery(name = "EstFisico.findByIdEstFisico", query = "SELECT e FROM EstFisico e WHERE e.idEstFisico = :idEstFisico"),
    @NamedQuery(name = "EstFisico.findByNomeEstFisico", query = "SELECT e FROM EstFisico e WHERE e.nomeEstFisico = :nomeEstFisico"),
    @NamedQuery(name = "EstFisico.findByEspEstFisico", query = "SELECT e FROM EstFisico e WHERE e.espEstFisico = :espEstFisico")})
public class EstFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_est_fisico")
    private Integer idEstFisico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "nome_est_fisico")
    private String nomeEstFisico;
    @Size(max = 50)
    @Column(name = "esp_est_fisico")
    private String espEstFisico;

    public EstFisico() {
    }

    public EstFisico(Integer idEstFisico) {
        this.idEstFisico = idEstFisico;
    }

    public EstFisico(Integer idEstFisico, String nomeEstFisico) {
        this.idEstFisico = idEstFisico;
        this.nomeEstFisico = nomeEstFisico;
    }

    public Integer getIdEstFisico() {
        return idEstFisico;
    }

    public void setIdEstFisico(Integer idEstFisico) {
        this.idEstFisico = idEstFisico;
    }

    public String getNomeEstFisico() {
        return nomeEstFisico;
    }

    public void setNomeEstFisico(String nomeEstFisico) {
        this.nomeEstFisico = nomeEstFisico;
    }

    public String getEspEstFisico() {
        return espEstFisico;
    }

    public void setEspEstFisico(String espEstFisico) {
        this.espEstFisico = espEstFisico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstFisico != null ? idEstFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstFisico)) {
            return false;
        }
        EstFisico other = (EstFisico) object;
        if ((this.idEstFisico == null && other.idEstFisico != null) || (this.idEstFisico != null && !this.idEstFisico.equals(other.idEstFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EstFisico[ idEstFisico=" + idEstFisico + " ]";
    }

}
