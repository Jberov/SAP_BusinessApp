package GUI.Admin.Admins.Redact;

import CommandPattern.AdminCommandPattern.RedactAdminPassword;
import DAO.AdministratorDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactAdminPasswordGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JPasswordField newPassword;

    public RedactAdminPasswordGUI() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Redact Admin password");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactAdminPassword redactAdminPassword = new RedactAdminPassword (new AdministratorDAOImpl ());
            if(redactAdminPassword.execute (username.getText (), String.valueOf (newPassword.getPassword ()))){
                JOptionPane.showMessageDialog (new JPanel (), "Admin has been redacted");
                setVisible (false);
                AdminMainPanel adminMainPanel = new AdminMainPanel ();
                adminMainPanel.setVisible (true);
                adminMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        backButton.addActionListener (e -> {
            AdminMainPanel adminMainPanel = new AdminMainPanel ();
            setVisible (false);
            adminMainPanel.setVisible (true);
            adminMainPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
    }
}
