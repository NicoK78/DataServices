package com.example.nico.dataservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity{

    ImageView geoloc;
    TextView title, city, content;

    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        geoloc = (ImageView) findViewById(R.id.geoloc);
        title = (TextView) findViewById(R.id.title);
        city = (TextView) findViewById(R.id.city);
        content = (TextView) findViewById(R.id.content);

        Bundle bundle = getIntent().getExtras();
        article = new Article(bundle.getInt("id"), bundle.getString("title"), bundle.getString("city"), bundle.getString("content"));

        title.setText(article.getTitle());
        city.setText(article.getCity());
        content.setText(article.getContent());
    }

}
