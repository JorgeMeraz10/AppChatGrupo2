package com.example.appchatgrupo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.Group;

import java.util.ArrayList;
import java.util.List;

public class GruposCustomAdapter extends ArrayAdapter<Grupos> {
    private List<Grupos> groups;
    private Context context;

    public GruposCustomAdapter(Context context, ArrayList<Grupos> groups) {
        super(context, R.layout.list_item_grupos, groups);
        this.context = context;
        this.groups = groups;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_grupos, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.icon = view.findViewById(R.id.image_view_icon);
            viewHolder.name = view.findViewById(R.id.text_view_name);
            viewHolder.participants = view.findViewById(R.id.text_view_participants);
            viewHolder.buttonMore = view.findViewById(R.id.button_more);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Grupos group = groups.get(position);
        viewHolder.name.setText(group.getName());
        viewHolder.participants.setText(context.getResources().getQuantityString(R.plurals.participants, group.getParticipants(), group.getParticipants()));
       viewHolder.buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar la acción del botón "Agregar"
            }
        });

        return view;
    }

    static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView participants;
        ImageView buttonMore;
    }
}
