package org.acme.people.stream;

import io.smallrye.reactive.messaging.annotations.Channel;
import org.reactivestreams.Publisher;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.SseElementType;

/**
 * A simple resource retrieving the in-memory "my-data-stream" and sending the items as server-sent events.
 */
@Path("/names")
public class NameResource {

    @Inject
    @Channel("my-data-stream") Publisher<String> names; // (1)

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)// (2)
    @SseElementType("text/plain") // (3)
    public Publisher<String> stream() { // (4)
        return names;
    }
}
