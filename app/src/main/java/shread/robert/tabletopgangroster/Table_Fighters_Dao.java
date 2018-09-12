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
public interface Table_Fighters_Dao
{
    /*
    Fighter Name
	Gang_Name
    Fighter Type
	Base_Cost
	Total_Value
	Experience
	Advancements
	In_Recovery
	Captured_By
	Movement
	Weapon_Skill
	Ballistic_Skill
	Strength
	Toughness
	Wounds
	Initiative
	Attacks
	Leadership
	Cool
	Willpower
	Intelligence
    */

    @Query("Select * from Table_Fighters")
    List<Table_Fighters> getAllFighters();

    @Query("Select * from Table_Fighters where Gang_Name = :Gang_Name")
    List<Table_Fighters> getAllFightersFromThisGang(String Gang_Name);

    @Query("Select Count(*) from Table_Fighters where Gang_Name = :Gang_Name")
    int getCountOfAllFightersFromThisGang(String Gang_Name);

    @Query("Select Count(*) from Table_Fighters")
    int getSanityCountOfTable();

    @Query("Select * from Table_Fighters where Fighter_Name = :Fighter_Name")
    Table_Fighters getThisFighterByName(String Fighter_Name);

    @Insert(onConflict = IGNORE)
    void insertFighter(Table_Fighters Table_Fighter);

    @Update(onConflict = REPLACE)
    void updateFighter(Table_Fighters Table_Fighter);

    @Delete
    void deleteFighter(Table_Fighters Table_Fighter);

    @Query("Delete From Table_Fighters Where Gang_Name = :Gang_Name")
    void deleteFightersFromGang(String Gang_Name);

}
