import org.neo4j.driver.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.neo4j.driver.Values.parameters;

public class DB {

    public static void main(String[] args) {

        Driver driver = GraphDatabase.driver("bolt://localhost:7687/tbd",
                AuthTokens.basic("neo4j", "12345"));

        
        //Usuario u1 = new Usuario(111,"Jorge", "jorge@email.com", "123");
        //Usuario u2 = new Usuario(222,"Marcelo", "marcelo@email.com", "123");
        //Usuario u = new Usuario(444,"Mario", "mario@email.com", "123");
        try(Session session = driver.session()){
            System.out.println("Acceso correcto");

            //Adicionando usuario
            //session.run("CREATE (u:Usuario{cod:$cod, nombre:$nombre, email:$email, pass:$pass})",
              //      parameters("cod",u.getCod_usuario(),"nombre", u.getNombre(), "email", u.getEmail(),
                //            "pass", u.getPass()));
            //mas usuarios
            //session.run("CREATE (u2:Usuario{cod:$cod, nombre:$nombre, email:$email, pass:$pass})",
            //        parameters("cod",u2.getCod_usuario(),"nombre", u2.getNombre(), "email", u2.getEmail(),
            //                "pass", u2.getPass()));
            //System.out.println(result.consume().counters().nodesCreated());

            //relacionamento
            //Result result = session.run("MATCH (u1:Usuario{cod:$cod}),(u2:Usuario{cod:$cod2})" +
              //    "CREATE (u1)-[:AMIGO]->(u2)",
              //     parameters("cod", 333, "cod2", 222));
            //System.out.println(result.consume().counters().relationshipsCreated());

            //Recuperando todos los usuarios
            //Result result = session.run("MATCH (u:Usuario) RETURN u.cod, u.nombre, u.email, u.pass");
            //System.out.println(result.stream().map(record ->new Usuario(record.get(0).asInt(),record.get(1).asString(),
                  //record.get(2).asString(),record.get(3).asString())).collect(Collectors.toList()));

            //Buscando los cods de los ROLES (cod -> respuesta)
            //Result result = session.run("MATCH (u:Usuario{cod:$cod})-[:USUARIO_ROL]->(u2) RETURN u2",
              //      parameters("cod", 333));
            //result.list().forEach(r -> System.out.println(r.get(0).asNode().values() ));

        }finally {
            driver.close();
        }

    }

}