# TestKibernum
Prueba Tecnica de programación.

Este tutorial es indicado para ejecutar el proyecto JAVA con MAVEN.

A- Ejecutar el proyecto con: :: Spring Boot :: (v3.0.6)

B- Las librerías necesarias están configuradas desde el pom.xml de MAVEN.

C- La versión de JDK es JAVA 17.

D- Se uso libreria de OpenApi Webmvc-ui version 2.1.0

E- La base de datos es H2 ejecutado en memoria al iniciar el proyecto. http://localhost:8080/h2-ui/login.jsp user: sa pass: sa

F- Usar Swagger para poder acceder a los métodos del controller construidos. http://localhost:8080/swagger-ui.html#/

G- Los metodos su entrada es una estructura JSON y salida de error con ResponseEntity para controlar resultados de exito y errores con exepciones.

H- Los métodos a acceder son:

* Existen dos Controller para ver en swagger

* ### User Controller ###

Todos los usuarios creados con User Controller tienen la capacidad de trabajar con la creación, modificacon, eliminar y consultar un libro en Book Controller.

* Método POST /api/user/
  Este método es el necesario para crear a un usuario en la base de datos que relaciona la tabla USERS 
  Antes de crear el usuario el servicio valida que no exista una coincidencia en la base de datos del correo del usuario y rut antes de ser insertado,
  en caso de existir devolvera error 500 por constraint sql  
 
* Método GET /api/user/{id}
  Este método puede devolver atraves del id del usuario los datos de mismo siempre que exista en la base de datos, de lo contrario retorna un error 500.

* Método PUT /api/user/{id}
  Este método actualiza los datos del usuario ya creado asociado al id del mismo.

* Método DELETE /api/user/{id}
  Este método elimina un usuario existente en la base de daros asociado al id del mismo.

  * ### Book Controller ###
  
  Todos los usuarios creados con User Controller tienen la capacidad de trabajar con la creación, modificacon, eliminar y consultar un libro.
  
* Método POST /api/book/{idUser}
  Este método es el necesario para crear a un libro en la base de datos que relaciona la tabla BOOKS 
  Antes de crear el libro se valida que el usuario idUser exista, luego el servicio valida que no exista una coincidencia en la base de datos del SKU unico del libro antes de ser insertado,
  en caso de existir devolvera error 500 por constraint sql  
 
* Método GET /api/book/{idBook}/{idUser}
  Este método puede busca un libro valida que el usuario idUser exista si esta OK, con el idBook del libro los datos de mismo siempre que exista en la base de datos, de lo contrario retorna un error 500.

* Método PUT /api/book/{idBook}/{idUser}
  Este método actualiza los datos del libro valida que el usuario idUser exista si esta OK, con el idBook del libro existente modifica los valores dados.

* Método DELETE /api/user/{id}
  Este método elimina los datos del libro valida que el usuario idUser exista si esta OK, con el idBook del libro existente procede a eliminar.