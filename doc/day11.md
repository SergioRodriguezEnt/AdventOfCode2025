# ⚛️ Day 11: Reactor

---

## ❓ El problema

Hay una serie de cables que conectan diversos componentes, debes encontrar los caminos que van de un punto a otro.

### 🔹 Fase 1

Hay que los caminos que van desde **"you"** hasta **"out"**.

### 🔹 Fase 2

Hay que los caminos que van desde **"svr"** hasta **"out"** y que pasan por **"fft"** y **"dac"** en cualquier orden.

---

## 🧩 Las clases

* **DevicePath**: Representa un dispositivo y el camino tomado para llegar hasta él.
* **PathFinder**: Obtiene los caminos para llegar de un punto a otro.
* **Runner11**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Programación funcional / **Streams**, a la hora de ampliar las colas y obtener los resultados de nodos anteriores.

---

## 🏗️ Patrones

* Patrón **Factory Method**, para **PathFinder** y **Runner11**
* Patrón **Facade**, con el **Runner11**