package GUI.Admin.Products.RedactProducts;

import CommandPattern.ProductsCommandPattern.RedactProductEmailCommand;
import DAO.ProductsDAOImpl;
import GUI.Admin.Admins.AdminMainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RedactProductTradeRepEmailGUI extends JFrame{
    private JPanel panel1;
    private JTextField username;
    private JButton executeButton;
    private JButton backButton;
    private JTextField email;

    public RedactProductTradeRepEmailGUI() {
        setVisible (true);
        setResizable (false);
        setSize (350, 300);
        add (panel1);
        setTitle ("Redact email");
        setLocationRelativeTo (null);
        addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
            }
        });
        executeButton.addActionListener (e -> {
            RedactProductEmailCommand redactProductEmailCommand = new RedactProductEmailCommand (new ProductsDAOImpl ());
            if(redactProductEmailCommand.execute (username.getText (), email.getText())){
                JOptionPane.showMessageDialog (new JPanel (), "Product has been redacted");
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
