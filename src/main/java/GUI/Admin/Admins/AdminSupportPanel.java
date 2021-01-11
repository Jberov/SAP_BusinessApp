package GUI.Admin.Admins;

import GUI.Admin.Admins.Redact.RedactDirectoryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminSupportPanel extends JFrame{
    private JPanel panel1;
    private JButton addNewAdministratorButton;
    private JButton redactExistingAdministratorButton;
    private JButton deleteAdministratorButton;
    private JButton backButton;

    public AdminSupportPanel() {
        setTitle ("AdminSupport");
        setSize (400,300);
        setResizable (false);
        add (panel1);
        setLocationRelativeTo (null);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        addNewAdministratorButton.addActionListener (e -> {
        AdminAddGUI adminAddGUI= new AdminAddGUI ();
        adminAddGUI.setVisible (true);
        setVisible (false);
        adminAddGUI.addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        });
        redactExistingAdministratorButton.addActionListener (e -> {
            RedactDirectoryPanel redactDirectoryPanel = new RedactDirectoryPanel ();
            setVisible (false);
            redactDirectoryPanel.setVisible(true);
            redactDirectoryPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        deleteAdministratorButton.addActionListener (e -> {
        DeleteAdmin deleteAdmin = new DeleteAdmin ();
        deleteAdmin.setVisible (true);
        setVisible (false);
        deleteAdmin.addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        });
        backButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                 AdminMainPanel mainAdmin = new AdminMainPanel ();
                 mainAdmin.setVisible (true);
                 setVisible (false);
                 mainAdmin.addWindowListener (new WindowAdapter () {
                     @Override
                     public void windowClosing(WindowEvent e) {
                         super.windowClosing (e);
                         System.exit (0);
                     }
                 });
            }
        });
    }
}
