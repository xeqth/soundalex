package com.example.user.soundalex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.soundboardalex.R;

import java.util.ArrayList;

public class SoundAdapter extends ArrayAdapter<Sound> {
    private ArrayList<Sound> items;
    private Context c = null;
    public SoundAdapter(Context context, int textViewResourceId, ArrayList<Sound> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.c = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_row, null);
        }
        Sound s = items.get(position);
        if (s != null) {
            TextView description = (TextView) v.findViewById(R.id.description);
            if (description != null) {
                description.setText(s.getDescription());
            }
            ImageView icon = (ImageView) v.findViewById(R.id.icon);
            icon.setImageResource(s.getIconResourceId());
        }
        return v;
    }
}