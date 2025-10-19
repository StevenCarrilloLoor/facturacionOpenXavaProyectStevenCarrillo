================================================================================
  PROYECTO FACTURACION - OPENXAVA 7.6
  Laboratorio: Videos 4, 5 y MySQL
  Estudiante: Steven Carrillo
  Fecha: 19 de Octubre de 2025
================================================================================

DESCRIPCION DEL PROYECTO
--------------------------------------------------------------------------------
Aplicacion web empresarial de gestion de facturacion desarrollada con OpenXava.
Incluye modulos para gestion de:
- Clientes
- Productos
- Categorias
- Autores
- Facturas con detalles

El proyecto implementa:
- Refinamiento de interfaz de usuario con @View y @ReferenceView
- Desarrollo agil con entidades relacionadas (@ManyToOne, @OneToMany)
- Integracion con MySQL como base de datos de produccion


REQUISITOS DEL SISTEMA
--------------------------------------------------------------------------------
Software requerido:
- Java Development Kit (JDK) 11 o superior
- MySQL Server 8.0 o superior
- Apache Maven 3.6 o superior
- OpenXava Studio 7.6 (opcional, para desarrollo)

Navegadores compatibles:
- Google Chrome (recomendado)
- Mozilla Firefox
- Microsoft Edge
- Safari


ESTRUCTURA DEL PROYECTO
--------------------------------------------------------------------------------
facturacion/
|
+-- src/
|   +-- main/
|       +-- java/
|       |   +-- com/tuempresa/facturacion/
|       |       +-- modelo/
|       |       |   +-- Autor.java
|       |       |   +-- Categoria.java
|       |       |   +-- Cliente.java
|       |       |   +-- DetalleFactura.java
|       |       |   +-- Factura.java
|       |       |   +-- Producto.java
|       |       |
|       |       +-- run/
|       |           +-- facturacion.java
|       |
|       +-- webapp/
|           +-- META-INF/
|               +-- context.xml
|
+-- pom.xml
+-- README.txt


INSTALACION Y CONFIGURACION
--------------------------------------------------------------------------------

PASO 1: CLONAR O DESCARGAR EL PROYECTO
---------------------------------------
Si tienes Git instalado:
  git clone [URL_DEL_REPOSITORIO]
  cd facturacion

Si descargaste un ZIP:
  - Extraer el archivo ZIP
  - Navegar a la carpeta extraida


PASO 2: CONFIGURAR MYSQL
-------------------------
1. Abrir MySQL Workbench o cliente MySQL

2. Crear la base de datos:
   CREATE DATABASE facturaciondb;

3. Verificar creacion:
   SHOW DATABASES;


PASO 3: CONFIGURAR CREDENCIALES DE BASE DE DATOS
-------------------------------------------------
Editar el archivo: src/main/webapp/META-INF/context.xml

Localizar la seccion de MySQL y modificar:
- username: Tu usuario de MySQL (por defecto: root)
- password: Tu contrasena de MySQL
- url: Verificar que apunte a localhost:3306/facturaciondb

Ejemplo:
<Resource name="jdbc/FacturacionDS" 
          auth="Container"
          type="javax.sql.DataSource"
          maxTotal="100" 
          maxIdle="20" 
          maxWaitMillis="10000"
          username="root" 
          password="TU_PASSWORD_AQUI" 
          driverClassName="com.mysql.cj.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/facturaciondb"/>


PASO 4: COMPILAR EL PROYECTO
-----------------------------
Desde la raiz del proyecto, ejecutar:

  mvn clean install

Este comando:
- Descarga todas las dependencias necesarias
- Compila el codigo Java
- Genera el archivo WAR de la aplicacion
- Ejecuta las pruebas (si estan configuradas)

Tiempo estimado: 2-5 minutos (primera vez)


PASO 5: EJECUTAR LA APLICACION
-------------------------------

OPCION A: Usando OpenXava Studio
---------------------------------
1. Importar el proyecto en OpenXava Studio
2. Click derecho en: src/main/java/com/tuempresa/facturacion/run/facturacion.java
3. Seleccionar: Run As > Java Application
4. Esperar mensaje: "Aplicacion iniciada. Ve a http://localhost:8080/facturacion"

OPCION B: Usando Maven desde linea de comandos
-----------------------------------------------
1. Ejecutar:
   mvn tomcat7:run

2. Esperar hasta ver mensaje de inicio completo

OPCION C: Desplegar en Tomcat externo
--------------------------------------
1. Copiar facturacion.war desde target/ a carpeta webapps de Tomcat
2. Iniciar Tomcat
3. Acceder a la aplicacion


