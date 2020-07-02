/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.masivian.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "RULETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruleta.findAll", query = "SELECT r FROM Ruleta r")
    , @NamedQuery(name = "Ruleta.findById", query = "SELECT r FROM Ruleta r WHERE r.id = :id")
    , @NamedQuery(name = "Ruleta.findByName", query = "SELECT r FROM Ruleta r WHERE r.name = :name")
    , @NamedQuery(name = "Ruleta.findByStatus", query = "SELECT r FROM Ruleta r WHERE r.status = :status")})
public class Ruleta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_ID_GENERATOR",sequenceName = "RULETA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private Short status;
    @OneToMany(mappedBy = "idRuleta", fetch = FetchType.LAZY)
    private List<Apuesta> apuestaList;

    public Ruleta() {
    }

    public Ruleta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @XmlTransient
    public List<Apuesta> getApuestaList() {
        return apuestaList;
    }

    public void setApuestaList(List<Apuesta> apuestaList) {
        this.apuestaList = apuestaList;
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
        if (!(object instanceof Ruleta)) {
            return false;
        }
        Ruleta other = (Ruleta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.models.Ruleta[ id=" + id + " ]";
    }
    
}
