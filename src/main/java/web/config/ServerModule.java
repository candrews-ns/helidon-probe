package web.config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import web.route.PlanetRouter;
import web.route.Router;
import web.server.AmbiguousServer;
import web.server.Server;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AmbiguousServer.class).to(Server.class).in(Singleton.class);
        bind(Router.class).to(PlanetRouter.class).in(Singleton.class);
    }

}
