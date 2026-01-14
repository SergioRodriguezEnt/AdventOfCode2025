# 🗑️ Day 6: Trash Compactor

---

## ❓ El problema

Hay que resolver una serie de operaciones que están colocadas en formato **Cefalópodo**.

### 🔹 Fase 1

Los números se leen por fila y cada número corresponde a una operación.

### 🔹 Fase 2

Los números se leen por columna con un nuevo formato.

---

## 🧩 Las clases

* **Operator**: Enumerado para los operadores.
* **Operation**: Representa una operación y permite obtener su resultado.
* **OperationBuilder**: Se encarga de obtener las operaciones con el formato necesario.
* **Runner06**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Programación funcional / **Streams**, a la hora de crear las operaciones y ejecutarlas.

---

## 🏗️ Patrones

* Patrón **Builder**, para la creación de objetos **Operation**
* Patrón **Facade**, con el **Runner06**
* Patrón **State**, para el **Runner06** con el **OperationBuilder**
* Patrón **Factory Method**, para **Operator**.