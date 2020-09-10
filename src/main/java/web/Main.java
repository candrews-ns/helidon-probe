package web;

import com.google.inject.Inject;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Main {

//    @Inject
//    WebServer webServer;

    @SneakyThrows
    public static void main(String[] args) {
        WebServer webServer = WebServer
                .create(Routing.builder().any((req, res) -> res.send("It works!")))
                .start()
                .await(10, TimeUnit.SECONDS);

        System.out.println("Server started at: http://localhost:" + webServer.port());
    }

}
