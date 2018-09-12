package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface Table_Wargear_Dao
{
    @Query("Select * From Table_Wargear")
    List<Table_Wargear> getAllWargear();

    @Query("Select * FROM Table_Wargear WHERE Wargear_Name = (:Wargear_Name)")
    Table_Wargear getWargearByName(String Wargear_Name);

    @Query("Select Wargear_Text FROM Table_Wargear WHERE Wargear_Name = (:Wargear_Name)")
    String getWargearTextByName(String Wargear_Name);

    @Query("Select Count(*) From Table_Wargear")
    int rowCount();

    @Insert(onConflict = IGNORE)
    void insertWargear(Table_Wargear Table_Wargear);

    @Delete
    void deleteWargear(Table_Wargear Table_Wargear);
}
