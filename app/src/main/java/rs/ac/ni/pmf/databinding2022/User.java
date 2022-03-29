package rs.ac.ni.pmf.databinding2022;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private int age;
    private boolean registered;

    public User(String firstName, String lastName, String username, int age, boolean registered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.age = age;
        this.registered = registered;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
