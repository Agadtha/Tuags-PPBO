import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    public LoginPage(){


        setTitle("Sistem informasi Akademis");
        setSize(300,200);
        setLocationRelativeTo(null); //biar open window ditengah layar


        JPanel panel = new JPanel(new BorderLayout());

        add(panel);

        JLabel label = new JLabel("Please Login", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD,10));
        panel.add(label, BorderLayout.NORTH);


        JButton button = new JButton("Login");
        panel.add(button, BorderLayout.SOUTH);


        JPanel fieldPanel = new JPanel(new GridLayout(2,2));


        fieldPanel.add(new JLabel("username"));
        JTextField usernameField = new JTextField();
        fieldPanel.add(usernameField);


        fieldPanel.add(new JLabel("password"));
        JPasswordField passwordField= new JPasswordField();
        fieldPanel.add(passwordField);

        panel.add(fieldPanel);


        button.addActionListener(ActionEvent -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if(username.equals("Admin") && password.equals("12345")){
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                dispose();
                new Dashboard().setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this,"Wrong username or password");
                usernameField.setText("");
                passwordField.setText("");
            }

        });
    }
}
