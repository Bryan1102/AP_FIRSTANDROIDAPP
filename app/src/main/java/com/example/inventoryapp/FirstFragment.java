package com.example.inventoryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inventoryapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment
{

    private FragmentFirstBinding binding;
    private TextView showCountTextView;
    private int counter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    )
    {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        //showCountTextView = container.findViewById(R.id.textview_first);
        showCountTextView = binding.textviewFirst;
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonRnd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(counter);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);

                //NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment());
            }
        });
        binding.toastButton.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               Toast toast = Toast.makeText(getActivity(), "test", Toast.LENGTH_SHORT);
               toast.show();
           }

       });
        binding.buttonCount.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        CountMe(/*v*/);
                    }
                }
        );
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }

    private void CountMe(/*View v*/)
    {
        String current = showCountTextView.getText().toString();
        /*int count*/ counter = Integer.parseInt(current);
        //count++;
        counter++;
        showCountTextView.setText((/*count*/counter + ""));

    }

}