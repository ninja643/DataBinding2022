package rs.ac.ni.pmf.databinding2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import rs.ac.ni.pmf.databinding2022.fragments.UserDetailsFragment;
import rs.ac.ni.pmf.databinding2022.fragments.UsersListFragment;
import rs.ac.ni.pmf.databinding2022.model.User;

public class UsersMainActivity extends AppCompatActivity implements UsersListFragment.UserSelectionListener {

    private UsersViewModel _usersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_main);

        _usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
    }

    @Override
    public void onUserSelected() {
        if (findViewById(R.id.portrait_fragment_container) != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.portrait_fragment_container, UserDetailsFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.users_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_add_user) {
            final User user = new User("Marko", "Milosevic", "markom", 40, true);

            _usersViewModel.addUser(user);
        }

        return super.onOptionsItemSelected(item);
    }
}