package web.route.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/")
public class PlanetService implements Service {

    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @SneakyThrows
    public Response home() {
        ObjectNode node = mapper.createObjectNode();
        node.put("welcome", "Welcome to Earth! Choose planet number [1..8] and go to path: /planet/{number}");

        return Response.status(200).entity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node)).build();
    }

    @GET
    @Path("planet/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @SneakyThrows
    public Response getPlanet(@PathParam("id") Integer id) {
        if (Objects.isNull(id))
            return Response.noContent().build();

        Planet planet = Planet.find(id);

        ObjectNode node = mapper.createObjectNode();
        node.put("id", planet.getIndex());
        node.put("name", planet.getName());

        ArrayNode satellites = mapper.createArrayNode();
        planet.getSatellites().forEach(satellites::add);

        node.putPOJO("satellites", satellites);

        return Response.status(200).entity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node)).build();
    }

}
