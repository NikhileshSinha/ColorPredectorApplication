package com.nikhileshsinha.colorpredictorapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nikhileshsinha.colorpredictorapp.R;
import com.nikhileshsinha.colorpredictorapp.databinding.FragmentHomeBinding;
import com.nikhileshsinha.colorpredictorapp.ui.aboutDev.AboutDeveloper;

import java.util.Random;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button re = binding.button;
        Button bl = binding.button2;
        ImageView im = binding.imageView;
        TextView ans = binding.ans;

        char col[] = new char[]{'R','B'};

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int rNum = r.nextInt(col.length);
                char ch = col[rNum];
                if(ch=='R'){
                    im.setImageResource(R.drawable.solid_red);
                    ans.setText("You won");
                }
                else {
                    im.setImageResource(R.drawable.solid_blue);
                    ans.setText("You loose");
                }
            }
        });

        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int rNum = r.nextInt(col.length);
                char ch = col[rNum];
                if(ch=='B'){
                    im.setImageResource(R.drawable.solid_blue);
                    ans.setText("You won");
                }
                else {
                    im.setImageResource(R.drawable.solid_red);
                    ans.setText("You loose");
                }
            }
        });




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}