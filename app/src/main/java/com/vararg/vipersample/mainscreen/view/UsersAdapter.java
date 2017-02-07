package com.vararg.vipersample.mainscreen.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vararg.vipersample.databinding.ListItemUserBinding;
import com.vararg.vipersample.mainscreen.domain.UserViewModel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by vararg on 27-01-17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private ArrayList<UserViewModel> users;

    public UsersAdapter() {
        this.users = new ArrayList<>();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(ListItemUserBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(Collection<UserViewModel> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private ListItemUserBinding binding;

        public UserViewHolder(ListItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UserViewModel model) {
            binding.setModel(model);
        }
    }
}
