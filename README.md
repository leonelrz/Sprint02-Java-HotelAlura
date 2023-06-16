# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

Proyecto que forma parte del programa de formación ORACLE NEXT EDUCATION, impartido por ALURA LATAM, en el cual se solicitó implementar un sistema de registro de reservas y huéspedes para un hotel, utlizando el lenguaje Java.Las características solicitadas por nuestro cliente son las siguientes:

- Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema
- Permitir crear, editar y eliminar una reserva para los clientes
- Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas
- Registrar, editar y eliminar datos de los huéspedes
- Calcular el valor de la reserva en base a la cantidades de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país, por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra diaria son 20$ debemos multiplicar esos 3 dias por el valor de la diaria que serian 60$, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva
- Base de datos para almacenar todos los datos pedidos anteriormente.
---

## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- MySql

---
## ⚠️ Importante! ⚠️

☕ Use Java versión 8 o superior para compatibilidad. </br></br>
📝 Recomendamos usar el editor de Eclipse para compatibilidad con la Interfaz Gráfica. </br></br>
🎨 La interfaz contiene dos métodos importantes:
- setResizable(false): determina el tamaño de la ventana, y a través del parámetro <strong>false</strong>, la pantalla no se puede maximizar;
- setLocationRelativeTo(null): determina la ubicación de la ventana, y a través del parámetro <strong>null</strong> la mantiene centrada en la pantalla.</br>

🔃 En ConnectionFactory, que es donde se hace la conexión a la base de datos, se deben cambiar los valores del usuario y contraseña, dependiendo de los que tengas configurado en MySQL en tu computadora.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/112449858/214437568-25c0ad92-a187-480f-a022-92703e928b0f.png">
</p>
</br>

📋 Para asegurar que no haya problemas en la compatibilidad de los datos y el código, sugiero crear una base de datos en MySQL con el nombre "hotelalura" y dentro de ella, dos tablas, una con el nombre "reservas" y otra "huespedes", éstos son los tipos de datos que va a albergar cada una.

<p align="center">
     <img width="200" heigth="200" src="https://user-images.githubusercontent.com/112449858/214439470-d10cae1e-7f3f-4307-929e-60824e877733.png">
     <img width="200" heigth="200" src="https://user-images.githubusercontent.com/112449858/214439498-ae5bfab5-21c4-4e02-9f28-e98ad51c7c74.png">
</p>






---

## 🔍 ¡Analizando nuestro repositorio!

Este repositorio es una colaboración en el cual, la interfaz gráfica fue proporcionada previamente y se puede encontrar en la branch "repositorio-base" de este mismo, es importante mencionar que las vistas de las ventanas se encuentran en el siguiente paquete:
#### 🔹 src/views: carpeta con toda la interfaz gráfica de las pantallas necesarias para desarrollar el programa, la pantalla con la que inicia la aplicación es "Menú Principal".

---

## :hammer: Funcionalidad del proyecto.

Tan pronto la aplicación es desplegada nos arroja la siguiente pantalla, la cual tiene un botón de login, el cual debemos oprimir para acceder:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214430118-12f76459-f214-489a-b113-772508f900ae.png">
</p>


Una vez pulsado dicho botón nos dirige a otra pantalla en la cual debemos ingresar unos datos para entrar al sistema. En este caso el usuario es: "usuario" y la contraseña es: "password", ambos valores deben ser ingresados sin las comillas.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214430941-dffc0a4a-131f-48f1-9bce-3ee5b25305be.png">
</p>


Si ingresamos los datos de forma correcta nos va a mandar a la siguiente pantalla, de lo contrario nos mandará algun mensaje de error. Al estar dentro podremos ver un menú donde podremos acceder al sistema de registro de reservas y tambien a otra ventana que nos permitirá hacer busquedas de los valores ya contenidos en la base de datos.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214431690-1ebb7301-56bd-469a-9628-8e1f45488a36.png">
</p>


