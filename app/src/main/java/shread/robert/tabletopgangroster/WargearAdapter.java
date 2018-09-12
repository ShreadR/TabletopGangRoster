package shread.robert.tabletopgangroster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WargearAdapter extends ArrayAdapter<Table_Wargear>
{
    public WargearAdapter(Context context, ArrayList<Table_Wargear> wargear)
    {
        super(context, 0, wargear);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Table_Wargear wargear = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.wargearviewtemplate, parent, false);
        }
        // Lookup view for data population
        TextView tvName = convertView.findViewById(R.id.wargearName);
        //TextView tvHome = convertView.findViewById(R.id.weaponStats);
        // Populate the data into the template view using the data object
        tvName.setText(wargear.getWargear_Name());
        //tvHome.setText(weapon.getStatBlock());
        // Return the completed view to render on screen
        return convertView;
    }
}