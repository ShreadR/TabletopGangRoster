package shread.robert.tabletopgangroster;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Create_Gang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__gang);

        Spinner spinner = (Spinner) findViewById(R.id.House_Spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.house_names, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        setTitle("Create New Gang");
    }

    //onClick clickCreateGang
    public void clickCreateGang(View view)
    {
        EditText gangName = (EditText) findViewById(R.id.gangName);
        EditText startingCredits = (EditText) findViewById(R.id.startingCredits);
        Spinner houseName = (Spinner) findViewById(R.id.House_Spinner);

        String gangNameEntry = gangName.getText().toString();
        String startingCreditsEntryString = startingCredits.getText().toString();
        String gangHouse = houseName.getSelectedItem().toString();

        Integer startingCreditsEntryInt = 0;

        //Check entries are valid
        //If not
        //gangNameEntry
        //startingCreditsEntry
        if (gangNameEntry.matches("") || startingCreditsEntryString.matches(""))
        {
            //Prompt for correct inputs
            Toast.makeText(this, "Entries invalid", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Toast.makeText(this, "Entries Valid", Toast.LENGTH_SHORT).show();

            try {
                startingCreditsEntryInt = Integer.parseInt(startingCredits.getText().toString());
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }

            AppDatabase.getInstance(getApplicationContext())
                    .get_Table_Gangs_Dao()
                    .insertGang(new Table_Gangs(gangNameEntry,  //String Gang_Name
                                gangHouse,                      //String House
                                startingCreditsEntryInt));      //Integer Stash

            Toast.makeText(this, "Gang Saved", Toast.LENGTH_SHORT).show();

            //Now go to the Edit Gang activity, with the newly created gang as the subject
            //Create a new intent
            Intent editGangIntent = new Intent(getApplicationContext(), Edit_Gang.class);

            editGangIntent.putExtra("Gang_Name",gangNameEntry);

            //start the new activity
            startActivity( editGangIntent );

            finish();
        }

        //else prompt user for correct inputs, set entryBox item error messages

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
