# **Software TFG para ... (privado)**

## **Funcionalidades:**

* Gestión completa de Stock del Producto Terminado

* Implementación BarTender (programa etiquetado)

* Sistema de rollback en registros (Inspirado en SCD Tipo 2\)

* Control de usuarios y permisos

## **Estructura Cliente-Servidor Stateless(API REST):**

### SERVIDOR

* Base de datos (MySQL)

* Servicio REST (SpringBoot)

### CLIENTE

Desde el cliente no se manipularán los datos. Éste enviará solicitudes al Servicio REST que se encuentra en el servidor.

* Windows: Interfaz gráfica utilizando WPF

* Android: Aplicación para móvil y Tablet

# **Detalles y comentarios:**

### GESTIÓN DE STOCK

La idea es conseguir que la gestión de stock del producto terminado esté digitalizado, consiguiendo que se mantenga siempre actualizado y que desde cualquier cliente (Aplicación Windows/Android) con permisos, se pueda consultar al instante.

La entrada/salida/ajuste de stock estará principalmente enfocado para dispositivos Android, aunque también se podrá realizar desde Windows. La idea es facilitar la introducción de datos implementando una lectura del código de barras a través de la cámara del dispositivo Android. Para que solo se tenga que introducir el número de cajas, lote e id del pedido o entrada de stock.

En cada movimiento se guardará registro de quién, y a qué hora se hizo. El usuario podrá colocar una observación.

####¿QUÉ PROBLEMAS SOLUCIONARÍA? ¿CUÁNTO TIEMPO GANAMOS CON ESTO?

* **Datos actualizados en la oficina:** Frecuentemente el almacén recibe llamadas desde la oficina para preguntar si hay stock de un producto porque un cliente quería llevarse. Muchas veces tienen que dejar lo que están haciendo, ir al stock de producto terminado rápido, verificarlo y llamar. (Incluso cuando están desbordados). Con esto se ganaría tiempo en el almacén, en la oficina y se conseguiría una respuesta instantánea al cliente.

* **Recuentos de stock:** Al mantener el stock actualizado se puede bajar la frecuencia con la que realizar los recuentos de stock. Evidentemente seguiría siendo imprescindible, porque es necesario verificar que realmente hay la cantidad que pone. Pero igual verificándolo 1 vez a la semana ya es suficiente (sería probar).

* **Facilidad en los recuentos de stock:** Si los movimientos de stock se hacen correctamente, serán muy pocos los productos en los que no cuadre el stock. Como durante el recuento sabremos cuántas cajas (por lote) debería haber, en caso de estar correcto, sería un sencillo click de confirmación, en vez de introducir lote, cajas y tipo en TODOS los lotes. Se tardaría mucho menos de la mitad.

* **Control de movimientos:** ¿Estas cajas de donde han salido? ¿A qué pedido se han metido estas cajas? ¿Quién ha dejado esto aquí? Y todas esas preguntas que nos vuelven locos… Al tener un registro instantáneo de todas las entradas y salidas, siendo responsable la persona que lo lleva/saca, podrá ser consultado desde cualquier dispositivo con permisos.

* **Reserva de stock:** Supongamos que se están reservando unas cajas para un cliente. Llega una llamada a la oficina, y aún no saben que están reservadas. Supuestamente sí que hay stock, se lo llevan y hay que reprogramar la producción porque el cliente para el que estaban reservadas las necesita.

  Mi idea es poder tener cajas reservadas a un pedido antes de realizar la salida de stock, añadiendo un comentario a la reserva en caso de ser necesario. Pudiendo consultar las reservas desde cualquier dispositivo, y así no hay que estar constantemente memorizándolo, ni sería necesario el exceso de comunicación, ya que todos pueden ver a quién fueron reservadas, el comentario introducido si es el caso y el responsable de la reserva.

  En caso de que alguien introduzca una salida de stock en algo que esté previamente reservado, le saldrá una advertencia (no le prohibirá realizar la salida de stock).

### IMPLEMENTACIÓN DE BARTENDER

