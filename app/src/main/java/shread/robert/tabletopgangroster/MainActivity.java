package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Declare buttons, do I need them??
        Button newGang = (Button) findViewById(R.id.buttonNewGang);
        Button manageExistingGang = (Button) findViewById(R.id.buttonManageExistingGang);

        //DB Debug
        //String currentDBPath = getDatabasePath("application_db").getAbsolutePath();
        //Log.i("TAG","DB Path: "+currentDBPath);
    }

    public void clickNewGang(View view)
    {
        //Go to New Gang layout and activity

        //Create a new intent
        Intent createGangIntent = new Intent(getApplicationContext(), Create_Gang.class);

        //start the new activity
        startActivity( createGangIntent );
    }


    public void clickManageGang(View view)
    {
        //Go to manage existing gangs layout and activity

        //Create a new intent
        Intent manageGangIntent = new Intent(getApplicationContext(), Manage_Gang.class);

        //start the new activity
        startActivity( manageGangIntent );
    }

    public void clickDeleteGang(View view)
    {
        //Go to delete existing gangs layout and activity

        //Create a new intent
        Intent deleteGangIntent = new Intent(getApplicationContext(), Delete_Gang.class);

        //start the new activity
        startActivity( deleteGangIntent );
    }

}
