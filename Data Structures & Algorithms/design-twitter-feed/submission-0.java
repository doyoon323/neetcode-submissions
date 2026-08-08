class Twitter {
    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private static int globalTime = 0;
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Tweet>> userTweets;

    public Twitter() {
        follows = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>())
                  .add(new Tweet(tweetId, globalTime++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        Set<Integer> myFollows = follows.getOrDefault(userId, new HashSet<>());
        myFollows.add(userId);

        for (int followeeId : myFollows) {
            List<Tweet> tweets = userTweets.get(followeeId);
            if (tweets != null) {
                for (Tweet t : tweets) {
                    maxHeap.offer(t);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll().id);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followerId);
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}