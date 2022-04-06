package rs.ac.ni.pmf.databinding2022.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import rs.ac.ni.pmf.databinding2022.model.User;

public class UsersRepository {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("Tasa", "Petrović", null, 10, false),
            new User("Petar", "Petrović", "pera123", 20, false),
            new User("Mika", "Mikić", "mika123", 30, true)
    ));

    private UsersRepository() {
    }

    public static final UsersRepository INSTANCE = new UsersRepository();

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public User findById(long id) {
        for (final User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public int count() {
        return users.size();
    }

    public void deleteById(long id) {
        final Iterator<User> it = users.iterator();
        boolean found = false;
        while (it.hasNext() && !found) {
            final User user = it.next();
            if (user.getId() == id) {
                found = true;
                it.remove();
            }
        }
    }

    public void addUser(final User user) {
        users.add(user);
    }
}
