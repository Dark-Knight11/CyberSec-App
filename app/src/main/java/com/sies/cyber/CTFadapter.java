package com.sies.cyber;

import android.graphics.Color;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CTFadapter extends RecyclerView.Adapter<CTFadapter.myViewHolder>{
    List<CtfsInfo> res;
    int count = 0;

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
        holder.main_link.setMovementMethod(LinkMovementMethod.getInstance());
        holder.main_link.setText(Html.fromHtml(getHyperLink(res.get(position).getTitle(),res.get(position).getCtftime_url())));
        holder.main_link.setMovementMethod(LinkMovementMethod.getInstance());
        holder.main_link.setLinkTextColor(Color.parseColor("#E3000B"));
        holder.end_time.setText(res.get(position).getFinish());
        holder.description.setText(res.get(position).getDescription());
    }

    private String getHyperLink(String title, String ctftime_url) {

        String str = "<a href='"+ctftime_url+"'>"+title+"</a>";
        return str;

    }

    @Override
    public int getItemCount() {
        return res.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView start_time,main_link,end_time,description;
        RelativeLayout description_box;
        String url;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            start_time = itemView.findViewById(R.id.start_time);
            main_link = itemView.findViewById(R.id.main_link);
            end_time = itemView.findViewById(R.id.end_time);
            description = itemView.findViewById(R.id.description);
            description_box = itemView.findViewById(R.id.description_box);
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            if (count%2==0)
                description_box.setVisibility(View.VISIBLE);
            else
                description_box.setVisibility(View.GONE);

            count++;



        }
    }
}
