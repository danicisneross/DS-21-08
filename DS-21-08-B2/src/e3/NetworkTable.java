package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NetworkTable implements NetworkManager {
    List<User> userList = new ArrayList<>();

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        User usuario = new User(user, topicsOfInterest);
        userList.add(usuario);
    }

    public void removeUser(String user) {
        for (int i = 0; i < userList.size(); i++)
            if (Objects.equals(userList.get(i).getUser(), user)) {
                userList.remove(i);
                break;
            }
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        for (User value : userList)
            if (Objects.equals(value.getUser(), user))
                value.topicList.add(topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        for (User value : userList)
            if (Objects.equals(value.getUser(), user))
                value.topicList.remove(topicOfInterest);
    }

    public List<String> getUsers() {
        List<String> userAux = new ArrayList<>();
        for (User user : userList) {
            userAux.add(user.getUser());
        }
        return userAux;
    }

    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> interestsAux = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            for (int j = 0; j < userList.get(i).topicList.size(); j++) {
                if (!interestsAux.contains(userList.get(i).topicList.get(j)))
                    interestsAux.add(userList.get(i).topicList.get(j));
            }
        }
        return interestsAux;
    }

    public List<TopicOfInterest> getInterestsUser(String user) {
        for (User value : userList)
            if (Objects.equals(value.getUser(), user))
                return value.topicList;
        return null;
    }
}
