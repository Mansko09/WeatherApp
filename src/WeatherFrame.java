import javax.swing.*;
import java.awt.*;

public class WeatherFrame extends JFrame{
    JLabel label = new JLabel();
    public WeatherFrame() {
        ImageIcon image = new ImageIcon("WeatherApp_BG.png");

        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle(" Weather App ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,845);
        this.setVisible(true);
        this.add(label);

        addGuiComponents();

    }
    private void addGuiComponents(){
        //search field
        JTextField searchTextField = new JTextField();
        searchTextField.setBounds(15,15,100,60);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN,24));
        searchTextField.setVisible(true);
        this.add(searchTextField);
    }
}