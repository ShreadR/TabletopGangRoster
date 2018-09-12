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

public class AddSkill extends AppCompatActivity
{

    String FighterBeingViewed;
    Table_Fighters thisFighter;
    String allowedSkillsCSV;
    ArrayList<Table_Skills> allowedSkills = new ArrayList<>();
    String SkillName;
    String thisSkillCSV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skill);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s New Skill");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);
        allowedSkillsCSV = thisFighter.Get_Allowed_Skills();
        //Log.i("Add Skills Log","allowedSkillsCSV = "+allowedSkillsCSV);

        List<String> items = Arrays.asList(allowedSkillsCSV.split(","));
        //Log.i("Add Skills Log","items.size = "+items.size());

        // Get skill names by category
        for(int i = 0; i < items.size(); i++)
        {
            allowedSkills.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Skills_Dao().getSkillsByCategory(items.get(i)));
        }

        final ListView SkillListView = findViewById(R.id.fighterSkillList);

        SkillsAdapter skillsAdapter = new SkillsAdapter(this, allowedSkills);

        SkillListView.setAdapter(skillsAdapter);

        SkillListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                SkillName = allowedSkills.get(position).Get_Skill_Name();

                //Sanity Toast
                //Toast.makeText(getApplicationContext(),"Click: " + WeaponName, Toast.LENGTH_SHORT).show();


                //*** ALERT***
                AlertDialog.Builder alert = new AlertDialog.Builder(AddSkill.this);

                alert.setMessage(SkillName);

                alert.setTitle("Add the following skill to " + FighterBeingViewed + "?");

                alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        //Get and update record for this fighterName / gangName

                        thisSkillCSV = thisFighter.Get_Current_Skills();

                        //Log.i("AddSkill","thisSkillCSV after DB read: " + thisSkillCSV);

                        if(thisSkillCSV !=null && !thisSkillCSV.isEmpty())
                        {
                            thisSkillCSV += "," + SkillName;
                            //Log.i("AddSkill","Branch A. thisSkillCSV now = " + thisSkillCSV);
                            thisFighter.Set_Current_Skills(thisSkillCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
                        }
                        else
                        {
                            thisSkillCSV = SkillName;
                            //Log.i("AddSkill","Branch B. thisSkillCSV now = " + thisSkillCSV);
                            thisFighter.Set_Current_Skills(thisSkillCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
                        }

                        //Log.i("AddSkill","thisSkillCSV after DB write: " + thisSkillCSV);

                        Toast.makeText(getApplicationContext(),SkillName + " Added", Toast.LENGTH_SHORT).show();
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
