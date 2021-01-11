package GUI.Admin.Admins.Redact;

import CommandPattern.AdminCommandPattern.RedactAdminNameCommand;
import DAO.AdministratorDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactAdminNameGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JTextField name;


    public RedactAdminNameGUI() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Redact Admin name");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactAdminNameCommand redactAdminName = new RedactAdminNameCommand (new AdministratorDAOImpl ());
            if(redactAdminName.execute (username.getText (), name.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Admin has been successfully redacted");
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
