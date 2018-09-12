package shread.robert.tabletopgangroster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Delete_Gang extends AppCompatActivity
{

    //List<String> allGangNames;
    List allGangNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_gang);

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Delete Existing Gang");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void clickDeleteGang(View view)
    {
        Spinner gangName = (Spinner) findViewById(R.id.gangNameSpinner);

        String selectedGang = gangName.getSelectedItem().toString();

        if (selectedGang.contains("No Gang Exists"))
        {
            Toast.makeText(this, "No Gang Exists. Please create a new Gang.", Toast.LENGTH_LONG).show();
        }
        else {
            Table_Gangs gangToDelete = AppDatabase.getInstance(getApplicationContext()).get_Table_Gangs_Dao().getThisGang(selectedGang);

            AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().deleteFightersFromGang(gangToDelete.Get_Gang_Name());

            AppDatabase.getInstance(getApplicationContext()).get_Table_Gangs_Dao().deleteGang(gangToDelete);

            Toast.makeText(this, "Gang Successfully Deleted!", Toast.LENGTH_SHORT).show();

            //Reset Spinner contents
            allGangNames = AppDatabase.getInstance(getApplicationContext()).get_Table_Gangs_Dao().getAllGangNames();

            if (allGangNames.isEmpty())
            {
                //Toast.makeText(this, "No Gang selected. Please choose a Gang from the list or create a new Gang.", Toast.LENGTH_LONG).show();
                allGangNames.add("No Gang Exists");
            }

            Spinner spinner = (Spinner) findViewById(R.id.gangNameSpinner);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, allGangNames);

            adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

            // Spinner spinYear = (Spinner)findViewById(R.id.spin);
            spinner.setAdapter(adapter);

        }
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
