package GUI.Admin.Admins.Redact;

import CommandPattern.AdminCommandPattern.RedactAdminEmailCommand;
import DAO.AdministratorDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactAdminEmailGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JTextField email;


    public RedactAdminEmailGUI() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        setTitle ("Redact email");
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactAdminEmailCommand redactAdminEmailCommand = new RedactAdminEmailCommand (new AdministratorDAOImpl ());
            if(redactAdminEmailCommand.execute (username.getText (), email.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Admin's email has been successfully redacted");
                setVisible (false);
                AdminMainPanel adminMainPanel = new AdminMainPanel ();
                adminMainPanel.setVisible (true);
                adminMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
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
                }
            });
        });
    }
}
