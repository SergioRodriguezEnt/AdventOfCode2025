# 🗝️ Day 1: Secret entrance

---

## ❓ El problema

Hay una caja fuerte con un dial cuya posición que va del **0 al 99** y nos dan una serie de movimientos que tenemos que aplicar al dial.

### 🔹 Fase 1

Hay que contar el número de veces que el dial acaba en **0** tras aplicar una order.

### 🔹 Fase 2

Hay que contar cuantas veces el díal pasa por **0**.

---

## 🧩 Las clases

* **Dial**: Representa el estado del dial.
* **Order**: Representa una orden / movimiento que aplicar al dial.
* **Lock**: Lleva la cuenta necesaria y aplica las ordenes al dial.
* **Runner01**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Inyección de dependencias (**Open Closed**), para la función contadora de la clase **Lock**.
* Programación funcional / **Streams**, a la hora de aplicar las órdenes y actualizar el contador.

---

## 🏗️ Patrones

* Patrón **Builder**, para la creación de objetos **Runner01**
* Patrón **Facade**, con el **Runner01**