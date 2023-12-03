package com.example.inventoryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inventoryapp.databinding.FragmentSecondBinding;

import java.util.Random;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        int counter = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        String countText = getString(R.string.lorem_ipsum, counter);
        TextView headerView = view.getRootView().findViewById(R.id.textview_second);
        headerView.setText(countText);


        Random random = new java.util.Random();
        Integer randomNumber = 0;
        if (counter > 0)
        {
            randomNumber = random.nextInt(counter + 1);
        }

        TextView randomView = view.getRootView().findViewById(R.id.textView_random);
        randomView.setText(randomNumber.toString());

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}