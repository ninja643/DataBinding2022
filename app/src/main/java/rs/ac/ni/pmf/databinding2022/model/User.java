package rs.ac.ni.pmf.databinding2022.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import rs.ac.ni.pmf.databinding2022.BR;

public class User extends BaseObservable implements Parcelable {
    private static long COUNTER = 0;

    private final long id;
    private String firstName;
    private String lastName;
    private String username;
    private int age;
    private boolean registered;

    public User(String firstName, String lastName, String username, int age, boolean registered) {
        this.id = ++COUNTER;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.age = age;
        this.registered = registered;
    }

    protected User(Parcel in) {
        id = in.readLong();
        firstName = in.readString();
        lastName = in.readString();
        username = in.readString();
        age = in.readInt();
        registered = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public long getId() {
        return id;
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
        Log.i("LOGTAG", "Username changed from " + this.username + " to " + username);
        this.username = username;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", registered=" + registered +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(username);
        parcel.writeInt(age);
        parcel.writeByte((byte) (registered ? 1 : 0));
    }
}
