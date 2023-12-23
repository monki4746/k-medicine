package org.techtown.K_medicine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private static final int REQ_CODE = 1;

    TextView text_title_1;

    Button btn_add_image;
    Button btn_sys_cancel;
    Button btn_sys_save;

    Uri temp_uri;
    ArrayList<ImageSerializable> image_list;
    ArrayList<String> uri_list;
    EditText textinput_significant;
    String significant_str;

    Button btn_item_name1;
    Button btn_item_name2;
    Button btn_item_name3;
    Button btn_item_name4;
    Button btn_item_temp1;
    Button btn_item_temp2;
    Button btn_item_temp3;
    Button btn_item_temp4;
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

    Intent intent1 = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text_title_1 = findViewById(R.id.text_title_1);
        text_title_1.bringToFront();

        btn_add_image = findViewById(R.id.btn_add_image);
        btn_sys_cancel = findViewById(R.id.btn_sys_cancel);
        btn_sys_save = findViewById(R.id.btn_sys_save);

        textinput_significant = findViewById(R.id.textinput_significant);

        btn_item_name1 = findViewById(R.id.textoutput_item_name1);
        btn_item_name2 = findViewById(R.id.textoutput_item_name2);
        btn_item_name3 = findViewById(R.id.textoutput_item_name3);
        btn_item_name4 = findViewById(R.id.textoutput_item_name4);
        btn_item_temp1 = findViewById(R.id.textoutput_item_temp1);
        btn_item_temp2 = findViewById(R.id.textoutput_item_temp2);
        btn_item_temp3 = findViewById(R.id.textoutput_item_temp3);
        btn_item_temp4 = findViewById(R.id.textoutput_item_temp4);


        // 이전에 저장한 데이터가 있을경우, 그것을 출력한다 //
        image_list = (ArrayList<ImageSerializable>)getIntent().getSerializableExtra("Activity_5_image_list");
        uri_list = (ArrayList<String>)getIntent().getStringArrayListExtra("Activity_5_uri_list");
        for (int i = 0; i < uri_list.size(); i++) {
            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list.get(i));
            // 추가될 위치
            LinearLayout layout = (LinearLayout) findViewById(R.id.view_horizontal_images);
            layout.addView(imageHorizontalLayout);
        }
        textinput_significant.setText(significant_str);

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
            btn_item_name1.setText(item_name_1);
        if(item_name_2 != null)
            btn_item_name2.setText(item_name_2);
        if(item_name_3 != null)
            btn_item_name3.setText(item_name_3);
        if(item_name_4 != null)
            btn_item_name4.setText(item_name_4);
        if(is_edit_item_temp_1 > 0)
            btn_item_temp1.setText(item_temp_1+"°C");
        if(is_edit_item_temp_2 > 0)
            btn_item_temp2.setText(item_temp_2+"°C");
        if(is_edit_item_temp_3 > 0)
            btn_item_temp3.setText(item_temp_3+"°C");
        if(is_edit_item_temp_4 > 0)
            btn_item_temp4.setText(item_temp_4+"°C");

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

                startActivityForResult(intentPicture, REQ_CODE);

            }
        });

        AlertDialog.Builder dialog_item_name = new AlertDialog.Builder(MainActivity3.this);
        dialog_item_name.setTitle("품목명 입력");
        dialog_item_name.setMessage("품목명을 입력해주세요.");

        AlertDialog.Builder dialog_item_temp = new AlertDialog.Builder(MainActivity3.this);
        dialog_item_temp.setTitle("최종 온도 입력");
        dialog_item_temp.setMessage("온도를 선택하세요.");
        btn_item_temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NumberPicker numberPicker = new NumberPicker(MainActivity3.this);
                numberPicker.setMaxValue(50);
                numberPicker.setMinValue(0);
                numberPicker.setValue(15);

                dialog_item_temp.setView(numberPicker);

                dialog_item_temp.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        item_temp_1 = numberPicker.getValue();
                        btn_item_temp1.setText(item_temp_1+"°C");
                        is_edit_item_temp_1++;
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.show();
            }
        });
        btn_item_temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final EditText editText = new EditText(MainActivity3.this);
                //editText.setInputType(InputType.TYPE_CLASS_NUMBER);  // 숫자 입력 설정
                final NumberPicker numberPicker = new NumberPicker(MainActivity3.this);
                numberPicker.setMaxValue(50);
                numberPicker.setMinValue(0);
                numberPicker.setValue(15);

                dialog_item_temp.setView(numberPicker);

                dialog_item_temp.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        item_temp_2 = numberPicker.getValue();
                        btn_item_temp2.setText(item_temp_2+"°C");
                        is_edit_item_temp_2++;
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.show();
            }
        });
        btn_item_temp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final EditText editText = new EditText(MainActivity3.this);
                //editText.setInputType(InputType.TYPE_CLASS_NUMBER);  // 숫자 입력 설정
                final NumberPicker numberPicker = new NumberPicker(MainActivity3.this);
                numberPicker.setMaxValue(50);
                numberPicker.setMinValue(0);
                numberPicker.setValue(15);

                dialog_item_temp.setView(numberPicker);

                dialog_item_temp.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        item_temp_3 = numberPicker.getValue();
                        btn_item_temp3.setText(item_temp_3+"°C");
                        is_edit_item_temp_3++;
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.show();
            }
        });
        btn_item_temp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final EditText editText = new EditText(MainActivity3.this);
                //editText.setInputType(InputType.TYPE_CLASS_NUMBER);  // 숫자 입력 설정
                final NumberPicker numberPicker = new NumberPicker(MainActivity3.this);
                numberPicker.setMaxValue(50);
                numberPicker.setMinValue(0);
                numberPicker.setValue(15);

                dialog_item_temp.setView(numberPicker);

                dialog_item_temp.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        item_temp_4 = numberPicker.getValue();
                        btn_item_temp4.setText(item_temp_4+"°C");
                        is_edit_item_temp_4++;
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog_item_temp.show();
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
                    intent1.putExtra("Activity_5_image_list", image_list);
                    intent1.putStringArrayListExtra("Activity_5_uri_list", uri_list);
                    intent1.putExtra("Activity_5_significant_str", significant_str);
                    intent1.putExtra("Activity_5_item_name_1", item_name_1);
                    intent1.putExtra("Activity_5_item_name_2", item_name_2);
                    intent1.putExtra("Activity_5_item_name_3", item_name_3);
                    intent1.putExtra("Activity_5_item_name_4", item_name_4);
                    intent1.putExtra("Activity_5_item_temp_1", item_temp_1);
                    intent1.putExtra("Activity_5_item_temp_2", item_temp_2);
                    intent1.putExtra("Activity_5_item_temp_3", item_temp_3);
                    intent1.putExtra("Activity_5_item_temp_4", item_temp_4);
                    intent1.putExtra("Activity_5_is_edit_item_temp_1", is_edit_item_temp_1);
                    intent1.putExtra("Activity_5_is_edit_item_temp_2", is_edit_item_temp_2);
                    intent1.putExtra("Activity_5_is_edit_item_temp_3", is_edit_item_temp_3);
                    intent1.putExtra("Activity_5_is_edit_item_temp_4", is_edit_item_temp_4);
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
        if(requestCode == REQ_CODE && resultCode == RESULT_OK) {
            temp_uri = data.getData();

            ImageSerializable imageSerializable = new ImageSerializable(temp_uri.toString());
            image_list.add(imageSerializable);
            uri_list.add(temp_uri.toString());

            // 추가할 레이아웃
            ImageHorizontalLayout imageHorizontalLayout = new ImageHorizontalLayout(getApplicationContext(), image_list.get(image_list.size()-1));
            // 추가될 위치
            LinearLayout layout = (LinearLayout)findViewById(R.id.view_horizontal_images);
            layout.addView(imageHorizontalLayout);
        }

    }
}