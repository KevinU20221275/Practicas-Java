# Proyecto: Algoritmos de Búsqueda y Ordenamiento en Java

## 📌 Descripción
Este proyecto implementa y analiza distintos algoritmos clásicos de búsqueda y ordenamiento, incluyendo pruebas de rendimiento para distintos tamaños de datos. Los resultados se documentan en un informe y se presentan de manera visual.

## 📂 Estructura del Proyecto

```text
src/
  |-/Busqueda
  |     |- BusquedaLineal.java
  |     |- BusquedaBinaria.java
  |-/Ordenamiento
  |     |- BubbleSort.java
  |     |- InsertionSort.java
  |     |-SelectionSort.java
  |-Main.java
  |-README.md
```


## ⚙️ Requisitos
- Java JDK 8 o superior
- IDE o compilador (por ejemplo: IntelliJ IDEA, Eclipse, o CLI)

## 🧪 Instrucciones para compilar y ejecutar

Desde terminal o consola:

```bash
javac Busqueda/*.java Ordenamiento/*.java Main.java
java Main
```

Desde un IDE:
- Abre el proyecto.
- Ejecuta la clase Main.

## 🧪 Pruebas incluidas
Comparación de tiempo de ejecución de los algoritmos de ordenamiento (Bubble, Insertion, Selection) en arreglos de:

- 100 elementos
- 10,000 elementos
- 100,000 elementos

| Algoritmo      | 100 elem | 10,000 elem | 100,000 elem |
|----------------|----------|-------------|---------------|
| Bubble Sort     | 0.37 ms | 275 ms      | 19,550 ms     |
| Insertion Sort  | 0.66 ms | 68 ms       | 3,744 ms      |
| Selection Sort  | 0.70 ms | 95 ms       | 6,653 ms      |