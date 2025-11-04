# Simple HTTP Server en Java (POO)

Un servidor HTTP básico construido *desde cero con Programación Orientada a Objetos*.

##  Estructura
- HttpServer: maneja conexiones, usa ExecutorService para concurrencia.
- Router: asigna rutas a handlers.
- HttpHandler: interfaz para definir endpoints.
- Logger: simple sistema de logging con colores.

##  Ejecución local

```bash

javac $(find src -name "*.java")
java Server
```
Luego abre en el navegador:

http://localhost:8080/

http://localhost:8080/time


 Conceptos demostrados

- Concurrencia con ExecutorService

- POO (abstracción, polimorfismo, encapsulación)

- Logging simple con timestamps

- Separación de responsabilidades (principios SOLID)