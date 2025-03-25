# El Monitor Dormilón

Este proyecto implementa una solución en Java al clásico problema de concurrencia conocido como **"El Monitor Dormilón"**, utilizando **hilos** y **semáforos**.

---

## Descripción del problema

El departamento de CSI de la **Universidad Icesi** dispone de un monitor que ayuda a los estudiantes de los cursos de algoritmos con sus tareas de programación. La oficina del monitor es muy pequeña y solo tiene:

- Un escritorio y una silla para el monitor.
- Una silla para el estudiante que recibe atención.
- **Tres sillas en el corredor** para estudiantes que esperan turno.

El comportamiento es el siguiente:

- Si no hay estudiantes esperando, el **monitor duerme**.
- Cuando un estudiante llega y el monitor está dormido, lo **despierta** para pedir ayuda.
- Si el monitor está ocupado ayudando a otro estudiante, el nuevo estudiante se **sienta en una silla del corredor**, si hay espacio.
- Si no hay sillas disponibles, el estudiante **regresa a programar** y lo intenta más tarde.
- El monitor ayuda a un estudiante por vez, y cuando termina, revisa si hay más estudiantes esperando.
- Si no hay más, vuelve a dormirse.

Los **estudiantes y el monitor** son modelados como **hilos independientes**. El acceso a las sillas y al monitor se sincroniza utilizando **semáforos**. Se simula el tiempo de ayuda o de programación usando pausas aleatorias.

---

## ¿Cómo ejecutar el programa?

### 1. Asegúrate de tener Java instalado

Puedes verificarlo con:

```bash
java -version
```

### 2. Descarga los archivos del proyecto

Guarda los siguientes archivos en la misma carpeta:

- `Main.java`
- `SleeperMonitor.java`
- `Student.java`

### 3. Abre la terminal y navega hasta la carpeta del proyecto

```bash
cd /ruta/a/tu/proyecto
```

### 4. Compila los archivos

```bash
javac Main.java SleeperMonitor.java Student.java
```

Esto generará los archivos `.class` correspondientes.

### 5. Ejecuta el programa

```bash
java Main
```

Verás en la consola cómo los estudiantes programan, piden ayuda, despiertan al monitor, esperan en el corredor o se retiran si no hay sillas disponibles.

---

## Integrantes del grupo

- **Daron Mercado**
- **Miguel Angel Martinez**
- **Julian Motta**

---
