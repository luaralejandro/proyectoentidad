/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author raual
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNick", query = "SELECT u FROM Usuario u WHERE u.nick = :nick")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nick")
    private String nick;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Contrasena")
    private String contrasena;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioNick")
    private Collection<Datos> datosCollection;

    public Usuario() {
    }

    public Usuario(String nick) {
	this.nick = nick;
    }

    public Usuario(String nick, String contrasena) {
	this.nick = nick;
	this.contrasena = contrasena;
    }

    public String getNick() {
	return nick;
    }

    public void setNick(String nick) {
	this.nick = nick;
    }

    public String getContrasena() {
	return contrasena;
    }

    public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Datos> getDatosCollection() {
	return datosCollection;
    }

    public void setDatosCollection(Collection<Datos> datosCollection) {
	this.datosCollection = datosCollection;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (nick != null ? nick.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Usuario)) {
	    return false;
	}
	Usuario other = (Usuario) object;
	if ((this.nick == null && other.nick != null) || (this.nick != null && !this.nick.equals(other.nick))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "com.entidad.Usuario[ nick=" + nick + " ]";
    }
    
}
