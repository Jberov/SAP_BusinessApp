package Twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.*;

public class TweetSender {
    private Twitter twitter = null;
    public TweetSender(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("") //API Key
                .setOAuthConsumerSecret("") //API secret
                .setOAuthAccessToken("") //Access token
                .setOAuthAccessTokenSecret("");//Access token secret
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
    public boolean createTweet(String post) throws TwitterException {
        if(twitter != null){
            twitter.updateStatus (post);
            return true;
        }else {
            JOptionPane.showMessageDialog (new JPanel (), "Tweet failed");
            throw new TwitterException ("You need to create TweetSender instance first");
        }
    }
}
