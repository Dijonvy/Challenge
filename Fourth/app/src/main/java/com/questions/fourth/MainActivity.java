package com.questions.fourth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.questions.fourth.Adapters.WordsAdapter;
import com.questions.fourth.Methods.WordTypos;
import com.questions.fourth.Methods.WordsWithJumbledLetters;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText textToSearch;
    Button searchButton;
    ListView wordsList;

    ArrayList<String> data;
    WordsAdapter adapter;
    WordsWithJumbledLetters isJumbled = new WordsWithJumbledLetters();
    WordTypos dontHasMoreThanOneTypo = new WordTypos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textToSearch = this.findViewById(R.id.searchField);
        this.searchButton = this.findViewById(R.id.searchButton);
        this.wordsList = this.findViewById(R.id.searchResults);

        data = new ArrayList<>(Arrays.asList(this.getResources().getStringArray(R.array.words)));
        adapter = new WordsAdapter(this, data);

        this.wordsList.setAdapter(adapter);
    }

    public void searchWord(View view) {
        String word = this.textToSearch.getText().toString();
        searchResults(word);
        adapter.notifyDataSetChanged();
    }

    public void searchResults(String word) {
        ArrayList<String> fullData = new ArrayList<>(Arrays.asList(this.getResources().getStringArray(R.array.words)));
        for(int i=0; i<fullData.size(); i++) {
            if(fullData.get(i).equals(word)) {
                if(!this.data.contains(word)) this.data.add(fullData.get(i));
            }else {
                boolean partialPermutation = isJumbled.isPartialPermutation(fullData.get(i),word);
                boolean typos = dontHasMoreThanOneTypo.isZeroOrOneTypoAway(fullData.get(i),word);
                if((partialPermutation && !typos) || (!partialPermutation && typos)) {
                    if(!this.data.contains(fullData.get(i))) this.data.add(fullData.get(i));
                }else {
                    if (this.data.contains(fullData.get(i))) this.data.remove(fullData.get(i));
                }
            }
        }
    }
}