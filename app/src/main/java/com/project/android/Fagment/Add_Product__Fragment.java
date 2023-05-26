package com.project.android.Fagment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.android.R;


public class Add_Product__Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup viewGroup,@Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_add_product__,viewGroup,false);
    }




}