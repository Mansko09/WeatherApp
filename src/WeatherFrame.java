import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherFrame extends JFrame{
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
        weatherConditionImage.setBounds(70,225,245,217);
        add(weatherConditionImage);

        //temperature text
        JLabel temperatureText = new JLabel("10 °C");
        temperatureText.setBounds(0,400,450,54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD,48));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        //weather condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0,455,450,36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN,32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        //humidity image
        JLabel humidityImage =new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15,500,74,66);
        add(humidityImage);


        JLabel humidityText=new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90,500,85,55);
        humidityText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(humidityText);

        //windspeedImage
        JLabel windspeedImage = new JLabel((loadImage("src/assets/windspeed.png")));
        windspeedImage.setBounds(180,500,74,66);
        add(windspeedImage);

        //windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b>15km/h</html>");
        windspeedText.setBounds(260,500,85,55);
        windspeedText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(windspeedText);



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