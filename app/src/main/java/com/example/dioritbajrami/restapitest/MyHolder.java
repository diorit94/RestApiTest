package com.example.dioritbajrami.restapitest;

import android.view.View;
import android.widget.TextView;

/**
 * Created by dioritbajrami on 13.04.18.
 */


public class MyHolder {

    TextView name;

    public MyHolder(View itemView) {

        name= (TextView) itemView.findViewById(R.id.list_item_text);

    }

}
