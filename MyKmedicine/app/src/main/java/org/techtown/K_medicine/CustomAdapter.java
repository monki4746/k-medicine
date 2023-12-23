package org.techtown.K_medicine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<CustomListForm> list;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int layout, ArrayList<CustomListForm> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // ListView에서 보여줄 데이터 개수

    @Override
    public int getCount() {
        return list.size();
    }

    // ListView에서 보여줄 객체 지정
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = layoutInflater.inflate(layout, null);

        TextView text_output_order_number = view.findViewById(R.id.text_output_order_number);
        TextView text_output_supplier = view.findViewById(R.id.text_output_supplier);
        TextView text_output_receiver = view.findViewById(R.id.text_output_receiver);
        TextView text_output_items_info_summary = view.findViewById(R.id.text_output_items_info_summary);

        CustomListForm customListForm = list.get(i);
        text_output_order_number.setText(customListForm.getOrder_number());
        text_output_supplier.setText(customListForm.getSupplier());
        text_output_receiver.setText(customListForm.getReceiver());
        text_output_items_info_summary.setText(customListForm.getItems_info_summary());

        return view;
    }
}
