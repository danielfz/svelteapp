package me.danielf.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;
import me.danielf.quarkus.domain.Grunt;
import me.danielf.quarkus.domain.GruntService;

@RequiredArgsConstructor
@Path("/grunt/reactive")
public class GruntReactiveResource {
    private final GruntService service;
    @GET
    public Multi<Grunt> retrieve(){
        return Multi.createFrom().iterable(service.findAll());
    }
}
