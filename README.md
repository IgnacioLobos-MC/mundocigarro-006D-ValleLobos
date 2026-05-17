# Mundo Cigarro - Arquitectura de Microservicios

## Descripción del Proyecto

Mundo Cigarro es un sistema desarrollado en Spring Boot basado en arquitectura de microservicios para la gestión de una tienda dedicada a la venta de cigarros y accesorios para fumar.

El proyecto permite administrar:

* Clientes
* Productos
* Ventas
* Detalle de ventas
* Delivery

Cada módulo funciona como un microservicio independiente conectado mediante comunicación REST utilizando RestTemplate.

---

# Tecnologías Utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven
* Lombok
* Hibernate
* Postman
* Git & GitHub

---

# Arquitectura de Microservicios

| Microservicio | Puerto | Función                      |
| ------------- | ------ | ---------------------------- |
| cliente       | 8081   | Gestión de clientes          |
| producto      | 8082   | Gestión de productos         |
| venta         | 8083   | Gestión de ventas            |
| detalleventa  | 8084   | Gestión de detalles de venta |
| delivery      | 8085   | Gestión de envíos            |

---

# Base de Datos

El proyecto utiliza MySQL.

Base de datos utilizada:

```sql
mundocigarro
```

Cada microservicio crea automáticamente sus tablas mediante:

```properties
spring.jpa.hibernate.ddl-auto=update
```

---

# Microservicios Implementados

# 1. Cliente

Puerto:

```text
8081
```

El microservicio Cliente se encarga de administrar toda la información de los clientes registrados en el sistema.

Permite:

* Registrar clientes
* Consultar clientes
* Buscar clientes específicos
* Eliminar clientes

Este servicio funciona como base para otros microservicios, ya que Venta utiliza la información de clientes para registrar compras.

Atributos:

* idCliente
* nombre
* email
* telefono
* direccion
* fechaRegistro

Endpoint base:

````text
/api/v1/clientes
```text
/api/v1/clientes
````

---

# 2. Producto

Puerto:

```text
8082
```

El microservicio Producto administra el catálogo de productos disponibles en la tienda.

Permite:

* Registrar productos
* Consultar productos
* Buscar productos
* Eliminar productos

La información almacenada es utilizada posteriormente por el microservicio DetalleVenta para calcular subtotales y registrar compras.

Atributos:

* idProducto
* nombre
* marca
* tipo
* precio

Endpoint base:

````text
/api/v1/productos

/api/v1/productos
````

---

# 3. Venta

Puerto:

```text
8083
```

El microservicio Venta se encarga de registrar las ventas realizadas por los clientes.

Permite:

* Registrar ventas
* Consultar ventas
* Buscar ventas
* Eliminar ventas

Antes de registrar una venta, el sistema verifica que el cliente exista mediante comunicación con el microservicio Cliente.

Atributos:

* idVenta
* idCliente
* fechaVenta
* totalVenta

Endpoint base:

````text
/api/v1/ventas

/api/v1/ventas
````

---

# 4. Detalle Venta

Puerto:

```text
8084
```

El microservicio DetalleVenta se encarga de almacenar los productos asociados a cada venta.

Permite:

* Registrar detalles de venta
* Consultar detalles
* Buscar detalles por ID
* Buscar detalles asociados a una venta
* Eliminar detalles

Este servicio se comunica con:

* Venta
* Producto

Además, calcula automáticamente el subtotal según el precio del producto y la cantidad comprada.

Atributos:

* idDetalle
* idVenta
* idProducto
* cantidad
* subtotal

Endpoint base:

````text
/api/v1/detalles

/api/v1/detalles
````

---

# 5. Delivery

Puerto:

```text
8085
```

El microservicio Delivery administra la información relacionada con los envíos de pedidos.

Permite:

* Registrar envíos
* Consultar envíos
* Buscar envíos
* Eliminar envíos

Antes de registrar un delivery, el sistema verifica que la venta exista mediante comunicación con el microservicio Venta.

Atributos:

* idDelivery
* idVenta
* direccion
* comuna
* region
* estado
* fechaEnvio
* fechaEntrega

Endpoint base:

````text
/api/v1/delivery

/api/v1/delivery
````

---

# Comunicación Entre Microservicios

Los microservicios se comunican entre sí mediante peticiones HTTP REST.

Esto permite que cada módulo funcione de manera independiente mientras comparte información necesaria con otros servicios del sistema.

Por ejemplo:

* Venta consulta información de Cliente.
* DetalleVenta consulta información de Venta y Producto.
* Delivery consulta información de Venta.

La comunicación entre servicios permite mantener una arquitectura desacoplada y escalable.

---

# Configuración General application.properties

Ejemplo:

```properties
spring.application.name=delivery

server.port=8085

spring.datasource.url=jdbc:mysql://localhost:3306/mundocigarro
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

# Ejecución del Proyecto

Ingresar a cada microservicio:

```powershell
cd nombre_microservicio
```

Ejecutar:

```powershell
.\mvnw spring-boot:run
```

---

# Pruebas en Postman

## Crear Cliente

```http
POST http://localhost:8081/api/v1/clientes
```

```json
{
    "nombre": "Ignacio Lobos",
    "email": "ignacio@gmail.com",
    "telefono": "987654321",
    "direccion": "Santiago Centro",
    "fechaRegistro": "2026-05-14"
}
```

---

## Crear Producto

```http
POST http://localhost:8082/api/v1/productos
```

```json
{
    "nombre": "Marlboro Gold",
    "marca": "Marlboro",
    "tipo": "Cigarro",
    "precio": 4500
}
```

---

## Crear Venta

```http
POST http://localhost:8083/api/v1/ventas
```

```json
{
    "idCliente": 2,
    "fechaVenta": "2026-05-14",
    "totalVenta": 9000
}
```

---

## Crear Detalle Venta

```http
POST http://localhost:8084/api/v1/detalles
```

```json
{
    "idVenta": 2,
    "idProducto": 1,
    "cantidad": 3
}
```

---

## Crear Delivery

```http
POST http://localhost:8085/api/v1/delivery
```

```json
{
    "idVenta": 2,
    "direccion": "Av. Alameda 123",
    "comuna": "Santiago",
    "region": "Metropolitana",
    "estado": "En camino",
    "fechaEnvio": "2026-05-14",
    "fechaEntrega": "2026-05-15"
}
```

---

# GitHub

Comandos utilizados:

```powershell
git add .
git commit -m "Actualizacion microservicios"
git push origin main
```

---

# Estado Actual del Proyecto

Actualmente el proyecto cuenta con:

* Arquitectura de microservicios funcional
* Comunicación REST entre servicios
* Persistencia en MySQL
* CRUD completo
* Integración entre módulos
* Testing mediante Postman
* Control de versiones con GitHub

---

# Autor

Ignacio Lobos
Diego Valle

Proyecto académico desarrollado con Spring Boot y MySQL.
