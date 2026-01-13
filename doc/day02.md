# Day 2: Gift Shop
## El problema
Nos proporcionan una serie de rangos de IDs de productos y hay que encontrar los IDs inválidos.
### Fase 1:
Un ID es inválido si es una secuencia de digitos que se repite 2 veces.
### Fase 2:
Un ID es inválido si es una secuencia de dígitos que se repite al menos 2 veces.
## Las clases
- IdRange: Representa el rango de IDs y te devuelve los inválidos en base a una función de validez.
- Runner02: Obtiene los datos de entrada y produce la solución correspondiente.
## Principios generales
- Single Responsibility
- You aren't gonna need it
- Keep it simple, stupid
- Tell, don't ask
- Don't repeat yourself
## Tecnicas
- Objetos inmutables, con las clases de tipo Record.
- Inyección de dependencias (Open Closed), para la función de validez de la clase IdRange.
- Programación funcional / Streams, a la hora de encontrar y sumar los IDs inválidos.
## Patrones
- Patrón Builder, para la creación de objetos Runner02
- Patrón Facade, con el Runner02