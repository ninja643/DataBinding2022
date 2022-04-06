package rs.ac.ni.pmf.databinding2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import java.util.List;

import rs.ac.ni.pmf.databinding2022.databinding.UserListElementBinding;

public class UsersListAdapter extends BaseAdapter {

    private final Context _context;
    private final List<User> _users;

    public UsersListAdapter(Context context, List<User> users) {
        _context = context;
        _users = users;
    }

    @Override
    public int getCount() {
        return _users.size();
    }

    @Override
    public Object getItem(int position) {
        return _users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final UserListElementBinding binding = DataBindingUtil.inflate(inflater, R.layout.user_list_element, parent, false);

        binding.setUser((User) getItem(position));

        return binding.getRoot();
    }
}
