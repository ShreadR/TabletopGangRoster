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

public class RemoveWeapon extends AppCompatActivity
{

    String FighterBeingViewed = "";
    String thisWeaponCSV= "";
    ArrayList<Table_Weapons> thisFightersWeapons = new ArrayList<>();
    Table_Fighters thisFighter;
    String WeaponName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_weapon);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        setTitle("Remove " + FighterBeingViewed + "'s Weapon");

        //Get this fighter's weaponCSV
        //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());
        thisWeaponCSV = thisFighter.getCurrent_Weapons();

        //Log.i("View Fighter Log","thisWeaponCSV = " + thisWeaponCSV);

        if(thisWeaponCSV !=null && !thisWeaponCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisWeaponCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersWeapons.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Dao().getWeaponByName(items.get(i)));
            }

            final ListView WeaponListView = findViewById(R.id.removeWeaponsList);

            WeaponsAdapter weaponsAdapter = new WeaponsAdapter(this, thisFightersWeapons);

            WeaponListView.setAdapter(weaponsAdapter);

            WeaponListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                    WeaponName = thisFightersWeapons.get(position).getName();

                    //Sanity Toast
                    //Toast.makeText(getApplicationContext(),"Click: " + WeaponName, Toast.LENGTH_SHORT).show();


                    //*** ALERT***
                    AlertDialog.Builder alert = new AlertDialog.Builder(RemoveWeapon.this);

                    alert.setMessage(WeaponName);

                    alert.setTitle("Remove the following weapon profile from " + FighterBeingViewed + "?");

                    alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            //Get and update record for this fighterName / gangName

                            //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());

                            //Log.i("RemoveWeapon","thisWeaponCSV after DB read: " + thisWeaponCSV);

                            thisWeaponCSV = thisWeaponCSV.replaceFirst(WeaponName,"");
                            thisWeaponCSV = thisWeaponCSV.replace(",,",",");
                            thisWeaponCSV = thisWeaponCSV.replaceAll(",$", "");
                            //Log.i("RemoveWeapon","Branch A. thisWeaponCSV now = " + thisWeaponCSV);

                            thisFighter.setCurrent_Weapons(thisWeaponCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);

                            //Log.i("RemoveWeapon","thisWeaponCSV after DB write: " + thisWeaponCSV);

                            Toast.makeText(getApplicationContext(),WeaponName + " Profile Removed", Toast.LENGTH_SHORT).show();

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
        Intent Intent = new Intent(getApplicationContext(), EditWeapons.class);
        String FighterName = FighterBeingViewed;
        Intent.putExtra("Fighter_Name", FighterName);
        Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Intent);
        finish();
    }
}
