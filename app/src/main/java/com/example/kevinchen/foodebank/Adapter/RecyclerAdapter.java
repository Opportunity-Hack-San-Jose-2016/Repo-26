package com.example.kevinchen.foodebank.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinchen.foodebank.Model.Site;
import com.example.kevinchen.foodebank.R;

/**
 * Created by kevinchen on 7/9/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{

    Site[] mSites;
    Context mContext;

    public RecyclerAdapter(Context context, Site[] sites) {
        mContext = context;
        mSites = sites;
    }

    @Override
    //create each item holder
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    //bind fields to the view.
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bindHour(mSites[position]);
    }

    @Override
    public int getItemCount() {
        return mSites.length;
    }

    //view holder for each item. using layout hourly_list_item.xml
    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        private TextView mTemperatureLabel, mSummary, mTime;
        private ImageView mIconImageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //initialize all fields, get references to all components
            //used to be done by inflater
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mSummary = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTime = (TextView) itemView.findViewById(R.id.timeLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String time = mTime.getText().toString();
            String summary = mSummary.getText().toString();
            String temp = mTemperatureLabel.getText().toString();
            String msg = String.format("At %s it will be %s degree and %s",
                    time, temp, summary);
            Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
        }

        public void bindHour(Site hour) {
            //update ui
//            mTemperatureLabel.setText(hour.getTemperature()+"");
//            mSummary.setText(hour.getSummary());
//            mIconImageView.setImageResource(hour.getIconId());
//            mTime.setText(hour.getHour());
        }
    }
}
