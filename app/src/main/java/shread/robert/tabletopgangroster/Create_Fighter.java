package shread.robert.tabletopgangroster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Create_Fighter extends AppCompatActivity
{
    String thisGangName;
    String thisHouse;
    List fighterTypes = new ArrayList<String>();
    String thisFighterType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_fighter);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Gang_Name")!= null) {
            thisGangName = extras.getString("Gang_Name");
        }
        if(extras.getString("House")!= null) {
            thisHouse = extras.getString("House");
        }

        setTitle("Create a New " + thisHouse + " Fighter");

        fighterTypes = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighter_Types_Dao().getAllFighterTypesFromThisHouse(thisHouse);
        //fighterTypes = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighter_Types_Dao().getSanityCheckFighterTypes();

        if (fighterTypes.isEmpty())
        {
            fighterTypes.add("Error"); //Should never see this.
        }

        Spinner spinner = (Spinner) findViewById(R.id.typeSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, fighterTypes);

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinner.setAdapter(adapter);
    }

    public void clickCreateFighter(View view)
    {
        TextView fighterNameText = (TextView) findViewById(R.id.fighterName);

        String thisFighterName = fighterNameText.getText().toString();

        Spinner fighterType = (Spinner) findViewById(R.id.typeSpinner);

        thisFighterType = fighterType.getSelectedItem().toString();

        if(thisFighterName.isEmpty())
        {
            Toast.makeText(this, "Enter a name for your fighter.", Toast.LENGTH_LONG).show();
        }
        else {

            if (thisFighterType.contains("Error")) {
                Toast.makeText(this, "No fighter types exist for this House, something has gone wrong!", Toast.LENGTH_LONG).show();
            } else {
                Table_Fighter_Types thisFighterProfile = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighter_Types_Dao().getThisFighterByTypeAndHouse(thisFighterType, thisHouse);

                AppDatabase.getInstance(getApplicationContext())
                        .get_Table_Fighters_Dao()
                        .insertFighter(new Table_Fighters(thisFighterName,
                                thisGangName,
                                thisFighterType,
                                thisFighterProfile.Get_Base_Cost(),
                                thisFighterProfile.Get_Advancements(),
                                thisFighterProfile.Get_Movement(),
                                thisFighterProfile.Get_Weapon_Skill(),
                                thisFighterProfile.Get_Ballistic_Skill(),
                                thisFighterProfile.Get_Strength(),
                                thisFighterProfile.Get_Toughness(),
                                thisFighterProfile.Get_Wounds(),
                                thisFighterProfile.Get_Initiative(),
                                thisFighterProfile.Get_Attacks(),
                                thisFighterProfile.Get_Leadership(),
                                thisFighterProfile.Get_Cool(),
                                thisFighterProfile.Get_Willpower(),
                                thisFighterProfile.Get_Intelligence(),
                                thisFighterProfile.Get_Allow_Basic(),
                                thisFighterProfile.Get_Allow_Close_Combat(),
                                thisFighterProfile.Get_Allow_Pistols(),
                                thisFighterProfile.Get_Allow_Special(),
                                thisFighterProfile.Get_Allow_Heavy(),
                                thisFighterProfile.Get_Allow_Grenades(),
                                thisFighterProfile.Get_Allow_Wargear(),
                                thisFighterProfile.Get_Allow_Adept_Weapons(),
                                thisFighterProfile.Get_Allow_Acolyte_Weapons(),
                                thisFighterProfile.Get_Allow_Aberrant_Weapons(),
                                thisFighterProfile.Get_Allowed_Skills(),
                                thisFighterProfile.Get_Current_Skills()));

                Toast.makeText(this, "New fighter created!", Toast.LENGTH_SHORT).show();

                Intent editGangIntent = new Intent(getApplicationContext(), Edit_Gang.class);

                editGangIntent.putExtra("Gang_Name", thisGangName);

                startActivity(editGangIntent);

                finish();
            }
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent backToEditIntent = new Intent(getApplicationContext(),Edit_Gang.class);

        backToEditIntent.putExtra("Gang_Name",thisGangName);

        backToEditIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(backToEditIntent);

        finish();
    }
}
