package rs.ac.ni.pmf.databinding2022;

import java.util.Arrays;
import java.util.List;

public class UsersRepository {
    private List<User> users = Arrays.asList(
            new User("Tasa", "Petrović", null, 10, false),
            new User("Petar", "Petrović", "pera123", 20, false),
            new User("Mika", "Mikić", "mika123", 30, true)
    );

    private UsersRepository() {
    }

    public static final UsersRepository INSTANCE = new UsersRepository();

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public int count() {
        return users.size();
    }
}
