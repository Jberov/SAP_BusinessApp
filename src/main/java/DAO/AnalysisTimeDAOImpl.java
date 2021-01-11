package DAO;

import DatabaseUtility.DBConnectionHandler;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisTimeDAOImpl {

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }



    private Timestamp time;
    public boolean analyze(String startDate, String endDate, JTextPane text){
        Timestamp time = null;
        double totalPrice = 0.00, timePrice = 0.00;
        int counter1 =0, counter2=0;
        Pattern pattern = Pattern.compile ("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])");
        Matcher match = pattern.matcher (startDate);
        if(match.matches ()){
            match = pattern.matcher (endDate);
            if(match.matches ()) {
                try {
                    DBConnectionHandler database = DBConnectionHandler.getInstance ();
                    PreparedStatement statement = database.setDBConnection ().prepareStatement ("select TotalPrice from sales where TimeOfSale>=? and TimeOfSale<=?");
                    converter (startDate);
                    time = specialConverter (endDate);
                    statement.setTimestamp (1, getTime ());
                    statement.setTimestamp (2, time );
                    ResultSet result = statement.executeQuery ();
                    while(result.next ()){
                        timePrice+=result.getDouble ("TotalPrice");
                        counter1++;
                        System.out.println (timePrice);
                        System.out.println (counter1);
                    }
                    result = statement.executeQuery ("select TotalPrice from sales");
                    while(result.next ()){
                        totalPrice+=result.getDouble ("TotalPrice");
                        counter2++;
                        System.out.println (totalPrice);
                        System.out.println (counter2);
                    }
                    text.setText ("Sales from " + startDate + " to " + endDate + " are: " + timePrice + "lv\n" + "The percentage of the amount of these sales, compared to the amount of all sales, is " + (((double)counter1/(double)counter2)*100) + "%\n" + "The percentage of the revenue of the amount of these sales, compared to the revenue of all sales, is " + (timePrice/totalPrice)*100 + "%");
                    return true;
                }catch (SQLException sqle){
                  JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
                    sqle.printStackTrace ();
                    return false;
                }catch (NullPointerException nptr){
                    JOptionPane.showMessageDialog (new JPanel (), "Date error");
                    nptr.printStackTrace ();
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog (new JPanel (), "Invalid set end date. Please write as specified");
                return false;
            }

        }else{
            JOptionPane.showMessageDialog (new JPanel (), "Invalid set start date. Please write as specified");
            return false;
        }
    }
    private void converter(String builder){
        try {
            builder = builder + " 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            Date parsedTime = dateFormat.parse (builder);
            setTime (new Timestamp (parsedTime.getTime ()));
        }catch (ParseException prse){
            prse.printStackTrace ();
            JOptionPane.showMessageDialog (new JPanel (), "Error parsing date");
        }

    }
    private Timestamp specialConverter(String endDate){
        SimpleDateFormat dateFormat;
        Timestamp timestamp = null;
        try {
            endDate = endDate + " 23:59:59";
            dateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            Date parsedTime2 = dateFormat.parse (endDate);
            timestamp = new Timestamp (parsedTime2.getTime ());
        }catch (ParseException prse){
            prse.printStackTrace ();
            JOptionPane.showMessageDialog (new JPanel (), "Error parsing date");
        }
        return timestamp;
    }
}
