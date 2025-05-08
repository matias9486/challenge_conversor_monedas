# Conversor de Monedas en Java
Este proyecto es una aplicación de consola desarrollada en **Java 17** como parte de la formación en Java de **Alura**.

Su propósito es aplicar conocimientos adquiridos como programación orientada a objetos, el consumo de APIs, manejo de JSON, escritura/lectura de archivos, manejo de excepciones y uso de bibliotecas externas como `Gson`.

## 🚀 Descripción
La aplicación permite realizar **conversiones entre diferentes monedas** utilizando datos actualizados desde la API de **ExchangeRate**.

Los datos se consultan a través de HTTP y se procesan utilizando la biblioteca Gson.

Las conversiones realizadas se almacenan localmente en un archivo JSON.

## 🛠️ Tecnologías y herramientas utilizadas
- Java 17
- API ExchangeRate
- Gson (para manejo de JSON)
- HttpClient (para consumir la API)
- java.io (para lectura y escritura de archivos)
- Manejo de excepciones
- Excepciones personalizadas

## 📋 Funcionalidades
- Menú interactivo en consola con opciones para:
    - Seleccionar monedas de origen y destino.
    - Ingresar el monto a convertir.
    - Ver resultados de la conversión en tiempo real.
- Validación de entradas del usuario.
- Guardado de cada conversión en un archivo JSON (`Historial_conversiones.json`).
- Lectura del historial desde el archivo.
- Manejo robusto de errores, incluyendo:
    - Fallos en la conexión con la API.
    - Errores en el formato de respuesta.
    - Manejo de errores personalizados.

## 📸 Capturas
A continuación se muestran algunas imágenes del funcionamiento de la aplicación en consola:

- Menú de la aplicación:

<a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/1_menu.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/1_menu.png" alt="Menu"></a>
<br>

- Historial de registro de conversiones:

<a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/2_historial_conversiones.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/2_historial_conversiones.png" alt="Historial"></a>
<br>

- Manejo de excepciones:

<a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/3_excpciones.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/3_excpciones.png" alt="Excepciones"></a>
<br>

- Funcionamiento de la aplicación:
  - Elección de moneda
  - Ingreso de monto a convertir
  - Información de la conversión realizada
  
<a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/4_funcionamiento.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/4_funcionamiento.png" alt="Funcionamiento"></a>
<br>

- Aplicación Finalizada:

<a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/5_fin.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/5_fin.png" alt="Fin_aplicacion"></a>
<br>

✅ Requisitos
- JDK 17 instalado
- Conexión a internet para consumir la API
- Gson como dependencia (agregar JAR descargado en directorio Lib)
  - Acceder a la estructura del proyecto para agregar el jar(File -> Project Structure)

  <a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/9_project_structure.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/9_project_structure.png" alt="Estructura_proyecto"></a>
  <br> 

  - Agregar el jar de gson(Project settings -> Modules y tocar en el icono + y elegir JARS o directories y elegir el archivo gson ubicado en directorio Lib de éste proyecto)

  <a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/10_agregar_gson_proyecto.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/10_agregar_gson_proyecto.png" alt="Agregar_gson"></a>
  <br>

- Generar cuenta en https://www.exchangerate-api.com/ para generar tu propia ApiKey
- Agregar la ApiKey como variable de entorno. Ejemplo desde Intellij:
  1. Modificar la configuración de ejecución. Desde la pestaña Run, puedo tocar en el icono 🔧 (Modify run configuration)  
  
  <a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/6_editar_configuracion.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/6_editar_configuracion.png" alt="Configuracion_aplicacion"></a>
  <br>

  2. Accediendo a variables de entorno(tocar en Enviroment Variables):
  
  <a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/7_modificar_configuracion.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/7_modificar_configuracion.png" alt="accediendo_variables_entorno"></a>
  <br>  
  
  3. Agregar variable de entorno(tocar en el icono + y agregar como clave ExchangeApiKey y como valor tu clave generada):
  
  <a href="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/8_api_key.png" target="_blank"><img src="https://raw.githubusercontent.com/matias9486/challenge_conversor_monedas/refs/heads/main/screenshot/8_api_key.png" alt="agregando_api_key"></a>
  <br>

