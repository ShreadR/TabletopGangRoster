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

public class RemoveWargear extends AppCompatActivity
{
    String FighterBeingViewed;
    Table_Fighters thisFighter;
    String thisWargearCSV;
    ArrayList<Table_Wargear> thisFightersWargear = new ArrayList<>();
    String WargearName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_wargear);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        setTitle("Remove " + FighterBeingViewed + "'s Wargear");

        //Get this fighter's weaponCSV
        //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());
        thisWargearCSV = thisFighter.getCurrent_Wargear();

        //Log.i("Remove Wargear Log","thisWargearCSV = " + thisWargearCSV);

        if(thisWargearCSV !=null && !thisWargearCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisWargearCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersWargear.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Wargear_Dao().getWargearByName(items.get(i)));
            }

            final ListView WargearListView = findViewById(R.id.removeWargearList);

            WargearAdapter wargearAdapter = new WargearAdapter(this, thisFightersWargear);

            WargearListView.setAdapter(wargearAdapter);

            WargearListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                    WargearName = thisFightersWargear.get(position).getWargear_Name();

                    //Sanity Toast
                    //Toast.makeText(getApplicationContext(),"Click: " + WeaponName, Toast.LENGTH_SHORT).show();


                    //*** ALERT***
                    AlertDialog.Builder alert = new AlertDialog.Builder(RemoveWargear.this);

                    alert.setMessage(WargearName);

                    alert.setTitle("Remove the following wargear from " + FighterBeingViewed + "?");

                    alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            //Get and update record for this fighterName / gangName

                            //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());

                            //Log.i("RemoveWargear","thisWargearCSV after DB read: " + thisWargearCSV);

                            thisWargearCSV = thisWargearCSV.replaceFirst(WargearName,"");
                            thisWargearCSV = thisWargearCSV.replace(",,",",");
                            thisWargearCSV = thisWargearCSV.replaceAll(",$", "");
                            //Log.i("RemoveSkill","Branch A. thisSkillCSV now = " + thisWargearCSV);

                            thisFighter.setCurrent_Wargear(thisWargearCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);

                            //Log.i("RemoveWargear","thisWargearCSV after DB write: " + thisWargearCSV);

                            Toast.makeText(getApplicationContext(),WargearName + " Removed", Toast.LENGTH_SHORT).show();

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
        Intent Intent = new Intent(getApplicationContext(), EditWargear.class);
        String FighterName = FighterBeingViewed;
        Intent.putExtra("Fighter_Name", FighterName);
        Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Intent);
        finish();
    }
}
