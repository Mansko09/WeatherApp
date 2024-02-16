import javax.swing.*;
import java.awt.*;

public class WeatherFrame extends JFrame{
    public WeatherFrame() {
        setTitle("Weather App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 800);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Set the background image
        ImageIcon backgroundIcon = new ImageIcon("WeatherApp_BG_resized.png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(null);

        JTextField searchTextField = new JTextField();
        searchTextField.setBounds(120, 160, 150, 50);
        searchTextField.setFont(new Font("Sans Serif", Font.BOLD, 24));
        backgroundLabel.add(searchTextField);


        add(backgroundLabel);
    }

}