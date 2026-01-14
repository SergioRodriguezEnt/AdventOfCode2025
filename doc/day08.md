# 🛝 Day 8: Playground

---

## ❓ El problema

Hay unas cajas de conexión suspendidas por un espacio y hay que conectarlas formando circuitos.

### 🔹 Fase 1

Hay que conectar las **1000** parejas de cajas de conexión que estén más cerca entre sí.

### 🔹 Fase 2

Hay que conectar todas las cajas de conexión por las parejas más cercanas.

---

## 🧩 Las clases

* **Box**: Representa una caja de conexión / coordenada 3D.
* **BoxPair**: Representa la pareja de cajas de conexión.
* **Circuit**: Guarda el conjunto de cajas que lo forman.
* **CircuitLoader**: Carga los circuitos iniciales (cada caja es un circuito).
* **CircuitConnector**: Conecta los circuitos según lo que se especifique.
* **Runner08**: Obtiene los datos de entrada y produce la solución correspondiente.

---

## 🧠 Principios generales

* Single Responsibility
* You aren't gonna need it
* Keep it simple, stupid
* Tell, don't ask
* Don't repeat yourself

---

## 🛠️ Tecnicas

* Objetos inmutables, con las clases de tipo **Record**.
* Programación funcional / **Streams**, a la hora de crear y combinar los circuitos.

---

## 🏗️ Patrones

* Patrón **Builder**, para la creación de la lista de circuitos
* Patrón **Facade**, con el **Runner08**