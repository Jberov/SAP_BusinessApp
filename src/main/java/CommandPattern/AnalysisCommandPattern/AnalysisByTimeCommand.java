package CommandPattern.AnalysisCommandPattern;


import DAO.AnalysisTimeDAOImpl;

import javax.swing.*;

public class AnalysisByTimeCommand {
        private final AnalysisTimeDAOImpl time;

        public AnalysisByTimeCommand(AnalysisTimeDAOImpl time) {
            this.time = time;
        }

        public boolean execute(String startDate, String endDate, JTextPane text) {
            return time.analyze (startDate, endDate, text);
        }
}
