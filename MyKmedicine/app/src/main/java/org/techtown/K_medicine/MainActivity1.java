package org.techtown.K_medicine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {
    private static final int REQUEST_CODE_ACTIVITY_1 = 1;
    private static final int REQUEST_CODE_ACTIVITY_2 = 2;
    private static final int REQUEST_CODE_ACTIVITY_3 = 3;
    private static final int REQUEST_CODE_ACTIVITY_4 = 4;
    private static final int REQUEST_CODE_ACTIVITY_5 = 5;
    private static final int REQUEST_CODE_ACTIVITY_6 = 6;

    int list_adapter_id;

    Button btn_sys_back;
    Button btn_sys_home;

    TextView text_print_order_number;
    TextView text_print_supplier;
    TextView text_print_receiver;
    TextView text_print_items_info_summary;

    Button btn_data_check;
    Button btn_tax_invoice;
    Button btn_transaction_name;
    Button btn_temp_info;
    Button btn_deliver_paper;

    Button btn_done;

//    ArrayList<ImageSerializable> activity_1_image_list;
//    ArrayList<String> activity_1_uri_list;
//    String activity_1_significant_str;

    ArrayList<ImageSerializable> activity_2_image_list;
    ArrayList<String> activity_2_uri_list;
    String activity_2_significant_str;

    ArrayList<ImageSerializable> activity_3_image_list;
    ArrayList<String> activity_3_uri_list;
    String activity_3_significant_str;

    ArrayList<ImageSerializable> activity_4_image_list;
    ArrayList<String> activity_4_uri_list;
    String activity_4_significant_str;

    ArrayList<ImageSerializable> activity_5_image_list;
    ArrayList<String> activity_5_uri_list;
    String activity_5_significant_str;
    String activity_5_item_name_1;
    String activity_5_item_name_2;
    String activity_5_item_name_3;
    String activity_5_item_name_4;
    int activity_5_item_temp_1;
    int activity_5_item_temp_2;
    int activity_5_item_temp_3;
    int activity_5_item_temp_4;
    int activity_5_is_edit_item_temp_1;
    int activity_5_is_edit_item_temp_2;
    int activity_5_is_edit_item_temp_3;
    int activity_5_is_edit_item_temp_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btn_sys_back = findViewById(R.id.btn_sys_back); // 사용 예정
        btn_sys_home = findViewById(R.id.btn_sys_home); // 사용 예정

        text_print_order_number = findViewById(R.id.text_print_order_number);
        text_print_supplier = findViewById(R.id.text_print_supplier);
        text_print_receiver = findViewById(R.id.text_print_receiver);
        text_print_items_info_summary = findViewById(R.id.text_print_items_info_summary);

        btn_data_check = findViewById(R.id.btn_data_check);
        btn_tax_invoice = findViewById(R.id.btn_tax_invoice);
        btn_transaction_name = findViewById(R.id.btn_transaction_name);
        btn_temp_info = findViewById(R.id.btn_temp_info);
        btn_deliver_paper = findViewById(R.id.btn_deliver_paper);

        btn_done = findViewById(R.id.btn_done); // 사용 예정

        activity_2_image_list = new ArrayList<>();
        activity_2_uri_list = new ArrayList<>();
        activity_3_image_list = new ArrayList<>();
        activity_3_uri_list = new ArrayList<>();
        activity_4_image_list = new ArrayList<>();
        activity_4_uri_list = new ArrayList<>();
        activity_5_image_list = new ArrayList<>();
        activity_5_uri_list = new ArrayList<>();

        // 이전 엑티비티에 선택한 어뎁터뷰 id에 따른, 값 출력 //
        list_adapter_id = getIntent().getIntExtra("LIST_ADAPTER_ID", -1);
        // 추후 API에서 값 받아서 넣도록 만들기 //
        if(list_adapter_id == 0) {
            text_print_order_number.setText("거래 번호  : 20220302-2");
            text_print_supplier.setText("인계사       : 행복약품");
            text_print_receiver.setText("인수사       : 행복병원");
            text_print_items_info_summary.setText("물품 정보  : 항생제 외 3개 품목");
        }
        else if(list_adapter_id == 1) {
            text_print_order_number.setText("거래 번호  : ks0202020");
            text_print_supplier.setText("인계사       : ㅇㅇ 제약회사");
            text_print_receiver.setText("인수사       : ㅇㅇ 약국");
            text_print_items_info_summary.setText("물품 정보  : 항생제 외 5개 품목");
        }


        btn_data_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 나중에 구현됩니다. //
            }
        });

        btn_tax_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity1.this, MainActivity2.class);
                intent2.putExtra("Activity_2", "Activity_2");
                intent2.putExtra("Activity_3", "x");
                intent2.putExtra("Activity_4", "x");
                intent2.putExtra("Activity_2_image_list", activity_2_image_list);
                intent2.putStringArrayListExtra("Activity_2_uri_list", activity_2_uri_list);
                intent2.putExtra("Activity_2_significant_str", activity_2_significant_str);
                startActivityForResult(intent2, REQUEST_CODE_ACTIVITY_2);
            }
        });

        btn_transaction_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity1.this, MainActivity2.class);
                intent3.putExtra("Activity_2", "x");
                intent3.putExtra("Activity_3", "Activity_3");
                intent3.putExtra("Activity_4", "x");
                intent3.putExtra("Activity_3_image_list", activity_3_image_list);
                intent3.putStringArrayListExtra("Activity_3_uri_list", activity_3_uri_list);
                intent3.putExtra("Activity_3_significant_str", activity_3_significant_str);
                startActivityForResult(intent3, REQUEST_CODE_ACTIVITY_3);
            }
        });

        btn_temp_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity1.this, MainActivity2.class);
                intent4.putExtra("Activity_2", "x");
                intent4.putExtra("Activity_3", "x");
                intent4.putExtra("Activity_4", "Activity_4");
                intent4.putExtra("Activity_4_image_list", activity_4_image_list);
                intent4.putStringArrayListExtra("Activity_4_uri_list", activity_4_uri_list);
                intent4.putExtra("Activity_4_significant_str", activity_4_significant_str);
                startActivityForResult(intent4, REQUEST_CODE_ACTIVITY_4);
            }
        });

        btn_deliver_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity1.this, MainActivity3.class);
                intent5.putExtra("Activity_5_image_list", activity_5_image_list);
                intent5.putStringArrayListExtra("Activity_5_uri_list", activity_5_uri_list);
                intent5.putExtra("Activity_5_significant_str", activity_5_significant_str);
                intent5.putExtra("Activity_5_item_name_1", activity_5_item_name_1);
                intent5.putExtra("Activity_5_item_name_2", activity_5_item_name_2);
                intent5.putExtra("Activity_5_item_name_3", activity_5_item_name_3);
                intent5.putExtra("Activity_5_item_name_4", activity_5_item_name_4);
                intent5.putExtra("Activity_5_item_temp_1", activity_5_item_temp_1);
                intent5.putExtra("Activity_5_item_temp_2", activity_5_item_temp_2);
                intent5.putExtra("Activity_5_item_temp_3", activity_5_item_temp_3);
                intent5.putExtra("Activity_5_item_temp_4", activity_5_item_temp_4);
                intent5.putExtra("Activity_5_is_edit_item_temp_1", activity_5_is_edit_item_temp_1);
                intent5.putExtra("Activity_5_is_edit_item_temp_2", activity_5_is_edit_item_temp_2);
                intent5.putExtra("Activity_5_is_edit_item_temp_3", activity_5_is_edit_item_temp_3);
                intent5.putExtra("Activity_5_is_edit_item_temp_4", activity_5_is_edit_item_temp_4);
                startActivityForResult(intent5, REQUEST_CODE_ACTIVITY_5);
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity1.this, MainActivity4.class);
                intent6.putExtra("Activity_2_image_list", activity_2_image_list);
                intent6.putStringArrayListExtra("Activity_2_uri_list", activity_2_uri_list);
                intent6.putExtra("Activity_3_image_list", activity_3_image_list);
                intent6.putStringArrayListExtra("Activity_3_uri_list", activity_3_uri_list);
                intent6.putExtra("Activity_4_image_list", activity_4_image_list);
                intent6.putStringArrayListExtra("Activity_4_uri_list", activity_4_uri_list);
                intent6.putExtra("Activity_5_image_list", activity_5_image_list);
                intent6.putStringArrayListExtra("Activity_5_uri_list", activity_5_uri_list);
                intent6.putExtra("Activity_2_significant_str", activity_2_significant_str);
                intent6.putExtra("Activity_3_significant_str", activity_3_significant_str);
                intent6.putExtra("Activity_4_significant_str", activity_4_significant_str);
                intent6.putExtra("Activity_5_significant_str", activity_5_significant_str);
                intent6.putExtra("Activity_5_item_name_1", activity_5_item_name_1);
                intent6.putExtra("Activity_5_item_name_2", activity_5_item_name_2);
                intent6.putExtra("Activity_5_item_name_3", activity_5_item_name_3);
                intent6.putExtra("Activity_5_item_name_4", activity_5_item_name_4);
                intent6.putExtra("Activity_5_item_temp_1", activity_5_item_temp_1);
                intent6.putExtra("Activity_5_item_temp_2", activity_5_item_temp_2);
                intent6.putExtra("Activity_5_item_temp_3", activity_5_item_temp_3);
                intent6.putExtra("Activity_5_item_temp_4", activity_5_item_temp_4);
                intent6.putExtra("Activity_5_is_edit_item_temp_1", activity_5_is_edit_item_temp_1);
                intent6.putExtra("Activity_5_is_edit_item_temp_2", activity_5_is_edit_item_temp_2);
                intent6.putExtra("Activity_5_is_edit_item_temp_3", activity_5_is_edit_item_temp_3);
                intent6.putExtra("Activity_5_is_edit_item_temp_4", activity_5_is_edit_item_temp_4);
                startActivityForResult(intent6, REQUEST_CODE_ACTIVITY_6);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ACTIVITY_1 && resultCode == RESULT_OK) {
            // 나중에 구현됩니다. //
        } else if(requestCode == REQUEST_CODE_ACTIVITY_2 && resultCode == RESULT_OK) {
            activity_2_image_list = (ArrayList<ImageSerializable>)data.getSerializableExtra("Activity_2_image_list");
            activity_2_uri_list = (ArrayList<String>)data.getStringArrayListExtra("Activity_2_uri_list");
            activity_2_significant_str = data.getStringExtra("Activity_2_significant_str");
        } else if(requestCode == REQUEST_CODE_ACTIVITY_3 && resultCode == RESULT_OK) {
            activity_3_image_list = (ArrayList<ImageSerializable>)data.getSerializableExtra("Activity_3_image_list");
            activity_3_uri_list = (ArrayList<String>)data.getStringArrayListExtra("Activity_3_uri_list");
            activity_3_significant_str = data.getStringExtra("Activity_3_significant_str");
        } else if(requestCode == REQUEST_CODE_ACTIVITY_4 && resultCode == RESULT_OK) {
            activity_4_image_list = (ArrayList<ImageSerializable>)data.getSerializableExtra("Activity_4_image_list");
            activity_4_uri_list = (ArrayList<String>)data.getStringArrayListExtra("Activity_4_uri_list");
            activity_4_significant_str = data.getStringExtra("Activity_4_significant_str");
        } else if(requestCode == REQUEST_CODE_ACTIVITY_5 && resultCode == RESULT_OK) {
            activity_5_image_list = (ArrayList<ImageSerializable>)data.getSerializableExtra("Activity_5_image_list");
            activity_5_uri_list = (ArrayList<String>)data.getStringArrayListExtra("Activity_5_uri_list");
            activity_5_significant_str = data.getStringExtra("Activity_5_significant_str");
            activity_5_item_name_1 = data.getStringExtra("Activity_5_item_name_1");
            activity_5_item_name_2 = data.getStringExtra("Activity_5_item_name_2");
            activity_5_item_name_3 = data.getStringExtra("Activity_5_item_name_3");
            activity_5_item_name_4 = data.getStringExtra("Activity_5_item_name_4");
            activity_5_item_temp_1 = data.getIntExtra("Activity_5_item_temp_1", -1);
            activity_5_item_temp_2 = data.getIntExtra("Activity_5_item_temp_2", -1);
            activity_5_item_temp_3 = data.getIntExtra("Activity_5_item_temp_3", -1);
            activity_5_item_temp_4 = data.getIntExtra("Activity_5_item_temp_4", -1);
            activity_5_is_edit_item_temp_1 = data.getIntExtra("Activity_5_is_edit_item_temp_1", -1);
            activity_5_is_edit_item_temp_2 = data.getIntExtra("Activity_5_is_edit_item_temp_2", -1);
            activity_5_is_edit_item_temp_3 = data.getIntExtra("Activity_5_is_edit_item_temp_3", -1);
            activity_5_is_edit_item_temp_4 = data.getIntExtra("Activity_5_is_edit_item_temp_4", -1);
        }
    }
}