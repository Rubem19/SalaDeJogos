/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rsrub
 */
@Entity
@Table(name = "fabricante")
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByCodigofab", query = "SELECT f FROM Fabricante f WHERE f.codigofab = :codigofab"),
    @NamedQuery(name = "Fabricante.findByNome", query = "SELECT f FROM Fabricante f WHERE f.nome = :nome")})
public class Fabricante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigofab")
    private String codigofab;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "jogo_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jogo jogoCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabricanteCodigofab", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarioList;

    public Fabricante() {
    }

    public Fabricante(String codigofab) {
        this.codigofab = codigofab;
    }

    public Fabricante(String codigofab, String nome) {
        this.codigofab = codigofab;
        this.nome = nome;
    }

    public String getCodigofab() {
        return codigofab;
    }

    public void setCodigofab(String codigofab) {
        this.codigofab = codigofab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogo getJogoCodigo() {
        return jogoCodigo;
    }

    public void setJogoCodigo(Jogo jogoCodigo) {
        this.jogoCodigo = jogoCodigo;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigofab != null ? codigofab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.codigofab == null && other.codigofab != null) || (this.codigofab != null && !this.codigofab.equals(other.codigofab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fabricante[ codigofab=" + codigofab + " ]";
    }
    
}
