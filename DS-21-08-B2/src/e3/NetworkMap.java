package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class NetworkMap implements NetworkManager {
    Map<String, List<TopicOfInterest>> map = new LinkedHashMap<>();

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if (map.containsKey(user))
            throw new IllegalArgumentException();
        else map.put(user, topicsOfInterest);
    }

    public void removeUser(String user) {
        if (map.containsKey(user))
            map.remove(user);
        else throw new IllegalArgumentException();
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        for (int i = 0; i < map.get(user).size(); i++) {
            if (topicOfInterest != map.get(user).get(i));
            else throw new IllegalArgumentException();
        }
        map.get(user).add(topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        for (int i = 0; i < map.get(user).size(); i++) {
            if (topicOfInterest == map.get(user).get(i))
                map.get(user).remove(topicOfInterest);
        }
    }

    public List<String> getUsers() {
        List<String> userAux = new ArrayList<>();
        for (Map.Entry<String, List<TopicOfInterest>> map : map.entrySet()) {
            userAux.add(map.getKey());
        }
        return userAux;
    }

    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> interestsAux = new ArrayList<>();
        for (Map.Entry<String, List<TopicOfInterest>> map : map.entrySet()) {
            for (int i = 0; i < map.getValue().size(); i++) {
                if (!interestsAux.contains(map.getValue().get(i)))
                    interestsAux.add(map.getValue().get(i));
            }
        }
        return interestsAux;
    }

    public List<TopicOfInterest> getInterestsUser(String user) {
        if (map.containsKey(user)) {
            return map.get(user);
        } else throw new IllegalArgumentException();
    }
}
