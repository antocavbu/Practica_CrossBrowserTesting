# Selenium Cross-Browser Testing

Ejercicio del Módulo 4 del curso de Automatización de Pruebas.

## Descripción

Proyecto de automatización con Selenium que ejecuta pruebas cross-browser en modo headless usando TestNG. La prueba verifica el título de la página de login de Practice Test Automation.

## Tecnologías

- **Java 11**
- **Selenium WebDriver 4.15.0**
- **TestNG 7.8.0**
- **WebDriverManager 5.6.2**
- **Maven**

## Navegadores soportados

- Chrome (headless)
- Firefox (headless)

## Ejecutar pruebas

```bash
# Compilar proyecto
mvn clean compile

# Ejecutar pruebas cross-browser
mvn test
```

## Estructura

- `src/test/java/CrossBrowserHeadlessTest.java` - Clase de prueba
- `testng.xml` - Configuración TestNG para cross-browser testing
- `pom.xml` - Configuración Maven
