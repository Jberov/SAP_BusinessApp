package GUI.Admin.Products;

import CommandPattern.ProductsCommandPattern.AddProductCommand;
import DAO.ProductsDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProductAddGUI extends JFrame{
    private JPanel panel1;
    private JTextField ProdName;
    private JTextField price;
    private JTextField quantity;
    private JTextField email;
    private JButton cancelButton;
    private JButton executeButton;

    public ProductAddGUI() {
        setVisible (true);
        setSize (500, 400);
        setTitle ("Add product");
        setResizable (false);
        add (panel1);
        setLocationRelativeTo (null);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            AddProductCommand addProductCommand = new AddProductCommand (new ProductsDAOImpl ());
            try {
                if (addProductCommand.execute (ProdName.getText (), Double.parseDouble (price.getText ()), Integer.parseInt (quantity.getText ()), email.getText ())) {
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
            }catch (NumberFormatException nfex){
                JOptionPane.showMessageDialog (new JPanel (), "Failure: use the '.' character for the decimal number");
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
