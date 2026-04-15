# 🧪 Automation QA Project – Selenium + TestNG

## 📌 Descripción del Proyecto
Este proyecto implementa la automatización completa del flujo de compra en la web:

🔗 https://automationexercise.com/

Se ha desarrollado utilizando **Java, Selenium WebDriver y TestNG**, aplicando buenas prácticas como el patrón **Page Object Model (POM)**, manejo de **esperas dinámicas**, ejecución en múltiples navegadores, y generación de **reportes HTML con evidencias (screenshots)**.

---

## 🎯 Objetivo
Automatizar de manera eficiente y estable el flujo de venta incluyendo:

- Registro de usuario
- Login
- Navegación de productos
- Agregado al carrito
- Proceso de checkout
- Validación de casos negativos

---

## 🛠️ Tecnologías Utilizadas

- ☕ Java JDK 21
- 🌐 Selenium WebDriver 4
- 🧪 TestNG
- 📊 ExtentReports (reportes HTML)
- 📸 Captura automática de screenshots
- 🔧 WebDriverManager (Chrome)
- 🧩 Page Object Model (POM)

---

## 📁 Estructura del Proyecto

```
AutomationQAProject
│
├── base
│   └── BaseTest.java
│
├── pages
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── ProductPage.java
│   └── RegisterPage.java
│
├── reports
│   └── ExtentManager.java
│
├── tests
│   ├── CartTest.java
│   └── CheckoutTest.java
│   ├── LoginTest.java
│   ├── NegativeLoginTest.java
│   └── RegisterTest.java
│
├── utils
│   ├── ScreenshotUtils.java
│   ├── TestData.java
│   ├── TestListener.java
│   └── WaitUtils.java
│
└── testng.xml
```

---

## ⚙️ Configuración del Entorno

### 1. Requisitos

- Java JDK 21 instalado
- Maven configurado
- IntelliJ IDEA (recomendado)
- Navegadores:
  - Google Chrome (última versión)
  - Microsoft Edge (última versión)

---

### 2. Clonar el repositorio

```bash
git clone https://github.com/JosledDemon/AutomationQAProject.git
```

---

### 3. Instalación de dependencias

```bash
mvn clean install
```

---

### 4. Configuración de Drivers

- ✅ Chrome → automático con WebDriverManager
- ✅ Edge → driver local en:

```
/drivers/msedgedriver.exe
```

El proyecto usa una ruta dinámica:

```java
String path = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
```

---

## ▶️ Ejecución de Pruebas

### Ejecutar desde TestNG:

- Click derecho en:
```
testng.xml
```
→ Run

---

### Ejecutar por navegador

En `testng.xml`:

```xml
<parameter name="browser" value="chrome"/>
```

o

```xml
<parameter name="browser" value="edge"/>
```

---

## 🔄 Flujo Automatizado

El proyecto cubre completamente:

1. Registro de usuario
2. Login
3. Navegación de productos
4. Agregado al carrito
5. Validación del carrito
6. Checkout

✔ Implementado con esperas dinámicas (WebDriverWait)  
✔ Sin uso de `Thread.sleep()`  

---

## ❌ Manejo de Casos Negativos

Se implementaron validaciones como:

- Login con credenciales incorrectas
- Validación de mensajes de error
- Control de acceso denegado

✔ Uso de asserts para validar comportamiento esperado  
✔ Captura de errores en reportes  

---

## 🌐 Compatibilidad de Navegadores

El framework permite ejecutar pruebas en:

- ✅ Google Chrome
- ✅ Microsoft Edge

✔ Cambio dinámico mediante parámetro  
✔ Ejecución estable sin errores  

---

## 🧠 Buenas Prácticas Implementadas

- ✔ Page Object Model (POM)
- ✔ Separación de lógica y localizadores
- ✔ Código reutilizable
- ✔ Esperas explícitas
- ✔ Manejo de excepciones
- ✔ Nomenclatura clara y profesional

---

## 📸 Evidencias (Screenshots)

Se capturan automáticamente en cada ejecución:

📁 Ruta:
```
/screenshots/
```

---

## 📊 Reportes HTML

Se generan con ExtentReports:

📁 Ruta:
```
/reports/Reporte.html
```

Incluyen:

- Estado de cada test (PASS / FAIL)
- Screenshots en fallos
- Detalles de ejecución

---

## 🚀 Solución de Problemas

### ❗ Error: SessionNotCreatedException (Edge)

✔ Solución:
- Verificar que la versión de Edge coincida con el driver

---

### ❗ CDP Warning (Chrome/Edge)

```
Unable to find CDP implementation
```

✔ No afecta la ejecución (solo advertencia)

---

### ❗ Screenshots no se guardan

✔ Verificar que exista la carpeta:
```
/screenshots/
```

---

## 📌 Conclusiones

El proyecto cumple con todos los criterios de evaluación:

✔ Automatización completa del flujo de venta  
✔ Manejo de casos negativos  
✔ Compatibilidad multi-navegador  
✔ Código estructurado con POM  
✔ Reportes y evidencias automáticas  

🎯 Nivel alcanzado: **SOBRESALIENTE**

---

## 👨‍💻 Autor

**Josled Luis Antonio Roman Huaman**

---

## 📎 Recomendaciones

- Mantener actualizados los drivers
- Implementar ejecución en CI/CD (futuro)
- Agregar más escenarios negativos