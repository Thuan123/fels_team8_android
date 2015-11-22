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
public class ItemLearnedAdapter extends
        RecyclerView.Adapter<ItemLearnedAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCategories;
        public TextView tvDate;
        public ImageView ivView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCategories = (TextView) itemView.findViewById(R.id.tv_rc_catergory);
            tvDate = (TextView) itemView.findViewById(R.id.tv_rc_date);
            ivView = (ImageView) itemView.findViewById(R.id.iv_rc_catergory);
        }
    }

    private List<ItemLearned> mItemList;

    public ItemLearnedAdapter(List<ItemLearned> itemList) {
        mItemList = itemList;
    }

    @Override
    public ItemLearnedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View learnedView = inflater.inflate(R.layout.item_learned, parent, false);
        ViewHolder viewHolder = new ViewHolder(learnedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemLearned itemLearned = mItemList.get(position);

        TextView tvCate = holder.tvCategories;
        tvCate.setText(itemLearned.getCategoriesLearned());

        TextView tvDat = holder.tvDate;
        tvDat.setText(itemLearned.getDateLearned());

        ImageView imageView = holder.ivView;
        imageView.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

}

