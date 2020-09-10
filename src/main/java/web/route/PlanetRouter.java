package web.route;

import io.helidon.webserver.Routing;
import io.helidon.webserver.jersey.JerseySupport;
import web.route.service.PlanetService;

public class PlanetRouter implements Router {

    Routing routing;

    PlanetRouter() {
       routing = Routing.builder()
               .register(JerseySupport.builder().register(PlanetService.class).build())
               .build();
    }

    @Override
    public Routing getRoute() {
        return routing;
    }

}
