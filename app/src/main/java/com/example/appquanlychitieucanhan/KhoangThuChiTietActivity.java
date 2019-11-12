package com.example.appquanlychitieucanhan;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class KhoangThuChiTietActivity extends AppCompatActivity {

    TextView ngay,taikhoan,sotien,loaithu,mota;


    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoang_thu_chi_tiet);

        ngay=findViewById(R.id.ngay);
        taikhoan=findViewById(R.id.taikhoan);
        sotien=findViewById(R.id.sotien);
        loaithu=findViewById(R.id.loaithu);
        mota=findViewById(R.id.mota);
        String Nameloaithu=getIntent().getStringExtra("loaithu");
        collapsingToolbarLayout=findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        collapsingToolbarLayout.setTitle(Nameloaithu);

        toolbar=findViewById(R.id.toolbar_order);
        setSupportActionBar(toolbar);
       
        ngay.setText(getIntent().getStringExtra("ngay"));
        taikhoan.setText(getIntent().getStringExtra("taikhoan"));

        sotien.setText(getIntent().getStringExtra("sotien"));

        loaithu.setText(Nameloaithu);
        mota.setText(getIntent().getStringExtra("mota"));

    }

    private void setSupportActionBar(Toolbar toolbar) {
        if(getSupportActionBar() !=null)
        {
            Drawable drawable= ResourcesCompat.getDrawable(this.getResources(), R.drawable.ic_arrow_back_black_24dp, null);

            //custom color
            drawable.setColorFilter(ResourcesCompat.getColor(this.getResources(), R.color.colorAccent, null), PorterDuff.Mode.SRC_IN);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(drawable);

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