Al seleccionar el apartado de registro de reservas, se despliega el formulario donde vamos a llenar la información, el apartado del "Valor de la reserva" es generado de forma automática.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214432295-d3dac948-6237-4ffc-a79f-0c0f6de45c26.png">
</p>


Una vez que pulsamos "Siguiente", nos manda a la pantalla donde se registrará al huesped que hizo esa reserva, es importante mencionar qeu tanto el huesped, como la reserva estan contenidos en dos tablas diferentes en la base de datos, pero están ligados por una clave foranea, la cual es el "id" de la reserva.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214433098-a5ff0b73-ea61-4c3f-a1d7-83e4ad28111b.png">
</p>


Al concluir el registro del huesped, el sistema nos manda un mensaje en caso de que el registro fue exitoso, y a su vez, nos regresa al menú de usuario (Pantalla #3 de éste apartado). Ahora, en ésta ocasión, seleccionaremos el apartado de "Búsqueda", el cúal nos desplegará la siguiente pantalla, en la cual podremos visualizar los registros contenidos en la base de datos, tanto de la reserva como del cliente.


<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214433833-dc62387d-2c63-4e9e-ae57-751364eaaba5.png">
</p>


En la barra de búsqueda de éste apartado podemos ingresar 3 criterios de búsqueda:
- Por No. de reserva.
- Por Apellido del huesped.
- Si el campo está vacío y presionamos el botón, cargará todos los registros de la base de datos.

La aplicación tiene internamente una funcionalidad que permite saber que tipo de caracter se está ingresando por medio de una RegEx para poder realizar la búsqueda. También es importante mencionar que al estar ambas tablas relacionada, si buscamos por el No. de la Reserva, en la tabla de huespedes, tambien nos mostrará el registro asociado, y también lo hace de forma inversa, es decir, si buscamos por el Apellido del huesped, no solo mostraremos el registro del huesped, si no también el registro de la reserva asociada a éste, esto se logró implementando un Statement de SQL compuesto con INNER JOIN.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214435182-c20df3d3-90c5-4e23-8988-a007b2df24a6.png">
</p>


Para modificar algún registro de los listados en las tablas solo tenemos que seleccionar alguno de ellos y "modificar" el valor literalmente, una vez hecho, presionaremos el botón de editar, y si todo salió bien, nos mostrará el siguiente mensaje, para posteriormente cargar nuevamente los datos en la tabla con todos los registros ya actualizados.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214435973-ae65c9de-df84-4985-b0fd-ad4e962ad74f.png">
</p>


Por último, si desearamos eliminar algún registro de cualquiera de las dos tablas, solo lo seleccionamos y presionamos el botón de "Eliminar". Posteriormente cargará dicha tabla actualizada. Si eliminaramos un valor de la tabla de reserva, también se eliminará el registro asociado de la tabla de huespedes y viceversa.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/112449858/214436692-08f7fcef-38a8-40eb-8dae-0fe8a885a18f.png">
</p>

---

## :open_file_folder: :rocket: Abre y ejecuta el proyecto

Para ejecutar el proyecto necesitamos: 

- Descargarlo de éste repositorio.
- Creamos la base de datos con las recomendaciones que están en la seccion "Importante"
- Una vez guardado podemos abrirlo con algún IDE como Eclipse o Netbeans.
- Cambiamos los valores de conexión a la base de datos también especificados anteriormente
- Corremos el proyecto como una aplicación de Java, cuidando que, el archivo con el que vamos a iniciar sea MenuPrincipal, en la carpeta o paquete "views".

---

## Autores

| [<img src="https://avatars.githubusercontent.com/u/91544872?v=4" width=115><br><sub>Genesys Rondón</sub>](https://github.com/genesysaluralatam) |[<img src="https://avatars.githubusercontent.com/u/112590041?v=4" width=115><br><sub>Leonel Reyes</sub>](https://github.com/leonelrz) | 
| :---: | :---: | 
