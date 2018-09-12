package shread.robert.tabletopgangroster;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

/**
 * Created by Rob on 01/03/2018.
 */

@Database(entities = {Table_Gangs.class, Table_Fighters.class, Table_Fighter_Types.class, Table_Skills.class, Table_Weapons.class, Table_Wargear.class}, version = 14, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    private static final String DB_NAME = "application_db";
    private static volatile AppDatabase instance;

    static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addCallback(new Callback()
                {
                    @Override
                    //public void onCreate(@NonNull SupportSQLiteDatabase db)
                    public void onOpen(@NonNull SupportSQLiteDatabase db)
                    {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                //if (getInstance(context).get_Table_Fighter_Types_Dao().rowCount() == 0)
                                //{
                                    //getInstance(context).get_Table_Fighter_Types_Dao().insertAllFighterTypes(Table_Fighter_Types.populateData());
                                //}
                                DatabaseInitialiser DBInit = new DatabaseInitialiser();
                                DBInit.populateAsync(getInstance(context));
                            }
                        });
                    }
                })
                .build();

    }

    public abstract Table_Gangs_Dao get_Table_Gangs_Dao();
    public abstract Table_Fighters_Dao get_Table_Fighters_Dao();
    public abstract Table_Fighter_Types_Dao get_Table_Fighter_Types_Dao();
    public abstract Table_Skills_Dao get_Table_Skills_Dao();
    public abstract Table_Weapons_Dao get_Table_Weapons_Dao();
    public abstract Table_Wargear_Dao get_Table_Wargear_Dao();
}
