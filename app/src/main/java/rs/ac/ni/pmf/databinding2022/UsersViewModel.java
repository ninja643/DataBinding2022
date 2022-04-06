package rs.ac.ni.pmf.databinding2022;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import rs.ac.ni.pmf.databinding2022.model.User;
import rs.ac.ni.pmf.databinding2022.repository.UsersRepository;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<User>> _users;
    private final MutableLiveData<User> _selectedUser = new MutableLiveData<>();

    public LiveData<User> getSelectedUser() {
        return _selectedUser;
    }

    public void selectUser(final long id) {
        _selectedUser.setValue(UsersRepository.INSTANCE.findById(id));
    }

    public void deselectUser() {
        _selectedUser.setValue(null);
    }

    public LiveData<List<User>> getUsers() {
        if (_users == null) {
            _users = new MutableLiveData<>();
            loadUsers();
        }

        return _users;
    }

    private void loadUsers() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> _users.setValue(UsersRepository.INSTANCE.getUsers()), 100);
    }

    public void deleteUser(final long id) {
        if (_selectedUser.getValue() != null && _selectedUser.getValue().getId() == id)
        {
            deselectUser();
        }

        UsersRepository.INSTANCE.deleteById(id);
        _users.setValue(UsersRepository.INSTANCE.getUsers());
    }

    public void addUser(final User user) {
        UsersRepository.INSTANCE.addUser(user);
        _users.setValue(UsersRepository.INSTANCE.getUsers());
    }
}
