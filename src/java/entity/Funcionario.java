/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Funcionario.findBySbNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.sbNomeFuncionario = :sbNomeFuncionario"),
    @NamedQuery(name = "Funcionario.findBySexo", query = "SELECT f FROM Funcionario f WHERE f.sexo = :sexo"),
    @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionario.findByRg", query = "SELECT f FROM Funcionario f WHERE f.rg = :rg"),
    @NamedQuery(name = "Funcionario.findByDtNasc", query = "SELECT f FROM Funcionario f WHERE f.dtNasc = :dtNasc"),
    @NamedQuery(name = "Funcionario.findByMatFuncionario", query = "SELECT f FROM Funcionario f WHERE f.matFuncionario = :matFuncionario"),
    @NamedQuery(name = "Funcionario.findByDtAdmissao", query = "SELECT f FROM Funcionario f WHERE f.dtAdmissao = :dtAdmissao"),
    @NamedQuery(name = "Funcionario.findByFuncao", query = "SELECT f FROM Funcionario f WHERE f.funcao = :funcao"),
    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "Funcionario.findByNivelFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nivelFuncionario = :nivelFuncionario"),
    @NamedQuery(name = "Funcionario.findByEspecializacao", query = "SELECT f FROM Funcionario f WHERE f.especializacao = :especializacao"),
    @NamedQuery(name = "Funcionario.findByIdContato", query = "SELECT f FROM Funcionario f WHERE f.idContato = :idContato"),
    @NamedQuery(name = "Funcionario.findByIdEndereco", query = "SELECT f FROM Funcionario f WHERE f.idEndereco = :idEndereco")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nome_funcionario")
    private String nomeFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "sb_nome_funcionario")
    private String sbNomeFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_nasc")
    @Temporal(TemporalType.DATE)
    private Date dtNasc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_funcionario")
    private int matFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_admissao")
    @Temporal(TemporalType.DATE)
    private Date dtAdmissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "funcao")
    private String funcao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nivel_funcionario")
    private String nivelFuncionario;
    @Size(max = 12)
    @Column(name = "especializacao")
    private String especializacao;
    @Column(name = "id_contato")
    private Integer idContato;
    @Column(name = "id_endereco")
    private Integer idEndereco;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<TipoSolicitacao> tipoSolicitacaoCollection;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Movimentacao> movimentacaoCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "endereco_id_endereco", referencedColumnName = "id_endereco")
    @ManyToOne(optional = false)
    private Endereco enderecoIdEndereco;
    @JoinColumn(name = "contatos_id_contato", referencedColumnName = "id_contato")
    @ManyToOne(optional = false)
    private Contatos contatosIdContato;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nomeFuncionario, String sbNomeFuncionario, String sexo, String cpf, String rg, Date dtNasc, int matFuncionario, Date dtAdmissao, String funcao, String cargo, String nivelFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.sbNomeFuncionario = sbNomeFuncionario;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.dtNasc = dtNasc;
        this.matFuncionario = matFuncionario;
        this.dtAdmissao = dtAdmissao;
        this.funcao = funcao;
        this.cargo = cargo;
        this.nivelFuncionario = nivelFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSbNomeFuncionario() {
        return sbNomeFuncionario;
    }

    public void setSbNomeFuncionario(String sbNomeFuncionario) {
        this.sbNomeFuncionario = sbNomeFuncionario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public int getMatFuncionario() {
        return matFuncionario;
    }

    public void setMatFuncionario(int matFuncionario) {
        this.matFuncionario = matFuncionario;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivelFuncionario() {
        return nivelFuncionario;
    }

    public void setNivelFuncionario(String nivelFuncionario) {
        this.nivelFuncionario = nivelFuncionario;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @XmlTransient
    public Collection<TipoSolicitacao> getTipoSolicitacaoCollection() {
        return tipoSolicitacaoCollection;
    }

    public void setTipoSolicitacaoCollection(Collection<TipoSolicitacao> tipoSolicitacaoCollection) {
        this.tipoSolicitacaoCollection = tipoSolicitacaoCollection;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Endereco getEnderecoIdEndereco() {
        return enderecoIdEndereco;
    }

    public void setEnderecoIdEndereco(Endereco enderecoIdEndereco) {
        this.enderecoIdEndereco = enderecoIdEndereco;
    }

    public Contatos getContatosIdContato() {
        return contatosIdContato;
    }

    public void setContatosIdContato(Contatos contatosIdContato) {
        this.contatosIdContato = contatosIdContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scpp.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }

}
