# 🎄 Day 12: Christmas Tree Farm

---

## ❓ El problema

Hay que encajar ciertos regalos en regiones determinados

### 🔹 Fase 1

Hay que ver en qué regiones caben los regalos especificados.

---

## 🧩 Las clases

* **Coordinate**: Representa una coordenada 2D.
* **Present**: Representa un regalo y las coordenadas relativas que ocupa.
* **Region**: Representa una región y los regalos que requiere.
* **Combinator**: Crea streams de combinaciones de elementos de una lista.
* **PresentFitter**: Comprueba si en una región caben los regalos requeridos.
* **Runner12**: Obtiene los datos de entrada y produce la solución correspondiente.

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
* Programación funcional / **Streams**, para todas las combinaciones y comprobaciones con coordenadas.

---

## 🏗️ Patrones

* Patrón **Factory Method**, para **Present**, **PresentFitter**, **Region** y **Runner12**
* Patrón **Iterator**, para **Combinator**
* Patrón **Facade**, con el **Runner12**