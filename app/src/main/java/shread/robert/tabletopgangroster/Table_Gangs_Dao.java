package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by Rob on 02/03/2018.
 */

@Dao
public interface Table_Gangs_Dao
{
    /*
    Fields:
    Gang_Name
    House
    Stash
    Reputation
    Turf_Size
    Special_Territories
     */

    @Query("Select * from Table_Gangs")
    List<Table_Gangs> getAllGangs();

    @Query("Select Gang_Name from Table_gangs")
    List<String> getAllGangNames();

    @Query("Select * from Table_gangs where Gang_Name like :Gang_Name")
    Table_Gangs getThisGang(String Gang_Name);

    @Insert(onConflict = IGNORE)
    void insertGang(Table_Gangs Table_Gang);

    @Update
    void update(Table_Gangs Table_Gang);

    @Delete
    void deleteGang(Table_Gangs Table_Gang);
}
