package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rob on 02/03/2018.
 */

@Entity
public class Table_Gangs
{
    @PrimaryKey
    @NonNull
    //Name of the gang
    public String Gang_Name;

    //Name of the House the Gang belongs to
    public String House;

    //How many credits the gang has
    public Integer Stash;

    //How much reputation the gang has
    public Integer Reputation;

    //How large their territory is
    public Integer Turf_Size;

    //A list of special territories the gang has, if any
    public String Special_Territories; //CSV - WishList Functionality

    //The total value of all members of the gang and their equipment
    public Integer Gang_Rating;

    //Get Gang Name
    public String Get_Gang_Name()
    {
        return Gang_Name;
    }

    //Set Gang Name
    public void Set_Gang_Name(String Gang_Name)
    {
        this.Gang_Name = Gang_Name;
    }

    //Get Gang House
    public String Get_Gang_House()
    {
        return House;
    }

    //Set Gang House
    public void Set_Gang_House(String House)
    {
        this.House = House;
    }

    //Get Gang Stash
    public Integer Get_Gang_Stash()
    {
        return Stash;
    }

    //Set Gang Stash
    //Might need to create an adder
    public void Set_Gang_Stash(Integer Stash)
    {
        this.Stash = Stash;
    }

    //Get Reputation
    public Integer Get_Reputation()
    {
        return Reputation;
    }

    //Set Reputation
    //Might need an adder
    public void Set_Reputation(Integer Reputation)
    {
        this.Reputation = Reputation;
    }

    //Get Turf Size
    public Integer Get_Turf_Size()
    {
        return Turf_Size;
    }

    //Set Turf Size
    //Might need an adder
    public void Set_Turf_Size(Integer Turf_Size)
    {
        this.Turf_Size = Turf_Size;
    }

    //Get Special Territories list
    public String Get_Special_Territories()
    {
        return Special_Territories;
    }

    //Set Special Territories List
    //Wish List - Will not be fully implemented unless time allows
    public void Set_Special_Territories(String Special_Territories)
    {
        this.Special_Territories = Special_Territories;
    }

    //Get Gang_Rating
    public Integer Get_Gang_Rating()
    {
        return this.Gang_Rating;
    }

    //Set Gang_Rating
    public void Set_Gang_Rating(Integer Gang_Rating)
    {
        this.Gang_Rating = Gang_Rating;
    }

    //Talbe_Gangs object constructor
    //User sets three values, others are all set to their default values as per the rule book
    public Table_Gangs (String Gang_Name, String House, Integer Stash)
    {
        this.Gang_Name = Gang_Name; //As per user input
        this.House = House; //As per user input
        this.Stash = Stash; //As per user input
        this.Reputation = 1; //Default starting value
        this.Turf_Size = 1; //Default starting value
        this.Special_Territories = ""; //Default starting value
        this.Gang_Rating = 0; //Default starting value
    }
}
