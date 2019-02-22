package com.example.traniningproject.Adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.traniningproject.Model.StudentListGetSet;
import com.example.traniningproject.R;

import java.util.ArrayList;

public class studentListAdaptor extends RecyclerView.Adapter<studentListAdaptor.ViewHolder> {

    private Context context;
    private ArrayList<StudentListGetSet> list;

    public studentListAdaptor(Context context, ArrayList<StudentListGetSet> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_student_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.eno.setText(String.valueOf(list.get(i).getEno()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,eno;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.student_nameTV);
            eno = (TextView) itemView.findViewById(R.id.enrollmentTV);

        }
    }
}
