# 🧠 Proyecto de Sistemas de Clases en Java

Este proyecto contiene una serie de ejercicios enfocados en la **programación orientada a objetos (POO)** con Java. Cada ejercicio representa un sistema de clases con jerarquías, herencia, polimorfismo, abstracción e interfaces, organizados en diferentes dominios del mundo real.

---

## 📁 Estructura del Proyecto

```
src/
├── agendaTelefonica/
│   ├── Contactos/
│   │   ├── Amigo.java
│   │   ├── Companero.java
│   │   ├── Contacto.java (abstracta)
│   │   ├── Familiar.java
│   │   └── TipoContacto.java (enum)
│   ├── Agenda.java
│   ├── Cita.java
│   └── Main.java
│  
│
├── animales/
│   ├── aves/
│   │   ├── Avestruz.java
│   │   ├── Canario.java
│   │   ├── Pato.java
│   │   └── interfaces/
│   │       ├── ComerDormir.java
│   │       ├── Correr.java
│   │       ├── Nadar.java
│   │       └── Volar.java
│   ├── especies/
│   │   ├── Ave.java
│   │   ├── Mamifero.java
│   │   └── Especies.java (enum)
│   ├── perros/
│   │   └── Perro.java
│   ├── Animal.java (abstracta)
│   └── Main.java
│
├── figurasGeometricas/
│   ├── circulares/
│   │   ├── Circulo.java
│   │   └── Ovalo.java
│   ├── cuadrados/
│   │   ├── Cuadrado.java
│   │   └── Rectangulo.java
│   ├── triangulares/
│   │   └── TrianguloEquilatero.java
│   ├── Figura.java (abstracta)
│   ├── TipoFigura.java (enum)
│   └── Main.java
│
└── ventaProductos/
    ├── electrodomesticos/
    │   └── Electrodomestico.java
    ├── muebles/
    │   └── Mueble.java
    ├── Producto.java (abstracta)
    ├── TipoDevoluciones.java (enum)
    ├── Devolucion.java
    ├── Venta.java
    └── Main.java
```

---

## 🐾 Sistema de Clasificación de Animales

- Se clasifican animales por especie y raza.
- **Perros:** Se utiliza **polimorfismo** con métodos como `cortarPelo()` y `nadar()` que cambian su comportamiento según atributos como `necesitaCortePelo` y `puedeNadar`.
- **Aves:** Se emplean **interfaces** (`Volar`, `Correr`, `Nadar`) para definir capacidades específicas por clase. Por ejemplo:
    - `Avestruz` **no vuela ni nada**, pero **sí corre**.
    - `Pato` puede **nadar y volar**.
- Uso de clase abstracta (`Animal`) y un `enum` para representar tipos de especie.

---

## 🔺 Sistema de Clasificación de Figuras Geométricas

- Clasificación de figuras en **circulares**, **cuadradas** y **triangulares**.
- Clase abstracta `Figura` define la estructura base.
- Clases como `Circulo`, `Ovalo`, `Cuadrado`, `Rectangulo`, y `TrianguloEquilatero` representan tipos concretos.
- Se utiliza un `enum` `TipoFigura` para identificar el tipo de figura.

---

## 🛋️ Sistema de Venta de Productos

- Gestión de **muebles** y **electrodomésticos**.
- Clase abstracta `Producto` con propiedades comunes.
- Soporte para operaciones de:
    - **Ventas**
    - **Devoluciones**
    - **Control de stock**
- Uso de polimorfismo para manejar distintos tipos de producto.
- Uso de `TipoDevoluciones` (enum) para clasificar las devoluciones (por averia y cambio de opinion).

---

## 📇 Sistema de Agenda Telefónica

- Organización de contactos por tipo:
    - `Familiar`
    - `Amigo`
    - `Compañero`
- Clase abstracta `Contacto` y enum `TipoContacto`.
- Registro de **citas/compromisos** mediante la clase `Cita`.
- Clase `Agenda` gestiona todos los contactos y citas.

---

## 🧪 Principales Conceptos Aplicados

- ✅ Abstracción mediante clases abstractas.
- ✅ Polimorfismo (en `Perro`, `Figura`, etc).
- ✅ Herencia (como `Familiar` hereda de `Contacto`).
- ✅ Uso de interfaces (especialmente en animales).
- ✅ Enumeraciones (`TipoContacto`, `TipoFigura`, `TipoDevoluciones`).
- ✅ Encapsulamiento y buenas prácticas POO.

---

## 🛠️ Requisitos para Ejecutar

- Java JDK 8 o superior.
- Un entorno de desarrollo como IntelliJ IDEA o VSCode con soporte para Java.
- Compilar con:
  ```bash
  javac src/**/*.java
  ```
- Ejecutar cualquier `Main.java` desde su respectiva carpeta.

---