CREATE (luis:person {name: "luis"})
CREATE (carlos:person {name: "carlos"})
CREATE (jose:person {name: "jose"})
CREATE (miguel:person {name: "miguel"})
CREATE (andres:person {name: "andres"})
CREATE (felipe:person {name: "felipe"})


//ROLES
CREATE (docente:Rol {cod: 101,name: "Docente"})
CREATE (estudiante:Rol {cod: 102,name: "Estudiante"})
CREATE (administrativo:Rol {cod: 103,name: "Administrativo"})


//relaciones ++ USUARIO_ROL
MATCH (u1:Usuario{cod:222}),(r1:Rol{cod:101}) CREATE (u1)-[:USUARIO_ROL]->(r1)
MATCH (u2:Usuario{cod:111}),(r2:Rol{cod:102}) CREATE (u2)-[:USUARIO_ROL]->(r2)
MATCH (u3:Usuario{cod:333}),(r2:Rol{cod:102}) CREATE (u3)-[:USUARIO_ROL]->(r2)
MATCH (u4:Usuario{cod:444}),(r3:Rol{cod:103}) CREATE (u4)-[:USUARIO_ROL]->(r3)

//FUNCIONES
CREATE (Registrar_Notas:Funcion {cod: 201,name: "Registrar notas"})
CREATE (Inscribirse:Funcion {cod: 202,name: "Inscribirse"})
CREATE (Registrar_Pagos:Funcion {cod: 203,name: "Registrar pagos en cajas"})

//relaciones ROL_FUNCION
MATCH (r1:Rol{cod:101}),(f1:Funcion{cod:201}) CREATE (r1)-[:ROL_FUNCION]->(f1)
MATCH (r2:Rol{cod:102}),(f2:Funcion{cod:202}) CREATE (r2)-[:ROL_FUNCION]->(f2)
MATCH (r3:Rol{cod:103}),(f3:Funcion{cod:203}) CREATE (r3)-[:ROL_FUNCION]->(f3)

//IU
CREATE (Ver_Estudiantes:IU {cod: 301,name: "Ver estudiantes"})
CREATE (Ver_Materias:IU {cod: 302,name: "Ver materias"})
CREATE (Ver_Cajas:IU {cod: 303,name: "Ver cajas"})

//relaciones FUNCION_IU
MATCH (f1:Funcion{cod:201}),(iu1:IU{cod:301}) CREATE (f1)-[:FUNCION_IU]->(iu1)
MATCH (f2:Funcion{cod:202}),(iu2:IU{cod:302}) CREATE (f2)-[:FUNCION_IU]->(iu2)
MATCH (f3:Funcion{cod:203}),(iu3:IU{cod:303}) CREATE (f3)-[:FUNCION_IU]->(iu3)



MATCH (n) return n

//borrar todo
match(n) delete n
//borrar nodo
MATCH (n:Usuario {nombre:'Rene'}) DELETE n
//Borrar relacion
MATCH (n:Usuario {nombre: 'Rene'})-[r:AMIGO]->() DELETE r