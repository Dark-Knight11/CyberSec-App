package com.sies.cyber;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapterInner extends RecyclerView.Adapter<myAdapterInner.myViewHolder>{
    ArrayList<DataModelInner> dataHolder;

    public myAdapterInner(ArrayList<DataModelInner> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_topic_example,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(dataHolder.get(position).getTitle());
        holder.topic_no = dataHolder.get(position).getTopic_no();
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        int topic_no;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.activity_topic_title);
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            Intent intent;
            switch(topic_no){
                case 0:
                    intent = new Intent(view.getContext(), Network_Security.class);
                    break;
                case 1:
                    intent = new Intent(view.getContext(), Cloud_Security.class);
                    break;
                case 2:
                    intent = new Intent(view.getContext(), Data_Security.class);
                    break;
                case 3:
                    intent = new Intent(view.getContext(), Linux_Essentials.class);
                    break;
                case 4:
                    intent = new Intent(view.getContext(), WAPT_Security.class);
                    break;
                case 5:
                    intent = new Intent(view.getContext(), Application_Security.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + topic_no);
            }
            intent.putExtra("inTOPIC",getAdapterPosition());
            view.getContext().startActivity(intent);
        }
    }
}
