package com.appin.javaexamples;

import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class AndroidMediaStoreEx extends AppCompatActivity {
    Button createAndWriteButton,findAndReadButton,findAndWriteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_media_store_ex);
        createAndWriteButton=findViewById(R.id.button);
        findAndReadButton=findViewById(R.id.button2);
        findAndWriteButton=findViewById(R.id.button3);
        createAndWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ContentValues values = new ContentValues();

                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, "menuCategory");       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "text/plain");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + "/Kamen Rider Decade/");     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write("This is menu category data.".getBytes());

                    outputStream.close();

                    Toast.makeText(getApplicationContext(), "File created successfully", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Fail to create file", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findAndReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri contentUri = MediaStore.Files.getContentUri("external");

                String selection = MediaStore.MediaColumns.RELATIVE_PATH + "=?";

                String[] selectionArgs = new String[]{Environment.DIRECTORY_DOCUMENTS + "/Kamen Rider Decade/"};

                Cursor cursor = getContentResolver().query(contentUri, null, selection, selectionArgs, null);

                Uri uri = null;

                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No file found in \"" + Environment.DIRECTORY_DOCUMENTS + "/Kamen Rider Decade/\"", Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext()) {
                        String fileName = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME));

                        if (fileName.equals("menuCategory.txt")) {
                            long id = cursor.getLong(cursor.getColumnIndex(MediaStore.MediaColumns._ID));

                            uri = ContentUris.withAppendedId(contentUri, id);

                            break;
                        }
                    }

                    if (uri == null) {
                        Toast.makeText(getApplicationContext(), "\"menuCategory.txt\" not found", Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uri);

                            int size = inputStream.available();

                            byte[] bytes = new byte[size];

                            inputStream.read(bytes);

                            inputStream.close();

                            String jsonString = new String(bytes, StandardCharsets.UTF_8);

                            /*AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

                            builder.setTitle("File Content");
                            builder.setMessage(jsonString);
                            builder.setPositiveButton("OK", null);

                            builder.create().show()*/;
                            Toast.makeText(AndroidMediaStoreEx.this, "File Content "+jsonString, Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(), "Fail to read file", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        findAndWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri contentUri = MediaStore.Files.getContentUri("external");

                String selection = MediaStore.MediaColumns.RELATIVE_PATH + "=?";

                String[] selectionArgs = new String[]{Environment.DIRECTORY_DOCUMENTS + "/Kamen Rider Decade/"};    //must include "/" in front and end

                Cursor cursor = getContentResolver().query(contentUri, null, selection, selectionArgs, null);

                Uri uri = null;

                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No file found in \"" + Environment.DIRECTORY_DOCUMENTS + "/Kamen Rider Decade/\"", Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext()) {
                        String fileName = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME));

                        if (fileName.equals("menuCategory.txt")) {                          //must include extension
                            long id = cursor.getLong(cursor.getColumnIndex(MediaStore.MediaColumns._ID));

                            uri = ContentUris.withAppendedId(contentUri, id);

                            break;
                        }
                    }

                    if (uri == null) {
                        Toast.makeText(getApplicationContext(), "\"menuCategory.txt\" not found", Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            OutputStream outputStream = getContentResolver().openOutputStream(uri, "rwt");      //overwrite mode, see below

                            outputStream.write("This is overwritten data。\n你就不要想起我。".getBytes());

                            outputStream.close();

                            Toast.makeText(getApplicationContext(), "File written successfully", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(), "Fail to write file", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}