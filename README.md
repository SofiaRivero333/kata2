**Kata 2**
Objetivo de la entrega:
Esta segunda kata tiene como objetivo familiarizarnos con la entrada y salida de datos, a través de InputStream y 
OutputStream. Se reciben datos mediante streams cómo los valida y cómo produce una salida entendible. Por ejemplo, 
en la primera repetición se puede ver (mostrado en el video y en el repositorio) que trato con un dataset sobre peliculas, 
se incluyen componentes para calcular la frecuencia de películas por clasificación y escribir ese resumen en un OutputStream.

Cómo compilar y ejecutar:
Para poder compilar y ejecutar el codigo, hay que descargarse el repositorio en git. Extraer el proyecto y abrir el pm.xml,
configurar el proyecto y Maven para utilizar JDK 27 y cargar el proyecto Maven. La clase principal es software.ulpgc.katas.Main 
y no necesita argumentos. La ejecución original de películas requiere conexión a Internet porque obtiene el TSV desde una URL.
Al abrir el estado actual de master o develop y ejecutar software.ulpgc.katas.Main, se ejecuta la tercera repetición, de videojuegos. 
Esta utiliza games.tsv en la raíz del proyecto y genera games-summary.txt.

Dependencias y versión de JDK:
No requiere de dependencias externas y la versión del JDK es 27, maven.compiler.source.

Estructura de la entrega y clases principales:
Se pueden ver dos paquetes, model e io, model contiene las clases que representan los datos, e io significa Input/Output: entrada y salida.
Dentro de model tenemos las clases Movie, epresenta una película con su nombre y clasificación, y Rating, que define las calificaciones
disponibles. En cuanto al paquete io, tenemos, MovieReader que define las operaciones de carga, UrlMovieReader lee el dataset y crea las películas, 
y SummaryWriter escribe el resumen.
Fuera de estos dos paquetes tenemos la clase principal (Main) y MovieSummary. Main onfigura la URL, carga los datos y muestra los objetos por consola, por 
otro lado, MovieSummary calcula el número de películas por clasificación a partir de una lista. La URL que yo he escogido es esta:
https://raw.githubusercontent.com/ibm-watson-data-lab/open-data/master/movies/movies.tsv, con 595 películas. En el fichero real, las columnas están separadas por 
tabulaciones, yo omito la cabecera y divido cada fila con split("\t", -1).

Video:
https://youtu.be/U8wtTZb1vgQ

La variación principal entre las repeticiones ha sido el tema, primero fue peliculas, luego libros y por ultimo videojuegos.
Commits de referencia:
Peliculas = 866a7a1 a b07c454.
Libros = fcf680a a 669258d.
Videojuegos = 5a4bff7 a 6d65420.

Evidencias de verificación o pruebas realizadas: 
Se comprobó que movies.tsv genera 595 objetos Movie y que la lectura desde fichero y memoria produce la misma lista. También se verificó que 
el resumen mantiene las cantidades al reordenar las películas y que el escritor genera el mismo contenido en memoria y fichero, ¿la prueba? movies-error.tsv.
En las otras repeticiones también hay evidencia de ello. 




