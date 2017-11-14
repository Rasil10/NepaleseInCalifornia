package sunbidemo.nepaleseincalifornia;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rasil10 on 2017-11-13.
 */

public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem> {


    Context context;

    public CustomDrawerAdapter(Activity context, ArrayList<DrawerItem> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_drawer_item, parent, false);
        }


        final DrawerItem currentNavItem = getItem(position);

        TextView itemTextView = (TextView) listItemView.findViewById(R.id.drawerItemTextView);
        ImageView itemImageView = (ImageView) listItemView.findViewById(R.id.drawerItemImageView);

        itemTextView.setText(currentNavItem.getItemName());
        itemImageView.setImageResource(currentNavItem.getImgResID());


        return listItemView;
    }


}
