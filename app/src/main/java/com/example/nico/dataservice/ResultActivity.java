package com.example.nico.dataservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import okhttp3.Request;
import okhttp3.Response;


public class ResultActivity extends AppCompatActivity{

    private ListView lvArticles;
    ArrayList<Article> articles;
    private static ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lvArticles = (ListView) findViewById(R.id.lvArticles);



        articles = new ArrayList<>();
        articles.add(new Article(0, "Titre 0", "Paris 0", "Contenu 0"));
        articles.add(new Article(0, "Titre 1", "Paris 1", "Contenu 1"));
        articles.add(new Article(0, "Titre 2", "Paris 2", "Contenu 2"));
        articles.add(new Article(0, "Titre 3", "Paris 3", "Contenu 3"));
        articles.add(new Article(0, "Titre 4", "Paris 4", "Contenu 4"));
        articles.add(new Article(0, "Titre 5", "Paris 5", "Contenu 5"));
        articles.add(new Article(0, "Titre 6", "Paris 6", "Contenu 6"));
        articles.add(new Article(0, "Titre 7", "Paris 7", "Contenu 7"));
        articles.add(new Article(0, "Titre 8", "Paris 8", "Contenu 8"));
        articles.add(new Article(0, "Titre 9", "Paris 9", "Contenu 9"));

        adapter= new ArticleAdapter(articles,getApplicationContext());

        lvArticles.setAdapter(adapter);
        lvArticles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Article article = articles.get(position);

                Intent intent = new Intent(ResultActivity.this, ArticleActivity.class);
                intent.putExtra("title", article.getTitle());
                intent.putExtra("city", article.getCity());
                intent.putExtra("content", article.getContent());
                intent.putExtra("id", article.getId());
                startActivity(intent);
//                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }

}
