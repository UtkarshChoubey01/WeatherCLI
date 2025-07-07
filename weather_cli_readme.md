# 🌦️ WeatherCLI

A simple Java command-line application to fetch and display the current weather of any city using the OpenWeatherMap API.

---

## 🚀 Features
- Takes a city name as a command-line argument
- Connects to OpenWeatherMap REST API using Java 11 HTTP Client
- Parses JSON response and displays:
  - Current temperature (°C)
  - Weather description
- Lightweight, fast, and works directly from terminal

---

## 🛠 Built With
- **Java 11+**
- **java.net.http** (built-in HTTP client)
- **org.json** library for JSON parsing
- Simple CLI architecture

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
```

---

## ⚙️ How it works
- User runs the program and passes the city name as an argument:
  ```
  java -jar WeatherCLI.jar Mumbai
  ```
- App sends HTTP request to:
  ```
  http://api.openweathermap.org/data/2.5/weather?q=<city>&appid=<API_KEY>&units=metric
  ```
- Parses JSON response to extract temperature and weather description
- Prints result to console

---

## ✏️ Usage
1. Clone/download this repository.
2. Add your **OpenWeatherMap API key** in `WeatherCLI.java`:
   ```java
   String apiKey = "YOUR_API_KEY_HERE";
   ```
3. Build the runnable jar (in Eclipse: `Export → Runnable JAR`).
4. Open terminal in the jar’s folder and run:
   ```
   java -jar WeatherCLI.jar <city>
   ```
   Example:
   ```
   java -jar WeatherCLI.jar London
   ```

---

## 🧠 Concepts Practiced
- Java CLI application with `main(String[] args)`
- Using Java 11 `HttpClient`
- JSON parsing with `org.json`
- Separation of concerns: CLI input, HTTP request, data parsing
- Exporting runnable JAR and running from terminal

---

## 🛆 Dependencies
- [`json-20210307.jar`](https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar)

---

## 📔 License
This project is open source and free to use for educational purposes.

---

✅ **Feel free to improve, fork, or suggest changes!**

