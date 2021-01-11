package GUI.Admin.Admins;

import CommandPattern.AdminCommandPattern.AddAdmin;
import DAO.AdministratorDAOImpl;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminAddGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JPasswordField Password;
    private JTextField email;
    private JTextField name;
    private JButton cancelButton;
    private JButton executeButton;

    public AdminAddGUI() {
        setVisible (true);
        setSize (500, 400);
        setResizable (false);
        add (panel1);
        setLocationRelativeTo (null);
        setTitle ("Add admin");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (el -> {
            AddAdmin addAdmin = new AddAdmin (new AdministratorDAOImpl ());
            if(addAdmin.execute (username.getText (), email.getText (), String.valueOf (Password.getPassword ()), name.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Success");
                AdminMainPanel adminMainPanel = new AdminMainPanel ();
                adminMainPanel.setVisible (true);
                setVisible (false);
                adminMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }

        });
        cancelButton.addActionListener (e -> {
            AdminMainPanel adminMainPanel = new AdminMainPanel ();
            adminMainPanel.setVisible (true);
            setVisible (false);
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
