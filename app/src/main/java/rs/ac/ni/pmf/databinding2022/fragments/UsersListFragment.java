package rs.ac.ni.pmf.databinding2022.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import rs.ac.ni.pmf.databinding2022.R;
import rs.ac.ni.pmf.databinding2022.UsersListAdapter;
import rs.ac.ni.pmf.databinding2022.UsersViewModel;
import rs.ac.ni.pmf.databinding2022.model.User;
import rs.ac.ni.pmf.databinding2022.repository.UsersRepository;

public class UsersListFragment extends ListFragment {

    public interface UserSelectionListener {
        void onUserSelected();
    }

    private UserSelectionListener _userSelectionListener;

    private UsersViewModel _usersViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        _userSelectionListener = (UserSelectionListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _usersViewModel = new ViewModelProvider(requireActivity()).get(UsersViewModel.class);
        _usersViewModel.getUsers()
                .observe(getViewLifecycleOwner(), users -> setListAdapter(new UsersListAdapter(requireActivity(), users)));

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        _usersViewModel.selectUser(id);
        _userSelectionListener.onUserSelected();
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        requireActivity().getMenuInflater().inflate(R.menu.list_context_menu, menu);

        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        if (info == null) {
            return;
        }

        final User user = UsersRepository.INSTANCE.findById(info.id);
        final MenuItem menuItem = menu.findItem(R.id.menu_delete_user);

        menuItem.setTitle("Delete user " + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_delete_user) {
            final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            _usersViewModel.deleteUser(info.id);

            return true;
        }

        return false;
    }
}
