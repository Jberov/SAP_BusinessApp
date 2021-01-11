package GUI.Admin.Admins.Redact;


import DAO.AdministratorDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactAdminUsername extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton redactButton;
    private JButton backButton;
    private JTextField newUsername;

    public RedactAdminUsername() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Redact username");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        redactButton.addActionListener (e -> {
            CommandPattern.AdminCommandPattern.RedactAdminUsername redactAdminUsername = new CommandPattern.AdminCommandPattern.RedactAdminUsername (new AdministratorDAOImpl ());
            if(redactAdminUsername.execute (textField1.getText (), newUsername.getText ())){
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
