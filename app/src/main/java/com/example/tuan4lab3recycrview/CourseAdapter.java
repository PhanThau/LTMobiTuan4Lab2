package com.example.tuan4lab3recycrview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private Context context;

    private List<MonHoc> courseList;
    public CourseAdapter(Context context, List<MonHoc> courseList){
        this.context=context;
        this.courseList=courseList;
    }
    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(context).inflate(R.layout.course_item,parent,false);
        return new CourseViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position){
        MonHoc monHoc = courseList.get(position);
        holder.courseCode.setText(monHoc.getMaMonHoc());
        holder.courseName.setText(monHoc.getTenMonHoc());
        holder.lecturerName.setText(monHoc.getTenGiangVien());
        holder.courseImage.setImageResource(monHoc.getHinhAnh());
    }
    @Override
    public int getItemCount(){
        return courseList.size();
    }
    public static class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView courseCode;
        TextView courseName;
        TextView lecturerName;
        ImageView courseImage;

        public CourseViewHolder(View itemView){
            super(itemView);
            courseCode=itemView.findViewById(R.id.course_code);
            courseName=itemView.findViewById(R.id.course_name);
            lecturerName=itemView.findViewById(R.id.lecturer_name);
            courseImage=itemView.findViewById(R.id.course_image);
        }
    }
}
