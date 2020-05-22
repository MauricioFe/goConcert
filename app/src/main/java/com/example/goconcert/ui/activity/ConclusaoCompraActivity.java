package com.example.goconcert.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.goconcert.R;

import java.math.BigDecimal;

import model.Show;
import util.MoedaBrUtil;
import util.ResourceUtil;

public class ConclusaoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusao_compra);
        carregaShowRecebido();
    }

    private void carregaShowRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("show")) {
            final Show show = (Show) intent.getSerializableExtra("show");
            setTitle(show.getNome());
            carregaComponentes(show);
            configuraBotao();
        }
    }

    private void configuraBotao() {
        Button btnRealizarPagamento = findViewById(R.id.conclusao_compra_btnVoltarInicio);
        btnRealizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retViewHome();
            }
        });
    }

    private void retViewHome() {
        Intent intent = new Intent(ConclusaoCompraActivity.this, ListaShowsActivity.class);
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
        String moedaBr = "";
        TextView preco = findViewById(R.id.conclusao_compra_preco);
        moedaBr = MoedaBrUtil.formaMoeda(show.getPreco());
        preco.setText(moedaBr);
    }

    private void mostraImagem(Show show) {
        ImageView imagem = findViewById(R.id.conclusao_compra_imagem);
        Drawable drawable = ResourceUtil.getDrawable(show.getImagem(), this);
        imagem.setImageDrawable(drawable);
    }

    private void mostraDiaHora(Show show) {
        TextView dia = findViewById(R.id.conclusao_compra_data_hora);
        dia.setText(show.getDia());
    }

    private void mostraData(Show show) {
        TextView data = findViewById(R.id.conclusao_compra_data);
        data.setText(show.getData());
    }

    private void mostraLocal(Show show) {
        TextView local = findViewById(R.id.conclusao_compra_local);
        local.setText(show.getLocal());
    }

    private void mostraNome(Show show) {
        TextView nome = findViewById(R.id.conclusao_compra_banda);
        nome.setText(show.getNome());
    }
}
