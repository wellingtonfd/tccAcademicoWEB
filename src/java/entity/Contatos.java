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
@Table(name = "contatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contatos.findAll", query = "SELECT c FROM Contatos c"),
    @NamedQuery(name = "Contatos.findByIdContato", query = "SELECT c FROM Contatos c WHERE c.idContato = :idContato"),
    @NamedQuery(name = "Contatos.findByTel", query = "SELECT c FROM Contatos c WHERE c.tel = :tel"),
    @NamedQuery(name = "Contatos.findByEmail", query = "SELECT c FROM Contatos c WHERE c.email = :email"),
    @NamedQuery(name = "Contatos.findByCelular", query = "SELECT c FROM Contatos c WHERE c.celular = :celular"),
    @NamedQuery(name = "Contatos.findBySite", query = "SELECT c FROM Contatos c WHERE c.site = :site"),
    @NamedQuery(name = "Contatos.findByRadio", query = "SELECT c FROM Contatos c WHERE c.radio = :radio")})
public class Contatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contato")
    private Integer idContato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "radio")
    private String radio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contatosIdContato")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contatosIdContato")
    private Collection<Funcionario> funcionarioCollection;

    public Contatos() {
    }

    public Contatos(Integer idContato) {
        this.idContato = idContato;
    }

    public Contatos(Integer idContato, String tel, String email, String celular, String site, String radio) {
        this.idContato = idContato;
        this.tel = tel;
        this.email = email;
        this.celular = celular;
        this.site = site;
        this.radio = radio;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contatos)) {
            return false;
        }
        Contatos other = (Contatos) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Contatos[ idContato=" + idContato + " ]";
    }

}
