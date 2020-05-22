package com.example.goconcert.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.goconcert.R;

import java.math.BigDecimal;

import model.Show;
import util.MaskEditUtil;
import util.MoedaBrUtil;

public class PagamentoActivity extends AppCompatActivity {

    String precoAtualizado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        carregaShowRecebido();
        EditText editTextCartao = findViewById(R.id.pagamento_numero_cartao);
        editTextCartao.addTextChangedListener(MaskEditUtil.mask(editTextCartao, MaskEditUtil.FORMAT_CARTAO));
    }

    private void carregaShowRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("show")) {
            final Show show = (Show) intent.getSerializableExtra("show");
            setTitle(show.getNome());
            mostraPreco(show);
            configuraBotao(show);
            if (intent.hasExtra("precoAtualizado")) {
                this.precoAtualizado = intent.getStringExtra("precoAtualizado");
                atualizaPreco();
            }
        }
    }

    private void configuraBotao(final Show show) {
        Button btnRealizarPagamento = findViewById(R.id.pagamento_btnFinalizarCompra);
        btnRealizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retViewPagamento(show);
            }
        });
    }

    private void retViewPagamento(Show show) {
        Intent intent = new Intent(PagamentoActivity.this, ConclusaoCompraActivity.class);
        intent.putExtra("show", show);
        startActivity(intent);
    }

    private void mostraPreco(Show show) {
        String moedaBr = "";
        TextView preco = findViewById(R.id.pagamento_preco);
        moedaBr = MoedaBrUtil.formaMoeda(show.getPreco());
        preco.setText(moedaBr);
    }
    private void atualizaPreco() {
        TextView preco = findViewById(R.id.resumo_show_preco);
        preco.setText(precoAtualizado);
    }
}
