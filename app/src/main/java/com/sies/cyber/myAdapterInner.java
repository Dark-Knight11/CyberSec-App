package com.sies.cyber;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
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
            if(topic.equals("Application Security")) {  //don't use switch
                switch (getAdapterPosition()) {
                    case 0:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 2:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 3:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 4:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                }
            }
            else if(topic.equals("Cloud Security")) {
                switch (getAdapterPosition()) {
                    case 0:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 2:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 3:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 4:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                }
            }
            else if(topic.equals("Data Security")) {
                switch (getAdapterPosition()) {
                    case 0:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 2:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 3:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 4:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                }
            }
            else if(topic.equals("Linux Essentials")) {
                switch (getAdapterPosition()) {
                    case 0:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 2:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 3:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 4:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                }
            }
            else if(topic.equals("Web App Pen-Testing")) {
                switch (getAdapterPosition()) {
                    case 0:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 2:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 3:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                    case 4:
                        view.getContext().startActivity(new Intent(view.getContext(), ASTopic1.class));
                        break;
                }
            }
        }
    }
}
