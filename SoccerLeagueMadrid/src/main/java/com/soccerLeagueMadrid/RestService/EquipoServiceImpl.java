package com.soccerLeagueMadrid.RestService;

import com.soccerLeagueMadrid.data.EquipoDAO;
import com.soccerLeagueMadrid.model.Equipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

@Stateless
@Path("/equipo")
public class EquipoServiceImpl {

    @Inject
    private EquipoDAO equipoDAO;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Equipo> findAllTeams() {
        List<Equipo> equipo = equipoDAO.findAllTeams();
        System.out.println("equipos encontrados: " + equipo);
        return equipo;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idEquipo}")
    public Equipo findByIdEquipo(@PathParam("idEquipo") int id) {
        Equipo equipo = equipoDAO.findByIdEquipo(new Equipo(id));
        System.out.println("equipo Econtrado: " + equipo);

        return equipo;

    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Equipo InsertTeam(Equipo equipo) {
        equipoDAO.InsertTeam(equipo);
        return equipo;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idEquipo}")
    public Response updateTeam(@PathParam("idEquipo") int id, Equipo updateTeam) {
        Equipo equipo = equipoDAO.findByIdEquipo(new Equipo(id));

        if (equipo != null) {
            equipoDAO.updateTeam(updateTeam);
            System.out.println("UpDate Team = " + updateTeam);
            return Response.ok().entity(updateTeam).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idEquipo}")
    public Response deleteEquipo(@PathParam("idEquipo") int id) {
        equipoDAO.deleteEquipo(new Equipo(id));

        return Response.ok().build();
    }

}
