package com.example.a5l4.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a5l4.R;
import com.example.a5l4.databinding.FragmentBoardBinding;
import com.example.a5l4.interFace.OnClickListener;
import com.example.a5l4.prefs.Prefs;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class BoardFragment extends Fragment implements OnClickListener {
    private FragmentBoardBinding binding;
    @Inject
    Prefs prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prefs.setCon(requireActivity());
        BoardAdaptor adaptor = new BoardAdaptor(this);
        ViewPager2 viewPager2 = view.findViewById(R.id.view_pager);
        viewPager2.setAdapter(adaptor);
        binding.dotsIndicator.setViewPager2(viewPager2);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();

                    }
                });
        binding.buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 3) {
                    binding.buttonSkip.setVisibility(View.INVISIBLE);
                } else {
                    binding.buttonSkip.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick();
            }
        });
    }

    private void close() {
        prefs.saveBoardState();
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigateUp();
    }

    @Override
    public void itemClick() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigateUp();
    }
}