package com.soccerLeagueMadrid.data;

import com.soccerLeagueMadrid.model.Equipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class EquipoDAOImpl implements EquipoDAO {

    @PersistenceContext(unitName = "SoccerLeagueMadridPU")
    EntityManager em;

    @Override

    public List<Equipo> findAllTeams() {

        return em.createNamedQuery("Equipo.findAll").getResultList();
    }

    @Override
    public Equipo findByIdEquipo(Equipo equipo) {
        return em.find(Equipo.class, equipo.getIdEquipo());
    }

   
    public Equipo findByNombreEquipo(Equipo equipo) {

        Query query = em.createNamedQuery("SELECT e FROM Equipo e WHERE e.NombreEquipo = :NombreEquipo");
        query.setParameter("nombreEquipo", equipo.getNombreEquipo());

        return (Equipo) query.getResultList();
    }

    @Override
    public void InsertTeam(Equipo equipo) {

        em.persist(equipo);
        em.flush();
    }

    @Override
    public void updateTeam(Equipo equipo) {
        em.merge(equipo);

    }

    @Override
    public void deleteEquipo(Equipo equipo) {
        em.remove(em.merge(equipo));

    }

}
