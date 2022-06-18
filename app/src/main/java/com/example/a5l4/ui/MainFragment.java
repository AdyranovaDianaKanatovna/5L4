package com.example.a5l4.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a5l4.R;
import com.example.a5l4.databinding.FragmentMainBinding;
import com.example.a5l4.viewModel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    NavController navController;
    MainViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        navController = NavHostFragment.findNavController(this);
    }

    private void initClickers() {
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLoveApi();
            }
        });
    }
    private void getDataFromLoveApi() {
        String firstName = binding.EditOne.getText().toString();
        String secondName = binding.EditTwo.getText().toString();
        viewModel.getLoveModelLiveData(firstName, secondName).observe(this, model -> {
            binding.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("1", model.percentage);
                    bundle.putString("2", model.firstName);
                    bundle.putString("3", model.secondName);
                    bundle.putString("4", model.result);
                    Log.e("ololo", "OnResponse " + model.percentage);
                    navController.navigate(R.id.secondFragment, bundle);
                }
            });
        });
    }
}