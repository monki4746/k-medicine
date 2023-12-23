package org.techtown.K_medicine;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editSearch;

    private ArrayList<CustomListForm> arraylist;
    public ArrayList<CustomListForm> list;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn2 = (ImageButton) findViewById(R.id.btn2);  // 버튼1
        ImageButton btnQr = (ImageButton) findViewById(R.id.btnQr);  // 버튼2

        editSearch = (EditText) findViewById(R.id.editSearch);

        arraylist = new ArrayList<CustomListForm>();

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Change.class);
                startActivity(intent);
            }
        });

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Qr.class);
                startActivity(intent);
            }
        });


        // 리스트 시작 //
        // 추후 API에서 값 받아서 넣도록 만들기 //
        list = new ArrayList<CustomListForm>();
        list.add(new CustomListForm("20220302-2", "행복약품", "행복병원", "항생제 외 3개 품목"));
        list.add(new CustomListForm("ks0202020", "ㅇㅇ 제약회사", "ㅇㅇ 약국", "항생제 외 5개 품목"));
        list.add(new CustomListForm("ks0", "supplier", "receiver", "summary"));

        listView = findViewById(R.id.listView);

        customAdapter = new CustomAdapter(getApplicationContext(), R.layout.custom_list_item, list);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                intent.putExtra("LIST_ADAPTER_ID", i);
                startActivity(intent);
            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });
    }
    public void search(String charText) {
        arraylist.addAll(list);
        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getItems_info_summary().toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        customAdapter.notifyDataSetChanged();
    }
}