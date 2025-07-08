Here you go! 📄
Just **copy-paste** the entire block below into a new file named **`README.md`** in your project root:

```markdown
# 🌦️ WeatherCLI

A simple Java CLI tool to fetch:
- Current weather
- Coordinates (latitude & longitude)
- Local time

using OpenWeatherMap and TimezoneDB APIs.

---

## 🚀 Features
✅ Takes city name as CLI argument  
✅ Fetches weather data (temperature, description)  
✅ Fetches coordinates from same weather response  
✅ Gets local time using TimezoneDB  
✅ Handles HTTP errors gracefully  
✅ Uses environment variables for API keys (secure)

---

## 🏗 Project Structure
```

WeatherCLI/
├── src/
│   └── weathercli/
│       └── WeatherCLI.java
├── lib/
│   └── json-20210307.jar
└── README.md

````

---

## ⚙️ How to Build
**In Eclipse:**
1. Add `json-20210307.jar` to classpath.
2. `File → Export → Java → Runnable JAR file`
3. Choose launch config (`WeatherCLI`).
4. Library handling: ✅ *Package required libraries into generated JAR*
5. Export as `WeatherCLI.jar`.

---

## 🧪 How to Run
Set environment variables with your API keys and run:

**Windows CMD:**
```cmd
set OPENWEATHER_API_KEY=your_key
set TIMEZONEDB_API_KEY=your_key
java -jar WeatherCLI.jar Mumbai
````

**Linux/macOS:**

```bash
export OPENWEATHER_API_KEY=your_key
export TIMEZONEDB_API_KEY=your_key
java -jar WeatherCLI.jar Mumbai
```

---

## 🧠 Concepts Practiced

* Java 11 `HttpClient` & `HttpRequest`
* JSON parsing with `org.json`
* CLI input via `args`
* Environment variables
* Error handling and refactoring

---

## 📔 License

Open source & free to use for learning.

---

✅ **Contributions welcome!**

````

---

✅ Once saved, you can do:
```bash
git add README.md
git commit -m "Add README.md"
git push origin main
````

If you'd like, I can draft the commit message & commands for you too.
Just say so! 🚀
