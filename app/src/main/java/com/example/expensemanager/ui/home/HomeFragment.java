package com.example.expensemanager.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.expensemanager.FriendsGroupActivity;
import com.example.expensemanager.OfficeGroupActivity;
import com.example.expensemanager.R;
import com.example.expensemanager.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set click listener for group_info_container
        binding.groupInfoContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the intent for friends_group.xml
                startActivity(new Intent(getContext(), FriendsGroupActivity.class));
            }
        });

        // Set click listener for group_info_container2
        binding.groupInfoContainer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the intent for office_group.xml
                startActivity(new Intent(getContext(), OfficeGroupActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
