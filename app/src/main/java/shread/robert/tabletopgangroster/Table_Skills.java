package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rob on 23/03/2018.
 */

@Entity
public class Table_Skills
{
    @PrimaryKey
    @NonNull
    //Name of the skill
    public String Skill_Name;

    //Category of the skill
    public String Skill_Category;

    //Text of the skill's effect
    public String Skill_Text;

    //Get Skill_Name
    public String Get_Skill_Name()
    {
        return Skill_Name;
    }

    //Set Skill_Name
    public void Set_Skill_Name(String Skill_Name)
    {
        this.Skill_Name = Skill_Name;
    }

    //Get Skill_Category
    public String Get_Skill_Category()
    {
        return Skill_Category;
    }

    //Set Skill_Category
    public void Set_Skill_Category(String Skill_Category)
    {
        this.Skill_Category = Skill_Category;
    }

    //Get Skill_Text
    public String Get_Skill_Text()
    {
        return this.Skill_Text;
    }

    //Set Skill_Text
    public void Set_Skill_Text(String Skill_Text)
    {
        this.Skill_Text = Skill_Text;
    }

    public Table_Skills(String Skill_Name, String Skill_Category, String Skill_Text)
    {
        this.Set_Skill_Name(Skill_Name);
        this.Set_Skill_Category(Skill_Category);
        this.Set_Skill_Text(Skill_Text);
    }

}
