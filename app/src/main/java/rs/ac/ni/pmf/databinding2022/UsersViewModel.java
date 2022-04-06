package rs.ac.ni.pmf.databinding2022;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<User>> _users;
    private final MutableLiveData<User> _selectedUser = new MutableLiveData<>();

    public LiveData<User> getSelectedUser() {
        return _selectedUser;
    }

    public void selectUser(final int id) {
        _selectedUser.setValue(UsersRepository.INSTANCE.getUser(id));
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
        handler.postDelayed(() -> _users.setValue(UsersRepository.INSTANCE.getUsers()), 5000);
    }


}
