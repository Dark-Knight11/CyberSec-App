package com.sies.cyber;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.description.setText(dataHolder.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.activity_topic_title);
            description = itemView.findViewById(R.id.activity_topic_description);


            itemView.setOnClickListener(view -> Toast.makeText(view.getContext(),"Clicked on " + getAdapterPosition(),Toast.LENGTH_SHORT).show());
//            itemView.setOnClickListener(this::onClick);
        }

//        private void onClick(View view) {
//            switch (getAdapterPosition()) {
//                case 0:
//                    view.getContext().startActivity(new Intent(view.getContext(), Topic_1.class));
//                    break;
//                case 1:
//                    view.getContext().startActivity(new Intent(view.getContext(), Topic_2.class));
//                    break;
//            }
//        }
    }
}
