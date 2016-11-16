package com.ckcc.sengheng.brabkhneaapp.adapter;

/**
 * Created by HP on 04-Nov-16.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ckcc.sengheng.brabkhneaapp.R;
import com.ckcc.sengheng.brabkhneaapp.container.Postal;

import java.util.List;

public class PostalsAdapter extends RecyclerView.Adapter<PostalsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Postal> postalList;

    private PostalAdapterListener postalAdapterListener;

    public void setPostalsAdapterListener(PostalAdapterListener postalAdapterListener){

        this.postalAdapterListener=postalAdapterListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView provinceKh, provinceEn;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            provinceKh = (TextView) view.findViewById(R.id.id_label_kh);
            provinceEn = (TextView) view.findViewById(R.id.id_label_en);
            thumbnail = (ImageView)view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    postalAdapterListener.onItemClick(getAdapterPosition());
                }
            });
            //overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public PostalsAdapter(Context mContext, List<Postal> postalList) {
        this.mContext = mContext;
        this.postalList = postalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.postal_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Postal postal = postalList.get(position);
        holder.provinceKh.setText(postal.getProvinceKh());
        holder.provinceEn.setText(postal.getProvinceEn());

        // loading postal cover using Glide library
        Glide.with(mContext).load(postal.getThumbnail()).into(holder.thumbnail);
        //holder.thumbnail.setBackgroundColor(postal.getItemColor());
        //holder.itemView.setBackgroundColor(postal.getItemColor());
        //holder.thumbnail.setText(postal.getThumbnail());

       /* holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return postalList.size();
    }
}