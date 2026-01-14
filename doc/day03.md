# 🔋 Day 3: Lobby

---

## ❓ El problema

Hay unos bancos de baterías y hay que encontrar cuáles activar.

### 🔹 Fase 1

Se activan las **2** baterías que forman el número más grande.

### 🔹 Fase 2

Se activan las **12** baterías que forman el número más grande.

---

## 🧩 Las clases

* **Bank**: Representa un banco de baterías.
* **DigitSequenceSelector**: Se encarga de seleccionar la secuencia de dígitos que forma el más grande permitido.
* **Runner03**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Programación funcional / **Streams**, a la hora de obtener los mejores dígitos para las distintas baterías.

---

## 🏗️ Patrones

* Patrón **Builder**, para la creación de objetos **Runner03**
* Patrón **Facade**, con el **Runner03**