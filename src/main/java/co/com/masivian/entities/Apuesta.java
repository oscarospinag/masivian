/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.masivian.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "APUESTA")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Apuesta.findAll", query = "SELECT a FROM Apuesta a"),
		@NamedQuery(name = "Apuesta.findById", query = "SELECT a FROM Apuesta a WHERE a.id = :id"),
		@NamedQuery(name = "Apuesta.findByValue", query = "SELECT a FROM Apuesta a WHERE a.value = :value") })
public class Apuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@SequenceGenerator(name = "SEQ_ID_GENERATOR", sequenceName = "APUESTA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
	@Basic(optional = false)
	@Column(name = "ID")
	private Long id;
	@Column(name = "VALUE")
	private Double value;
	@JoinColumn(name = "ID_RULETA", referencedColumnName = "ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Ruleta idRuleta;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "NUMERO")
	private int numero;

	public Apuesta() {
	}

	public Apuesta(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Ruleta getIdRuleta() {
		return idRuleta;
	}

	public void setIdRuleta(Ruleta idRuleta) {
		this.idRuleta = idRuleta;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Apuesta)) {
			return false;
		}
		Apuesta other = (Apuesta) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.models.Apuesta[ id=" + id + " ]";
	}

}
