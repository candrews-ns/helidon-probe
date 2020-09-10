package web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.SneakyThrows;
import web.config.ServerModule;
import web.server.AmbiguousServer;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ServerModule());
        AmbiguousServer server = injector.getInstance(AmbiguousServer.class);

        server.start();
    }

}