PASO 6: ACCEDER A LA APLICACION
--------------------------------
1. Abrir navegador web

2. Navegar a:
   http://localhost:8080/facturacion

3. Iniciar sesion con credenciales por defecto:
   Usuario: admin
   Password: admin

4. Cambiar password en primer acceso (recomendado)


VERIFICACION DE INSTALACION
--------------------------------------------------------------------------------

1. VERIFICAR CONEXION A MYSQL
------------------------------
Despues de iniciar la aplicacion, verificar en MySQL:

  USE facturaciondb;
  SHOW TABLES;

Deberian aparecer las siguientes tablas:
- autor
- categoria
- cliente
- factura
- factura_detalles
- images
- oxdiscussioncomments
- producto


2. VERIFICAR MODULOS DE LA APLICACION
--------------------------------------
En la interfaz web, verificar que aparezcan los siguientes modulos:
- Autor
- Categoria
- Cliente
- Factura
- Producto


3. CREAR DATOS DE PRUEBA
-------------------------
Crear al menos un registro en cada modulo:

a) Crear Categoria:
   - Descripcion: Electronica

b) Crear Autor:
   - Nombre: Juan Perez

c) Crear Producto:
   - Numero: 1001
   - Descripcion: Laptop Dell
   - Categoria: Electronica
   - Autor: Juan Perez
   - Precio: 1200.00

d) Crear Cliente:
   - Numero: 1
   - Nombre: Maria Rodriguez

e) Crear Factura:
   - Año: 2025
   - Numero: 1
   - Fecha: Fecha actual
   - Cliente: Maria Rodriguez
   - Añadir detalle con el producto creado


4. VERIFICAR PERSISTENCIA EN MYSQL
-----------------------------------
Ejecutar consultas para verificar que los datos se guardaron:

  SELECT * FROM autor;
  SELECT * FROM categoria;
  SELECT * FROM producto;
  SELECT * FROM cliente;
  SELECT * FROM factura;


USO DE LA APLICACION
--------------------------------------------------------------------------------

MODULO AUTOR
------------
- Crear: Boton "Nuevo"
- Listar: Vista de lista por defecto
- Editar: Click en un registro
- Eliminar: Seleccionar registro y boton "Eliminar"
- Ver productos: En detalle de autor, pestaña de productos


MODULO CATEGORIA
----------------
- Funcionalidad CRUD completa
- Lista de productos por categoria


MODULO PRODUCTO
---------------
- Asignar categoria (obligatorio)
- Asignar autor (opcional)
- Precio en formato monetario
- Lista filtrable y ordenable


MODULO CLIENTE
--------------
- Numero de cliente unico
- Nombre obligatorio
- Vista simple en facturas


MODULO FACTURA
--------------
- Año, numero y fecha en misma linea
- Seleccion de cliente
- Agregar multiples detalles
- Calculo automatico de totales


SOLUCIONES A PROBLEMAS COMUNES
--------------------------------------------------------------------------------

PROBLEMA: "Error al conectar con la base de datos"
SOLUCION:
- Verificar que MySQL este en ejecucion
- Verificar usuario y password en context.xml
- Verificar que la base de datos facturaciondb exista
- Verificar firewall no bloquee puerto 3306


PROBLEMA: "BUILD FAILURE en Maven"
SOLUCION:
- Verificar conexion a internet (para descargar dependencias)
- Limpiar cache de Maven: mvn clean
- Eliminar carpeta .m2/repository y volver a compilar


PROBLEMA: "Puerto 8080 ya en uso"
SOLUCION:
- Cerrar otras aplicaciones usando el puerto
- Cambiar puerto en configuracion de Tomcat
- Usar comando: netstat -ano | findstr :8080 (Windows)


PROBLEMA: "Las tablas no se crean en MySQL"
SOLUCION:
- Verificar que DBServer.start este comentado en facturacion.java
- Verificar logs de Hibernate en la consola
- Verificar permisos del usuario MySQL para crear tablas


PROBLEMA: "Error 404 al acceder a la aplicacion"
SOLUCION:
- Verificar que la aplicacion inicio correctamente
- Verificar URL correcta: http://localhost:8080/facturacion
- Verificar que el WAR se desplego correctamente


MANTENIMIENTO Y DESARROLLO
--------------------------------------------------------------------------------

AGREGAR NUEVA ENTIDAD
----------------------
1. Crear clase Java en paquete modelo
2. Anotar con @Entity, @Getter, @Setter
3. Definir campos con anotaciones JPA
4. Reiniciar aplicacion
5. La tabla se crea automaticamente


