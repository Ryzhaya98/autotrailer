package com.shopapp.autotrailer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shopapp.autotrailer.R;
import com.shopapp.autotrailer.activities.ActivityHistory;
import com.shopapp.autotrailer.models.History;
import com.shopapp.autotrailer.utilities.Utils;

import java.util.List;

public class RecyclerAdapterHistory extends RecyclerView.Adapter<RecyclerAdapterHistory.ViewHolder> {

    private Context context;
    private List<History> arrayItemCart;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_purchase_code;
        TextView txt_order_date;
        TextView txt_order_total;

        public ViewHolder(View view) {
            super(view);
            txt_purchase_code = view.findViewById(R.id.txt_purchase_code);
            txt_order_date = view.findViewById(R.id.txt_order_date);
            txt_order_total = view.findViewById(R.id.txt_order_total);
        }

    }

    public RecyclerAdapterHistory(Context context, List<History> arrayItemCart) {
        this.context = context;
        this.arrayItemCart = arrayItemCart;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txt_purchase_code.setText(ActivityHistory.code.get(position));
        holder.txt_order_date.setText(Utils.getFormatedDateSimple(ActivityHistory.date_time.get(position)));
        holder.txt_order_total.setText(ActivityHistory.order_total.get(position));

    }

    @Override
    public int getItemCount() {
        return ActivityHistory.id.size();
    }

}
