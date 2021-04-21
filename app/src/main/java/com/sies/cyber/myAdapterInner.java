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
    public static final String TOPIC = "com.sies.cyber.TOPIC";
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
        holder.description.setText(dataHolder.get(position).getDescription());
        holder.topic = dataHolder.get(position).getTopic();
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        String topic;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.activity_topic_title);
            description = itemView.findViewById(R.id.activity_topic_description);



            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            int number = getAdapterPosition();
            if(topic.equals("Application Security")) {  //don't use switch
                Intent intent = new Intent(view.getContext(), Topic1.class);
                intent.putExtra(TOPIC,number);
                view.getContext().startActivity(intent);
            }
            else if(topic.equals("Cloud Security")) {
                Intent intent = new Intent(view.getContext(), Topic2.class);
                intent.putExtra(TOPIC,number);
                view.getContext().startActivity(intent);
            }
            else if(topic.equals("Data Security")) {
                Intent intent = new Intent(view.getContext(), Topic3.class);
                intent.putExtra(TOPIC,number);
                view.getContext().startActivity(intent);
            }
            else if(topic.equals("Linux Essentials")) {
                Intent intent = new Intent(view.getContext(), Topic4.class);
                intent.putExtra(TOPIC,number);
                view.getContext().startActivity(intent);
            }
            else if(topic.equals("Web App Pen-Testing")) {
                Intent intent = new Intent(view.getContext(), Topic5.class);
                intent.putExtra(TOPIC,number);
                view.getContext().startActivity(intent);
            }
        }
    }
}
