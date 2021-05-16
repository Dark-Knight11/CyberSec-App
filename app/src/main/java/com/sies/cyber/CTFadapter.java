package com.sies.cyber;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CTFadapter extends RecyclerView.Adapter<CTFadapter.myViewHolder>{
    List<CtfsInfo> res;

    public CTFadapter(List<CtfsInfo> res) {
        this.res = res;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ctf_grid,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.start_time.setText(res.get(position).getStart());
        holder.main_link.setText(res.get(position).getTitle());
        holder.end_time.setText(res.get(position).getFinish());
        holder.url = res.get(position).getCtftime_url();
    }

    @Override
    public int getItemCount() {
        return res.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView start_time,main_link,end_time;
        String url;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            start_time = itemView.findViewById(R.id.start_time);
            main_link = itemView.findViewById(R.id.main_link);
            end_time = itemView.findViewById(R.id.end_time);
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            view.getContext().startActivity(i);
        }
    }
}
