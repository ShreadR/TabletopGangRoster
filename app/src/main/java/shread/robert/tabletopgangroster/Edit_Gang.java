package shread.robert.tabletopgangroster;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Edit_Gang extends AppCompatActivity
{

    String GangToEdit;
    Table_Gangs gangToPass;
    TextView HouseText;
    TextView StashText;
    TextView ReputationText;
    TextView TurfText;
    TextView GangRatingText;
    ListView FighterList;
    ArrayList<Table_Fighters> FightersAllData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gang);

        //Test Toast
        //Toast.makeText(this, "You have arrived at your destination!", Toast.LENGTH_SHORT).show();

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Gang_Name")!= null) {
            GangToEdit = extras.getString("Gang_Name");
        }


        setTitle(GangToEdit);

        gangToPass = AppDatabase.getInstance(getApplicationContext()).get_Table_Gangs_Dao().getThisGang(GangToEdit);

        //Fields:
        //Gang_Name
        //House
        //Stash
        //Reputation
        //Turf_Size
        //Special_Territories
        //Gang_Rating

        HouseText = findViewById(R.id.houseDisplay);
        HouseText.setText(gangToPass.Get_Gang_House());

        StashText = findViewById(R.id.stashDisplay);
        StashText.setText(String.valueOf(gangToPass.Get_Gang_Stash()));

        ReputationText = findViewById(R.id.reputationDisplay);
        ReputationText.setText(String.valueOf(gangToPass.Get_Reputation()));

        TurfText = findViewById(R.id.turfDisplay);
        TurfText.setText(String.valueOf(gangToPass.Get_Turf_Size()));

        GangRatingText = findViewById(R.id.gangRatingDisplay);
        GangRatingText.setText(String.valueOf(gangToPass.Get_Gang_Rating()));

        final ListView FighterList = findViewById(R.id.fighterList);

        //Row count sanity check
        //Log.i("LOG!", "House Name used in query: " + gangToPass.Get_Gang_House());
        //Log.i("LOG!","Total number of fighters from this house should be: " + AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getCountOfAllFightersFromThisGang(gangToPass.Get_Gang_Name()));
        //Log.i("LOG!", "Total number of records in the fighters table: " + AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getSanityCountOfTable());
        FightersAllData.addAll(AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getAllFightersFromThisGang(gangToPass.Get_Gang_Name()));

        //Row count sanity check
        //Log.i("LOG!", "House Name used in query: " + gangToPass.Get_Gang_House());
        //Log.i("LOG!","Total number of fighters from this house should be: " + AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getCountOfAllFightersFromThisGang(gangToPass.Get_Gang_Name()));
        //Log.i("LOG!", "Total number of records in the fighters table: " + AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getSanityCountOfTable());

        //GangRatingText.setText(String.valueOf(TotalGangRating));

        Edit_Gang_List_Adapter adapter = new Edit_Gang_List_Adapter(this, FightersAllData);

        FighterList.setAdapter(adapter);

        FighterList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                
                Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
                String FighterName = FightersAllData.get(position).Get_Fighter_Name();
                intent.putExtra("Fighter_Name", FighterName);
                startActivity(intent);
                finish();
                //Sanity Toast
                //Toast.makeText(getApplicationContext(),"Click: " + FighterName, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void clickEditStash(View view)
    {
        //Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(getApplicationContext());
        edittext.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setMessage("Enter New Stash Amount");
        alert.setTitle("Stash");

        alert.setView(edittext);

        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int whichButton)
            {

                StashText.setText(edittext.getText());
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

    public void clickEditReputation(View view)
    {
        //Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(getApplicationContext());
        edittext.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setMessage("Enter New Reputation Amount");
        alert.setTitle("Reputation");

        alert.setView(edittext);

        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                ReputationText.setText(edittext.getText());
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do nothing
            }
        });

        alert.show();
    }

    public void clickEditTurfSize(View view)
    {
        //Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(getApplicationContext());
        edittext.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setMessage("Enter New Turf Size");
        alert.setTitle("Turf Size");

        alert.setView(edittext);

        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                TurfText.setText(edittext.getText());
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do nothing
            }
        });

        alert.show();
    }

    public void clickEditGangRating(View view)
    {
        //Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(getApplicationContext());
        edittext.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setMessage("Enter New Gang Rating");
        alert.setTitle("Gang Rating");
        //edittext.setText(gangToPass.Get_Gang_Rating());
        alert.setView(edittext);

        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                GangRatingText.setText(edittext.getText());
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do nothing
            }
        });

        alert.show();
    }

    public void clickSaveChanges(View view)
    {
        //Get values
        Table_Gangs gangToSave = new Table_Gangs(gangToPass.Get_Gang_Name(),gangToPass.Get_Gang_House(),Integer.parseInt(StashText.getText().toString()));

        gangToSave.Set_Reputation(Integer.parseInt(ReputationText.getText().toString()));
        gangToSave.Set_Turf_Size(Integer.parseInt(TurfText.getText().toString()));
        gangToSave.Set_Gang_Rating(Integer.parseInt(GangRatingText.getText().toString()));

        //Update Gang
        AppDatabase.getInstance(getApplicationContext())
                .get_Table_Gangs_Dao()
                .update(gangToSave);

        Toast.makeText(this, "Gang Saved", Toast.LENGTH_SHORT).show();
    }

    public void clickAddFighter(View view)
    {
        //Go to Create Fighter Activity
        //Create a new intent
        Intent createFighterIntent = new Intent(getApplicationContext(), Create_Fighter.class);

        createFighterIntent.putExtra("Gang_Name",GangToEdit);
        createFighterIntent.putExtra("House",gangToPass.Get_Gang_House());

        //start the new activity
        startActivity( createFighterIntent );

        finish();

        //Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed()
    {
        Intent backToMainIntent = new Intent(getApplicationContext(),MainActivity.class);

        backToMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(backToMainIntent);

        finish();
    }
}


