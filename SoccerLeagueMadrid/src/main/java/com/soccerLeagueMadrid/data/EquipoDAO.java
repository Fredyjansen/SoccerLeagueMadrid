package com.soccerLeagueMadrid.data;

import com.soccerLeagueMadrid.model.Equipo;
import java.util.List;

public interface EquipoDAO {

    public List<Equipo> findAllTeams();

    public Equipo findByIdEquipo(Equipo equipo);

  
    public void InsertTeam(Equipo equipo);

    public void updateTeam(Equipo equipo);

    public void deleteEquipo(Equipo equipo);

}
