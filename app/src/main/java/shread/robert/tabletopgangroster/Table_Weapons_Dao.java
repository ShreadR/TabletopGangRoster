package shread.robert.tabletopgangroster;

/**
 * Created by Rob on 18/07/2018.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface Table_Weapons_Dao
{
    @Query("Select * From Table_Weapons")
    List<Table_Weapons> getAllWeapons();

    @Query("Select * From Table_Weapons WHERE Type = (:Type)")
    List<Table_Weapons> getWeaponsByType(String Type);

    @Query("Select * FROM Table_Weapons WHERE Name = (:Weapon_Name)")
    Table_Weapons getWeaponByName(String Weapon_Name);

    @Query("Select Count(*) From Table_Weapons")
    int rowCount();

    @Insert(onConflict = IGNORE)
    void insertWeapon(Table_Weapons Table_Weapon);

    @Delete
    void deleteWeapon(Table_Weapons Table_Weapon);
}