Como el proyecto está enfocado principalmente para el Producto Terminado, facilita bastante la implementación de BarTender. Se obtendrían todos los datos posibles para la etiqueta de la base de datos. Para la mayoría de etiquetas no haría falta la inserción de datos a parte del nombre de la etiqueta, seleccionar el producto y el idioma. En el caso de requerir otros datos, se introducirán de forma gráfica tanto desde dispositivo Android como Windows.

El objetivo sería conseguir que hacer cambios en BarTender solo sea necesario cuando la etiqueta requiera una plantilla diferente.

####¿QUÉ CONSEGUIMOS CON ESTO?

* **Nuevas etiquetas:** Crear nuevas etiquetas sería super rápido, ya que obtendría todos los datos de la base de datos, y no hay que estar colocando a mano cada campo en cada etiqueta.

* **Errores:** Reducimos mucho la posibilidad de cometer errores, como equivocarnos de tecla al introducir datos.

* **Actualización:** Si una marca de repente cambia el logo, todas las etiquetas serán actualizadas al momento. Si un producto cambia un dato importante, no habría que ir actualizando cada etiqueta

* **Modificaciones de urgencia:** En producción, desde el dispositivo Android se podrá modificar los datos de la etiqueta sin necesidad de conocer el programa de etiquetado. Permitiendo que más gente pueda solucionar los problemas con el etiquetado, sin depender de los que conocen el programa.

* **Control de versiones:** Somos humanos y todos nos equivocamos. Igual intentamos hacer un cambio en la etiqueta y lo terminamos de estropear. Así que, por cada cambio en la etiqueta guardaría una versión (no se guardaría como una etiqueta nueva). Esto permitiría volver a cualquiera de las versiones anteriores en caso de equivocarnos.

### SISTEMA DE ROLLBACK

Muchas veces los productos, marcas, etiquetas, etc… tienen cambios. Pero hasta que no gastamos el material previo a los cambios, tenemos que hacer etiquetas con la versión anterior a la nueva. Pero nos interesa estar preparados para cuando se vaya a realizar el cambio, tener las etiquetas creadas y todo actualizado.

Esto es un problema, ya que, al hacer una actualización en la base de datos, las etiquetas que acceden a ella cambiarían sus datos automáticamente y no nos permitiría continuar con la producción del producto antes de los cambios.

La solución sería controlar las versiones. Para ello aplicaré un patrón inspirado en SCD Tipo 2 (Slowly Changing Dimensions) en la base de datos. Pudiendo seleccionar qué versión se desea utilizar.
![Explicacion SCD Tipo 2](https://cdn.discordapp.com/attachments/1184903737928589322/1343042124811206716/image.png?ex=67bbd4f3&is=67ba8373&hm=b503fd5233c51093062b973ee01676d11e57b4d374e087cd57003bb44fb33322& "Explicacion SCD Tipo 2")



### CONTROL DE USUARIOS UTILIZANDO NFC

Es interesante tener un control de quién realiza las diferentes acciones en la aplicación. Y establecer permisos a ciertas funcionalidades para que no todos los empleados puedan modificar datos de la base de datos, por ejemplo. Pero si cada vez que un empleado va a realizar un movimiento en el stock o cualquier otra funcionalidad, tiene que estar haciendo login. Estaríamos perdiendo esa ventaja del tiempo que estamos ganando, y entorpecería bastante las cosas.

Por eso he pensado que la solución sería que los empleados lleven una

pulsera/llavero NFC (es bastante económico). Y que cada vez que vayan a hacer un movimiento, inicien sesión automáticamente acercando la pulsera al dispositivo Android. Para cerrar sesión se hará de forma automática después de un tiempo de inactividad.

Con esto conseguimos que no falsifiquen el responsable de los movimientos, un acceso instantáneo a la aplicación con la sesión del empleado. Y lo más importante, no todos los empleados van a poder realizar las mismas funcionalidades.

En caso de error, también se permitirá el inicio de sesión con usuario y contraseña

![NFC interactuando con el movil](https://www.etiquetas-nfc.es/wp-content/uploads/pulsera-nfc-silicona-negra-_2_.webp "NFC interactuando con el movil")
