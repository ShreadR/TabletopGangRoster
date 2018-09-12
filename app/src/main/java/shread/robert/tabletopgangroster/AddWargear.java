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

public class AddWargear extends AppCompatActivity
{
    String FighterBeingViewed;
    Table_Fighters thisFighter;
    ArrayList<Table_Wargear> allowedWargear = new ArrayList<>();
    String wargearName;
    String thisWargearCSV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wargear);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s New Wargear");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        allowedWargear.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Wargear_Dao().getAllWargear());

        final ListView WargearListView = findViewById(R.id.addWargearList);

        WargearAdapter wargearAdapter = new WargearAdapter(this, allowedWargear);

        WargearListView.setAdapter(wargearAdapter);

        WargearListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                wargearName = allowedWargear.get(position).getWargear_Name();

                //Sanity Toast
                //Toast.makeText(getApplicationContext(),"Click: " + WeaponName, Toast.LENGTH_SHORT).show();


                //*** ALERT***
                AlertDialog.Builder alert = new AlertDialog.Builder(AddWargear.this);

                alert.setMessage(wargearName);

                alert.setTitle("Add the following wargear to " + FighterBeingViewed + "?");

                alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        //Get and update record for this fighterName / gangName

                        thisWargearCSV = thisFighter.getCurrent_Wargear();

                        //Log.i("AddWargear","thisWargearCSV after DB read: " + thisWargearCSV);

                        if(thisWargearCSV !=null && !thisWargearCSV.isEmpty())
                        {
                            thisWargearCSV += "," + wargearName;
                            //Log.i("AddWargear","Branch A. thisWargearCSV now = " + thisWargearCSV);
                            thisFighter.setCurrent_Wargear(thisWargearCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
                        }
                        else
                        {
                            thisWargearCSV = wargearName;
                            //Log.i("AddWargear","Branch B. thisWargearCSV now = " + thisWargearCSV);
                            thisFighter.setCurrent_Wargear(thisWargearCSV);
                            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
                        }

                        //Log.i("AddWargear","thisWargearCSV after DB write: " + thisWargearCSV);

                        Toast.makeText(getApplicationContext(),wargearName + " Added", Toast.LENGTH_SHORT).show();
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
        Intent Intent = new Intent(getApplicationContext(), EditWargear.class);
        String FighterName = FighterBeingViewed;
        Intent.putExtra("Fighter_Name", FighterName);
        Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Intent);
        finish();
    }
}
