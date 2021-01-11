package GUI.Admin.Admins;

import GUI.Admin.Analysis.AnalysisDirectoryGUI;
import GUI.Admin.Products.ProductMaintenancePanel;
import GUI.Admin.Traders.TradeRepSupportPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminMainPanel extends JFrame{
    private JPanel panel1;
    private JButton TradeRepSupport;
    private JButton AdminSupport;
    private JButton ProductMaintenance;
    private JButton analyzeSalesButton;

    public AdminMainPanel() {
        setVisible (true);
        setSize (1200,400);
        setLocationRelativeTo (null);
        add (panel1);
        setTitle ("Main panel admin");
        AdminSupport.addActionListener (e -> {
        AdminSupportPanel adminSupport = new AdminSupportPanel ();
        adminSupport.setVisible (true);
        setVisible (false);
        adminSupport.addWindowListener (new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing (e);
                System.exit (0);
            }
        });

        });
        TradeRepSupport.addActionListener (e -> {
            TradeRepSupportPanel traders = new TradeRepSupportPanel ();
            traders.setVisible (true);
            setVisible (false);
            traders.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });

        });
        ProductMaintenance.addActionListener (e -> {
            ProductMaintenancePanel productsPanel = new ProductMaintenancePanel ();
            productsPanel.setVisible (true);
            setVisible (false);
            productsPanel.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
        });
        analyzeSalesButton.addActionListener (e -> {
            AnalysisDirectoryGUI analysisDirectoryGUI = new AnalysisDirectoryGUI ();
            analysisDirectoryGUI.setLocationRelativeTo (null);
            analysisDirectoryGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);
                }
            });
            setVisible (false);
        });

    }
}
