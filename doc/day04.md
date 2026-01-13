# Day 4: Printing Department
## El problema
Hay un muro de papel con algunos espacios y hay que quitar los papeles.
### Fase 1:
Hay que detectar cuantos papeles se pueden quitar de una tirada.
### Fase 2:
Hay que quitar todos los papeles que se pueda.
## Las clases
- Position: Representa una posición en el muro.
- Space: Representa el estado de una celda del muro.
- Wall: Representa el muro con sus celdas.
- WallAnalyzer: Se encarga de detectar qué papeles se pueden quitar de un muro.
- WallRemover: Se encarga de quitar los papeles que se puedan quitar de un muro.
- Runner04: Obtiene los datos de entrada y produce la solución correspondiente.
## Principios generales
- Single Responsibility
- You aren't gonna need it
- Keep it simple, stupid
- Tell, don't ask
- Don't repeat yourself
## Tecnicas
- Objetos inmutables, con las clases de tipo Record.
- Abstracción por interfaces, para los Runners.
- Programación funcional / Streams, para la selección de los papeles removibles.
## Patrones
- Patrón Simple Factory, para la creación de objetos Runner04.
- Patrón Facade, con el Runner04
- Patrón Factory Method, para la creación de objetos Space y Wall.