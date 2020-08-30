package com.example.tiarecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private ArrayList<Word> wordList;
    private Context context;

    public WordListAdapter(ArrayList<Word> wordList, Context context) {
        this.wordList = wordList;
        this.context = context;
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.wordlist_item, parent, false);

        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        Word mword = wordList.get(position);
        holder.word.setText(mword.getNome());

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView word;
        private ImageView ivFavoritado;

        final WordListAdapter wordListAdapter;

    public WordViewHolder(@NonNull View itemView, WordListAdapter wordListAdapter) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
            ivFavoritado = itemView.findViewById(R.id.ivFavoritado);


            ivFavoritado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Favorito clicado!!!", Toast.LENGTH_SHORT).show();
                }
            });

            this.wordListAdapter = wordListAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

                // Get the position of the item that was clicked.
                int position = getLayoutPosition();

                // Obtém o atributo "name" da classe Word, na posição capturada pela instrução anterior.
                String word = wordList.get(position).getNome();

                // Change the word in the mWordList.
                wordList.set(position, new Word("Clicado em " +word +", que está na posição " +position));


                // Notify the adapter, that the data has changed so it can
                // update the RecyclerView to display the data.
                wordListAdapter.notifyDataSetChanged();

            Toast.makeText(context, "Linha do Recyclerview Clicada!!!", Toast.LENGTH_LONG).show();

            }

    }
}
