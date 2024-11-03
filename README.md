# Prueba Técnica: CRUD con Spring Boot

## Descripción del Proyecto

Se desarrolló una aplicación CRUD (Create, Read, Update, Delete) utilizando Spring Boot para gestionar préstamos de libros. La aplicación maneja tres tipos de personas para el préstamo de libros:

- **Afiliado:** Puede tener un libro prestado hasta 10 días.
- **Empleado:** Puede tener un libro prestado hasta 7 días.
- **Invitado:** Puede tener un libro prestado hasta 5 días y solo un préstamo activo a la vez.

Los endpoints de la API implementados fueron:

- **POST /books:** Se creó un endpoint para añadir un nuevo libro.
- **GET /books:** Se implementó un endpoint para obtener todos los libros.
- **GET /books/{id}:** Se desarrolló un endpoint para obtener un libro por ID.
- **PUT /books/{id}:** Se creó un endpoint para actualizar un libro existente.
- **DELETE /books/{id}:** Se desarrolló un endpoint para eliminar un libro por ID.
- **POST /prestamos:** Se implementó un endpoint para crear un préstamo.

## Requisitos Técnicos

### Backend
- Se utilizó Spring Boot para desarrollar la aplicación.
- Se implementó la arquitectura por capas.
- Se manejaron los errores adecuadamente, como el caso de libro no encontrado.

### Base de Datos
- Se empleó una base de datos PostgreSql.
- ![Diagrama de la Base de Datos](https://danielcontreras205.github.io/assets/titels/DBprestamoLibros.png)

### Documentación
- Se documentó el proyecto en `README.md`.
- Se implementó Swagger para la documentación de la API REST.

## Criterios de Evaluación

- La funcionalidad CRUD se completó correctamente.
- El código fue estructurado y organizado adecuadamente.
- Se utilizó Spring Boot y JPA de manera efectiva.
- La documentación en `README.md` fue clara y detallada.
- Se utilizó Swagger para la documentación de la API.