MODIFICAR ENTIDAD EXISTENTE
----------------------------
1. Editar clase Java
2. Guardar cambios
3. Reiniciar aplicacion
4. Hibernate actualizara el esquema (usar con cuidado en produccion)


PERSONALIZAR VISTAS
-------------------
- Usar @View para definir layout
- Usar @ReferenceView para vistas de referencias
- Usar @ListProperties para columnas de listas
- Consultar documentacion oficial de OpenXava


BACKUP DE LA BASE DE DATOS
---------------------------
Desde MySQL:
  mysqldump -u root -p facturaciondb > backup_facturacion.sql

Restaurar:
  mysql -u root -p facturaciondb < backup_facturacion.sql


ARQUITECTURA DEL PROYECTO
--------------------------------------------------------------------------------

CAPAS DE LA APLICACION
-----------------------
1. CAPA DE PRESENTACION
   - Generada automaticamente por OpenXava
   - Basada en anotaciones @View
   - HTML + CSS + JavaScript

2. CAPA DE LOGICA DE NEGOCIO
   - Entidades JPA anotadas
   - Validaciones con Bean Validation
   - Calculadores personalizados

3. CAPA DE PERSISTENCIA
   - JPA/Hibernate
   - Pool de conexiones gestionado por Tomcat
   - Generacion automatica de esquema


TECNOLOGIAS UTILIZADAS
-----------------------
- OpenXava 7.6: Framework principal
- Java 11: Lenguaje de programacion
- JPA 2.2: Especificacion de persistencia
- Hibernate 5.x: Implementacion de JPA
- MySQL 8.0: Base de datos
- Apache Tomcat 9: Servidor de aplicaciones
- Maven 3.x: Gestion de dependencias
- Lombok: Reduccion de codigo boilerplate


PATRONES DE DISEÑO APLICADOS
-----------------------------
- Entity: Modelo de dominio
- DAO: Abstraccion de acceso a datos (via JPA)
- MVC: Modelo-Vista-Controlador
- Dependency Injection: Inyeccion de dependencias
- Factory: Generacion de vistas


SEGURIDAD
--------------------------------------------------------------------------------

CONSIDERACIONES DE SEGURIDAD
-----------------------------
1. Cambiar password de admin en primer acceso
2. No exponer credenciales de base de datos en repositorios publicos
3. Usar HTTPS en produccion
4. Implementar politica de passwords fuertes
5. Realizar backups periodicos
6. Mantener dependencias actualizadas


CONFIGURACION PARA PRODUCCION
------------------------------
- Cambiar credenciales por defecto
- Configurar SSL/TLS
- Ajustar pool de conexiones segun carga
- Configurar logs apropiados
- Implementar monitoreo
- Definir estrategia de backup


RECURSOS ADICIONALES
--------------------------------------------------------------------------------

DOCUMENTACION OFICIAL
----------------------
OpenXava: https://www.openxava.org/OpenXavaDoc/docs/index_es.html
MySQL: https://dev.mysql.com/doc/
Maven: https://maven.apache.org/guides/
JPA: https://docs.oracle.com/javaee/7/tutorial/persistence-intro.htm


SOPORTE Y AYUDA
---------------
Foro OpenXava: https://sourceforge.net/p/openxava/discussion/
Stack Overflow: https://stackoverflow.com/questions/tagged/openxava


REPOSITORIO DEL PROYECTO
-------------------------
GitHub: [INSERTAR URL DEL REPOSITORIO AQUI]


LICENCIA
--------------------------------------------------------------------------------
Este proyecto fue desarrollado con fines educativos para la materia de
Verificacion y Validacion de Software.

OpenXava es software de codigo abierto bajo licencia LGPL.


CONTACTO
--------------------------------------------------------------------------------
Estudiante: Steven Carrillo
Email: [TU EMAIL AQUI]
Fecha: 19 de Octubre de 2025


HISTORIAL DE VERSIONES
--------------------------------------------------------------------------------
Version 1.0 (19/10/2025)
- Implementacion inicial
- Videos 1-3 completados (trabajo anterior)

Version 2.0 (19/10/2025)
- Leccion 4: Refinamiento de interfaz de usuario
- Leccion 5: Desarrollo agil con Autor
- Integracion con MySQL
- Documentacion completa


NOTAS FINALES
--------------------------------------------------------------------------------
Este proyecto demuestra:
- Desarrollo rapido de aplicaciones empresariales
- Integracion con bases de datos relacionales
- Aplicacion de principios de desarrollo agil
- Buenas practicas de documentacion y configuracion

Para cualquier problema o duda, consultar la documentacion oficial de OpenXava
o contactar al desarrollador.


================================================================================
FIN DEL README
================================================================================