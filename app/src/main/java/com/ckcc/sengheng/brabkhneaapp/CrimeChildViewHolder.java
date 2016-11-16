package com.ckcc.sengheng.brabkhneaapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by HP on 16-Nov-16.
 */

public class CrimeChildViewHolder extends ChildViewHolder {

    public TextView mCrimeDateText;
    public CheckBox mCrimeSolvedCheckBox;

    public CrimeChildViewHolder(View itemView) {
        super(itemView);

        mCrimeDateText = (TextView) itemView.findViewById(R.id.child_list_item_crime_date_text_view);
        mCrimeSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.child_list_item_crime_solved_check_box);
    }
}