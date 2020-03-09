package com.example.appdatmon;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ArrayAdapter<food_obj> {
    private final Activity context;
    private final ArrayList<food_obj> objs;

    public MainActivity(Activity context, ArrayList<food_obj> objs) {
        super(context, R.layout.activity_main, objs);

        this.context = context;
        this.objs = objs;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_main, null, true);

        final EditText name = rowView.findViewById(R.id.tv_ten);
        final EditText price = rowView.findViewById(R.id.tv_gia);
        ImageView image = rowView.findViewById(R.id.image);
        CheckBox cb = rowView.findViewById(R.id.cb_buy);

        name.setText(objs.get(position).name);
        price.setText(objs.get(position).price + "");

        name.setEnabled(objs.get(position).editname);
        price.setEnabled(objs.get(position).editprice);

        cb.setChecked(objs.get(position).checked);
        image.setImageResource(objs.get(position).id_image);
        Button delete, edit;
        delete = rowView.findViewById(R.id.btn_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objs.remove(position);
                notifyDataSetChanged();
            }
        });
        edit = rowView.findViewById(R.id.btn_edit_name);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.isEnabled()) {
                    name.setEnabled(false);
                    price.setEnabled(true);
                    food_obj foodObj = objs.get(position);
                    foodObj.name = name.getText().toString();
                    foodObj.price = Integer.parseInt(price.getText().toString());
                    foodObj.editname = false;
                    foodObj.editprice = true;
                    objs.set(position, foodObj);
                    notifyDataSetChanged();
                } else if (price.isEnabled()) {
                    price.setEnabled(false);
                    food_obj foodObj = objs.get(position);
                    foodObj.name = name.getText().toString();
                    foodObj.price = Integer.parseInt(price.getText().toString());
                    foodObj.editprice = false;
                    objs.set(position, foodObj);
                    Toast.makeText(context, "Đã sửa thành công", Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                } else {
                    name.setEnabled(true);
                    food_obj foodObj = objs.get(position);
                    foodObj.editname = true;
                    objs.set(position, foodObj);
                    notifyDataSetChanged();
                }
            }
        });
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                food_obj foodObj = objs.get(position);
                foodObj.checked = isChecked;
                objs.set(position, foodObj);
                notifyDataSetChanged();
            }
        });
        return rowView;

    }
}
