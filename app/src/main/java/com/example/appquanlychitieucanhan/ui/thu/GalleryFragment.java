package com.example.appquanlychitieucanhan.ui.thu;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlychitieucanhan.Database.DatabaseKhoanThu;
import com.example.appquanlychitieucanhan.KhoanThuApdater;
import com.example.appquanlychitieucanhan.R;
import com.example.appquanlychitieucanhan.model.KhoangThu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class GalleryFragment extends Fragment {
    TextView txtTongThu;
    RecyclerView recyclerView_KhoangThu;
EditText edtkhoanthu;
    FloatingActionButton btnFabKhoanThu;
    DatabaseKhoanThu databaseKhoanThu;
    RecyclerView.LayoutManager layoutManager;
    Spinner TaikhoanSp, LoaiThuSp;
    //    List<LoaiThu> listdata;
    TextInputEditText edtSoTien, edtMoTa;
    List<KhoangThu> listKhoanThu;
    Button btnNgay, BtnHienTai;
    private GalleryViewModel galleryViewModel;
    KhoanThuApdater apdater;
    //    AdapterSpinner adapterSpinner;
//    AdaterSpinnerTenTaiKhoan adapterTenTaiKhoan;
//    DatabaseTaiKhoan databaseTaiKhoan;
    TextView txtBatloi, txtBatLoiLoai;
    int pos = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
//
        txtTongThu = view.findViewById(R.id.tongthu);
        txtBatloi = view.findViewById(R.id.batloi);
        recyclerView_KhoangThu = view.findViewById(R.id.recyclerview_khoanthu);
        recyclerView_KhoangThu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView_KhoangThu.setLayoutManager(layoutManager);
        btnFabKhoanThu = view.findViewById(R.id.fabkhoanthu);
        databaseKhoanThu = new DatabaseKhoanThu(getContext());

        listKhoanThu = new ArrayList<>();

//        Log.d("size", String.valueOf(listdata.size()));
//        Log.d("size",listTaiKhoan.size()+"");
        btnFabKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });
        LoadListKhoanThu();


        return view;
    }

    private void ShowDialog() {

        AlertDialog.Builder aLertDialog = new AlertDialog.Builder(getContext());
        aLertDialog.setTitle("Thêm Khoảng Thu ");
        aLertDialog.setMessage("Vui lòng nhập đủ thông tin!");

        LayoutInflater inflater = this.getLayoutInflater();

        final View view_Add = inflater.inflate(R.layout.new_themkhoanthu_layout, null);

        btnNgay = view_Add.findViewById(R.id.btnNgay);
        BtnHienTai = view_Add.findViewById(R.id.btnHienTai);
        TaikhoanSp = view_Add.findViewById(R.id.loaitaikhoanSpinner);
//        LoaiThuSp = view_Add.findViewById(R.id.edtkhoanthu);
        edtSoTien = view_Add.findViewById(R.id.edtSoTien);
        edtMoTa = view_Add.findViewById(R.id.edtMota);
        edtkhoanthu=view_Add.findViewById(R.id.edtkhoanthu);


//        adapterTenTaiKhoan=new AdaterSpinnerTenTaiKhoan(getContext(),R.layout.item_spinner_taikhoan,listTaiKhoan);
//        TaikhoanSp.setAdapter(adapterTenTaiKhoan);
//        adapterTenTaiKhoan.notifyDataSetChanged();
//
//        TaikhoanSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                pos=listTaiKhoan.get(position).getId();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

//        adapterSpinner=new AdapterSpinner(getContext(),R.layout.item_spinner_loaithu,listdata);
//        LoaiThuSp.setAdapter(adapterSpinner);
//        adapterSpinner.notifyDataSetChanged();

        aLertDialog.setIcon(R.drawable.ic_add_circle_outline_black_24dp);

        getCurrentDate();
        btnNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChooseDate();
            }
        });

        aLertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        aLertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aLertDialog.setView(view_Add);
        final AlertDialog dialog = aLertDialog.create();
        dialog.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean err = true;
                KhoangThu khoangThu = new KhoangThu();
                String Ngay = btnNgay.getText().toString();
//                String TaiKhoan = TaikhoanSp.getSelectedItem().toString();
//                String LoaiThu = LoaiThuSp.getSelectedItem().toString();
                String SoTien = edtSoTien.getText().toString();
                String Mota = edtMoTa.getText().toString();
                String Khoanthu=edtkhoanthu.getText().toString();
                khoangThu.setSoTien(Khoanthu);
//                khoangThu.setLoaiThu(LoaiThu);
                khoangThu.setMoTa(Mota);
                khoangThu.setSoTien(SoTien);
//                khoangThu.setTaiKhoan(TaiKhoan);
                khoangThu.setNgay(Ngay);

                if (Ngay.equals("Chọn Ngày")) {
                    err = false;
                    Toast.makeText(getContext(), "Vui Lòng Chọn Ngày", Toast.LENGTH_SHORT).show();
                } else if (SoTien.equals("")) {
                    err = false;
                    Toast.makeText(getContext(), "Vui Lòng Nhập Số Tiền", Toast.LENGTH_SHORT).show();
                }
                if (err == true) {

                    long check=databaseKhoanThu.AddKhoanThu(khoangThu);
                    int add = 0;
                    if (check>0||edtSoTien.length() > 0) {
//                        for (TaiKhoan tk : listTaiKhoan)
//                        {
//                            if(tk.getId()==pos){
//                                add=Integer.parseInt(.getSoTienTaiKhoan()) + Integer.parseInt(SoTien);
//                                tk.setSoTienTaiKhoan(String.valueOf(add));
//                                databaseTaiKhoan.UpdateLoaiThu(tk);
//                            }
//                        }
                        dialog.dismiss();
                        Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        LoadListKhoanThu();
                    } else {
                        Toast.makeText(getContext(), "Thất Bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void LoadListKhoanThu() {
        listKhoanThu = databaseKhoanThu.getKhoangThu();
        apdater = new KhoanThuApdater(listKhoanThu, getContext());
        recyclerView_KhoangThu.setAdapter(apdater);
        apdater.notifyDataSetChanged();


        NumberFormat fmt;
        Locale locale;
        locale = new Locale("vi", "VN");
        fmt = NumberFormat.getCurrencyInstance(locale);
        int total = 0;
        for (KhoangThu khoangThu : listKhoanThu) {
            total += (Integer.parseInt(khoangThu.getSoTien()));

        }
        txtTongThu.setText(fmt.format(total));
    }

    private void ChooseDate() {
        final Calendar calendar = Calendar.getInstance();
        //Date
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                btnNgay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, Year, Month, Day);
        datePickerDialog.show();
    }

    private void getCurrentDate() {
        BtnHienTai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                //Time
                int seconds = calendar.get(Calendar.SECOND);
                int minute = calendar.get(Calendar.MINUTE);
                int hours = calendar.get(Calendar.HOUR);
                //Date
                int Month;
                int Day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int Year = calendar.get(Calendar.YEAR);
                Calendar calendar1 = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = sdf.format(calendar1.getTime());
                if (month < 13) {
                    month = month + 1;
                }
                String Date = Day + "/" + month + "/" + Year;
                String Time = hours + ":" + minute;
                btnNgay.setText(currentDate);

            }
        });
    }


}