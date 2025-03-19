package org.acme;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Pool;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    Pool pool;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return pool.query("SELECT 1").execute()
                .onItem().transform(rows -> "Hello");
    }
}
