# Batarang Solutions MVC

Este proyecto es una aplicación Spring Boot que proporciona una API REST para interactuar con datos orgánicos.

## Paquetes

El proyecto se organiza en varios paquetes:

- `com.batarang_solutions_mvc.demo`: Contiene la clase principal de la aplicación Spring Boot.
- `com.batarang_solutions_mvc.demo.service`: Contiene las clases de servicio que manejan la lógica de negocio.
- `com.batarang_solutions_mvc.demo.repository`: Contiene las interfaces del repositorio para interactuar con la base de datos.
- `com.batarang_solutions_mvc.demo.model`: Contiene las clases de modelo que representan las entidades de la base de datos.
- `com.batarang_solutions_mvc.demo.controller`: Contiene las clases de controlador que manejan las solicitudes HTTP.
- `com.batarang_solutions_mvc.demo.config`: Contiene las clases de configuración.

## Uso

Para iniciar la aplicación, ejecute la clase `BatarangSolutionsMvcApplication`.

La aplicación expone varios endpoints bajo `/api/organic-results`:

- `GET /fetch-and-save`: Obtiene y guarda datos.
- `GET /authors/position/{position}`: Obtiene autores por posición.
- `GET /top10`: Obtiene los 10 primeros resultados orgánicos.
- `GET /authors/summary/{position}`: Obtiene por posición y resumen del autor.
- `GET /authors/title/{position}`: Obtiene por posición y título del autor.
- `GET /authors/snippet/{position}`: Obtiene por posición y fragmento.

## Configuración

La configuración de CORS se maneja en la clase `CorsConfiguration`.
