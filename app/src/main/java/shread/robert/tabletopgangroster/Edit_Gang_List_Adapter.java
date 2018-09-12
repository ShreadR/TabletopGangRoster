package shread.robert.tabletopgangroster;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import java.util.ArrayList;

public class Edit_Gang_List_Adapter extends ArrayAdapter<Table_Fighters>
{
    public Edit_Gang_List_Adapter(Context context, ArrayList<Table_Fighters> fighters)
    {
        super(context, 0, fighters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {


        // Get the data item for this position
        final Table_Fighters fighter = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fighterviewtemplate, parent, false);
        }

        // Lookup view for data population
        TextView fighterEntry = convertView.findViewById(R.id.fighterEntry);

        // Populate the data into the template view using the data object
        fighterEntry.setText(MakeFighterString(fighter));

        // Return the completed view to render on screen
        return convertView;


    }

    public String MakeFighterString(Table_Fighters thisFighter)
    {
        String thisFighterString = "";

        thisFighterString += thisFighter.Get_Fighter_Name();
        thisFighterString += ", ";
        thisFighterString += thisFighter.Get_Fighter_Type();
        thisFighterString += ", ";
        //thisFighterString += thisFighter.Get_Total_Value();
        //thisFighterString += "c, ";
        thisFighterString += thisFighter.Get_Experience();
        thisFighterString += " xp. ";
        thisFighterString += thisFighter.getReady();
        thisFighterString += ".";
        //thisFighterString += thisFighter.Get_Advancements();
        //thisFighterString += " advancements, ";
        //thisFighterString += thisFighter.Get_In_Recovery();
        //thisFighterString += ", ";
        //thisFighterString += thisFighter.Get_Captured_By();

        return thisFighterString;
    }
}
