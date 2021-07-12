package com.androidbatch.onlineretrofittest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    List<ImageDetailsModel> list;
    Context context;

    public ImageAdapter(List<ImageDetailsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image, parent, false);
        ImageViewHolder imgviewholder = new ImageViewHolder(view);
        return imgviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ImageDetailsModel img = list.get(position);
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=25";


        Glide.with(context)
                .load(img.getUrl())
                .centerCrop()
                .into(holder.imgview_images);

        holder.imgview_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ImageDetailsActivity.class);
                intent.putExtra("date",img.date);
                intent.putExtra("",img.explanation);
                intent.putExtra("",img.hdurl);
                intent.putExtra("",img.url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imgview_images;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview_images = itemView.findViewById(R.id.layout_img);
        }
    }
}
