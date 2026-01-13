# Day 10: Factory
## El problema
Tenemos unas máquinas para las cuales necesitamos pulsar botones en un determinado patrón para encender.
### Fase 1:
Hay que encontrar la combinación mínima de botones que obtiene el patrón de luces descrito por máquina.
### Fase 2:
Hay que encontrar la combinación mínima de botones que proporciona el voltaje necesario por máquina.
## Las clases
- Button: Representa un botón, con las luces a las que afecta.
- Indicator: Representa el indicador del estado de una máquina, con luces y voltajes.
- Machine: Representa la máquina y sus botones y devuelve la secuencia de botones requerida.
- Runner10: Obtiene los datos de entrada y produce la solución correspondiente.
## Principios generales
- You aren't gonna need it
- Keep it simple, stupid
- Tell, don't ask
- Don't repeat yourself
## Tecnicas
- Objetos inmutables, con las clases de tipo Record.
- Programación funcional / Streams, a la hora de crear y solucionar las máquinas.
## Patrones
- Patrón Factory Method, para la creación de todos los objetos.
- Patrón Facade, con el Runner10