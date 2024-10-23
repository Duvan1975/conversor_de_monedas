
# Conversor de Monedas

Este proyecto es un **conversor de monedas** que permite convertir un valor entre diferentes monedas usando la API de `exchangerate-api`. El programa consulta las tasas de cambio y genera un historial de conversiones en un archivo JSON.

## Funcionalidades
- Conversión de monedas entre cualquier par de divisas soportado por la API.
- Guardado de las conversiones realizadas en un archivo `historial.json`.
- Consulta de las tasas de cambio actualizadas.

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

```bash
├── modelos/
│   ├── ConsultaMoneda.java
│   ├── ConversorDeMoneda.java
│   ├── GeneradorDeHistorial.java
│   ├── Moneda.java
├── principal/
│   └── Principal.java   # Punto de entrada principal de la aplicación
├── historial.json        # Archivo JSON que almacena el historial de conversiones
├── README.md             # Archivo README con la descripción del proyecto
```

### Clase Principal

La clase `Principal` es el punto de entrada de la aplicación. En esta clase, se implementa el flujo principal del programa, permitiendo al usuario interactuar con las opciones de conversión de moneda y almacenamiento en el historial. Se encarga de gestionar la lógica del menú y las interacciones del usuario.

### Clase `ConsultaMoneda`
La clase `ConsultaMoneda` realiza la consulta a la API de ExchangeRate para obtener las tasas de cambio actualizadas. Usa `HttpClient` para realizar solicitudes HTTP y devuelve un objeto `Moneda` con la información de conversión.

### Clase `ConversorDeMoneda`
Esta clase maneja la lógica para convertir una moneda de origen a una moneda de destino. Calcula la cantidad convertida basándose en las tasas proporcionadas por la API y muestra el resultado al usuario.

### Clase `GeneradorDeHistorial`
Esta clase gestiona el historial de conversiones realizadas. Permite agregar nuevas conversiones y guarda el historial en un archivo JSON llamado `historial.json`.

### Clase `Moneda`
La clase `Moneda` modela la respuesta recibida de la API. Contiene información como la última actualización de las tasas (`time_last_update_utc`), el código de la moneda base (`base_code`), y un mapa con las tasas de conversión (`conversion_rates`).

## Uso
1. El usuario ejecuta el programa, el cual muestra un menú con varias opciones.
2. Elige las monedas de origen y destino, y la cantidad a convertir.
3. La tasa de cambio se obtiene a través de la API y el resultado de la conversión se muestra.
4. El historial de conversiones se guarda automáticamente en `historial.json`.

## Ejemplo de Ejecución
```
Por favor ingrese la moneda de origen: USD
Por favor ingrese la moneda de destino: COP
Por favor ingrese la cantidad a convertir: 2.0

2.00 dólares equivalen a: 8526.34 COP
Historial guardado correctamente en historial.json
```

## Requisitos
- Java 11 o superior
- Biblioteca `Gson` para la manipulación de JSON

## API Utilizada
- [ExchangeRate API](https://www.exchangerate-api.com/)

## Autor
- Proyecto desarrollado por **Duván Ballesteros Gallego** como parte del desafío en Alura Cursos.
