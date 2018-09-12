package shread.robert.tabletopgangroster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditSkills extends AppCompatActivity
{

    String FighterBeingViewed;
    Table_Fighters thisFighter;
    String thisSkillCSV;
    ArrayList<Table_Skills> thisFightersSkills = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_skills);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s Skills");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        //Get this fighter's weaponCSV
        //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());
        thisSkillCSV = thisFighter.Get_Current_Skills();

        //Log.i("Edit Skills Log","thisSkillCSV = " + thisSkillCSV);
        //Log.i("Edit Skills Log", "Allowed Skills = " + thisFighter.Get_Allowed_Skills());

        if(thisSkillCSV !=null && !thisSkillCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisSkillCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersSkills.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Skills_Dao().getSkillByName(items.get(i)));
            }

            final ListView SkillListView = findViewById(R.id.editSkillsList);

            SkillsAdapter skillsAdapter = new SkillsAdapter(this, thisFightersSkills);

            SkillListView.setAdapter(skillsAdapter);
        }
    }

    public void clickAddSkill(View view)
    {
        Intent addSkillIntent = new Intent(getApplicationContext(), AddSkill.class);
        String FighterName = FighterBeingViewed;
        addSkillIntent.putExtra("Fighter_Name", FighterName);
        addSkillIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(addSkillIntent);
        finish();
    }

    public void clickRemoveSkill(View view)
    {
        Intent removeSkillIntent = new Intent(getApplicationContext(), RemoveSkill.class);
        String FighterName = FighterBeingViewed;
        removeSkillIntent.putExtra("Fighter_Name", FighterName);
        removeSkillIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(removeSkillIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
        String FighterName = FighterBeingViewed;
        intent.putExtra("Fighter_Name", FighterName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
