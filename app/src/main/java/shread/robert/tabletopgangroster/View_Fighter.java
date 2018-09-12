package shread.robert.tabletopgangroster;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View_Fighter extends AppCompatActivity
{

    String FighterBeingViewed = "";
    String FighterStatBlock = "";
    TextView statBlock;
    TextView XPText;
    Table_Fighters ThisFighter;
    String thisWeaponCSV;
    ArrayList<Table_Weapons> thisFightersWeapons = new ArrayList<>();
    Button readyButton;
    String thisSkillCSV;
    ArrayList<Table_Skills> thisFightersSkills = new ArrayList<>();
    String thisWargearCSV;
    ArrayList<Table_Wargear> thisFightersWargear = new ArrayList<>();

    /*buttons
    buttonEditWeapons
    buttonEditWargear
    buttonEditWargear
    buttonEditSkills
    buttonEditStats
    buttonEditXP
    */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fighter);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed);

        statBlock = findViewById(R.id.statBlock);

        FighterStatBlock = createFighterStatBlock(FighterBeingViewed);

        statBlock.setText(FighterStatBlock);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        XPText = findViewById(R.id.xpTextView);
        ThisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);
        XPText.setText(String.valueOf(ThisFighter.Get_Experience()));

        //Get this fighter's weaponCSV
        //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(ThisFighter.Get_Fighter_Name(),ThisFighter.Get_Gang_Name());
        thisWeaponCSV = ThisFighter.getCurrent_Weapons();

        //Log.i("View Fighter Log","thisWeaponCSV = " + thisWeaponCSV);

        if(thisWeaponCSV !=null && !thisWeaponCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisWeaponCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersWeapons.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponByName(items.get(i)));
            }

            final ListView WeaponListView = findViewById(R.id.fighterWeaponList);

            WeaponsAdapter weaponsAdapter = new WeaponsAdapter(this, thisFightersWeapons);

            WeaponListView.setAdapter(weaponsAdapter);
        }

        thisSkillCSV = ThisFighter.Get_Current_Skills();

        if(thisSkillCSV !=null && !thisSkillCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisSkillCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersSkills.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Skills_Dao().getSkillByName(items.get(i)));
            }

            final ListView SkillListView = findViewById(R.id.fighterSkillsList);

            SkillsAdapter skillsAdapter = new SkillsAdapter(this, thisFightersSkills);

            SkillListView.setAdapter(skillsAdapter);
        }

        thisWargearCSV = ThisFighter.getCurrent_Wargear();

        if(thisWargearCSV !=null && !thisWargearCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisWargearCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersWargear.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Wargear_Dao().getWargearByName(items.get(i)));
            }

            final ListView WargearListView = findViewById(R.id.fighterWargearList);

            WargearAdapter wargearAdapter = new WargearAdapter(this, thisFightersWargear);

            WargearListView.setAdapter(wargearAdapter);
        }

        readyButton = findViewById(R.id.readyToggleButton);

        if (ThisFighter.getReady().equals("Ready"))
        {
            readyButton.setText(R.string.ready);
        }
        else if (ThisFighter.getReady().equals("Not Ready"))
        {
            readyButton.setText(R.string.notReady);
        }
        else
        {
            readyButton.setText("Error");
        }

    }

    public String createFighterStatBlock(String FighterBeingViewed)
    {
        String FighterStatBlock = "";

        Table_Fighters ThisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        FighterStatBlock += ThisFighter.Get_Movement();
        FighterStatBlock += "\"    ";
        FighterStatBlock += ThisFighter.Get_Weapon_Skill();
        FighterStatBlock += "+    ";
        FighterStatBlock += ThisFighter.Get_Ballistic_Skill();
        FighterStatBlock += "+    ";
        FighterStatBlock += ThisFighter.Get_Strength();
        FighterStatBlock += "    ";
        FighterStatBlock += ThisFighter.Get_Toughness();
        FighterStatBlock += "    ";
        FighterStatBlock += ThisFighter.Get_Wounds();
        FighterStatBlock += "    ";
        FighterStatBlock += ThisFighter.Get_Initiative();
        FighterStatBlock += "+    ";
        FighterStatBlock += ThisFighter.Get_Attacks();
        FighterStatBlock += "    ";
        FighterStatBlock += ThisFighter.Get_Leadership();
        FighterStatBlock += "+    ";
        FighterStatBlock += ThisFighter.Get_Cool();
        FighterStatBlock += "+    ";
        FighterStatBlock += ThisFighter.Get_Willpower();
        FighterStatBlock += "+    ";
        FighterStatBlock += ThisFighter.Get_Intelligence();
        FighterStatBlock += "+";

        return FighterStatBlock;
    }

    public void clickReadyToggleButton(View view)
    {
        readyButton = view.findViewById(R.id.readyToggleButton);

        if (ThisFighter.getReady().equals("Ready"))
        {
            readyButton.setText(R.string.notReady);
            ThisFighter.setReady("Not Ready");
        }
        else if (ThisFighter.getReady().equals("Not Ready"))
        {
            readyButton.setText(R.string.ready);
            ThisFighter.setReady("Ready");
        }
        else
        {
            readyButton.setText(R.string.ready);
            ThisFighter.setReady("Ready");
        }

        AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(ThisFighter);
        //finish();
        //startActivity(getIntent());
    }

    public void clickEditWeapons(View view)
    {
        //Edit Weapons for ThisFighter - new activity
        Intent editWeaponsIntent = new Intent(getApplicationContext(), EditWeapons.class);
        String FighterName = ThisFighter.Get_Fighter_Name();
        editWeaponsIntent.putExtra("Fighter_Name", FighterName);
        editWeaponsIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(editWeaponsIntent);
        finish();
    }

    public void clickEditWargear(View view)
    {
        //Edit Wargear for ThisFighter - new activity
        Intent editWargearIntent = new Intent(getApplicationContext(), EditWargear.class);
        String FighterName = ThisFighter.Get_Fighter_Name();
        editWargearIntent.putExtra("Fighter_Name", FighterName);
        editWargearIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(editWargearIntent);
        finish();
    }

    public void clickEditSkills(View view)
    {
        //Edit Skills for ThisFighter - new activity
        Intent editSkillsIntent = new Intent(getApplicationContext(), EditSkills.class);
        String FighterName = ThisFighter.Get_Fighter_Name();
        editSkillsIntent.putExtra("Fighter_Name", FighterName);
        editSkillsIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(editSkillsIntent);
        finish();
    }

    public void clickEditStats(View view)
    {
        //Edit Stats for ThisFighter - new activity
        Intent editStatsIntent = new Intent(getApplicationContext(), EditStats.class);
        String FighterName = ThisFighter.Get_Fighter_Name();
        editStatsIntent.putExtra("Fighter_Name", FighterName);
        editStatsIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(editStatsIntent);
        finish();
    }

    public void clickEditXP(View view)
    {
        //Edit XP for ThisFighter - pop up, like reputation
        //Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(getApplicationContext());
        edittext.setText(ThisFighter.Get_Experience().toString());
        edittext.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setMessage("Enter New XP");
        alert.setTitle("XP");

        alert.setView(edittext);

        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int whichButton)
            {
                XPText.setText(edittext.getText());

                //Update Fighter
                int thisXP = Integer.parseInt(XPText.getText().toString());
                ThisFighter.Set_Experience(thisXP);
                AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(ThisFighter);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do nothing
            }
        });

        alert.show();
    }

    @Override
    public void onBackPressed()
    {
        //Create a new intent
        Intent editGangIntent = new Intent(getApplicationContext(), Edit_Gang.class);

        //I was going to use a Bundle, but it would be easier to just pass the Gang_Name
        //as a single extra and then poll the DB for the rest of the info at the other end.

        editGangIntent.putExtra("Gang_Name",ThisFighter.Get_Gang_Name());

        editGangIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //start the new activity
        startActivity( editGangIntent );

        finish();
    }
}
