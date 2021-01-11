package GUI.Admin.Products.RedactProducts;

import CommandPattern.ProductsCommandPattern.RedactProductQuantityCommand;
import DAO.ProductsDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactProductQuantityGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JTextField quantity;


    public RedactProductQuantityGUI() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Redact product quantity");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        executeButton.addActionListener (e -> {
            RedactProductQuantityCommand redactProductQuantityCommand = new RedactProductQuantityCommand (new ProductsDAOImpl ());
            if(redactProductQuantityCommand.execute (username.getText (), Integer.parseInt (quantity.getText ()))){
                JOptionPane.showMessageDialog (new JPanel (), "Product quantity has been successfully redacted");
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
