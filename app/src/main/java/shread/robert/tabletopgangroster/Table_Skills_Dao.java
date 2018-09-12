package shread.robert.tabletopgangroster;

/**
 * Created by Rob on 23/03/2018.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface Table_Skills_Dao
{
    /*
    Fields

    Skill_Name
    Skill_Category
    Skill_Text
     */

    //@Query("Select * from Table_Skills")
    //List<Table_Skills> getAllSkills();
    @Query("Select * From Table_Skills")
    List<Table_Skills> getAllSkills();

    @Query("Select * FROM Table_Skills WHERE Skill_Category IN (:Category)")
    List<Table_Skills> getSkillsByCategory(String Category);

    @Query("Select Skill_Name From Table_Skills Where Skill_Category IN (:Category)")
    List<String> getSkillNamesByCategory(String Category);

    @Query("Select * FROM Table_Skills WHERE Skill_Name = (:Skill_Name)")
    Table_Skills getSkillByName(String Skill_Name);

    @Query("Select Skill_Text FROM Table_Skills WHERE Skill_Name = (:Skill_Name)")
    String getSkillTextByName(String Skill_Name);

    @Query("Select Count(*) From Table_Skills")
    int rowCount();

    @Insert(onConflict = IGNORE)
    void insertSkill(Table_Skills Table_Skill);

    @Delete
    void deleteSkill(Table_Skills Table_Skill);

}
