package com.example.expensemanager.ui.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.expensemanager.databinding.ProfilePageBinding;

public class ProfilePageFragment extends Fragment {

    private ProfilePageBinding binding;
    private TextView fullNameView;
    private TextView birthDateView;
    private TextView emailView;
    private TextView phoneView;
    private TextView addressView;
    private TextView cityView;
    private TextView countryView;
    private TextView aboutView;
    private LinearLayout personalView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel slideshowViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = ProfilePageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        fullNameView = binding.fullname;
        birthDateView = binding.birthdate;
        emailView = binding.email;
        cityView = binding.city;
        countryView = binding.country;
        phoneView = binding.phone;
        addressView = binding.address;
        aboutView = binding.address;
        personalView = binding.personal;


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}