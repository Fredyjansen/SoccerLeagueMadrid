package com.soccerLeagueMadrid.model;

import java.io.Serializable;

import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByNombreEquipo", query = "SELECT e FROM Equipo e WHERE e.nombreEquipo = :nombreEquipo")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonbTransient
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipo")
    private Integer idEquipo;
    @Size(max = 45)
    @Column(name = "NombreEquipo")
    @Size(max = 45)
    private String nombreEquipo;

//    @OneToMany(mappedBy = "NombreEquipo")
//    private List<Jugador> jugadorList;
    public Equipo(Integer idEquipo, String nombreEquipo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
    }

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + '}';
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
//
//    @XmlTransient
//    public List<Jugador> getJugadoresCollection() {
//        return jugadorList;
//    }
//
//    public void setJugadoresCollection(List<Jugador> jugadorList) {
//        this.jugadorList = jugadorList;
//    }

}
