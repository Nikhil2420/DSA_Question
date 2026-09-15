package Design;

import java.util.*;
import java.util.stream.Collectors;

public class DesignTwitter {


    Map<Integer, List<Tweet>> userTweetIdList;
    Map<Integer, List<Integer>> userFollowedList;
    private int time = 0;

    public DesignTwitter() {
        userTweetIdList = new HashMap<>();
        userFollowedList = new HashMap<>();

    }

    public void postTweet(int userId, int tweetId) {
        time++;
        if (!userTweetIdList.containsKey(userId)) {
            userTweetIdList.put(userId, new ArrayList<>());
        }
        userTweetIdList.get(userId).add(new Tweet(tweetId, time));
    }

    /*
            collect(Collectors.toList())->modifiable list
            toList() provide unmodifiable list
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> tweetList = userTweetIdList.getOrDefault(userId, new ArrayList<>());
        List<Integer> userFollowsList = userFollowedList.getOrDefault(userId, new ArrayList<>());

        List<List<Tweet>> userFollowsTweetList = userFollowsList.stream()
                .map(elem -> {
                    return userTweetIdList.getOrDefault(elem, new ArrayList<>());
                })
                .collect(Collectors.toCollection(ArrayList::new));
        userFollowsTweetList.add(tweetList);
        List<Tweet> result = userFollowsTweetList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Collections.sort(result, (a, b) -> b.time - a.time);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < result.size() && i < 10; i++) {
            ans.add(result.get(i).tweetId);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!userFollowedList.containsKey(followerId)) {
            userFollowedList.put(followerId, new ArrayList<>());
        }


        if (!userFollowedList.get(followerId).contains(followeeId)) {
            userFollowedList.get(followerId).add(followeeId);
        }

    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowedList.containsKey(followerId)) {
            userFollowedList.get(followerId).remove(followeeId);
        }
    }

}