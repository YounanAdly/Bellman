package com.example.android.bellman.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.bellman.Model.Event;
import com.example.android.bellman.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    Context context;
    ArrayList<Event> mList;

    public EventAdapter(Context context, ArrayList<Event> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.MyViewHolder holder, int position) {

        if (mList.size() >0) {
            if (mList.get(position).getName().length() > 0) {

                holder.name.setText(mList.get(position).getName());
            } else {
                holder.name.setText(R.string.notfound);
            }

            if (mList.get(position).getCategories().size() > 0) {
                holder.categories.setText(mList.get(position).getCategories().get(0).getName());
            } else {
                holder.categories.setText("NULL");
            }

            if (mList.get(position).getPhotos().size() > 0) {
                String image = mList.get(position).getPhotos().get(0);
                Picasso.with(context)
                        .load(image)
                        .placeholder(R.drawable.noimage)
                        .into(holder.mainImg);
            } else {
                Picasso.with(context)
                        .load(R.drawable.noimage)
                        .into(holder.mainImg);
            }
        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImg;
        TextView name, categories;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImg = (ImageView) itemView.findViewById(R.id.mainImg);
            name = (TextView) itemView.findViewById(R.id.name);
            categories = (TextView) itemView.findViewById(R.id.categories);
        }
    }
}
