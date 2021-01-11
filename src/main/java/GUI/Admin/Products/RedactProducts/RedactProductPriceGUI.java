package GUI.Admin.Products.RedactProducts;


import CommandPattern.ProductsCommandPattern.RedactProductPriceCommand;
import DAO.ProductsDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactProductPriceGUI extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton redactButton;
    private JButton backButton;
    private JTextField newUsername;

    public RedactProductPriceGUI() {
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        setTitle ("Redact product price");
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        redactButton.addActionListener (e -> {
            try{
                RedactProductPriceCommand redactPrice = new RedactProductPriceCommand (new ProductsDAOImpl ());
                if (redactPrice.execute (textField1.getText (), Double.parseDouble (newUsername.getText ()))) {
                    JOptionPane.showMessageDialog (new JPanel (), "Price has been redacted");
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
            }catch (NumberFormatException nfex){
                JOptionPane.showMessageDialog (new JPanel (), "Use the '.' for the decimal point!");
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
