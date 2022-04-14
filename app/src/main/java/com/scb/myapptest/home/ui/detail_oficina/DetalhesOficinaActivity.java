package com.scb.myapptest.home.ui.detail_oficina;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.scb.myapptest.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetalhesOficinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detal_activity);
        DetalhesOficinaFragment detalhesOficinaFragment = new DetalhesOficinaFragment();
        detalhesOficinaFragment.setArguments(getIntent().getExtras());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, detalhesOficinaFragment)
                    .commitNow();
        }

    }
}