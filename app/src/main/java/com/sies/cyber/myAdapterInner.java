package com.sies.cyber;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        holder.topic_no = dataHolder.get(position).getTopic_no();
        holder.image.setImageResource(dataHolder.get(position).getLock());
        holder.score = dataHolder.get(position).getScore();
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        int topic_no;
        ImageView image;
        int score;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.activity_topic_title);
            image = itemView.findViewById(R.id.lock);
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            Intent intent;
            switch(topic_no){
                case 0:
                    if (score<10)
                        Toast.makeText(view.getContext(),"Insufficient Score!",Toast.LENGTH_SHORT).show();

                    else
                    {
                        intent = new Intent(view.getContext(), Network_Security.class);
                        intent.putExtra("inTOPIC",getAdapterPosition());
                        view.getContext().startActivity(intent);
                    }

                    break;
                case 1:
                    if (score<5)
                        Toast.makeText(view.getContext(),"Insufficient Score!",Toast.LENGTH_SHORT).show();

                    else
                    {
                        intent = new Intent(view.getContext(), Cloud_Security.class);
                        intent.putExtra("inTOPIC",getAdapterPosition());
                        view.getContext().startActivity(intent);
                    }
                    break;
                case 2:
                    if (score<10)
                        Toast.makeText(view.getContext(),"Insufficient Score!",Toast.LENGTH_SHORT).show();

                    else
                    {
                        intent = new Intent(view.getContext(), Data_Security.class);
                        intent.putExtra("inTOPIC",getAdapterPosition());
                        view.getContext().startActivity(intent);
                    }
                    break;
                case 3:
                    if (score<10)
                        Toast.makeText(view.getContext(),"Insufficient Score!",Toast.LENGTH_SHORT).show();

                    else
                    {
                        intent = new Intent(view.getContext(), Linux_Essentials.class);
                        intent.putExtra("inTOPIC",getAdapterPosition());
                        view.getContext().startActivity(intent);
                    }
                    break;
                case 4:
                    if (score<10)
                        Toast.makeText(view.getContext(),"Insufficient Score!",Toast.LENGTH_SHORT).show();

                    else
                    {
                        intent = new Intent(view.getContext(), WAPT_Security.class);
                        intent.putExtra("inTOPIC",getAdapterPosition());
                        view.getContext().startActivity(intent);
                    }
                    break;
                case 5:
                    if (score<10)
                        Toast.makeText(view.getContext(),"Insufficient Score!",Toast.LENGTH_SHORT).show();

                    else
                    {
                        intent = new Intent(view.getContext(), Application_Security.class);
                        intent.putExtra("inTOPIC",getAdapterPosition());
                        view.getContext().startActivity(intent);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + topic_no);
            }


        }
    }
}
