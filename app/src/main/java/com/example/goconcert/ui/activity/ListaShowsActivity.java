package com.example.goconcert.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.goconcert.R;
import com.example.goconcert.ui.adapter.ListaShowsAdapter;

import java.util.List;

import DAO.ShowDAO;
import model.Show;

public class ListaShowsActivity extends AppCompatActivity {

    public static final String TITULOAPPBAR = "Shows para você conferir!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_shows);
        setTitle(TITULOAPPBAR);
        configuraLista();
    }

    private void configuraLista() {
        final ListView listaShows = findViewById(R.id.lista_bandas);
        final List<Show> shows = new ShowDAO().lista();
        listaShows.setAdapter(new ListaShowsAdapter(shows, this));
        retViewResumoShow(listaShows, shows);
    }

    private void retViewResumoShow(ListView listaShows, final List<Show> shows) {
        listaShows.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Show showClicado = shows.get(position);
                Intent intent = new Intent(ListaShowsActivity.this, ResumoShowActivity.class);
                intent.putExtra("show", showClicado);
                startActivity(intent);
            }
        });
    }
}
