package com.example.tiarecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private ArrayList<String> wordList;
    private Context context;

    public WordListAdapter(ArrayList<String> wordList, Context context) {
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

        String word = wordList.get(position);
        holder.wordItemView.setText(word);

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView wordItemView;
        final WordListAdapter wordListAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter wordListAdapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.wordListAdapter = wordListAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int position = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = wordList.get(position);
            // Change the word in the mWordList.
            wordList.set(position, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            wordListAdapter.notifyDataSetChanged();
        }
    }
}
