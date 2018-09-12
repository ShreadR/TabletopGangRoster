package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Table_Wargear
{
    @PrimaryKey(autoGenerate = true)
    public int ID;

    public String Wargear_Name;

    public String Wargear_Text;

    public String getWargear_Name()
    {
        return Wargear_Name;
    }

    public void setWargear_Name(String wargear_Name)
    {
        Wargear_Name = wargear_Name;
    }

    public String getWargear_Text()
    {
        return Wargear_Text;
    }

    public void setWargear_Text(String wargear_Text)
    {
        Wargear_Text = wargear_Text;
    }

    public Table_Wargear(String Wargear_Name,
                         String Wargear_Text)
    {
        this.setWargear_Name(Wargear_Name);
        this.setWargear_Text(Wargear_Text);
    }
}
