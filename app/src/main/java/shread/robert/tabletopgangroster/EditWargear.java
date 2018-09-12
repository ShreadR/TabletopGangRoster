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

public class EditWargear extends AppCompatActivity
{
    String FighterBeingViewed;
    Table_Fighters thisFighter;
    String thisWargearCSV;
    ArrayList<Table_Wargear> thisFightersWargear = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wargear);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s Wargear");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        //Get this fighter's weaponCSV
        //thisWeaponCSV = AppDatabase.getInstance(getApplicationContext()).get_Table_Weapons_Owned_Dao().getWeaponsByOwner(thisFighter.Get_Fighter_Name(),thisFighter.Get_Gang_Name());
        thisWargearCSV = thisFighter.getCurrent_Wargear();

        //Log.i("Edit Wargear Log","thisWargearCSV = " + thisWargearCSV);

        if(thisWargearCSV !=null && !thisWargearCSV.isEmpty())
        {

            List<String> items = Arrays.asList(thisWargearCSV.split(","));

            for(int i = 0; i < items.size(); i++)
            {
                thisFightersWargear.add(AppDatabase.getInstance(getApplicationContext()).get_Table_Wargear_Dao().getWargearByName(items.get(i)));
            }

            final ListView WargearListView = findViewById(R.id.editWargearList);

            WargearAdapter wargearAdapter = new WargearAdapter(this, thisFightersWargear);

            WargearListView.setAdapter(wargearAdapter);
        }
    }

    public void clickAddWargear(View view)
    {
        Intent addWargearIntent = new Intent(getApplicationContext(), AddWargear.class);
        String FighterName = FighterBeingViewed;
        addWargearIntent.putExtra("Fighter_Name", FighterName);
        addWargearIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(addWargearIntent);
        finish();
    }

    public void clickRemoveWargear(View view)
    {
        Intent removeWargearIntent = new Intent(getApplicationContext(), RemoveWargear.class);
        String FighterName = FighterBeingViewed;
        removeWargearIntent.putExtra("Fighter_Name", FighterName);
        removeWargearIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(removeWargearIntent);
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
