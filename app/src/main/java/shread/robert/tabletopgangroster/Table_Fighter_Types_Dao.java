package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Rob on 07/03/2018.
 */

@Dao
public interface Table_Fighter_Types_Dao
{
    @Query("Select * from Table_Fighter_Types")
    List<Table_Fighter_Types> getAllFighterTypes();

    @Query("Select Fighter_Type from Table_Fighter_Types where House = :House")
    List<String> getAllFighterTypesFromThisHouse(String House);

    //Debug / Sanity check
    @Query("Select Fighter_Type from Table_Fighter_Types")
    List<String> getSanityCheckFighterTypes();

    @Query("Select * from Table_Fighter_Types where Fighter_Type = :Fighter_Type and House = :House")
    Table_Fighter_Types getThisFighterByTypeAndHouse(String Fighter_Type, String House);

    @Query("SELECT COUNT(*) FROM Table_Fighter_Types")
    int rowCount();

    @Insert(onConflict = REPLACE)
    void insertFighterType(Table_Fighter_Types Table_Fighter_Type);

    @Insert(onConflict = REPLACE)
    void insertAllFighterTypes(Table_Fighter_Types... Table_Fighter_Type);

    @Update
    void updateFighterType(Table_Fighter_Types Table_Fighter_Type);

    @Delete
    void deleteFighterType(Table_Fighter_Types Table_Fighter_Type);
}
