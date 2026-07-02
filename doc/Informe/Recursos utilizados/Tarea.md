# Programación Avanzada
Semana 9 – Laboratorio: Optimización de Recursos mediante Programación Dinámica

## **El Problema de la Mochila (0/1 Knapsack)**

### Introducción

En numerosas situaciones reales es necesario seleccionar un conjunto de elementos limitados con el objetivo de maximizar algún beneficio sin exceder una capacidad disponible.

Este tipo de problemas aparece en logística, transporte, planificación de proyectos, asignación de recursos computacionales, gestión de presupuestos e incluso en exploración espacial.

En este laboratorio usted implementará una solución basada en Programación Dinámica para resolver uno de los problemas clásicos de optimización: **El problema de la Mochila 0/1 (0/1 Knapsack Problem)**.

Además de implementar la solución, deberá analizar el comportamiento del algoritmo, reconstruir la solución óptima encontrada y comparar los resultados obtenidos para distintos tamaños de entrada.

---

### Escenario
Una organización de ayuda humanitaria debe preparar un vehículo para entregar suministros a una zona afectada por un desastre natural.

El vehículo tiene una capacidad máxima de carga limitada.

Existen diversos recursos disponibles para transportar:

* Agua potable
* Medicamentos
* Alimentos
* Equipamiento médico
* Generadores eléctricos
* Equipos de comunicación
* Herramientas de rescate

Cada recurso posee:

* Un peso asociado
* Un valor de prioridad para la misión

Debido a las restricciones de capacidad, no es posible transportar todos los elementos.

El objetivo es determinar qué elementos deben ser seleccionados para maximizar el beneficio total sin exceder la capacidad disponible.


### Objetivos del Laboratorio
Al finalizar esta actividad el estudiante será capaz de:

* > Identificar problemas que presentan subproblemas superpuestos.
* > Aplicar Programación Dinámica para resolver problemas de optimización.
* > Construir una tabla DP.
* > Reconstruir una solución óptima a partir de la tabla.
* > Analizar empíricamente la complejidad del algoritmo.
* > Comparar resultados para distintos tamaños de entrada.

### Parte A – Implementación del Algoritmo
Implemente una solución para el problema de la Mochila 0/1 utilizando Programación Dinámica.

Su programa deberá recibir:

* Lista de objetos
* Peso de cada objeto
* Valor de cada objeto
* Capacidad máxima de la mochila

y determinar:

* Valor máximo alcanzable.
* Objetos seleccionados.
* Tabla dinámica generada.

### Dataset Inicial
Utilice inicialmente el siguiente conjunto de datos:

| Recurso      | Peso | Valor |
| ------------ | ---: | ----: |
| Agua         | 2    | 6
| Medicamentos | 3    | 8
| Alimentos    | 4    | 7
| Radio        | 5    | 10
| Generador    | 9    | 15
| Herramientas | 7    | 12 

Capacidad máxima:   20 unidades

--- 

### Parte B – Reconstrucción de la Solución
Una vez obtenida la tabla DP, implemente el procedimiento necesario para reconstruir la solución óptima.

El programa deberá indicar...

Ejemplo:

Objetos seleccionados:

* Medicamentos
* Radio
* Herramientas
* Agua

> Peso total: 17 ; //Valor total: 36

---

### Parte C – Visualización de la Tabla
Imprima la tabla dinámica generada por el algoritmo.

Por ejemplo:

> Objeto 0 1 2 3 4

Explique brevemente qué representa cada fila y cada columna.

---

### Parte D – Experimentos
Genere automáticamente conjuntos de datos aleatorios.

Realice experimentos con:

* 10 objetos
* 20 objetos
* 50 objetos
* 100 objetos
* 200 objetos

Para cada ejecución registre:

* Número de objetos.
* Capacidad de la mochila.
* Tiempo de ejecución.
* Tamaño de la tabla DP.
* Valor óptimo encontrado.

### Parte E – Análisis de Complejidad
Analice experimentalmente el comportamiento observado.

Responda:

1. > ¿Cómo crece el tiempo de ejecución al aumentar el número de objetos?
1. > ¿Cómo afecta la capacidad máxima de la mochila al tiempo de ejecución?
1. > ¿Coinciden los resultados observados con la complejidad teórica O(nW)?
1. > ¿Qué ventajas presenta Programación Dinámica respecto de una búsqueda exhaustiva?

## Entregables

Cada grupo deberá entregar:

### Código Fuente

* Proyecto completo.
* Código documentado.
* Instrucciones de compilación y ejecución.

## Informe Técnico
Máximo 5 páginas.

Debe incluir:

### Introducción

Descripción del problema.

### Diseño de la solución

Descripción de estados y recurrencia utilizada.

### Resultados

Tablas y gráficos obtenidos.

### Análisis

Discusión de complejidad observada.

### Conclusiones

Lecciones aprendidas.

## Desafío Opcional (+10%)
Implemente una segunda versión utilizando Memoization (Top-Down).

Compare:

* Tiempo de ejecución.
* Consumo de memoria.
* Facilidad de implementación.

Discuta ventajas y desventajas de ambos enfoques.


# Rúbrica de Evaluación (100%)

| Criterio                                         | Porcentaje |
| ------------------------------------------------ | ---------- |
| Implementación correcta del algoritmo DP         | 25%        |
| Reconstrucción correcta de la solución óptima    | 15%        |
| Construcción y explicación de la tabla DP        | 15%        |
| Experimentos y mediciones                        | 15%        |
| Análisis de complejidad observada                | 15%        |
| Calidad del código y documentación               | 10%        |
| Informe técnico y conclusiones                   | 5%         |


### Resultado Esperado
Al finalizar el laboratorio, los estudiantes deberán comprender cómo la Programación Dinámica permite resolver problemas de optimización complejos reutilizando soluciones previamente calculadas, transformando problemas potencialmente exponenciales en soluciones computacionalmente eficientes.