package DAO;

import DatabaseUtility.DBConnectionHandler;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class AnalysisTraderDAOImpl implements AnalysisTraderDAOInterface{
    public String getTrader() {
        return Trader;
    }

    public void setTrader(String trader) {
        Trader = trader;
    }

    String Trader;
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    @Override
    public boolean analyze(String trader, JTextPane result) {
        try {
            if(!usernameChecker (trader)){
                return false;
            }
            double traderProfit= 0.00, totalProfit = 0.00;
            int counterTrader = 0, counter =0;
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select TotalPrice from Sales where TradeRepID=?");
            PreparedStatement auxiliaryStatement = database.setDBConnection ().prepareStatement ("select TradeRepID from tradereps where Username=?");
            auxiliaryStatement.setString (1, getTrader ());
            ResultSet rs = auxiliaryStatement.executeQuery ();
            rs.next ();
            statement.setLong (1,rs.getLong ("TradeRepID"));
            rs = statement.executeQuery ();
            while(rs.next ()){
                traderProfit += rs.getDouble ("TotalPrice");
                counterTrader++;
            }
            statement=database.setDBConnection ().prepareStatement ("select TotalPrice from Sales");
            rs = statement.executeQuery ();
            while(rs.next ()){
                totalProfit += rs.getDouble ("TotalPrice");
                counter++;
            }
            result.setText ("TradeRep " + getTrader () + " ha sold products for the total amount of: " + traderProfit + " lv.\n" + "The percentage of the profit of the sales of the TradeRep " + getTrader () + " compared to all sales is " + (traderProfit/totalProfit)*100 + "%\nThe total ratio of the trader sales to all sales is: " + ((double)counterTrader/(double)counter)*100 + "%.");
            database.shutDB ();
            return true;
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            sqle.printStackTrace ();
            return false;
        }catch (InputMismatchException ime){
            JOptionPane.showMessageDialog (new JPanel (), "Use valid symbols");
            ime.printStackTrace ();
            return false;
        }catch (NullPointerException nptr){
            JOptionPane.showMessageDialog (new JPanel (), "No results");
            nptr.printStackTrace ();
            return false;
        }
        catch (Exception E){
            E.printStackTrace ();
            return false;
        }
    }
    private boolean usernameChecker(String trader){
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
                result.setString (1, trader);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    JOptionPane.showMessageDialog (new JPanel (), "No such Trade representative");
                    return false;
                }
                else if (trader.equals (rs.getString ("Username"))) {
                    JOptionPane.showMessageDialog (new JPanel (), "Trade Representative found");
                    setTrader (trader);
                    return true;
                }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            SQLEx.printStackTrace ();
            return false;
        }
        return false;
    }
}
