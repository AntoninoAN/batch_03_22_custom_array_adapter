package com.example.activityfragmentcomm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<TodoTask> {

    public CustomAdapter(@NonNull Context context, List<TodoTask> dataSet) {
        super(context, 0, dataSet);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        View currentView = convertView;

        if (currentView == null)
            currentView = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_2,
                            parent,
                            false);
        TodoTask currentElement = getItem(position);

        onBind(currentElement, currentView);

        return currentView;
    }

    private void onBind(TodoTask currentElement, View currentView) {
        ((TextView) currentView.findViewById(android.R.id.text1)).setText(
                currentElement.getTodoName()
        );
        ((TextView) currentView.findViewById(android.R.id.text2)).setText(
                currentElement.getTodoCategory()
        );
    }
}
