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
 * Created by tranngoclinh on 11/22/15.
 */
public class ItemCategoryAdapter extends
        RecyclerView.Adapter<ItemCategoryAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameCategory;
        public TextView progress;
        public TextView listWords;
        public ImageView ivCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            nameCategory = (TextView) itemView.findViewById(R.id.tv_catergory);
            progress = (TextView) itemView.findViewById(R.id.tv_category_progress);
            listWords = (TextView) itemView.findViewById(R.id.tv_catergory_word);
            ivCategory = (ImageView) itemView.findViewById(R.id.iv_rc_catergory);
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
        View learnedView = inflater.inflate(R.layout.item_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(learnedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemCategory itemCategory = mItemList.get(position);

        TextView tvNameCate = holder.nameCategory;
        tvNameCate.setText(itemCategory.getNameCatergory());

        TextView tvProgress = holder.progress;
        tvProgress.setText(itemCategory.getProgress());

        TextView tvListW = holder.listWords;
        tvProgress.setText(itemCategory.getListWord());

        ImageView imageView = holder.ivCategory;
        imageView.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
