package com.example.dioritbajrami.restapitest.GetDataFromServer;

import android.view.View;
import android.widget.TextView;

import com.example.dioritbajrami.restapitest.R;

/**
 * Created by dioritbajrami on 13.04.18.
 */


public class MyHolder {

    TextView name;

    public MyHolder(View itemView) {

        name= (TextView) itemView.findViewById(R.id.list_item_text);

    }

}
