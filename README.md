TAREA PARA LA ASIGNATURA DE PROGRAMACIÓN DEL FP SUPERIOR DESARROLLO DE APLICACIONES WEB

Introducción.

En esta unidad se ha aprendido cómo realizar aplicaciones con entorno gráfico en java. Con esta práctica
se pretende demostrar lo aprendido. Para realizar la tarea hay que seguir las indicaciones y controles
vistos en los apuntes del tema, si no, no se dará por válida. (JSwing)
Es imprescindible para realizar la práctica, trabajar bien el anexo que está en el aula. La mayoría de los
conceptos que se necesitan para esta práctica están en ese anexo, además de trabajar los contenidos
oficiales que los amplían.
Se necesita una práctica con unos ejercicios funcionales y esta vez ya no se guía tanto al alumnado en la
estructura y en el diseño, por lo tanto, será difícil que dos prácticas se parezcan entre sí.

Consideraciones sobre el código que implementes:

* La práctica se tiene que hacer partiendo de cero. Si se detectan copias parciales de código fuente otras
prácticas, se dará por nula.
* El código tiene que estar suficientemente comentado y bien indentado (también conocido como
sangrado), si no, no se corregirá por ilegibilidad del mismo.
Como ya sabrás qué es de javadoc, si escribes /** y pulsas intro, automáticamente se crea una zona de
comentarios en las que aparece el autor, y podrías añadir más datos, como la versión, fecha o lo que veas
oportuno. Es conveniente hacerlo antes de cada clase, e incluso de cada método.
*Además, hay que poner un comentario al principio cada clase, con tu nombre y apellidos, indicando el
tema en el que estamos. Todo esto es requisito para continuar la corrección.

IMPORTANTE

Aunque los 2 ejercicios, por semántica, deberían ir en proyectos diferentes, los vamos a realizar en el
mismo para facilitar la entrega y corrección. Por lo tanto:
LOS 2 EJERCICIOS EN UN MISMO PROYECTO. CALCULADORA EN UN PAQUETE Y SUBPAQUETES DENTRO
DEL MISMO SI NECESITAS, Y LUEGO EL EJERCICIO 2 EN UNA DIVISIÓN DE AL MENOS 3 PAQUETES (UNA
PARA CUERPOCELESTE Y EXCEPCIONES PROPIAS, OTRA PARA ENTORNO GRÁFICO Y OTRO PARA
OPERACIONES DE ACCESO A FICHERO)


ENUNCIADO EJERCICIO 1: Calculadora. (1 puntos)

1. Se trata de realizar una calculadora personalizada y funcional (sencilla, basta con que realice
suma, resta, producto y división)
2. En el aula virtual he puesto contenidos de cómo realizar una, pero quiero que le des un aspecto
personal como icono propio, colores, colocación de los botones, funcionamiento o control de
errores etc. Por ejemplo, controlar que no haya divisiones por cero, que no se acumulan las
operaciones anteriores al resetear, que si das 2 veces a símbolos sin poner operandos no haga
cosas extrañas, etc.
3. De aquí basta con un vídeo de 1 minuto viendo funcionamiento y probando algunos casos
conflictivos explicados anteriormente. No hay que explicar código en este vídeo.

ENUNCIADO EJERCICIO 2 (9 puntos)

1. Se trata de aplicar un entorno gráfico a la práctica 6, de Cuerpos Celestes.
2. Toda la parte de clases, excepciones etc. es reutilizable con lo que hicisteis en la práctica 6 (es
posible que tengáis que hacer alguna pequeña mejora o adaptación en algún caso)
3. La parte de comunicación con el usuario se realizará mediante JSWING (ya no hay mensajes por
consola que mostrar, es decir, desaparecen los System.out.print y el leer por teclado cómo
habíamos hecho hasta ahora)
4. Aunque se trata de tocar lo menos posible la parte no gráfica que hiciste en la práctica 6, si ves
que, con lo aprendido hasta ahora, necesitas mejorarlo, puedes hacerlo (explícamelo en un
archivo aparte)
5. La parte gráfica tiene que seguir permitiendo hacer lo mismo: Añadir, Listar, Buscar por código,
Buscar por tipo, Borrar cuerpo, Borrar Fichero, Salir.
6. Los controles utilizados, al igual que los atributos y variables, tienen que seguir una
nomenclatura correcta.
Por ejemplo, si utilizáis jTextField, o jLabel, que no se llamen con el nombre que les asigna
NetBeans por defecto, sino seguir una nomenclatura camelCase y asignando nombres
apropiados y con significado al nombre de las variables.
7. Para listar los datos por ejemplo os podéis valer de JTable (como viene en los apuntes en el
apartado 2 del segundo fichero que os puse en la plataforma), pero doy libertad si preferís con
otro componente. Y para buscarlos aplicar un filtro sobre la tabla y mostrar la tabla con los datos
actualizados, pero es sólo una idea si a alguien se le ocurre otro diseño, y es funcional, será válido.
8. Se puede disponer de un menú superior que vaya llamando a las diferentes ventanas para hacer
las funcionalidades.
9. No necesariamente se debe disponer de un menú en la parte superior, la operatividad se puede
hacer con Botones, (hoy en día las aplicaciones tienden a eso en vez de hacer el menú clásico
como decía en el punto 7) o incluso que una ventana llame a otra. (por ejemplo, si pulsas en un
elemento de la tabla se puede mostrar el detalle en otra ventana para modificarlo).
10. Todo esto son ideas, pero cada uno tiene libertad para diseñar su aplicación, siempre que cumpla
la funcionalidad.
11. Se valorará una correcta división en paquetes, al menos 3 (por un lado, todo lo gráfico, por otro
la clase Cohete propiamente dicha junto con su excepción, e incluso en otro, debería ir el acceso
a fichero y todas las operaciones sobre el mismo). De esta manera vamos ya aprendiendo a
separar correctamente las partes de una aplicación cómo se hace de manera profesional (por un
lao la comunicación con el usuario, por otro el acceso a datos y por otro la operativa).
Incluso la operativa sin acceso a datos, y el acceso propiamente a datos, podrían ir separados,
dividiendo en 4 capas, pero con 3 me vale al ser una aplicación pequeña.
12. Si alguna funcionalidad de la práctica 6 no os funcionaba, es buen momento para corregirla.
13. Además, el proyecto, se realizará un vídeo explicando la estructura del programa y brevemente
el código realizado (no más de 2 minutos esta parte), y luego un uso de las diferentes
funcionalidades, en el que se vean todos los casos significativos, control de errores etc. (no más
de 3 o 4 minutos esta parte). Duración total del vídeo entre 5 o 6 minutos como máximo. Un
vídeo mayor puede penalizar.

ENTREGA

Se enviará un único archivo comprimido que contendrá el proyecto, un archivo pdf y dos vídeos
explicativos con lo que se pide en el punto 3 del primer ejercicio y en el punto 13 del segundo.
El PDF simplemente tendrá una o dos páginas como mucho, en el que me expliquéis las
interpretaciones realizadas, o las adaptaciones hechas, del ejercicio 2, (para que así no tengáis que
hacerlo en el vídeo y no sea tan largo)
Si algo no funciona o no se ha podido implementar en alguno de los ejercicios, se explicará en esos
vídeos, de tal manera que el profesor pueda luego ayudarte.
La entrega por lo tanto será un archivo comprimido, llamado Tarea9_Nombre_Apellidos.

Criterios de puntuación. Total 10 puntos.

Requisito para evaluar, que esté entregado el proyecto, el pdf y los vídeos con las indicaciones
dadas en los apartados anteriores.
Si está incompleto o no se entrega puede suponer que la evaluación de la práctica sea mínima.
Cada fallo puede restar entre 0.25 y 1 puntos, según la importancia del mismo, no pudiendo restar
más del valor del total del apartado correspondiente. (1 punto en el primer ejercicio, 9 en el segundo)
Recursos necesarios para realizar la Tarea como en unidades anteriores.
Ordenador personal; Sistema operativo Windows o Linux; NetBeans,JDK y JRE de Java.
