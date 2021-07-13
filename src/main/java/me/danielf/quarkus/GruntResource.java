package me.danielf.quarkus;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.RequiredArgsConstructor;
import me.danielf.quarkus.domain.Grunt;
import me.danielf.quarkus.domain.GruntService;

@RequiredArgsConstructor
@Path("/grunt")
public class GruntResource {
    private final GruntService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Grunt> findAll(){
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Grunt retrieve(@PathParam("id") Long id){
        return service.retrieve(id).orElse(null);
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Grunt grunt){
        Grunt result = service.create(grunt);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id){
        if (service.remove(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
