package GUI.Admin.Products;

import GUI.Admin.Admins.AdminMainPanel;
import GUI.Admin.Products.RedactProducts.RedactDirectoryPanelProducts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProductMaintenancePanel extends JFrame{
    private JPanel panel1;
    private JButton addNewProductButton;
    private JButton redactExistingProductButton;
    private JButton deleteProductButton;
    private JButton backButton;

    public ProductMaintenancePanel() {
        setTitle ("Product maintenance");
        setSize (400,300);
        setLocationRelativeTo (null);
        setResizable (false);
        add (panel1);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });
        addNewProductButton.addActionListener (e -> {
            ProductAddGUI productAddGUI = new ProductAddGUI ();
            productAddGUI.setVisible (true);
            setVisible (false);
            productAddGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        redactExistingProductButton.addActionListener (e -> {
            RedactDirectoryPanelProducts redactDirectoryPanelProducts = new RedactDirectoryPanelProducts ();
            redactDirectoryPanelProducts.setVisible (true);
            setVisible (false);
            redactDirectoryPanelProducts.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        deleteProductButton.addActionListener (e -> {
            DeleteProductGUI deleteProductGUI = new DeleteProductGUI ();
            deleteProductGUI.setVisible (true);
            setVisible (false);
            deleteProductGUI.addWindowListener (new WindowAdapter () {
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
