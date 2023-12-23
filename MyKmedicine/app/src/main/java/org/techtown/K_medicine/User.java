package org.techtown.K_medicine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class User extends AppCompatActivity {

        private TextView tv_result2;
        private EditText user_n;
        private Button userbtn;
        private SharedPreferences preferences;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user);

            tv_result2 = findViewById(R.id.tv_result2);
            user_n = findViewById(R.id.user_n);
            userbtn = (Button) findViewById(R.id.userbtn);

            preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

            userbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", user_n.getText().toString());
                    editor.commit();
                    getPreferences();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }


            private void getPreferences(){

                tv_result2.setText("USERN = " + preferences.getString("username",""));

            }
}
