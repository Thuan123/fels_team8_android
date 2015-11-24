package group8.com.e_learning;

/**
 * Created by tranngoclinh on 11/20/15.
 */

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
public class ItemWordAdapter extends
        RecyclerView.Adapter<ItemWordAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvWord, tvMeaning;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = (TextView) itemView.findViewById(R.id.tv_word);
            tvMeaning = (TextView) itemView.findViewById(R.id.tv_meanning);
        }
    }

    private List<ItemWord> mItemList;

    public ItemWordAdapter(List<ItemWord> itemList) {
        mItemList = itemList;
    }

    @Override
    public ItemWordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View learnedView = inflater.inflate(R.layout.item_word, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(learnedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemWord itemLearned = mItemList.get(position);

        // Set item views based on the data model
        TextView tvWor = holder.tvWord;
        tvWor.setText(itemLearned.getWord());

        TextView tvMean = holder.tvMeaning;
        tvMean.setText(itemLearned.getMeaning());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

}

