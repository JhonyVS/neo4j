import org.neo4j.driver.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.neo4j.driver.Values.parameters;

public class App {

    public static void main(String[] args) {
        Usuario u = new Usuario("Raul", "ral@email.com", "123");
        DB db = new DB();
        db.agregarUsuario(u);
    }

}