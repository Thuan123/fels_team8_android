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
 * Created by tranngoclinh on 11/23/15.
 */
public class ItemCategoryAdapter extends
        RecyclerView.Adapter<ItemCategoryAdapter.ViewHolder> {
    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameCategory;
        public TextView tvProgressCategory;
        public TextView tvWordCategory;
        public ImageView ivView;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvNameCategory = (TextView) itemView.findViewById(R.id.tv_category_name);
            tvProgressCategory = (TextView) itemView.findViewById(R.id.tv_category_progress);
            tvWordCategory = (TextView) itemView.findViewById(R.id.tv_category_word);
            ivView = (ImageView) itemView.findViewById(R.id.iv_rc_catergory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }

    private List<ItemCategory> mItemList;

    public ItemCategoryAdapter(List<ItemCategory> itemList) {
        mItemList = itemList;
    }

    @Override
    public ItemCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View categoryView = inflater.inflate(R.layout.item_category, parent, false);

        ViewHolder viewHolder = new ViewHolder(categoryView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemCategory itemCategory = mItemList.get(position);

        // Set item views based on the data model
        TextView tvNameCate = holder.tvNameCategory;
        tvNameCate.setText(itemCategory.getNameCategory());

        TextView tvProcess = holder.tvProgressCategory;
        tvProcess.setText(itemCategory.getProgressCategory());

        TextView tvWordCate = holder.tvWordCategory;
        tvWordCate.setText(itemCategory.getWordCategory());

        ImageView imageView = holder.ivView;
        imageView.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

}

