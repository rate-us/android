package com.example.androidratethem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<Image> images;
    private FeedActivity feedActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public Button mLikeButton;

        public ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textView2);
            mImageView = v.findViewById(R.id.imageView);
            mLikeButton = v.findViewById(R.id.likeButton);
        }
    }

    public ImageAdapter(ArrayList<Image> images, FeedActivity activity) {
        this.images = images;
        feedActivity = activity;
    }

    // Create new views
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Image image = (Image) images.get(position);
        if (image.user != null) {
            holder.mTextView.setText(image.user.displayName);
        }
        Picasso.get().load(image.downloadUrl).into(holder.mImageView);
        holder.mLikeButton.setText("Like (" + image.likes + ")");
        if(image.hasLiked) {
            holder.mLikeButton.setBackgroundColor(feedActivity.getResources().getColor(R.color.colorAccent));
        } else {
            holder.mLikeButton.setBackgroundColor(feedActivity.getResources().getColor(R.color.colorPrimary));
        }
        holder.mLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               feedActivity.setLiked(image);
            }
        });
    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return images.size();
    }

    public void addImage(Image image) {
        images.add(0, image);
        notifyDataSetChanged();
    }
}