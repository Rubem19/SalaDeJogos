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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rsrub
 */
@Entity
@Table(name = "jogo")
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j"),
    @NamedQuery(name = "Jogo.findByCodigo", query = "SELECT j FROM Jogo j WHERE j.codigo = :codigo"),
    @NamedQuery(name = "Jogo.findByNome", query = "SELECT j FROM Jogo j WHERE j.nome = :nome"),
    @NamedQuery(name = "Jogo.findByPlataforma", query = "SELECT j FROM Jogo j WHERE j.plataforma = :plataforma"),
    @NamedQuery(name = "Jogo.findByCategoria", query = "SELECT j FROM Jogo j WHERE j.categoria = :categoria")})
public class Jogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "plataforma")
    private String plataforma;
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jogoCodigo", fetch = FetchType.EAGER)
    private List<Fabricante> fabricanteList;

    public Jogo() {
    }

    public Jogo(String codigo) {
        this.codigo = codigo;
    }

    public Jogo(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Fabricante> getFabricanteList() {
        return fabricanteList;
    }

    public void setFabricanteList(List<Fabricante> fabricanteList) {
        this.fabricanteList = fabricanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Jogo[ codigo=" + codigo + " ]";
    }
    
}
