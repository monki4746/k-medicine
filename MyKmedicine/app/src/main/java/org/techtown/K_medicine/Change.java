package org.techtown.K_medicine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Change extends AppCompatActivity {
    private TextView tv_result;
    private EditText o_user, c_user;
    private Button btn_save;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_main);

        tv_result = findViewById(R.id.tv_result);
        o_user = findViewById(R.id.o_user);
        c_user = findViewById(R.id.c_user);
        btn_save = findViewById(R.id.btn_save);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("ouser", o_user.getText().toString());
                editor.putString("cuser", c_user.getText().toString());
                editor.commit();
                getPreferences();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

        private void getPreferences(){

            tv_result.setText("OUSER = " + preferences.getString("ouser", "")
                    + "-> CUSER = " + preferences.getString("cuser", ""));

        }

}
