package com.example.goconcert.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.goconcert.R;

import java.math.BigDecimal;

import model.Show;
import util.MoedaBrUtil;
import util.ResourceUtil;

public class ResumoShowActivity extends AppCompatActivity {
    BigDecimal precoBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_show);
        carregaShowRecebido();
    }

    private void carregaShowRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("show")) {
            final Show show = (Show) intent.getSerializableExtra("show");
            precoBase = show.getPreco();
            setTitle(show.getNome());
            carregaComponentes(show);
            configuraBotao(show);
            configuraRadioButton(show);
        }
    }

    private void configuraRadioButton(final Show show) {
        RadioGroup radio = findViewById(R.id.resumo_show_radio_group);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.resumo_show_radio_pista) {
                    mostraPreco(show);
                } else if (checkedId == R.id.resumo_show_radio_camarote) {
                    BigDecimal dobro = new BigDecimal("2");
                    BigDecimal valor = precoBase.multiply(dobro);
                    atualizaPreco(valor, show);
                }
            }
        });
    }

    private void configuraBotao(final Show show) {
        Button btnRealizarPagamento = findViewById(R.id.resumo_show_botao_realiza_pagamento);
        btnRealizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retViewPagamento(show);
            }
        });
    }

    private void retViewPagamento(Show show) {
        Intent intent = new Intent(ResumoShowActivity.this, PagamentoActivity.class);
        intent.putExtra("show", show);
        startActivity(intent);
    }

    private void carregaComponentes(Show show) {
        mostraNome(show);
        mostraLocal(show);
        mostraData(show);
        mostraDiaHora(show);
        mostraImagem(show);
        mostraPreco(show);
    }

    private void mostraPreco(Show show) {
        TextView preco = findViewById(R.id.resumo_show_preco);
        show.setPreco(precoBase);
        String moedaBr = MoedaBrUtil.formaMoeda(show.getPreco());
        preco.setText(moedaBr);
    }

    private void atualizaPreco(BigDecimal valor, Show show) {
        TextView preco = findViewById(R.id.resumo_show_preco);
        show.setPreco(valor);
        String moedaBr = MoedaBrUtil.formaMoeda(show.getPreco());
        preco.setText(moedaBr);
    }

    private void mostraImagem(Show show) {
        ImageView imagem = findViewById(R.id.resumo_show_imagem);
        Drawable drawable = ResourceUtil.getDrawable(show.getImagem(), this);
        imagem.setImageDrawable(drawable);
    }

    private void mostraDiaHora(Show show) {
        TextView dia = findViewById(R.id.resumo_show_dia_hora);
        dia.setText(show.getDia());
    }

    private void mostraData(Show show) {
        TextView data = findViewById(R.id.resumo_show_data);
        data.setText(show.getData());
    }

    private void mostraLocal(Show show) {
        TextView local = findViewById(R.id.resumo_show_local);
        local.setText(show.getLocal());
    }

    private void mostraNome(Show show) {
        TextView nome = findViewById(R.id.resumo_show_banda);
        nome.setText(show.getNome());
    }
}
