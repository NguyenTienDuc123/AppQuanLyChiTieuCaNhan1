package com.example.appquanlychitieucanhan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlychitieucanhan.model.KhoangThu;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Develop on 5/4/2018.
 */

class KhoanThuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txt_KhoangThu,txt_SoTien,txtNgay;
    public List<KhoangThu> thuList=new ArrayList<>();
    public Context context;
    private ItemOnClickListener itemOnClickListener;

    public KhoanThuViewHolder(View itemView, Context context, List<KhoangThu> list) {
        super(itemView);
        this.thuList=list;
        this.context=context;
        txt_KhoangThu=itemView.findViewById(R.id.txtLoaiThu);
        txt_SoTien=itemView.findViewById(R.id.txtSoTien);
        txtNgay=itemView.findViewById(R.id.txtNgay);
        itemView.setOnClickListener(this);

    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }
    String Ngay,TaiKhoan,SoTien,MoTa,LoaiThu;
    @Override
    public void onClick(View view) {
//        itemOnClickListener.onClick(view,getAdapterPosition(),false);
        int position= getAdapterPosition();
        KhoangThu khoangThu=thuList.get(position);
        Intent intent=new Intent(this.context, KhoangThuChiTietActivity.class);
        intent.putExtra("ngay",khoangThu.getNgay());
        intent.putExtra("taikhoan",khoangThu.getTaiKhoan());
        intent.putExtra("sotien",khoangThu.getSoTien());
        intent.putExtra("mota",khoangThu.getMoTa());
        intent.putExtra("loaithu",khoangThu.getLoaiThu());
        context.startActivity(intent);

    }
}

public class KhoanThuApdater  extends RecyclerView.Adapter<KhoanThuViewHolder>{

    private List<KhoangThu> listData= new ArrayList<>();
    private Context context;

    public KhoanThuApdater(List<KhoangThu> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public KhoanThuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.item_khoan_thu,parent,false);
        return new KhoanThuViewHolder(itemView,context,listData);
    }


    @Override
    public void onBindViewHolder(KhoanThuViewHolder holder, int position) {

        holder.txt_KhoangThu.setText(listData.get(position).getLoaiThu());
        holder.txt_SoTien.setText(listData.get(position).getSoTien() + " đ");
        holder.txtNgay.setText(listData.get(position).getNgay());
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

}
