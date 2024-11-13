# Microservicios
Trabajo Práctico No. 5: Microservicios

Tomando como base el TP2 Integrador (https://github.com/fsimaro/JDBC), elegir 2 microservicios que interactúen entre sí, e implementarlos en Springboot (Java) o
en el lenguaje de su preferencia.

## Introducción

En este proyecto se crearon dos aplicaciones con Spring initializr, ambas corresponden a un típico backend con arquitectura por capas, donde se encuentran Controllers, Services y Repositories.

Los dos microservicios seleccionados para esta implementación son:

- Microservicio de **Estudiantes**
- Microservicio de **Carreras**

Cada uno de estos microservicios cumple con una responsabilidad específica del dominio del registro de estudiantes, lo cual facilita la gestión modular del sistema y permite la evolución independiente de cada servicio. El microservicio de Estudiantes será responsable de la creación y administración de los datos de cada estudiante, mientras que el microservicio de Carreras gestionará las inscripciones, los datos asociados a las carrera y los reportes.

## Atributos de calidad de los microservicios

- Responsabilidad: El servicio de Estudiantes se encarga exclusivamente de los datos del estudiante (nombre, edad, número de libreta universitaria, etc.), mientras que el servicio de Carreras administra la información de cada carrera y los datos de inscripción.
- Escalabilidad: Estos microservicios pueden ser escalados de forma independiente. Por ejemplo, si se incrementa la demanda en la gestión de estudiantes, solo es necesario escalar el microservicio de Estudiantes.
- Modularidad: Cada microservicio tiene su propio modelo de datos, lo cual evita dependencias cruzadas y hace que el sistema sea más mantenible.

## Protocolos de comunicación

Para la interacción entre estos servicios, se utiliza una comunicación sincrónica mediante API REST:

- Carreras a Estudiantes: El microservicio de Carreras puede solicitar datos específicos sobre estudiantes, como la ciudad de residencia o información demográfica.

## Patrones y decisiones de diseño

- Bounded Context: Cada microservicio mantiene su propio contexto delimitado (estudiantes y carreras), lo que permite que cada uno sea autónomo y maneje solo la información relevante a su dominio.

- Database per Microservice: Cada microservicio cuenta con su base de datos (ambas PostgreSQL). Esta separación asegura que cada microservicio gestione sus propios datos sin compartir el acceso directo a las tablas de los otros microservicios, lo cual fortalece la autonomía y encapsulación de cada servicio. Si ambos microservicios necesitan datos cruzados, se comunican entre sí mediante sus APIs REST en lugar de compartir la base de datos, reforzando el principio de Database per Service.

- API REST y Cliente HTTP: La comunicación entre microservicios se realiza a través de APIs REST. Cada servicio expone endpoints necesarios para el otro, y se configura un cliente HTTP para facilitar la integración. En Spring Boot, esto se realiza con RestTemplate o Feign Client (si se opta por un enfoque más desacoplado).

## Despliegue

Para desplegar estos microservicios y su base de datos PostgreSQL, se ha utilizado un archivo docker-compose.yml que define:

Un servicio para PostgreSQL, que es la base de datos compartida.
Un servicio para el microservicio de Estudiantes.
Un servicio para el microservicio de Carreras.

## Resumen 

Independencia y escalabilidad de cada servicio.
Comunicación RESTful para simplificar la interacción entre servicios.
Modularidad y autonomía de datos mediante el uso de contextos delimitados.
Este enfoque permite la escalabilidad de cada microservicio y simplifica la administración del sistema, garantizando además que cualquier mejora o cambio en un servicio no afecte la integridad de los demás.
