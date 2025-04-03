Versión inicial Sprint, para el proyecto de Concesionario de Motos de Adán Romero y André Soares, es una fase de demo por lo tanto está sujeta a cambios, se añadira nuevas versiones a medida que mejoremos el código.

Actualmente tiene: un controlador con el que accede a un login.jsp, en el cual introduces datos y te devuelve los datos introducidos en email y contraseña (temporalmente ya que cuando se hagan más cosas redirigira a otra ventana).


Version 2: hemos creado un jsp de registro, para crear Clientes en nuestra base de datos, mediante uso de lombok, que facilita y agiliza la inserción de datos.


------CAMBIOS IMPORTANTES----------

MOTOS V3: hemos hecho cambios (mayormente André (es un maquina este femboy)), lo que hace es en el apartado de API, accede a la tabla, se puede modificar los datos de la tabla (antes de insertarlos en la base de datos), además de que guarda todos los datos de la api.

MOTOS ADMIN: implementación de rol en la base de datos y en el registro estableciendo por defecto USER como rol, además de implementación de medidas de seguridad para en caso de el usuario ser admin se le manda a una pantalla diferente y en caso de ser user se le da una bienvenida básica (contribuyente principal Sabrina).

