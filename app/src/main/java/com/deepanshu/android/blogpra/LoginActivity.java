package com.deepanshu.android.blogpra;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton, callNO, callIntent;
    private TextView name, password, status;
    public static final int REQUEST_CODE_PICK =16 ;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        name = findViewById(R.id.Name);
        password = findViewById(R.id.Password);
        loginButton = findViewById(R.id.Login);
        status = findViewById(R.id.status);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String password1 = password.getText().toString();
                if (name1.equals("deepanshu") && password1.equals("deepanshu")) {
                    status.setText("successfull login");
                    Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                    intent.putExtra("Name", name1);
                    intent.putExtra("Password", password1);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"unsuccessfull login",Toast.LENGTH_LONG).show();
                    status.setText("unSuccessfull login");
                }

            }

        });
        /*callIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String password1 = password.getText().toString();
                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                intent.putExtra("Name", name1);
                intent.putExtra("Password", password1);
                startActivity(intent);

            }
        });*/

    }

}
