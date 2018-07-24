package com.questions.fourth.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.questions.fourth.R;
import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter<String> {

    public WordsAdapter(Context context, ArrayList<String> words) {
        super(context,0, words);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String currentWord = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.words_list_element,parent,false);
        }

        TextView word = convertView.findViewById(R.id.word);

        word.setText(currentWord);

        return convertView;
    }
}
