package com.sogou.sgmar.mycontentprovidertest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.book_store_query);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookStoreQuery();
            }
        });
    }

    void bookStoreQuery() {
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.sogou.sgmar.contentprovider/book"),
                null, null, null, null, null);

        if (cursor == null) {
            Toast.makeText(this, "content query failed!", Toast.LENGTH_SHORT).show();
            return;
        }

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String author = cursor.getString(cursor.getColumnIndex("author"));
            Log.e("baiwenlei", name+" "+author);
        }
    }
}
