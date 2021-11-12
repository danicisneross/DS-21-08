package e3;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String user;
    public List<TopicOfInterest> topicList;

    public User(String user, List<TopicOfInterest> topicList) {
        this.user = user;
        this.topicList = topicList;
    }

    public String getUser() {
        return user;
    }

    public List<TopicOfInterest> getTopicList() {
        return topicList;
    }
}
