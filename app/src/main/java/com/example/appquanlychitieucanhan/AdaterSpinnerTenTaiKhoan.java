package com.example.appquanlychitieucanhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appquanlychitieucanhan.model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Develop on 5/6/2018.
 */

public class AdaterSpinnerTenTaiKhoan extends ArrayAdapter<TaiKhoan> {

    public List<TaiKhoan> listData = new ArrayList<>();
    public Context context;
    public int resource;




    public AdaterSpinnerTenTaiKhoan(@NonNull Context context, int resource, @NonNull List<TaiKhoan> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listData = objects;
    }

    class viewHolder {
        TextView txtTaiKhoan;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        viewHolder view;
        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_taikhoan, parent, false);
            view = new viewHolder();

//            view.txtTaiKhoan = convertView.findViewById(R.id.txtTaiKhoan);
            convertView.setTag(view);
        } else {
            view = (viewHolder) convertView.getTag();
        }
        view.txtTaiKhoan.setText(listData.get(position).getTenTaiKhoan());
        return convertView;
    }
}
