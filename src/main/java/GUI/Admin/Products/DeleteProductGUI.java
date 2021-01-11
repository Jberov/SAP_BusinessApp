package GUI.Admin.Products;


import CommandPattern.ProductsCommandPattern.DeleteProduct;

import DAO.ProductsDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteProductGUI extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton deleteProductButton;
    private JButton backButton;

    public DeleteProductGUI() {
        setTitle ("Delete product");
        setVisible (true);
        setResizable (false);
        setSize (300, 300);
        setLocationRelativeTo (null);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        deleteProductButton.addActionListener (e -> {
            DeleteProduct deleteProduct = new DeleteProduct (new ProductsDAOImpl ());
            if(deleteProduct.execute (textField1.getText ())){
                JOptionPane.showMessageDialog (new JPanel (), "Product has been deleted");
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
