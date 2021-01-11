package GUI.TradeReps;

import CommandPattern.AddSale;
import DAO.SalesDAOImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.InputMismatchException;

public class Sales extends JFrame{
    private JTextField ProductName;
    private JTextField Username;
    private JTextField Quantity;
    private JTextField ClientName;
    private JButton executeButton;
    private JButton cancelButton;
    private JPanel Panel;

    public Sales() {
        setTitle ("Add sale");
        setResizable (false);
        setSize (400, 400);
        setLocationRelativeTo (null);
        add (Panel);
        executeButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale addSale = new AddSale (new SalesDAOImpl ());
                try {
                    if(addSale.execute (ProductName.getText (), ClientName.getText (), Integer.parseInt (Quantity.getText ()), Username.getText ())){
                        JOptionPane.showMessageDialog (new JPanel (), "Success");
                        TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                        tradeRepMainPanel.setVisible (true);
                        setVisible(false);
                        tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                super.windowClosing (e);
                                System.exit (0);
                            }
                        });
                    }else{
                        JOptionPane.showMessageDialog (new JPanel (), "Operation not successful!");
                    }
                }catch (InputMismatchException ime){
                    JOptionPane.showMessageDialog (new JPanel (), "Please, fill in the fields");

                }
            }
        });
        cancelButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                tradeRepMainPanel.setVisible (true);
                setVisible(false);
                tradeRepMainPanel.addWindowListener (new WindowAdapter () {
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
