package shread.robert.tabletopgangroster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeaponsAdapter extends ArrayAdapter<Table_Weapons>
{
    public WeaponsAdapter(Context context, ArrayList<Table_Weapons> weapons) {
        super(context, 0, weapons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Table_Weapons weapon = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.weaponviewtemplate, parent, false);
        }
        // Lookup view for data population
        TextView tvName = convertView.findViewById(R.id.weaponName);
        TextView tvHome = convertView.findViewById(R.id.weaponStats);
        // Populate the data into the template view using the data object
        tvName.setText(weapon.getName());
        tvHome.setText(weapon.getStatBlock());
        // Return the completed view to render on screen
        return convertView;
    }
}
