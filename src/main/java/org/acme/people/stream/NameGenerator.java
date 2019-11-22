package org.acme.people.stream;

import io.reactivex.Flowable;
import javax.enterprise.context.ApplicationScoped;
import org.acme.people.utils.CuteNameGenerator;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class NameGenerator {

    @Outgoing("generated-name")           // (1)
    public Flowable<String> generate() {  // (2)
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> CuteNameGenerator.generate());
    }
}

