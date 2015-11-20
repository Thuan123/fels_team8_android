package group8.com.e_learning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tranngoclinh on 11/20/15.
 */
public class ItemResultAdapter extends
        RecyclerView.Adapter<ItemResultAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvWord, tvMeaning;
        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = (TextView) itemView.findViewById(R.id.tv_reuslt_word);
            tvMeaning = (TextView) itemView.findViewById(R.id.tv_reuslt_mean);
            imageView = (ImageView) itemView.findViewById(R.id.iv_result);
        }
    }

    private List<ItemResult> mItemList;

    public ItemResultAdapter(List<ItemResult> itemList) {
        mItemList = itemList;
    }

    @Override
    public ItemResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View learnedView = inflater.inflate(R.layout.item_result, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(learnedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemResult itemResult = mItemList.get(position);

        // Set item views based on the data model
        TextView tvWor = holder.tvWord;
        tvWor.setText(itemResult.getWord());

        TextView tvMean = holder.tvMeaning;
        tvMean.setText(itemResult.getMeanning());

        ImageView ivRe = holder.imageView;
        ivRe.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}

