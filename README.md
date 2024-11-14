
# Practica Obligatoria Tema 2 Rueda Serrano y Cantero Maestro

**Table of Contents**

[TOCM]

[TOC]

#0. Instalación

Para poder ejecutar el programa debemos instalar el JDK [23.0.1](https://www.oracle.com/es/java/technologies/downloads/ "23.0.1") haciendo click aquí se te descargara directamente en el pc lo instalamos, deberemos asegurarse que instalarlo en **" C:\Program Files\Java "**

#1. Menu inicial

Conforme iniciemos el programa nos aparecera el siguiente menu:

![1  Menu principal](https://github.com/user-attachments/assets/045c575c-943b-4553-b966-faa884a92634)


Desde este menu elegiremos la opción correspondiente:

A-> Accederemos al menu de venta de entradas

B-> Accederemos al menu para comprobar el estado de un evento

C-> Accederemos al menu de administrador

Escribiremos por teclado la opción deseada y pulsaremos enter

#2. Menu Elección de evento

En este menu tendremos la posibilidad de elegir cual de los eventos en cartelera es el que nos interesa para comprar entradas y a su lado cual es la fecha correspondiente a dicho evento.

![2  Menu Venta Entradas](https://github.com/user-attachments/assets/349d7777-2dae-45d8-9eed-a88195b8c52e)


Igual que en el menu anterior y en todos los menus de este programa, elegiremos la opción que corresponda en este caso mediante el numero que acompaña al evento y accederemos al menu de elección de localidad.

Si elegimos la opción 0 nos devolvera al menu anterior.

##2.1 Menu elección de localidad:

Como podemos ver en la imagen este menu nos muestra el numero de localidades ya ocupadas. Además de indicarnos de cuanto seria el descuento en caso de realizar la compra con siete dias de anteliación al dia del evento.

![3  Menu Localidades](https://github.com/user-attachments/assets/d9141755-ff9b-4492-93f0-ed664cda1c32)


Tambien al lado de la localidad seleccionable mostraremos cuanto vale dicha entrada sin descuentos y sin la aplicación del IVA.


## 2.2 Pagos y cambios

Tras la elección de la localidad, el programa comprobara si la fecha actual y la fecha del evento tiene 7 dias de diferencia para comprobar si es posible que el cliente reciba el descuento correspondiente. 

Tras dicha comprobación el programa lanzara un mensaje al usuario indicando la cantidad que debe pagar por todas las entradas. A esta cantidad ya se le ha realizado el descuento y el IVA que corresponda para cada evento.

![4  Mensaje de total a pagar](https://github.com/user-attachments/assets/d74d9af0-8f75-49e6-80ef-6323a672ac66)

Una vez el usuario haya indicado la cantidad que paga se le devolvera el cambio equivalente. A la vez que el cliente recibe su cambio en el programa se actualiza la cantidad de billetes que quedan de cambio en el registro de la aplicación

![5  Tabla con cambio en monedas](https://github.com/user-attachments/assets/41bf59bf-86c3-4e27-b184-15988d0c03f6)


## 2.3 Ticktes de compra

Una vez el cliente ha recibido su cambio el programa se dispone a imprimir todos los tickets que el usuario haya solicitado. Siempre y cuando sea posible y haya suficientes entradas para satisfacer al cliente.

El ticket mostrara una ID para cada entrada junto a la localidad escogida, el numero de entradas totaltes compradas y el numero correspondiente a cada entrada.

Además el ticket muestra el cobro por entrada y si se le ha realizado el descuento pertinente.

A continuación veremos un ticket que **SI TIENE** descuento:

![6 Ticket con descuento](https://github.com/user-attachments/assets/41db61de-fc08-403d-8611-d6deb03aadb3)

Y ahora veremos un ticket sobre el que **NO TIENE** descuento realizado

![7  Ticket sin descuento](https://github.com/user-attachments/assets/19ac9073-74f6-440a-aed7-771021a03319)


##2.4. Ultima pregunta

Antes de terminar la venta de las entradas el cliente recibira un menu en el que podra indicar si quiere reaizar otra compra para el mismo evento, realizar una compra en otro evento o si quiere volver al menu inicial.

![8  Ultima pregunta compra de ticket](https://github.com/user-attachments/assets/2ab8ee14-f750-4e23-943c-ee8bc209aa99)


Dependiendo de la opción elegida el programa le redirigira al menu que haya elegido.

#3. Menu de comprobación de eventos

Pasamos ahora a enseñar la siguiente opción del menu principal.

En este menu el usuario puede comprobar información sobre los eventos que se realizaran en el teatro. Para poder acceder a la información del evento deberá escribir la opción correspondiente en el menu que se muestra en la imagen.

![9  Menu comprobar eventos](https://github.com/user-attachments/assets/90fdcb81-6692-46e4-9841-8d74e78ecf1d)


Una vez elijamos el evento del que queremos información se nos mostrara una tabla como la siguiente:

![10  Información evento](https://github.com/user-attachments/assets/e32a7cab-5187-4eb7-9eac-6213138e56f6)

En la que podemos ver los dias que faltan para el evento elegido, la cantidad de asientos disponibles en cada tipo de localidad, la fecha del evento y una linea que dependiendo de la fecha indicara si la compra de una entrada para dicho evento recibira un descuento por compra anticipada.


#4. Menu de administrador.

Para entrar a este menu se pedira nombre de usuario y contraseña.
La acreditación para entrar a este menu es la siguiente:

**USUARIO: Admin**

**Contraseña: Admin1234**

![11  Imagen acceso a Menu Admin](https://github.com/user-attachments/assets/607994b4-c4cd-4932-86f2-6000d8ee0954)


Una vez el usuario acceda a dicho menu le apareceran las siguientes opciones:

![12  Menu Admin](https://github.com/user-attachments/assets/e84cf396-44c8-4f0d-966e-990351dd16b3)


En este menu de administrador tendra varias opciones. Le recomendamos encarecidamente que empiece usando la opción C para cambiar el login de acceso a este menu.

Continuando con las opciones de este menu tiene las siguientes:

A-> Comprobar los ingresos de cada evento

B-> Comprobar el cambio disponible en caja

C-> Cambio de **USUARIO** Y **CONTRASEÑA**

D-> Cierre del programa

Z-> Salir del menu Administrador

## 4.1 Comprobar ingresos de cada Evento

En esta ventana podremos acceder a un menu que nos mostrara los eventos en cartelera y al elegir uno de ellos nos enseñara la recaudación total que ha generado dicho evento.

![13  Imagen recaudación](https://github.com/user-attachments/assets/78282ad5-3380-44a5-882f-d09f6018271e)


## 4.2 Consultar el cambio disponible

Al acceder a esta opción se nos desplegara una tabla en la que se nos indica como se ve en la imagen el cambio disponible en cada uno de los billetes y monedas que hay a disposición.

![14  Cambio disponible](https://github.com/user-attachments/assets/9da48043-dadb-4b6b-bf2e-729f5577a213)



## 4.3 Cierre de programa

La opción de cierre de programa solo se recomienda utilizarla una vez la aplicación haya realizado su función ya que en el momento del cierre del programa se perderan todos los datos que haya ido recopilando
