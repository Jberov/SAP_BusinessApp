package GUI.Admin.Admins;

import CommandPattern.AdminCommandPattern.RemoveAdmin;
import DAO.AdministratorDAOImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteAdmin extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton deleteProductButton;
    private JButton backButton;
    private JTextPane textPane1;

    public DeleteAdmin() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Delete admin");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        deleteProductButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveAdmin delete = new RemoveAdmin (new AdministratorDAOImpl ());
                if(delete.execute (username.getText ())){
                    JOptionPane.showMessageDialog (new JPanel (), "Admin has been deleted");
                    setVisible (false);
                    AdminMainPanel adminMainPanel = new AdminMainPanel ();
                    adminMainPanel.addWindowListener (new WindowAdapter () {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing (e);
                            System.exit (0);
                        }
                    });
                }
            }
        });
        backButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMainPanel adminMainPanel = new AdminMainPanel ();
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
    }
}
