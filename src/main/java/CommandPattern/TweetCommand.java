package CommandPattern;

import Twitter.TweetSender;
import twitter4j.TwitterException;

import javax.swing.*;

public class TweetCommand {
    private final TweetSender twitter;

    public TweetCommand(TweetSender twitter) {
        this.twitter = twitter;
    }
    public boolean execute(String post){
        try {
            if (twitter.createTweet (post)){
                return true;
            }
        }catch (TwitterException twitEx){
            twitEx.printStackTrace ();
            JOptionPane.showMessageDialog (new JPanel (), twitEx.getMessage ());
        }
        return false;
    }
}
