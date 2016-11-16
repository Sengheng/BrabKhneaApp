package com.ckcc.sengheng.brabkhneaapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by HP on 16-Nov-16.
 */

public class CrimeParentViewHolder extends ParentViewHolder {

    public TextView mCrimeTitleTextView;
    public ImageButton mParentDropDownArrow;

    public CrimeParentViewHolder(View itemView) {
        super(itemView);

        mCrimeTitleTextView = (TextView) itemView.findViewById(R.id.parent_list_item_crime_title_text_view);
        mParentDropDownArrow = (ImageButton) itemView.findViewById(R.id.parent_list_item_expand_arrow);
    }
}