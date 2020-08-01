package com.example.ht_422;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsDataAdapter extends BaseAdapter {

    private static final String TAG = "MyApp";
    private List<ItemData> items;
    private LayoutInflater inflater;

    ItemsDataAdapter(Context context, List<ItemData> items) {
        if (items == null)
            this.items = new ArrayList<>();
        else
            this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(ItemData item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ItemData getItem(int position) {
        if (position < items.size())
            return items.get(position);
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.item_list_view, parent, false);

        ItemData itemData = items.get(position);

        ImageView image = view.findViewById(R.id.image);
        TextView text = view.findViewById(R.id.mainText);
        TextView subText = view.findViewById(R.id.subText);
        Button button = view.findViewById(R.id.button);

        image.setImageDrawable(itemData.getImage());
        text.setText(itemData.getText());
        subText.setText(itemData.getSubText());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Кнопочка нажата");
                items.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
