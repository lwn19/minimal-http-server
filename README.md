# ☕ Simple HTTP Server en Java (POO)

Un servidor HTTP básico construido *desde cero con Programación Orientada a Objetos (POO)*.

## 🧩 Estructura
- HttpServer: maneja conexiones, usa ExecutorService para concurrencia.
- Router: asigna rutas a handlers.
- HttpHandler: interfaz para definir endpoints.
- Logger: simple sistema de logging con colores.
- (WIP) StaticFileHandler: sirve archivos desde public/.

## 🚀 Ejecución local

```bash

javac $(find src -name "*.java")
java Server
```
Luego abre en el navegador:

http://localhost:8080/

http://localhost:8080/time

http://localhost:8080/static/index.html

🐳 Docker
```bash

docker build -t java-http-server .
docker run -p 8080:8080 java-http-server
```

🧠 Conceptos demostrados

- Concurrencia con ExecutorService

- POO (abstracción, polimorfismo, encapsulación)

- Servir contenido estático

- Logging simple con timestamps

- Separación de responsabilidades (principios SOLID)