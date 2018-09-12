package shread.robert.tabletopgangroster;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSkill extends AppCompatActivity
{
    String FighterBeingViewed;
    Table_Fighters thisFighter;
    String thisSkillCSV;
    ArrayList<Table_Skills> thisFightersSkills = new ArrayList<>();
    String SkillName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_skill);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        setTitle("Remove " + FighterBeingViewed + "'s Skills");

        //Get this fighter's weaponCSV
        //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());
        thisSkillCSV = thisFighter.Get_Current_Skills();

        //Log.i("View Fighter Log","thisSkillCSV = " + thisSkillCSV);

        if(thisSkillCSV !=null && !thisSkillCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisSkillCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersSkills.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Skills_Dao().getSkillByName(items.get(i)));
            }

            final ListView SkillListView = findViewById(R.id.removeSkillList);

            SkillsAdapter skillsAdapter = new SkillsAdapter(this, thisFightersSkills);

            SkillListView.setAdapter(skillsAdapter);

            SkillListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                    SkillName = thisFightersSkills.get(position).Get_Skill_Name();

                    //Sanity Toast
                    //Toast.makeText(getApplicationContext(),"Click: " + WeaponName, Toast.LENGTH_SHORT).show();


                    //*** ALERT***
                    AlertDialog.Builder alert = new AlertDialog.Builder(RemoveSkill.this);

                    alert.setMessage(SkillName);

                    alert.setTitle("Remove the following skill from " + FighterBeingViewed + "?");

                    alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            //Get and update record for this fighterName / gangName

                            //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());

                            //Log.i("RemoveSkill","thisSkillCSV after DB read: " + thisSkillCSV);

                            thisSkillCSV = thisSkillCSV.replaceFirst(SkillName,"");
                            thisSkillCSV = thisSkillCSV.replace(",,",",");
                            thisSkillCSV = thisSkillCSV.replaceAll(",$", "");
                            //Log.i("RemoveSkill","Branch A. thisSkillCSV now = " + thisSkillCSV);

                            thisFighter.Set_Current_Skills(thisSkillCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);

                            //Log.i("RemoveSkill","thisSkillCSV after DB write: " + thisSkillCSV);

                            Toast.makeText(getApplicationContext(),SkillName + " Removed", Toast.LENGTH_SHORT).show();

                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                            overridePendingTransition(0, 0);
                        }
                    });

                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            // Do nothing
                        }
                    });

                    alert.show();
                }

            });
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent Intent = new Intent(getApplicationContext(), EditSkills.class);
        String FighterName = FighterBeingViewed;
        Intent.putExtra("Fighter_Name", FighterName);
        Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Intent);
        finish();
    }
}
