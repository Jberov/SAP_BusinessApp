
import GUI.Admin.Analysis.AnalysisByTimetGUI;
import GUI.Login.roleChooser;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        roleChooser role = new roleChooser();
        role.setVisible(true);
        role.setTitle ("Role");
        role.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
