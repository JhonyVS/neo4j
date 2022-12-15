CREATE (luis:person {name: "luis"})
CREATE (carlos:person {name: "carlos"})
CREATE (jose:person {name: "jose"})
CREATE (miguel:person {name: "miguel"})
CREATE (andres:person {name: "andres"})
CREATE (felipe:person {name: "felipe"})
CREATE (upb:universidad {name: "upb"})
CREATE (umss:universidad {name: "umss"})
CREATE (upal:universidad {name: "upal"})
CREATE (futbol:deporte {name: "futbol"})
CREATE (basket:deporte {name: "basket"})
CREATE (sistemas:carrera {name: "sistemas"})
CREATE (informatica:carrera {name: "informatica"})
CREATE (ingles:materia {name: "ingles"})
CREATE (algebra:materia {name: "algebra"})
CREATE (calculo:materia {name: "calculo"})
CREATE (luis)-[:FRIENDS]->(felipe)
CREATE (felipe)-[:FRIENDS]->(carlos)
CREATE (luis)-[:FRIENDS]->(andres)
CREATE (luis)-[:FRIENDS]->(miguel)
CREATE (luis)-[:FRIENDS]->(jose)
CREATE (miguel)-[:FRIENDS]->(jose)
CREATE (luis)-[:STUDENT]->(umss)
CREATE (jose)-[:STUDENT]->(umss)
CREATE (andres)-[:STUDENT]->(umss)
CREATE (miguel)-[:STUDENT]->(upal)
CREATE (carlos)-[:STUDENT]->(upb)
CREATE (jose)-[:SUBJECT]->(algebra)
CREATE (miguel)-[:SUBJECT]->(algebra)
CREATE (andres)-[:SUBJECT]->(ingles)
CREATE (carlos)-[:SUBJECT]->(calculo)
CREATE (jose)-[:SUBJECT]->(sistemas)
CREATE (andres)-[:SUBJECT]->(sistemas)
CREATE (miguel)-[:SUBJECT]->(sistemas)
CREATE (felipe)-[:SUBJECT]->(informatica)
CREATE (luis)-[:SUBJECT]->(informatica)

MATCH (n) return n

//borrar todo
match(n) delete n
//borrar nodo
MATCH (n:Usuario {nombre:'Rene'}) DELETE n
//Borrar relacion
MATCH (n:Usuario {nombre: 'Rene'})-[r:AMIGO]->() DELETE r

//relaciones ++
MATCH (u1:Usuario{cod:222}),(r1:Rol{cod:101}) CREATE (u1)-[:USUARIO_ROL]->(r1)