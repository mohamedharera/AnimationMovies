package com.example.mohamed.volleyapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mohamed.volleyapp.R;
import com.example.mohamed.volleyapp.activities.AnimeActivity;
import com.example.mohamed.volleyapp.models.Anime;

import java.util.List;

/**
 * Created by Mohamed on 9/10/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Anime>mData;
    RequestOptions options;

    public RecyclerViewAdapter(Context context, List<Anime> mData) {
        this.context = context;
        this.mData = mData;

        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view= inflater.inflate(R.layout.animate_row_item,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);



        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AnimeActivity.class);
                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategory());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_epsiode",mData.get(viewHolder.getAdapterPosition()).getEpisode());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImg_url());

                context.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_category.setText(mData.get(position).getCategory());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getStudio());


        // load image from the internet and put it into ImageView using Glide

        Glide.with(context).load(mData.get(position).getImg_url()).apply(options).into(holder.img_thumbail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        ImageView img_thumbail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_studio = itemView.findViewById(R.id.studio);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_category = itemView.findViewById(R.id.category);
            img_thumbail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
