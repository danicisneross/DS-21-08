package e3;

import java.util.List;

public class Network {
    public NetworkManager network;
    public Network(NetworkManager impl) {
        this.network = impl;
    }

    void altaUsuario(String user, List<TopicOfInterest> topicsOfInterest) {
        network.addUser(user, topicsOfInterest);
    }

    void bajaUsuario(String user) {
        network.removeUser(user);
    }

    void altaInteres(String user, TopicOfInterest topicOfInterest) {
        network.addInterest(user, topicOfInterest);
    }

    void bajaInteres(String user, TopicOfInterest topicOfInterest) {
        network.removeInterest(user, topicOfInterest);
    }

    List<String> devolverUsuarios() {
        return network.getUsers();
    }

    List<TopicOfInterest> devolverIntereses() {
        return network.getInterests();
    }

    List<TopicOfInterest> devolverInteresesUsuario(String user) {
        return network.getInterestsUser(user);
    }
}
