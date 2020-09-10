package web.route.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum Planet {

    MERCURY(1, "Mercury", Collections.EMPTY_LIST),
    VENUS(2, "Venus", Collections.EMPTY_LIST),
    EARTH(3, "Earth", Collections.singletonList("Moon")),
    MARS(4, "Mars", Arrays.asList("Phobos", "Deimos")),
    JUPITER(5, "Jupiter", Arrays.asList("Ganymede", "Callisto", "Io", "Europa", "Amalthea", "Himalia", "Thebe", "Elara")),
    SATURN(6, "Saturn", Arrays.asList("Titan", "Rhea", "Iapetus", "Dione", "Tethys", "Enceladus", "Mimas", "Hyperion")),
    URANUS(7, "Uranus", Arrays.asList("Titania", "Oberon", "Umbriel", "Ariel", "Miranda", "Sycorax")),
    NEPTUNE(8, "Neptune", Arrays.asList("Triton", "Proteus", "Nereid", "Larissa")),
    PLUTO(9, "Sorry, Pluto is not a Planet...", Arrays.asList("Charon", "Hydra")),
    UNKNOWN(0, "No more planets, sorry...", Collections.EMPTY_LIST);

    private final int index;
    private final String name;
    private final List<String> satellites;

    public static Planet find(int currentIndex) {
        return Arrays.stream(Planet.values())
                .filter(f -> (f.index == currentIndex))
                .findAny()
                .orElse(UNKNOWN);
    }

}
