package GUI.Login;

import CommandPattern.AdminCommandPattern.AdminLoginCommand;
import DAO.LoginDAO;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class LoginFormAdmin extends JFrame {
    private JPanel panel1;
    private JTextField textField2;
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JPanel panel4;
    private JPanel panel5;
    private JLabel password;

    public LoginFormAdmin() {
        setTitle ("Login");
        setResizable (false);
        add (panel1);
        setSize (400, 250);
        setLocationRelativeTo (null);
        loginButton.addActionListener(e -> {
            AdminLoginCommand adminlog = new AdminLoginCommand (new LoginDAO ());
            if(adminlog.execute (textField2.getText (), String.valueOf (passwordField1.getPassword ()))) {
                AdminMainPanel adminMain = new AdminMainPanel ();
                setVisible (false);
                adminMain.addWindowListener(new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                });
            }
        });
    }
}
