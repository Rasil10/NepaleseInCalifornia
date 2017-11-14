package sunbidemo.nepaleseincalifornia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rasil10 on 2017-11-08.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.MyViewHolder> {
    List<News> newsList;
    Context context;

    public NewsRecyclerAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_recycler_item_list, parent, false);
        return new MyViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.contentTextView.setText(news.getNewsHeadline());

        holder.contentImageView.setImageResource(R.drawable.recycler_image);


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView contentTextView;
        ImageView contentImageView;

        public MyViewHolder(View view) {
            super(view);
            contentImageView = (ImageView) view.findViewById(R.id.mainImageView);
            contentTextView = (TextView) view.findViewById(R.id.mainTextView);
        }
    }
}

