package heap.n355DesignTwitter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

  private static final int FEED_SIZE = 10;
  private final Map<Integer, Set<Integer>> userFollowers;
  private final Map<Integer, PriorityQueue<Tweet>> feeds;
  private final Map<Integer, List<Tweet>> userTweets;

  private int sequence = 0;

  public Twitter() {
    userFollowers = new HashMap<>();
    feeds = new HashMap<>();
    userTweets = new HashMap<>();

  }

  public void postTweet(int userId, int tweetId) {
    trySelfFollow(userId);
    Tweet newTweet = new Tweet(userId, tweetId, ++sequence);
    // Update personal feeds
    List<Tweet> personalTweets = userTweets.get(userId);
    if (personalTweets == null) {
      personalTweets = new LinkedList<>();
      userTweets.put(userId, personalTweets);
    }
    personalTweets.add(newTweet);

    // Update self and followers feeds
    for (Integer followerId : userFollowers.get(userId)) {
      pushTweetToUserFeed(followerId, newTweet);
    }

  }

  public List<Integer> getNewsFeed(int userId) {
    trySelfFollow(userId);
    PriorityQueue<Tweet> userFeed = feeds.get(userId);
    if (userFeed == null || userFeed.isEmpty()) {
      return List.of();
    }

    List<Tweet> temp = new LinkedList<>();
    List<Integer> orderedTweetIds = new LinkedList<>();
    int count = 1;
    while (count <= FEED_SIZE && !userFeed.isEmpty()) {
      Tweet tweet = userFeed.poll();
      // Check if user still follower, if not than skip tweet
      if (userFollowers.get(tweet.userId).contains(userId)) {
        temp.add(tweet);
        orderedTweetIds.add(tweet.tweetId);
        count++;
      }
    }
    // Put back the tweets to user feed
    for (Tweet tweet : temp) {
      userFeed.offer(tweet);
    }
    return orderedTweetIds;
  }

  public void follow(int followerId, int followeeId) {
    Set<Integer> followers = userFollowers.get(followeeId);
    if (followers == null) {
      followers = new HashSet<>();
      userFollowers.put(followeeId, followers);
      followers.add(followeeId); // self follow
    }

    if (followers.contains(followerId)) {
      // do nothing if already following
      return;
    }
    followers.add(followerId);

    // Add all previous tweets to the new follower feed
    List<Tweet> foloweeTweets = userTweets.get(followeeId);
    if (foloweeTweets == null) {
      return;
    }

    for (Tweet oldFoloweeTweet : foloweeTweets) {
      pushTweetToUserFeed(followerId, oldFoloweeTweet);
    }

  }

  public void unfollow(int followerId, int followeeId) {
    Set<Integer> followers = userFollowers.get(followeeId);
    if (followers == null) {
      followers = new HashSet<>();
      userFollowers.put(followeeId, followers);
    }
    followers.remove(followerId);
  }

  private void trySelfFollow(int userId) {
    if (!userFollowers.containsKey(userId)) {
      follow(userId, userId);
    }
  }

  private void pushTweetToUserFeed(int userId, Tweet tweet) {
    PriorityQueue<Tweet> userFeed = feeds.get(userId);
    if (userFeed == null) {
      userFeed = new PriorityQueue<>( Comparator.comparing(Tweet::getSequenceId).reversed());
      feeds.put(userId, userFeed);
    }
    userFeed.offer(tweet);
  }

  private static class Tweet {

    int userId;
    int tweetId;
    int sequenceId;

    Tweet(int userId, int tweetId, int sequenceId) {
      this.userId = userId;
      this.tweetId = tweetId;
      this.sequenceId = sequenceId;

    }

    int getSequenceId() {
      return this.sequenceId;
    }
  }

}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
