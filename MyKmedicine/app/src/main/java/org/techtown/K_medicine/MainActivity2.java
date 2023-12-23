package org.techtown.K_medicine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Button btn_add_image;
    Button btn_sys_cancel;
    Button btn_sys_save;

    String prev_activity_name_2;
    String prev_activity_name_3;
    String prev_activity_name_4;
    int now_activity_num;

    TextView textoutput_prev_activity_btn_name;

    private static final int REQ_CODE_2 = 2;
    private static final int REQ_CODE_3 = 3;
    private static final int REQ_CODE_4 = 4;
    Uri temp_uri;
    ArrayList<ImageSerializable> image_list_2;
    ArrayList<ImageSerializable> image_list_3;
    ArrayList<ImageSerializable> image_list_4;
    ArrayList<String> uri_list_2;
    ArrayList<String> uri_list_3;
    ArrayList<String> uri_list_4;

    String significant_str;
    EditText textinput_significant;

    Intent intent1 = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_add_image = findViewById(R.id.btn_add_image);
        btn_sys_cancel = findViewById(R.id.btn_sys_cancel);
        btn_sys_save = findViewById(R.id.btn_sys_save);

        textoutput_prev_activity_btn_name = findViewById(R.id.textoutput_prev_activity_btn_name);

        textinput_significant = findViewById(R.id.textinput_significant);

        // 이전에 저장한 데이터가 있을경우, 그것을 출력한다 //
        prev_activity_name_2 = getIntent().getStringExtra("Activity_2");
        prev_activity_name_3 = getIntent().getStringExtra("Activity_3");
        prev_activity_name_4 = getIntent().getStringExtra("Activity_4");

        if(prev_activity_name_2.equals("Activity_2")) {
            now_activity_num = 2;
            textoutput_prev_activity_btn_name.setText("- 세 금 계 산 서 -");
            image_list_2 = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_2_image_list");
            uri_list_2 = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_2_uri_list");
            for (int i = 0; i < uri_list_2.size(); i++) {
                // 추가할 레이아웃
                ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list_2.get(i));
                // 추가될 위치
                LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images);
                layout.addView(imageHorizontalLayout);
            }
            significant_str = getIntent().getStringExtra("Activity_2_significant_str");
        } else if(prev_activity_name_3.equals("Activity_3")) {
            now_activity_num = 3;
            textoutput_prev_activity_btn_name.setText("- 거 래 명 세 서 -");
            image_list_3 = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_3_image_list");
            uri_list_3 = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_3_uri_list");
            for (int i = 0; i < uri_list_3.size(); i++) {
                // 추가할 레이아웃
                ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list_3.get(i));
                // 추가될 위치
                LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images);
                layout.addView(imageHorizontalLayout);
            }
            significant_str = getIntent().getStringExtra("Activity_3_significant_str");
        } else if(prev_activity_name_4.equals("Activity_4")) {
            now_activity_num = 4;
            textoutput_prev_activity_btn_name.setText("- 온 도 정 보 -");
            image_list_4 = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_4_image_list");
            uri_list_4 = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_4_uri_list");
            for (int i = 0; i < uri_list_4.size(); i++) {
                // 추가할 레이아웃
                ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list_4.get(i));
                // 추가될 위치
                LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images);
                layout.addView(imageHorizontalLayout);
            }
            significant_str = getIntent().getStringExtra("Activity_4_significant_str");
        }
        textinput_significant.setText(significant_str);


        textinput_significant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                significant_str = textinput_significant.getText().toString();
            }
        });

        btn_add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicture = new Intent();
                intentPicture.setType("image/*");
                intentPicture.setAction(Intent.ACTION_GET_CONTENT);

                if(now_activity_num == 2)
                    startActivityForResult(intentPicture, REQ_CODE_2);
                else if(now_activity_num == 3)
                    startActivityForResult(intentPicture, REQ_CODE_3);
                else if(now_activity_num == 4)
                    startActivityForResult(intentPicture, REQ_CODE_4);
            }
        });

        btn_sys_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_sys_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(now_activity_num == 2) {
                        intent1.putExtra("Activity_2_image_list", image_list_2);
                        intent1.putStringArrayListExtra("Activity_2_uri_list", uri_list_2);
                        intent1.putExtra("Activity_2_significant_str", significant_str);
                    } else if(now_activity_num == 3) {
                        intent1.putExtra("Activity_3_image_list", image_list_3);
                        intent1.putStringArrayListExtra("Activity_3_uri_list", uri_list_3);
                        intent1.putExtra("Activity_3_significant_str", significant_str);
                    } else if(now_activity_num == 4) {
                        intent1.putExtra("Activity_4_image_list", image_list_4);
                        intent1.putStringArrayListExtra("Activity_4_uri_list", uri_list_4);
                        intent1.putExtra("Activity_4_significant_str", significant_str);
                    }
                    setResult(Activity.RESULT_OK, intent1);
                    finish();
                } catch (Exception e) {

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE_2 && resultCode == RESULT_OK) {
            temp_uri = data.getData();

            ImageSerializable imageSerializable = new ImageSerializable(temp_uri.toString());
            image_list_2.add(imageSerializable);
            uri_list_2.add(temp_uri.toString());

            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list_2.get(image_list_2.size()-1));
            // 추가될 위치
            LinearLayout layout = (LinearLayout)findViewById(R.id.view_horizontal_images);
            layout.addView(imageHorizontalLayout);
        }
        else if(requestCode == REQ_CODE_3 && resultCode == RESULT_OK) {
            temp_uri = data.getData();

            ImageSerializable imageSerializable = new ImageSerializable(temp_uri.toString());
            image_list_3.add(imageSerializable);
            uri_list_3.add(temp_uri.toString());

            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list_3.get(image_list_3.size()-1));
            // 추가될 위치
            LinearLayout layout = (LinearLayout)findViewById(R.id.view_horizontal_images);
            layout.addView(imageHorizontalLayout);
        }
        else if (requestCode == REQ_CODE_4 && resultCode == RESULT_OK) {
            temp_uri = data.getData();

            ImageSerializable imageSerializable = new ImageSerializable(temp_uri.toString());
            image_list_4.add(imageSerializable);
            uri_list_4.add(temp_uri.toString());

            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list_4.get(image_list_4.size()-1));
            // 추가될 위치
            LinearLayout layout = (LinearLayout)findViewById(R.id.view_horizontal_images);
            layout.addView(imageHorizontalLayout);
        }
    }
}
