package com.example.a5l4.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a5l4.R;
import com.example.a5l4.databinding.FragmentSecondBinding;
import com.example.a5l4.network.LoveModel;


public class SecondFragment extends Fragment {
    FragmentSecondBinding binding;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String percentage = getArguments().getString("1");
        binding.result.setText(percentage);
        String firstname = getArguments().getString("2");
        binding.hisName.setText(firstname);
        String secondName = getArguments().getString("3");
        binding.herName.setText(secondName);
        String desc = getArguments().getString("4");
        binding.desc.setText(desc);
        navController = NavHostFragment.findNavController(this);
        binding.btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });
    }

}