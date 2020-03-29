package com.deepanshu.android.blogpra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    public static final String KEY_PHONE_NUMBER ="KEY_PHONE_NUMBER" ;
    TextView name1,password1,status;
    Button backbutton,showBlogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*setResult(Activity.RESULT_OK, createResultData("896-745-231"));
        finish();*/
        name1=findViewById(R.id.Name1);
        password1=findViewById(R.id.Password1);
        final Intent intent=getIntent();
        String name2=intent.getStringExtra("Name");
        String password2=intent.getStringExtra("Password");
        name1.setText(name2);
        password1.setText(password2);
        backbutton=findViewById(R.id.backbutton);
        showBlogs=findViewById(R.id.show_list);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"back button is press ",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        showBlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });

    }



}
