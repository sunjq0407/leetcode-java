public class Twitter {
    
    private class User {
        int id;
        Set<User> follows;
        LinkedList<Tweet> tweets;
        public User(int id) {
            this.id = id;
            follows = new HashSet<>();
            follows.add(this);
            tweets = new LinkedList<>();
        }
    }
    
    private class Tweet {
        int id;
        int time;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    
    private static final int MAX_RETRIEVED_TWEETS_AMOUNT = 10;
    
    private Map<Integer, User> users;
    private int time;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        LinkedList<Tweet> tweets = users.get(userId).tweets;
        tweets.offer(new Tweet(tweetId, ++time));
        if(tweets.size() > MAX_RETRIEVED_TWEETS_AMOUNT) {
            tweets.poll();
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        
        // Same as merge K sorted array
        List<Integer> ret = new ArrayList<>();
        if(!users.containsKey(userId)) return ret;
        List<User> follows = new ArrayList<>(users.get(userId).follows);
        Map<Tweet, Integer> tweetIdxs = new HashMap<>();
        int[] idxs = new int[follows.size()];
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            follows.size(), (t1, t2) -> t2.time - t1.time);
        
        for(int i = 0; i < follows.size(); i++) {
            idxs[i] = follows.get(i).tweets.size() - 1;
            if(idxs[i] >= 0) {
                Tweet tweet = follows.get(i).tweets.get(idxs[i]);
                pq.offer(tweet);
                tweetIdxs.put(tweet, i);
            }
        }
        for(int i = 0; i < MAX_RETRIEVED_TWEETS_AMOUNT && !pq.isEmpty(); i++) {
            Tweet tweet = pq.poll();
            ret.add(tweet.id);
            int j = tweetIdxs.get(tweet);
            tweetIdxs.remove(tweet);
            if(idxs[j] > 0) {
                Tweet next = follows.get(j).tweets.get(--idxs[j]);
                pq.offer(next);
                tweetIdxs.put(next, j);
            }
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follows.add(users.get(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follows.remove(users.get(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */