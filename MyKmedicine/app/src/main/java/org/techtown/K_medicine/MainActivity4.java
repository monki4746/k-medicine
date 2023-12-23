package org.techtown.K_medicine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    private static final int REQUEST_CODE_ACTIVITY_6 = 6;

    TextView text_title;

    ArrayList<ImageSerializable> tax_invoice_image_list;
    ArrayList<String> tax_invoice_uri_list;
    TextView textoutput_tax_invoice_significant;

    ArrayList<ImageSerializable> transaction_name_image_list;
    ArrayList<String> transaction_name_uri_list;
    TextView textoutput_transaction_name_significant;

    ArrayList<ImageSerializable> temp_info_image_list;
    ArrayList<String> temp_info_uri_list;
    TextView textoutput_temp_info_significant;

    ArrayList<ImageSerializable> deliver_paper_image_list;
    ArrayList<String> deliver_paper_uri_list;
    TextView textoutput_deliver_paper_significant;

    String temp_significant_str;

    TextView textoutput_item_name1;
    TextView textoutput_item_name2;
    TextView textoutput_item_name3;
    TextView textoutput_item_name4;
    TextView textoutput_item_temp1;
    TextView textoutput_item_temp2;
    TextView textoutput_item_temp3;
    TextView textoutput_item_temp4;
    String item_name_1;
    String item_name_2;
    String item_name_3;
    String item_name_4;
    int item_temp_1;
    int item_temp_2;
    int item_temp_3;
    int item_temp_4;
    int is_edit_item_temp_1;
    int is_edit_item_temp_2;
    int is_edit_item_temp_3;
    int is_edit_item_temp_4;

    Button btn_acceptor_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        text_title = findViewById(R.id.text_title_2);
        text_title.bringToFront();  // 화면 가장 위쪽에 표시

        btn_acceptor_check = findViewById(R.id.btn_acceptor_check);

        textoutput_tax_invoice_significant = findViewById(R.id.textoutput_tax_invoice_significant);
        textoutput_transaction_name_significant = findViewById(R.id.textoutput_transaction_name_significant);
        textoutput_temp_info_significant = findViewById(R.id.textoutput_temp_info_significant);
        textoutput_deliver_paper_significant = findViewById(R.id.textoutput_deliver_paper_significant);
        textoutput_item_name1 = findViewById(R.id.textoutput_item_name1);
        textoutput_item_name2 = findViewById(R.id.textoutput_item_name2);
        textoutput_item_name3 = findViewById(R.id.textoutput_item_name3);
        textoutput_item_name4 = findViewById(R.id.textoutput_item_name4);
        textoutput_item_temp1 = findViewById(R.id.textoutput_item_temp1);
        textoutput_item_temp2 = findViewById(R.id.textoutput_item_temp2);
        textoutput_item_temp3 = findViewById(R.id.textoutput_item_temp3);
        textoutput_item_temp4 = findViewById(R.id.textoutput_item_temp4);


        tax_invoice_image_list = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_2_image_list");
        tax_invoice_uri_list = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_2_uri_list");
        System.out.println("MainActivity4로 옴");
        System.out.println(tax_invoice_image_list);
        System.out.println(tax_invoice_uri_list);
        for (int i = 0; i < tax_invoice_uri_list.size(); i++) {
            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), tax_invoice_image_list.get(i));
            // 추가될 위치
            LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images1);
            layout.addView(imageHorizontalLayout);
        }
        temp_significant_str = getIntent().getStringExtra("Activity_2_significant_str");
        if(temp_significant_str != null)
            textoutput_tax_invoice_significant.setText(temp_significant_str);

        transaction_name_image_list = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_3_image_list");
        transaction_name_uri_list = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_3_uri_list");
        for (int i = 0; i < transaction_name_uri_list.size(); i++) {
            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), transaction_name_image_list.get(i));
            // 추가될 위치
            LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images2);
            layout.addView(imageHorizontalLayout);
        }
        temp_significant_str = getIntent().getStringExtra("Activity_3_significant_str");
        if(temp_significant_str != null)
            textoutput_transaction_name_significant.setText(temp_significant_str);

        temp_info_image_list = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_4_image_list");
        temp_info_uri_list = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_4_uri_list");
        for (int i = 0; i < temp_info_uri_list.size(); i++) {
            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), temp_info_image_list.get(i));
            // 추가될 위치
            LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images3);
            layout.addView(imageHorizontalLayout);
        }
        temp_significant_str = getIntent().getStringExtra("Activity_4_significant_str");
        if(temp_significant_str != null)
            textoutput_temp_info_significant.setText(temp_significant_str);

        deliver_paper_image_list = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_5_image_list");
        deliver_paper_uri_list = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_5_uri_list");
        for (int i = 0; i < deliver_paper_uri_list.size(); i++) {
            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), deliver_paper_image_list.get(i));
            // 추가될 위치
            LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images4);
            layout.addView(imageHorizontalLayout);
        }
        temp_significant_str = getIntent().getStringExtra("Activity_5_significant_str");
        if(temp_significant_str != null)
            textoutput_deliver_paper_significant.setText(temp_significant_str);

        item_name_1 = getIntent().getStringExtra("Activity_5_item_name_1");
        item_name_2 = getIntent().getStringExtra("Activity_5_item_name_2");
        item_name_3 = getIntent().getStringExtra("Activity_5_item_name_3");
        item_name_4 = getIntent().getStringExtra("Activity_5_item_name_4");
        item_temp_1 = getIntent().getIntExtra("Activity_5_item_temp_1", -1);
        item_temp_2 = getIntent().getIntExtra("Activity_5_item_temp_2", -1);
        item_temp_3 = getIntent().getIntExtra("Activity_5_item_temp_3", -1);
        item_temp_4 = getIntent().getIntExtra("Activity_5_item_temp_4", -1);
        is_edit_item_temp_1 = getIntent().getIntExtra("Activity_5_is_edit_item_temp_1", -1);
        is_edit_item_temp_2 = getIntent().getIntExtra("Activity_5_is_edit_item_temp_2", -1);
        is_edit_item_temp_3 = getIntent().getIntExtra("Activity_5_is_edit_item_temp_3", -1);
        is_edit_item_temp_4 = getIntent().getIntExtra("Activity_5_is_edit_item_temp_4", -1);
        if(item_name_1 != null)
            textoutput_item_name1.setText(item_name_1);
        if(item_name_2 != null)
            textoutput_item_name2.setText(item_name_2);
        if(item_name_3 != null)
            textoutput_item_name3.setText(item_name_3);
        if(item_name_4 != null)
            textoutput_item_name4.setText(item_name_4);
        if(is_edit_item_temp_1 > 0)
            textoutput_item_temp1.setText(item_temp_1+"°C");
        if(is_edit_item_temp_2 > 0)
            textoutput_item_temp2.setText(item_temp_2+"°C");
        if(is_edit_item_temp_3 > 0)
            textoutput_item_temp3.setText(item_temp_3+"°C");
        if(is_edit_item_temp_4 > 0)
            textoutput_item_temp4.setText(item_temp_4+"°C");


        btn_acceptor_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity4.this, MainActivity5.class);
                startActivityForResult(intent6, REQUEST_CODE_ACTIVITY_6);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
    }
}