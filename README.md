# Kata 2: entrada y salida de datos
**Tecnologías:** Java · Maven · Google Gson 2.14.0
**Autora:** Sofía Rivero Perea 
---

## 1. Objetivo de la entrega

Esta segunda kata tiene como objetivo familiarizarnos con la entrada y salida de datos a través de `InputStream` y `OutputStream`.
Se reciben datos mediante flujos y se trabaja cómo validarlos y cómo producir una salida comprensible.
Por ejemplo, en la primera repetición, mostrada en el vídeo y en el repositorio, se trabaja con un conjunto de datos sobre películas. Se incluyen componentes para calcular la frecuencia de películas por clasificación y escribir ese resumen en un `OutputStream`.

---

## 2. Cómo compilar y ejecutar
Para compilar y ejecutar el código:
1. **Clonar o descargar el repositorio**.
2. Si se ha descargado como archivo comprimido, **extraer el proyecto**.
3. Abrir **`pom.xml`** en IntelliJ IDEA como proyecto Maven.
4. Configurar el proyecto y Maven para utilizar **JDK 27** y cargar el proyecto Maven.
5. Ejecutar la clase principal **`software.ulpgc.katas.Main`**, que **no necesita argumentos**, mediante el triángulo verde.
La ejecución original de películas requiere conexión a Internet, porque obtiene el TSV desde una URL.
Al abrir el estado actual de `master` o `develop` y ejecutar `software.ulpgc.katas.Main`, se ejecuta la tercera repetición, de videojuegos. Esta utiliza `games.tsv` en la raíz del proyecto y genera `games-summary.txt`.

---

## 3. Estructura de la entrega y clases principales
Se pueden ver dos paquetes principales: `model` e `io`.
`model` contiene las clases que representan los datos. `io` significa entrada/salida y contiene los componentes encargados de leer y escribir esos datos.

### Primera repetición: películas

| Clase o interfaz | Función |
| --- | --- |
| **`model.Movie`** | Representa una película con su nombre y clasificación. |
| **`model.Rating`** | Define las clasificaciones disponibles. |
| **`io.MovieReader`** | Define las operaciones de carga. |
| **`io.UrlMovieReader`** | Lee el dataset y crea las películas. |
| **`io.SummaryWriter`** | Escribe el resumen en un `OutputStream`. |
| **`MovieSummary`** | Calcula el número de películas por clasificación a partir de una lista. |
| **`Main`** | Configura la URL, carga los datos y muestra los objetos por consola. |

Fuera de los paquetes `model` e `io` se encuentran la clase principal **`Main`** y **`MovieSummary`**.

### Dataset de películas

La URL que he escogido es esta:
https://raw.githubusercontent.com/ibm-watson-data-lab/open-data/master/movies/movies.tsv
El dataset contiene 595 películas. En el fichero real, las columnas están separadas por tabulaciones. Yo omito la cabecera y divido cada fila mediante:

```java
line.split("\t", -1);
```

---

## 4. Vídeo explicativo

https://youtu.be/U8wtTZb1vgQ
El vídeo corresponde a la primera repetición, sobre películas.

---

## 5. Repeticiones de la kata

La variación principal entre las repeticiones ha sido el tema: primero se trabajó con películas, después con libros y, por último, con videojuegos.

| Repetición | Rama de consulta | Tema |
| --- | --- | --- |
| **R1** | **`develop_one`** | **Películas** |
| **R2** | **`develop_two`** | **Libros** |
| **R3** | **`develop_third`** | **Videojuegos** |

---

## 6. Evidencias de verificación o pruebas realizadas

Se comprobó que `movies.tsv` genera 595 objetos `Movie` y que la lectura desde fichero y memoria produce la misma lista.
También se verificó que el resumen mantiene las cantidades al reordenar las películas y que el escritor genera el mismo contenido en memoria y en fichero.
Como evidencia de los casos de error se utiliza `películas-error.tsv`. En las otras repeticiones también hay evidencia de estas comprobaciones.
