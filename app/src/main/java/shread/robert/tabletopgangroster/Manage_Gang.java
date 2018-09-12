package shread.robert.tabletopgangroster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Manage_Gang extends AppCompatActivity {

    //List<String> allGangNames;
    List allGangNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_manage_gang);
        setContentView(R.layout.content_manage__gang);

        allGangNames = AppDatabase.getInstance(getApplicationContext()).get_Table_Gangs_Dao().getAllGangNames();

        if (allGangNames.isEmpty())
        {
            //Toast.makeText(this, "No Gang selected. Please choose a Gang from the list or create a new Gang.", Toast.LENGTH_LONG).show();
            allGangNames.add("No Gang Exists");
        }

        Spinner spinner = (Spinner) findViewById(R.id.gangNameSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, allGangNames);

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinner.setAdapter(adapter);

        setTitle("Manage Existing Gang");

        Toolbar t = findViewById(R.id.toolbar);

        setSupportActionBar(t);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    //clickEditGang
    public void clickEditGang(View view)
    {
        //Lesson learned - Attempting to .toString() the Spinner when it was empty caused a crash. I was expecting the String to pass null or "".
        //                 I will put a string into the allGangNames array above if it's empty, then check for that string below for positive proceed.
        Spinner gangName = (Spinner) findViewById(R.id.gangNameSpinner);

        String selectedGang = gangName.getSelectedItem().toString();

        if (selectedGang.contains("No Gang Exists"))
        {
            Toast.makeText(this, "No Gang Exists. Please create a new Gang.", Toast.LENGTH_LONG).show();
        }
        else
        {
            //Toast.makeText(this, "Selection is valid!", Toast.LENGTH_SHORT).show();

            //Create a new intent
            Intent editGangIntent = new Intent(getApplicationContext(), Edit_Gang.class);

            //I was going to use a Bundle, but it would be easier to just pass the Gang_Name
            //as a single extra and then poll the DB for the rest of the info at the other end.

            editGangIntent.putExtra("Gang_Name",selectedGang);

            //start the new activity
            startActivity( editGangIntent );
        }


        //Toast.makeText(this, "Button pressed!", Toast.LENGTH_SHORT).show();
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
