package GUI.Admin.Products.RedactProducts;

import CommandPattern.ProductsCommandPattern.RedactProductNameCommand;
import DAO.ProductsDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactProductNameGUI extends JFrame{
    private JPanel panel1;
    private JTextField oldName;
    private JButton executeButton;
    private JButton backButton;
    private JTextField newName;


    public RedactProductNameGUI() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Redact Product name");
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactProductNameCommand redactProductNameCommandName = new RedactProductNameCommand (new ProductsDAOImpl ());
            if(redactProductNameCommandName.execute (oldName.getText (), newName.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Product has been successfully redacted");
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
