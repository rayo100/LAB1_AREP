# LAB1_AREP

Api que consulta la información de películas de cine a través de una servidor que se conecta con una API de www.omdbapi.com expuesta en internet.

# GUIA

## Herramientas

* Java - Ambiente de desarrollo
* Git - Sistema de control de versiones
* Maven - Administrador de dependencias

# Cómo Instalar

Descargue el archivo .zip o lo clone con el comando:

  git clone 

Una vez descargado el repositorio dirijase al directorio raiz del proyecto y ejecute el comando:

  mvn exec:java

Finalmente, ingrese al navegador de su preferencia y use el link (El cual es el localhost que corre por el puerto 35000):

http://localhost:35000

# Documentación

Para visualizar la documentación de javadoc ejecute el comando:

  mvn javadoc:javadoc

Y entre a la siguien ruta:


# Tests unitatios

Ubíquese en el directorio principal del repositorio y ejecute el comando:

  mvn test

# Versionamiento

  1.0

# Autor

  * Cesar Manuel Vásquez Montaña

# Extensión

  * Extensibilidad: Para cambiar la API de la cual se obtiene la informacion de las peliculas, solo se debe modificar la url donde se optiene la información, lo cual lo puede realizar en la clase HttpConnection.

  * Modular: HttpConnection realiza el enlace entre la API de peliculas y el socket creado por HttpServer. La clase Seeker unicamente guarda la informacion de peliculas que ya se buscarón anteriormente para que no se busque de nuevo. Por último, en HttpServer tenemos el servidor el cual es el metodo principal que inicia la conexión del socket en espera de solicitudes de información de peliculas, esta a su vez crea la tabla respectiva del JSON que contiene la información de la pelicula buscada. 

  * Patrones: Hacemos uso del patron de diseño Fachada, puesto que la clase Seeker recibe toda la consulta inicialmente y antes de preguntarle a la API revisa si ya se encuentra información guardada en el cache.




