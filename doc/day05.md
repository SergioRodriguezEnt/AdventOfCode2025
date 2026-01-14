# ☕ Day 5: Cafeteria

---

## ❓ El problema

Tenemos que ver qué ingredientes están en los rangos de ingredientes frescos.

### 🔹 Fase 1

Hay que contar los ingredientes frescos.

### 🔹 Fase 2

Hay que contar los ingredientes que se considerarían frescos según los rangos dados

---

## 🧩 Las clases

* **IdRange**: Representa el rango de IDs de ingredientes e incluye funciones útiles para rangos de números.
* **IdChecker**: Acumula los rangos de IDs válidos y comprueba los IDs que se le pasen.
* **Runner05**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Programación funcional / **Streams**, a la hora de agrupar rangos de IDs y comprobar IDs.

---

## 🏗️ Patrones

* Patrón **Facade**, con el **Runner05**
* Patrón **Factory Method**