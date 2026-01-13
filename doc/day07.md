# Day 7: Laboratories
## El problema
Hay un haz de taquiones que viaja por un camino.
### Fase 1:
Contar cuántas veces se divide el haz.
### Fase 2:
Contar cuántos caminos únicos podría tomar el haz.
## Las clases
- Cell: Representa una celda del espacio del problema.
- GridBuilder: Crea una cuadrícula con los elementos especificados.
- GridUpdater: Actualiza la cuadrícula según las acciones que pueda realizar un haz.
- Runner07: Obtiene los datos de entrada y produce la solución correspondiente.
## Principios generales
- Single Responsibility
- You aren't gonna need it
- Keep it simple, stupid
- Tell, don't ask
- Don't repeat yourself
## Tecnicas
- Objetos inmutables, con las clases de tipo Record.
- Programación funcional / Streams, a la hora de aplicar crear y actualizar la cuadrícula.
## Patrones
- Patrón Builder, para la creación de la cuadrícula con GridBuilder
- Patrón Factory Method, en Cell y Runner07
- Patrón Facade, con el Runner07