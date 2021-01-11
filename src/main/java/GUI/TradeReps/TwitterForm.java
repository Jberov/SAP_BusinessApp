package GUI.TradeReps;

import CommandPattern.TweetCommand;
import Twitter.TweetSender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TwitterForm extends JFrame{
    private JPanel panel;
    private JTextArea post;
    private JButton postToTwitterButton;
    private JButton cancelButton;

    public TwitterForm() {
        setTitle ("Twitter");
        setVisible (true);
        setSize (400, 300);
        setResizable (false);
        setLocationRelativeTo (null);
        add (panel);
        cancelButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible (false);
                TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing (e);
                        System.exit (0);
                    }
                });
            }
        });
        postToTwitterButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                TweetCommand tweetCommand = new TweetCommand (new TweetSender ());
                if(tweetCommand.execute (post.getText ())){
                    setVisible (false);
                    JOptionPane.showMessageDialog (new JPanel (), "Tweet posted");
                    TradeRepMainPanel tradeRepMainPanel = new TradeRepMainPanel ();
                    tradeRepMainPanel.addWindowListener (new WindowAdapter () {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing (e);
                            System.exit (0);
                        }
                    });
                }else{
                    JOptionPane.showMessageDialog (new JPanel (), "Tweet failed");
                }
            }
        });
    }
}
