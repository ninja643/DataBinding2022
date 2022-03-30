package rs.ac.ni.pmf.databinding2022;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import rs.ac.ni.pmf.databinding2022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements UsersHandler {

    private ActivityMainBinding _binding;

    private UsersRepository _usersRepository = UsersRepository.INSTANCE;
    private int _currentUser = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        _binding.setUser(_usersRepository.getUser(_currentUser));
        _binding.setUsers(_usersRepository.getUsers());
        _binding.setHandlers(this);
    }

    @Override
    public void nextUser() {

        if (_currentUser < _usersRepository.count() - 1) {
            _currentUser++;
            _binding.setUser(_usersRepository.getUser(_currentUser));
        }
    }

    @Override
    public void previousUser() {
        if (_currentUser > 0) {
            _currentUser--;
            _binding.setUser(_usersRepository.getUser(_currentUser));
        }
    }

    @Override
    public void toastValue(Object value) {
        Toast.makeText(this, "Value: " + String.valueOf(value), Toast.LENGTH_LONG).show();
    }
}