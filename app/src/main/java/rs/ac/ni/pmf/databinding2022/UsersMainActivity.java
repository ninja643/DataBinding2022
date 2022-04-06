package rs.ac.ni.pmf.databinding2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class UsersMainActivity extends AppCompatActivity implements UsersListFragment.UserSelectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_main);
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
}