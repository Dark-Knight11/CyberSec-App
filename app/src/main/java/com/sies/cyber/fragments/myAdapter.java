package com.sies.cyber.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sies.cyber.R;
import com.sies.cyber.Topic_Application_Security;
import com.sies.cyber.Topic_Cloud_Security;
import com.sies.cyber.Topic_Data_Security;
import com.sies.cyber.Topic_Linux_Essentials;
import com.sies.cyber.Topic_WAPT_Security;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{

    ArrayList<DataModel> dataHolder;

    public myAdapter(ArrayList<DataModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_grid,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.image.setImageResource(dataHolder.get(position).getImage());
        //holder.title.setText(dataHolder.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        //TextView title;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            //title = itemView.findViewById(R.id.textView);

            //itemView.setOnClickListener(view -> Toast.makeText(view.getContext(),"Clicked on " + getAdapterPosition(),Toast.LENGTH_SHORT).show());
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            switch (getAdapterPosition()) {
                case 0:
                    view.getContext().startActivity(new Intent(view.getContext(), Topic_Application_Security.class));
                    break;
                case 1:
                    view.getContext().startActivity(new Intent(view.getContext(), Topic_Cloud_Security.class));
                    break;
                case 2:
                    view.getContext().startActivity(new Intent(view.getContext(), Topic_Data_Security.class));
                    break;
                case 3:
                    view.getContext().startActivity(new Intent(view.getContext(), Topic_Linux_Essentials.class));
                    break;
                case 4:
                    view.getContext().startActivity(new Intent(view.getContext(), Topic_WAPT_Security.class));
                    break;


            }

        }
    }
}
