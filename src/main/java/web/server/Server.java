package web.server;

import com.google.inject.Inject;
import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.config.spi.ConfigSource;
//import io.helidon.media.jsonp.JsonpSupport;
import io.helidon.webserver.WebServer;
import web.route.Router;

import java.util.concurrent.TimeUnit;

public class Server implements AmbiguousServer {

    WebServer server;

    @Inject
    public Server(Router router) {
        ConfigSource configSource = ConfigSources.classpath("application.yml").build();
        Config config = Config.create(configSource);

        server = WebServer
                .create(router.getRoute(), config.get("server"));
    }

    @Override
    public void start() {
        server.start().await(10, TimeUnit.SECONDS);
        System.out.println(String.format("Server started at: http://localhost:%1s", server.port()));
    }

}
