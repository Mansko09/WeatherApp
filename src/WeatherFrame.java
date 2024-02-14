import javax.swing.*;
import java.awt.*;

public class WeatherFrame extends JFrame{
    WeatherFrame() {
        ImageIcon image = new ImageIcon("WeatherApp_BG.png");
        JLabel label = new JLabel();
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle(" Weather App ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,800);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.pink);
    }
}
