package com.laioffer.matrix.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.laioffer.matrix.Item;
import com.laioffer.matrix.R;

import java.util.List;

/**
 * Created by danningzhang on 9/29/18.
 */

public class ReportRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> mItems;
    private LayoutInflater mInflater;
    private OnItemClickListener mClickListener;

    public ReportRecyclerViewAdapter(Context context, List<Item> items) {
        this.mInflater = LayoutInflater.from(context);
        this.mItems = items;
    }

    //Observer pattern
    public interface OnItemClickListener{
        public void setItem(String item);
    }

    //Set OnItemClickListener implementation to private field mClickListener
    public void setItemClickListener(OnItemClickListener callback) {
        mClickListener = callback;
    }

    /**
     * Step1 : declare the view holder structure
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;
        View view;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            mTextView = (TextView) itemView.findViewById(R.id.info_text);
            mImageView = (ImageView) itemView.findViewById(R.id.info_img);
        }
    }
    /**
     * Step 2: create holder prepare listview to show
     * @param parent the listview
     * @param viewType view type
     * @return created view holder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * Step 3: render view holder on screen
     * @param holder view holder created by onCreateViewHolder
     * @param position corresponding position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.mTextView.setText(mItems.get(position).getDrawable_lable());
        viewHolder.mImageView.setImageResource(mItems.get(position).getDrawable_id());
        //pass out Item information(i.e. position) to real implementation of OnClickListener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.setItem(mItems.get(position).getDrawable_lable());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
