package com.example.dioritbajrami.restapitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dioritbajrami on 13.04.18.
 */

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {

    private Context context;
    private List<GitHubRepo> values;
    LayoutInflater inflater;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int i, View convertview, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertview == null) {
            convertview = inflater.inflate(R.layout.list_item_pagination, viewGroup, false);
        }

        final MyHolder holder = new MyHolder(convertview);

        GitHubRepo item = values.get(i);
        String message = item.getName();
        holder.name.setText(message);

        return convertview;
    }
}