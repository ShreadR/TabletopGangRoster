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

public class AddNewWeapon extends AppCompatActivity
{

    String FighterBeingViewed = "";
    Table_Fighters thisFighter;
    String thisWeaponCSV = "";
    String WeaponName = "";
    ArrayList<Table_Weapons> allowedWeapons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_weapon);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s New Weapon");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        //Get and set this fighter's allowed weapon flags
        /*
        Boolean Allow_Basic,
        Boolean Allow_Close_Combat,
        Boolean Allow_Pistols,
        Boolean Allow_Special,
        Boolean Allow_Heavy,
        Boolean Allow_Grenades,
        Boolean Allow_Adept_Weapons, //wrapped up in CC
        Boolean Allow_Acolyte_Weapons, //wrapped up in CC
        Boolean Allow_Aberrant_Weapons, //actually needs to be separate as Aberrants do not have access to CC
        */

        if (thisFighter.Get_Allow_Basic())
        {
            //basicWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Basic");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Basic"));
        }
        if (thisFighter.Get_Allow_Close_Combat())
        {
            //closeCombatWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Close Combat");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Close Combat"));
        }
        if (thisFighter.Get_Allow_Pistols())
        {
            //pistolWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Pistol");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Pistol"));
        }
        if (thisFighter.Get_Allow_Special())
        {
            //specialWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Special");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Special"));
        }
        if (thisFighter.Get_Allow_Heavy())
        {
            //heavyWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Heavy");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Heavy"));
        }
        if (thisFighter.Get_Allow_Grenades())
        {
            //grenadeWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Grenade");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Grenade"));
        }
        if (thisFighter.Get_Allow_Aberrant_Weapons())
        {
            //aberrantWeapons = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Aberrant");
            allowedWeapons.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponsByType("Aberrant"));
        }

        final ListView WeaponListView = findViewById(R.id.fighterWeaponList);

        WeaponsAdapter weaponsAdapter = new WeaponsAdapter(this, allowedWeapons);

        WeaponListView.setAdapter(weaponsAdapter);

        WeaponListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                WeaponName = allowedWeapons.get(position).getName();

                //Sanity Toast
                //Toast.makeText(getApplicationContext(),"Click: " + WeaponName, Toast.LENGTH_SHORT).show();


                //*** ALERT***
                AlertDialog.Builder alert = new AlertDialog.Builder(AddNewWeapon.this);

                alert.setMessage(WeaponName);

                alert.setTitle("Add the following weapon profile to " + FighterBeingViewed + "?");

                alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        //Get and update record for this fighterName / gangName

                        thisWeaponCSV = thisFighter.getCurrent_Weapons();

                        //Log.i("AddNewWeapon","thisWeaponCSV after DB read: " + thisWeaponCSV);

                        if(thisWeaponCSV !=null && !thisWeaponCSV.isEmpty())
                        {
                            thisWeaponCSV += "," + WeaponName;
                            //Log.i("AddNewWeapon","Branch A. thisWeaponCSV now = " + thisWeaponCSV);
                            thisFighter.setCurrent_Weapons(thisWeaponCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
                        }
                        else
                        {
                            thisWeaponCSV = WeaponName;
                            //Log.i("AddNewWeapon","Branch B. thisWeaponCSV now = " + thisWeaponCSV);
                            thisFighter.setCurrent_Weapons(thisWeaponCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
                        }

                        //Log.i("AddNewWeapon","thisWeaponCSV after DB write: " + thisWeaponCSV);

                        Toast.makeText(getApplicationContext(),WeaponName + " Profile Added", Toast.LENGTH_SHORT).show();
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
        Intent Intent = new Intent(getApplicationContext(), EditWeapons.class);
        String FighterName = FighterBeingViewed;
        Intent.putExtra("Fighter_Name", FighterName);
        Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Intent);
        finish();
    }

}
