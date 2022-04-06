package rs.ac.ni.pmf.databinding2022.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import rs.ac.ni.pmf.databinding2022.R;
import rs.ac.ni.pmf.databinding2022.UsersViewModel;
import rs.ac.ni.pmf.databinding2022.databinding.UserDetailsFragmentBinding;

public class UserDetailsFragment extends Fragment {
    private UserDetailsFragmentBinding _binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        _binding = DataBindingUtil.inflate(inflater, R.layout.user_details_fragment, container, false);
        return _binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final UsersViewModel usersViewModel = new ViewModelProvider(requireActivity()).get(UsersViewModel.class);

        usersViewModel.getSelectedUser().observe(getViewLifecycleOwner(), user -> _binding.setUser(user));
    }
}
