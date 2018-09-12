package shread.robert.tabletopgangroster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SkillsAdapter extends ArrayAdapter<Table_Skills>
{
    public SkillsAdapter(Context context, ArrayList<Table_Skills> skills)
    {
        super(context, 0, skills);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Table_Skills skill = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.skillviewtemplate, parent, false);
        }

        // Lookup view for data population
        TextView tvName = convertView.findViewById(R.id.skillName);
        TextView tvText = convertView.findViewById(R.id.skillText);

        // Populate the data into the template view using the data object
        tvName.setText(skill.Get_Skill_Name());
        tvText.setText(skill.Get_Skill_Text());

        // Return the completed view to render on screen
        return convertView;
    }
}
