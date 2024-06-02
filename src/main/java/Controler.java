
import Entity.Voiture;
 import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/voitures")
public class Controler {

    @Inject
    private Servises voitureService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voiture> getAllVoitures() {
        return voitureService.getAllVoitures();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVoitureById(@PathParam("id") Integer id) {
        Voiture voiture = voitureService.getVoitureById(id);
        if (voiture != null) {
            return Response.ok(voiture).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture createVoiture(Voiture voiture) {
        return voitureService.saveVoiture(voiture);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture updateVoiture(@PathParam("id") Integer id, Voiture voiture) {
        voiture.setId(id);
        return voitureService.saveVoiture(voiture);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVoiture(@PathParam("id") Integer id) {
        voitureService.deleteVoiture(id);
        return Response.noContent().build();
    }
}
