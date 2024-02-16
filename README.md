# Weather App

This is a simple weather application developed in Java that provides users with current weather information for a given location. The application has both frontend and backend components. It fetches weather data from an external API and displays it in a graphical user interface (GUI). Credits : TapTap ytb

## Features

- **GUI Interface**: The application has a graphical user interface built using Java Swing, making it easy and intuitive to interact with.
- **Weather Data Display**: It displays various weather parameters such as temperature, weather condition, humidity, and windspeed.
- **Dynamic Weather Updates**: Users can enter a location, and the application dynamically updates the weather information based on the entered location.
- **Weather Icons**: The GUI displays weather condition icons corresponding to the current weather condition.
- **API Integration**: It integrates with the Open Meteo API to fetch weather data based on the user's location input.

## Components

### Frontend (GUI)

The GUI is developed using Java Swing. It consists of the following components:

- **Search Input**: Allows users to enter the location for which they want to check the weather.
- **Search Button**: Triggers the weather data retrieval process based on the entered location.
- **Weather Condition Image**: Displays an icon representing the current weather condition.
- **Temperature Display**: Shows the current temperature in Celsius.
- **Weather Condition Description**: Provides a textual description of the current weather condition.
- **Humidity and Windspeed Display**: Shows the humidity and windspeed information.

### Backend

The backend logic handles the retrieval of weather data from the Open Meteo API. It includes the following functionalities:

- **API Integration**: Connects to the Open Meteo API to fetch weather data based on location coordinates.
- **Location Data Retrieval**: Retrieves geographic coordinates for a given location using the geocoding API.
- **Weather Data Processing**: Processes the retrieved weather data, including temperature, weather condition, humidity, and windspeed.
- **Dynamic Time Handling**: Determines the current hour to fetch relevant weather data for the present time.

## Installation

1. Clone the repository to your local machine.
2. Make sure you have Java Development Kit (JDK) installed.
3. Compile the Java files using a Java compiler.
4. Run any file to execute the program

## Usage

1. Launch the application.
2. Enter the desired location in the search input field (not all cities will have info)
3. Click the search button to retrieve weather information for the specified location.
4. View the updated weather data displayed on the GUI.

## Dependencies

- **JSON.simple Library**: Used for parsing JSON data retrieved from the API.
- **Java Swing Library**: Used for building the graphical user interface.

## Contributing

Contributions are welcome! If you have any suggestions, improvements, or feature requests, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to customize and enhance this weather application according to your needs! If you encounter any issues or have questions, don't hesitate to reach out. Happy coding! 🌤️📊
