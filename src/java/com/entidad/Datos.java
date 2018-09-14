/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raual
 */
@Entity
@Table(name = "datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d")
    , @NamedQuery(name = "Datos.findByCedula", query = "SELECT d FROM Datos d WHERE d.cedula = :cedula")
    , @NamedQuery(name = "Datos.findByNombre", query = "SELECT d FROM Datos d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Datos.findByApellido", query = "SELECT d FROM Datos d WHERE d.apellido = :apellido")
    , @NamedQuery(name = "Datos.findByDatoscol", query = "SELECT d FROM Datos d WHERE d.datoscol = :datoscol")
    , @NamedQuery(name = "Datos.findByTipoDocumento", query = "SELECT d FROM Datos d WHERE d.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Datos.findByFechaExp", query = "SELECT d FROM Datos d WHERE d.fechaExp = :fechaExp")
    , @NamedQuery(name = "Datos.findByTelefono", query = "SELECT d FROM Datos d WHERE d.telefono = :telefono")})
public class Datos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Long cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "datoscol")
    private String datoscol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_exp")
    @Temporal(TemporalType.DATE)
    private Date fechaExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private long telefono;
    @JoinColumn(name = "usuario_nick", referencedColumnName = "nick")
    @ManyToOne(optional = false)
    private Usuario usuarioNick;

    public Datos() {
    }

    public Datos(Long cedula) {
	this.cedula = cedula;
    }

    public Datos(Long cedula, String nombre, String apellido, String tipoDocumento, Date fechaExp, long telefono) {
	this.cedula = cedula;
	this.nombre = nombre;
	this.apellido = apellido;
	this.tipoDocumento = tipoDocumento;
	this.fechaExp = fechaExp;
	this.telefono = telefono;
    }

    public Long getCedula() {
	return cedula;
    }

    public void setCedula(Long cedula) {
	this.cedula = cedula;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getDatoscol() {
	return datoscol;
    }

    public void setDatoscol(String datoscol) {
	this.datoscol = datoscol;
    }

    public String getTipoDocumento() {
	return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
	this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaExp() {
	return fechaExp;
    }

    public void setFechaExp(Date fechaExp) {
	this.fechaExp = fechaExp;
    }

    public long getTelefono() {
	return telefono;
    }

    public void setTelefono(long telefono) {
	this.telefono = telefono;
    }

    public Usuario getUsuarioNick() {
	return usuarioNick;
    }

    public void setUsuarioNick(Usuario usuarioNick) {
	this.usuarioNick = usuarioNick;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (cedula != null ? cedula.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Datos)) {
	    return false;
	}
	Datos other = (Datos) object;
	if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "com.entidad.Datos[ cedula=" + cedula + " ]";
    }
    
}
