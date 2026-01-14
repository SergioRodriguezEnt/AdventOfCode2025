# 🎬 Day 9: Movie Theater

---

## ❓ El problema

Hay que colocar unos asientos en formación de rectángulo dentro de un área determinada.

### 🔹 Fase 1

Hay que ver cuál es el rectángulo más grande posible.

### 🔹 Fase 2

Hay que ver cuál es el rectángulo más grande posible dentro del área marcada.

---

## 🧩 Las clases

* **Coordinate**: Representa una coordenada en el teatro.
* **Rectangle**: Representa un rectángulo creado por 2 esquinas.
* **RectangleFinder**: Haya los rectángulos que nos sirven para cada caso.
* **Runner09**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Programación funcional / **Streams**, a la hora de crear y filtrar los rectángulos.

---

## 🏗️ Patrones

* Patrón **Factory Method**, para las clases **Coordinate** y **Runner**
* Patrón **Facade**, con el **Runner09**