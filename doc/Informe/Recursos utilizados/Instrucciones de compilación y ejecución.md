### Instrucciones de compilación y ejecución

#### Requisitos

* Java Development Kit (JDK) 17 o superior.
* Apache Maven.

#### Compilación

1. Abrir una terminal en la carpeta `demo`, donde se encuentra el archivo `pom.xml`.
2. Ejecutar el siguiente comando:

```bash
mvn clean compile
```

Al finalizar la compilación, los archivos `.class` se generarán en la carpeta `target/classes`.

#### Ejecución

Una vez compilado el proyecto, ejecutar la clase principal con el siguiente comando:

```bash
java -cp target/classes com.example.Main
```

La ejecución mostrará en la consola los resultados del algoritmo, incluyendo la tabla de programación dinámica, los objetos seleccionados para la mochila y el valor óptimo obtenido.
