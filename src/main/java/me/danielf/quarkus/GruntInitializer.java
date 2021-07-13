package me.danielf.quarkus;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import me.danielf.quarkus.domain.Grunt;
import me.danielf.quarkus.domain.GruntService;

@ApplicationScoped
@Startup
public class GruntInitializer {
    private String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    @PostConstruct
    public void initializeData(@Observes StartupEvent event, GruntService service) {
        Stream.generate(() -> new Grunt(generateRandomUser(), generateText(10 + new Random().nextInt(280))))
            .limit(15)
            .forEach(service::create);
    }

    private String generateRandomUser() {
        List<String> firstNames = List.of("Daniel", "Pedro", "Ana", "Roberto", "Maria", "Marta", "Tânia");
        List<String> lastNames = List.of("Fazeres", "Faria", "Silva", "Cheche", "Kabuty", "Quarlz", "Reynolds");
        return firstNames.get(new Random().nextInt(firstNames.size())) + " " +
            lastNames.get(new Random().nextInt(lastNames.size()));
    }

    private String generateText(int bound) {
        return lorem.substring(0, bound);
    }

    private String generateRandomAlphanumString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}