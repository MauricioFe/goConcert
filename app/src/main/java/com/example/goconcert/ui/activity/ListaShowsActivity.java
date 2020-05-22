package com.example.goconcert.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        final ListView listaShows = findViewById(R.id.lista_bandas);
        final List<Show> shows = new ShowDAO().lista();
        listaShows.setAdapter(new ListaShowsAdapter(shows, this));
    }
}
