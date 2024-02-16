import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherFrame extends JFrame{
    private JSONObject weatherData;

    public WeatherFrame() {
        setTitle("Weather App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 800);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Set the background image
        ImageIcon backgroundIcon = new ImageIcon("src/assets/WeatherApp_BG_resized.png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(null);

        JTextField searchTextField = new JTextField();
        searchTextField.setBounds(100, 160, 150, 50);
        searchTextField.setFont(new Font("Sans Serif", Font.BOLD, 24));
        backgroundLabel.add(searchTextField);

        JButton searchButton = new JButton(loadImage("src/assets/searchicon.png"));
        //change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(270,160,47,45);
        backgroundLabel.add(searchButton);
        searchButton.setFocusable(false);

        //weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(70,230,245,217);
        add(weatherConditionImage);

        //temperature text
        JLabel temperatureText = new JLabel("10 °C");
        temperatureText.setBounds(0,440,450,54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD,48));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        //weather condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0,495,450,36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN,32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        //humidity image
        JLabel humidityImage =new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15,540,74,66);
        add(humidityImage);


        JLabel humidityText=new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90,540,85,55);
        humidityText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(humidityText);

        //windspeedImage
        JLabel windspeedImage = new JLabel((loadImage("src/assets/windspeed.png")));
        windspeedImage.setBounds(180,540,74,66);
        add(windspeedImage);

        //windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b>15km/h</html>");
        windspeedText.setBounds(260,540,85,55);
        windspeedText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(windspeedText);
        searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get location from user
            String userInput = searchTextField.getText();

            // validate input - remove whitespace to ensure non-empty text
            if(userInput.replaceAll("\\s", "").length() <= 0){
                return;
            }

            // retrieve weather data
            weatherData = WeatherApp.getWeatherData(userInput);

            // update gui

            // update weather image
            String weatherCondition = (String) weatherData.get("weather_condition");

            // depending on the condition, we will update the weather image that corresponds with the condition
            switch(weatherCondition){
                case "Clear":
                    weatherConditionImage.setIcon(loadImage("src/assets/clear.png"));
                    break;
                case "Cloudy":
                    weatherConditionImage.setIcon(loadImage("src/assets/cloudy.png"));
                    break;
                case "Rain":
                    weatherConditionImage.setIcon(loadImage("src/assets/rain.png"));
                    break;
                case "Snow":
                    weatherConditionImage.setIcon(loadImage("src/assets/snow.pngImage"));
                    break;
            }

            // update temperature text
            double temperature = (double) weatherData.get("temperature");
            temperatureText.setText(temperature + " C");

            // update weather condition text
            weatherConditionDesc.setText(weatherCondition);

            // update humidity text
            long humidity = (long) weatherData.get("humidity");
            humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

            // update windspeed text
            double windspeed = (double) weatherData.get("windspeed");
            windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
        }
    });

        add(backgroundLabel);
    }

    private ImageIcon loadImage(String resourcePath){
        try{
            //read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));
            //returns on image icon so that our component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Could not find resource");
        return null;
    }

}