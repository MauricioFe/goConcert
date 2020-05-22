package com.example.goconcert.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goconcert.R;

import java.util.List;

import model.Show;
import util.MoedaBrUtil;
import util.ResourceUtil;

public class ListaShowsAdapter extends BaseAdapter {

    private final List<Show> shows;
    private final Context context;

    public ListaShowsAdapter(List<Show> shows, Context context) {
        this.shows = shows;
        this.context = context;
    }

    @Override
    public int getCount() {
        return shows.size();
    }

    @Override
    public Object getItem(int position) {
        return shows.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_shows, parent, false);
        Show show = shows.get(position);
        mostraLocal(view, show);
        mostraData(view, show);
        mostraDiaHora(view, show);
        mostrarImagem(view, show);
        mostraPreco(view, show);
        mostraNome(view, show);

        return view;
    }

    private void mostraPreco(View view, Show show) {
        TextView preco = view.findViewById(R.id.shows_preco);
        String moedaBr = MoedaBrUtil.formaMoeda(show.getPreco());
        preco.setText(moedaBr);
    }

    private void mostrarImagem(View view, Show show) {
        ImageView imagem = view.findViewById(R.id.shows_imagem_banda);
        Drawable drawableImagemBanda = ResourceUtil.getDrawable(show.getImagem(), context);
        imagem.setImageDrawable(drawableImagemBanda);
    }

    private void mostraLocal(View view, Show show) {
        TextView local = view.findViewById(R.id.shows_local);
        local.setText(show.getLocal());
    }

    private void mostraData(View view, Show show) {
        TextView data = view.findViewById(R.id.shows_data);
        data.setText(show.getData());
    }

    private void mostraDiaHora(View view, Show show) {
        TextView diaHora = view.findViewById(R.id.shows_dia_hora);
        diaHora.setText(show.getDia());
    }

    private void mostraNome(View view, Show show) {
        TextView nome = view.findViewById(R.id.shows_nome_banda);
        nome.setText(show.getNome());
    }


}
