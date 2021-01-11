package GUI.Admin.Analysis;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnalysisDirectoryGUI extends JFrame{
    private JPanel panel1;
    private JButton analyzeByTrader;
    private JButton analyzeByProduct;
    private JButton AnalyseByTime;

    public AnalysisDirectoryGUI() {
        setTitle ("Analysis");
        setLocationRelativeTo (null);
        setVisible (true);
        add (panel1);
        setResizable (false);
        setSize (1100, 300);
        analyzeByTrader.addActionListener (e -> {
            AnalysisByTraderGUI analysisByTraderGUI = new AnalysisByTraderGUI ();
            setVisible (false);
            analysisByTraderGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);

                }
            });
        });
        analyzeByProduct.addActionListener (e -> {
            AnalysisByProductGUI analysisByProductGUI = new AnalysisByProductGUI ();
            setVisible (false);
            analysisByProductGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);

                }
            });
        });
        AnalyseByTime.addActionListener (e -> {
            AnalysisByTimetGUI analysisByTimetGUI = new AnalysisByTimetGUI ();
            setVisible (false);
            analysisByTimetGUI.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing (e);
                    System.exit (0);

                }
            });
        });

    }
}
