# proyecto-final
Proyecto final de 1ºDAM -
Gestión de un club de fútbol. (Sevilla FC)

Credenciales de los dos roles ya creados de usuario para probar las funcionalidades de la página web:

Usuario:
usuario: user / password: 1234

Administrador:
usuario: admin / password: admin

Descripción de la página: 

En mi página podemos gestionar varias secciones que tiene un club de fútbol en una lógica de negocio realista.
Por una parte podemos gestionar todos los aspectos de una tienda, donde nos encontramos con la gestión de productos (añadir productos, editar productos, eliminar productos, ver los detalles de ese producto) 
donde todo esto lo puede gestionar el admin, y donde el usuario puede ver los detalles de un producto, y añadir al carrito los productos que quiera.
Además de la gestión de productos, tenemos la asociación categoria-producto, donde un atributo de producto son las diferentes categorias que existan y queramos.
Esta última funcionalidad de añadir productos al carrito y tener una vista general del carrito aún está en desarrollo, por lo que no está implementada.
Una vez en la tienda del admin, se agrega en el menú una opción llamada "Opciones de tienda", en la cual podemos ir a la gestión de productos o a la gestión de categorías.

Por otro lado tenemos la sección de gestión de socios, donde el admin puede añadir socios, eliminar socios, editar sus datos, y ver los detalles de cada socio.
Además un socio puede comprar en la tienda, y si se gasta una cantidad de dinero, puede obtener beneficios en la misma.
Como usuario NO LOGUEADO en esta sección podemos rellenar un formulario que al rellenarlo, se añadirá un nuevo socio automáticamente a la base de datos, y posteriormente se le actualizará al admin en su panel de socios. Y podremos usar el nombre de usuario y contraseña registrada para loguearnos como socio. (Si queremos que ese socio nuevo sea admin, tendría que hacerlo otro admin desde el panel de gestión).

Además de estas funcionalidades, cuenta con una página de inicio con historia del club, y varias páginas estáticas como clasificación, noticias, calendario de partidos, y otra de contacto con el club, 
donde si se envia el formulario correctamente, genera una ID de mensaje en la misma plantilla de contacto (esta id es visualmente).

En resumen, como lógica de negocio, tenemos el carrito, con toda su gestión, descuentos en las siguientes compras si un socio ha superado una cantidad de dinero gastado en la tienda, además de todos los CRUD y las asosiaciones: categoria-producto (OneToMany), 
lineaventa-venta (ManyToOne, siendo una composición) y venta-socio (ManyToOne).




 



