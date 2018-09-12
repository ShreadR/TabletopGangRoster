package shread.robert.tabletopgangroster;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditWeapons extends AppCompatActivity
{

    String FighterBeingViewed = "";
    Table_Fighters thisFighter;
    String thisWeaponCSV;
    ArrayList<Table_Weapons> thisFightersWeapons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_weapons);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s Weapons");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

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

            final ListView WeaponListView = findViewById(R.id.weaponsList);

            WeaponsAdapter weaponsAdapter = new WeaponsAdapter(this, thisFightersWeapons);

            WeaponListView.setAdapter(weaponsAdapter);
        }
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

    public void clickAddWeapon(View view)
    {
        Intent addWeaponIntent = new Intent(getApplicationContext(), AddNewWeapon.class);
        String FighterName = FighterBeingViewed;
        addWeaponIntent.putExtra("Fighter_Name", FighterName);
        addWeaponIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(addWeaponIntent);
        finish();
    }

    public void clickRemoveWeapon(View view)
    {
        Intent removeWeaponIntent = new Intent(getApplicationContext(), RemoveWeapon.class);
        String FighterName = FighterBeingViewed;
        removeWeaponIntent.putExtra("Fighter_Name", FighterName);
        removeWeaponIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(removeWeaponIntent);
        finish();
    }
}
