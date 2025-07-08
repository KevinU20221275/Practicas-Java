# Lista Enlazada Simple en Java

## 🧠 Descripción
Este proyecto implementa una **Lista Enlazada Simple** en Java, utilizando principios de programación orientada a objetos. La estructura permite insertar, eliminar, buscar y modificar elementos de manera dinámica.

### 📌 Características principales:
- Inserción al inicio, final o en una posición específica.
- Eliminación al inicio o por índice.
- Búsqueda y modificación de nodos por índice.
- Impresión del contenido de la lista.
- Gestión automática de memoria gracias al recolector de basura de Java.

## 🛠️ Estructura del Proyecto

src/

├── Nodo.java

├── ListaEnlazadaSimple.java

├── Main.java

├── ListaEnlazadaSimpleTest.java

└── NodoTest.java


## ▶️ Instrucciones para Compilar y Ejecutar

### Requisitos:
- Java JDK 8 o superior
- IDE (IntelliJ IDEA, VS Code, Eclipse) o terminal
- JUnit 5 para ejecutar pruebas

### Compilar y ejecutar el programa principal:
```bash
javac Nodo.java ListaEnlazadaSimple.java Main.java
java Main
```

### Ejecutar pruebas unitarias:
Asegúrate de tener JUnit 5 en el classpath.

Ejecuta los tests desde tu IDE o usando:

```bash
javac -cp .:junit-platform-console-standalone-1.9.0.jar *.java
java -jar junit-platform-console-standalone-1.9.0.jar --class-path . --scan-classpath
```

### ✅ Pruebas Unitarias
Se implementaron pruebas con JUnit para verificar el comportamiento correcto de la lista enlazada:

- insertarAlInicioYListar: Verifica inserciones al inicio.
- insertarAlFinal: Inserta elementos al final de la lista.
- insertarPorIndice: Inserta nodos en una posición específica.
- eliminarPorIndice: Elimina nodos por índice.
- buscarPorIndice: Busca nodos por su posición.
- modificarDatosPorIndice: Modifica datos existentes.
- Casos límite: Validaciones con índices fuera de rango o lista vacía.

Los resultados esperados fueron obtenidos satisfactoriamente.

### 🔍 Observaciones
La implementación utiliza referencias encadenadas entre nodos para permitir el manejo dinámico de memoria.

Se priorizó la legibilidad del código y su estructura modular.

Los errores como índices inválidos son tratados con mensajes adecuados.

Es una base ideal para expandir a listas doblemente enlazadas o listas circulares.