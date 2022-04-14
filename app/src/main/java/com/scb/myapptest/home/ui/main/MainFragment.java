package com.scb.myapptest.home.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.scb.myapptest.databinding.MainFragmentBinding;
import com.scb.myapptest.home.domain.models.OficinaEntity;
import com.scb.myapptest.home.ui.adapters.AdapterList;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;
    RecyclerView listOficinas;
    ProgressBar progressBar;
    TextView errorTextView;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initView();
    }

    public void initView(){

        listOficinas = binding.list;
        progressBar = binding.progressBar;
        errorTextView = binding.textError;
        mViewModel.get();
        mViewModel.getListOficinas().observe(getActivity(), new Observer<List<OficinaEntity>>() {
            @Override
            public void onChanged(List<OficinaEntity> oficinaEntities) {
                if (oficinaEntities !=null){
                    if (oficinaEntities.size()>0) {

                        listOficinas.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        errorTextView.setVisibility(View.GONE);

                        listOficinas.setAdapter(new AdapterList(getActivity(), oficinaEntities));
                        listOficinas.setLayoutManager(new LinearLayoutManager(getContext()));

                    }
                }else
                {
                    listOficinas.setVisibility(View.GONE);
                    errorTextView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

}