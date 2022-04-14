package com.scb.myapptest.home.ui.detail_oficina;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.scb.myapptest.databinding.DetalFragmentBinding;
import com.scb.myapptest.home.data.models.IndicacaoData;
import com.scb.myapptest.home.data.models.IndicacaoResponse;
import com.scb.myapptest.home.domain.models.IndicacaoEntity;
import com.scb.myapptest.home.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetalhesOficinaFragment extends Fragment {

    private DetalFragmentBinding binding;
    private MainViewModel mViewModel;

    public static DetalhesOficinaFragment newInstance() {
        return new DetalhesOficinaFragment();
    }

    String nome="";
    String descricao="";
    String tell="";
    String end="";
    TextView t_nome;
    TextView t_descricao;
    TextView t_tell;
    TextView t_end;
    Button btnIndicacao;
    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = DetalFragmentBinding.inflate(inflater,container,false);
        Bundle bundle = this.getArguments();
        if (bundle.getString("nome")!= null)
            nome = bundle.getString("nome");
        if (bundle.getString("descricao")!= null)
            descricao = bundle.getString("descricao");
        if (bundle.getString("tell")!= null)
            tell = bundle.getString("tell");
        if (bundle.getString("end")!= null)
            end = bundle.getString("end");
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    public void initView(){

        t_descricao = binding.txtDesc;
        t_nome = binding.txtNomeDetal;
        t_end = binding.txtEnd;
        t_tell = binding.txtTellDetal;
        btnIndicacao = binding.btnIndicar;
        progressBar = binding.progressBar;
        progressBar.setVisibility(View.GONE);
        t_nome.setText(nome);
        t_descricao.setText(descricao);
        t_tell.setText(tell);
        t_end.setText(end);

        btnIndicacao.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            IndicacaoData indicacaoData = new IndicacaoData();
            List<String> list = new ArrayList<String>();
            indicacaoData.setCopias(list);
            indicacaoData.setRemetente("teste@teste.com");
            IndicacaoEntity indicacaoEntity = new IndicacaoEntity();
            indicacaoEntity.setCodigoAssociacao("601");
            indicacaoEntity.setCpfAssociado("0000000000");
            indicacaoEntity.setDataCriacao("01-11-2022");
            indicacaoEntity.setEmailAmigo("amigo@g.com");
            indicacaoEntity.setEmailAssociado("assoc@g.com");
            indicacaoEntity.setNomeAmigo("NomeAmigo");
            indicacaoEntity.setNomeAssociado("NomeAssoc");
            indicacaoEntity.setPlacaVeiculoAssociado("Placa");
            indicacaoEntity.setTelefoneAmigo("Tell Amigo");
            indicacaoEntity.setTelefoneAssociado("Tell Assoc");
            indicacaoData.setIndicacaoEntity(indicacaoEntity);
            mViewModel.postIndicacao(indicacaoData);
            mViewModel.getIndicacaoEntity().observe(getActivity(), new Observer<IndicacaoResponse>() {
                @Override
                public void onChanged(IndicacaoResponse response) {
                    progressBar.setVisibility(View.GONE);

                    Log.i("RESPONSE","RESPONSE "+response.getRetornoErro().getRetornoErro());
                    Log.i("RESPONSE","RESPONSE "+response.getSucesso());
                    if (response != null){
                        if (response.getSucesso()==null)
                            Snackbar.make(getContext(),getView(),response.getRetornoErro().getRetornoErro(),BaseTransientBottomBar.LENGTH_LONG).show();
                        else
                            Snackbar.make(getContext(),getView(),"Indicação enviada!", BaseTransientBottomBar.LENGTH_LONG).show();
                  }else
                      Snackbar.make(getContext(),getView(),"Erro ao enviar indicação.",BaseTransientBottomBar.LENGTH_LONG).show();
                }
            });
        });

    }

}