package com.example.tuan4lab3recycrview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseAdapter adapter;
    private List<MonHoc> courseList;
    Button btnAddMonHoc;
    EditText edtmaMonHoc,edttenMonHoc,edtGiangVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseList = new ArrayList<>();
        courseList.add(new MonHoc("CMP454", "Lap Trinh Di Dong", "Nguyen Huy Cuong", R.drawable.image1));
        adapter = new CourseAdapter(this, courseList);
        recyclerView.setAdapter(adapter);
        btnAddMonHoc = findViewById(R.id.btnAddMonHoc);
        btnAddMonHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddMonHocDialog();
            }
        });

    }
    private void openAddMonHocDialog () {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.add_monhoc);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        final EditText edtMaMonHoc = dialog.findViewById(R.id.edtMaMonHoc);
        final EditText edtTenMonHoc = dialog.findViewById(R.id.edtTenMonHoc);
        final EditText edtGiangVien = dialog.findViewById(R.id.edtGiangVien);

        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ EditText
                String maMonHoc = edtMaMonHoc.getText().toString();
                String tenMonHoc = edtTenMonHoc.getText().toString();
                String giangVien = edtGiangVien.getText().toString();

                // Kiểm tra xem có thông tin đầy đủ không
                if (!maMonHoc.isEmpty() && !tenMonHoc.isEmpty() && !giangVien.isEmpty()) {
                    // Tạo đối tượng MonHoc từ thông tin đã nhập và thêm vào courseList
                    courseList.add(new MonHoc(maMonHoc, tenMonHoc, giangVien, R.drawable.image1));
                    // Thông báo cho Adapter biết dữ liệu đã thay đổi
                    adapter.notifyDataSetChanged();

                    // Đóng Dialog sau khi thêm xong
                    dialog.dismiss();
                } else {
                    // Hiển thị thông báo lỗi nếu thông tin chưa đầy đủ
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Hiển thị Dialog
        dialog.show();
    }
}