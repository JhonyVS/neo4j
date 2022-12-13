import org.neo4j.driver.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.neo4j.driver.Values.parameters;

public class DB {
    private Driver driver;
    private static DB db;
    public static void main(String[] args) {

        
        Usuario u1 = new Usuario("Jorge", "jorge@email.com", "123");
        try(Session session = db.getDriver().session()){
            System.out.println("Acceso correcto");

            //Adicionando usuario
            session.run("CREATE (u1:Usuario{nombre:$nombre, email:$email, pass:$pass})",
                    parameters("nombre", u1.getNombre(), "email", u1.getEmail(),
                            "pass", u1.getPass()));
            //System.out.println(result.consume().counters().nodesCreated());

            //relacionamiento
           Result result = session.run("MATCH (p1:Pessoa{cpf:$cpf}),(p2:Pessoa{cpf:$cpf2})" +
                    "CREATE (p1)-[:AMIGO]->(p2)",
                    parameters("cpf", "111.111.111-01", "cpf2", "222.222.222-02"));
            System.out.println(result.consume().counters().relationshipsCreated());

            //Recuperando todas as pessoas
//            Result result = session.run("MATCH (p:Pessoa) RETURN p.cpf, p.nome, p.nascimento");
//            System.out.println(result.stream().map(record ->
//                    new Pessoa(record.get(0).asString(),
//                    record.get(1).asString(),
//                    record.get(2).asLocalDate()))
//                    .collect(Collectors.toList()));

            //Buscando os CPFs de todos os amigos de uma pessoa
//            Result result = session.run("MATCH (p:Pessoa{cpf:$cpf})-[:AMIGO]->(p2) RETURN p2",
//                    parameters("cpf", "111.111.111-01"));
//            result.list().forEach(r -> System.out.println(r.get(0).asNode().values() ));

        }finally {
            getDB().getDriver().close();
        }

        

    }

    public DB(){

        driver = GraphDatabase.driver("bolt://localhost:7687/tbd",
                AuthTokens.basic("neo4j", "12345"));
    }
    public Driver getDriver(){
        return getDB().getDriver();
    }
    public static DB getDB(){
        if(db == null)
            return new DB();
        else 
            return db;
    }

    public void agregarUsuario(Usuario u){
        try(Session session = driver.session()){
            System.out.println("Acceso correcto");

            //Adicionando usuario
            session.run("CREATE (u1:Usuario{nombre:$nombre, email:$email, pass:$pass})",
                    parameters("nombre", u.getNombre(), "email", u.getEmail(),
                            "pass", u.getPass()));
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Algo salio mal en agregarPersona()");
        }
    }
    public void closeDriver(){
        driver.close();
    }

    

    public void crearRelacion(){
        try(Session session = db.getDriver().session()){
        Result result = session.run("MATCH (u:Usuario{nombre:$nombre}),(u2:Usuario{nombre:$nombre2})" +
                    "CREATE (u)-[:AMIGO]->(u2)",parameters("nombre", "111.111.111-01", "nombre2", "222.222.222-02"));
            System.out.println(result.consume().counters().relationshipsCreated());
        }
    }
}