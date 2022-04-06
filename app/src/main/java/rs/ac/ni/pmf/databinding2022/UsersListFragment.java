package rs.ac.ni.pmf.databinding2022;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

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
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        _usersViewModel.selectUser((int) id);
        _userSelectionListener.onUserSelected();
    }
}
