package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rob on 07/03/2018.
 */

@Entity
public class Table_Fighters
{
    @PrimaryKey
    @NonNull
    protected String Fighter_Name; //Name as entered by user

    public String Gang_Name; //Taken from the gang the fighter was created for

    public String Fighter_Type; //Taken from a list, determines stats

    public Integer Base_Cost; //Base value of the fighter

    public Integer Total_Value; //Total value of the fighter and their gear.

    public Integer Experience; //How much experience (XP) this fighter has

    public Integer Advancements; //How many advancements this fighter has

    public String In_Recovery; //Whether or not this fighter is injured and In Recovery

    public String Captured_By; //If the fighter has been captured, which player they've been captured by

    public Integer Movement; //How many inches this fighter can move normally in one move action

    public Integer Weapon_Skill; //This fighters skill in hand to hand combat

    public Integer Ballistic_Skill; //This fighters skill at ranged combat

    public Integer Strength; //This fighters strength

    public Integer Toughness; //This fighters toughness

    public Integer Wounds; //How many wounds this fighter has

    public Integer Initiative; //This fighters Initiative

    public Integer Attacks; //How many attacks this fighter gets in close combat

    public Integer Leadership; //This fighters leadership skill

    public Integer Cool; //This fighters cool skill

    public Integer Willpower; //This fighters willpower

    public Integer Intelligence; //This fighters Intelligence

    public Boolean Allow_Basic; //Can this fighter be equipped with Basic weapons

    public Boolean Allow_Close_Combat; //Can this fighter be equipped with Close Combat weapons

    public Boolean Allow_Pistols; //Can this fighter be equipped with Pistols

    public Boolean Allow_Special; //Can this fighter be equipped with Special weapons

    public Boolean Allow_Heavy; //Can this fighter be equipped with Heavy weapons

    public Boolean Allow_Grenades; //Can this fighter be equipped with Grenades

    public Boolean Allow_Wargear; //Can this fighter be equipped with Wargear

    public Boolean Allow_Adept_Weapons; //Can this fighter use Adept Weapons

    public Boolean Allow_Acolyte_Weapons; //Can this fighter use Acolyte weapons

    public Boolean Allow_Aberrant_Weapons; //Can this fighter use Aberrant weapons

    public String Allowed_Skills; //CSV of allowed skill categories

    public String Current_Skills; //CSV of current skills, usually empty but there are special cases

    public String Ready; //Ready or Not Ready

    public String Current_Weapons;

    public String Current_Wargear;

    //Fighter Name
    public String Get_Fighter_Name()
    {
        return this.Fighter_Name;
    }

    public void Set_Fighter_Name(String Fighter_Name)
    {
        this.Fighter_Name = Fighter_Name;
    }

    //Gang Name
    public String Get_Gang_Name()
    {
        return this.Gang_Name;
    }

    public void Set_Gang_Name(String Gang_Name)
    {
        this.Gang_Name = Gang_Name;
    }

    //Fighter Type
    public String Get_Fighter_Type()
    {
        return this.Fighter_Type;
    }

    public void Set_Fighter_Type(String Fighter_Type)
    {
        this.Fighter_Type = Fighter_Type;
    }

    //Bse Cost
    public Integer Get_Base_Cost()
    {
        return this.Base_Cost;
    }

    public void Set_Base_Cost(Integer Base_Cost)
    {
        this.Base_Cost = Base_Cost;
    }

    //Total Value
    public Integer Get_Total_Value()
    {
        return this.Total_Value;
    }

    public void Set_Total_Value(Integer Total_Value)
    {
        this.Total_Value = Total_Value;
    }

    //Experience
    public Integer Get_Experience()
    {
        return this.Experience;
    }

    public void Set_Experience(Integer Experience)
    {
        this.Experience = Experience;
    }

    //Advancements
    public Integer Get_Advancements()
    {
        return this.Advancements;
    }

    public void Set_Advancements(Integer Advancements)
    {
        this.Advancements = Advancements;
    }

    //In_Recovery
    public String Get_In_Recovery()
    {
        return this.In_Recovery;
    }

    public void Set_In_Recovery(String In_Recovery)
    {
        this.In_Recovery = In_Recovery;
    }

    //Captured_By
    public String Get_Captured_By()
    {
        return this.Captured_By;
    }

    public void Set_Captured_By(String Captured_By)
    {
        this.Captured_By = Captured_By;
    }

    //Movement
    public Integer Get_Movement()
    {
        return this.Movement;
    }

    public void Set_Movement(Integer Movement)
    {
        this.Movement = Movement;
    }

    //Weapon_Skill
    public Integer Get_Weapon_Skill()
    {
        return this.Weapon_Skill;
    }

    public void Set_Weapon_Skill(Integer Weapon_Skill)
    {
        this.Weapon_Skill = Weapon_Skill;
    }

    //Ballistic_Skill
    public Integer Get_Ballistic_Skill()
    {
        return this.Ballistic_Skill;
    }

    public void Set_Ballistic_Skill(Integer Ballistic_Skill)
    {
        this.Ballistic_Skill = Ballistic_Skill;
    }

    //Strength
    public Integer Get_Strength()
    {
        return this.Strength;
    }

    public void Set_Strength(Integer Strength)
    {
        this.Strength = Strength;
    }

    //Toughness
    public Integer Get_Toughness()
    {
        return this.Toughness;
    }

    public void Set_Toughness(Integer Toughness)
    {
        this.Toughness = Toughness;
    }

    //Wounds
    public Integer Get_Wounds()
    {
        return this.Wounds;
    }

    public void Set_Wounds(Integer Wounds)
    {
        this.Wounds = Wounds;
    }

    //Initiative
    public Integer Get_Initiative()
    {
        return this.Initiative;
    }

    public void Set_Initiative(Integer Initiative)
    {
        this.Initiative = Initiative;
    }

    //Attacks
    public Integer Get_Attacks()
    {
        return this.Attacks;
    }

    public void Set_Attacks(Integer Attacks)
    {
        this.Attacks = Attacks;
    }

    //Leadership
    public Integer Get_Leadership()
    {
        return this.Leadership;
    }

    public void Set_Leadership(Integer Leadership)
    {
        this.Leadership = Leadership;
    }

    //Cool
    public Integer Get_Cool()
    {
        return this.Cool;
    }

    public void Set_Cool(Integer Cool)
    {
        this.Cool = Cool;
    }

    //Willpower
    public Integer Get_Willpower()
    {
        return this.Willpower;
    }

    public void Set_Willpower(Integer Willpower)
    {
        this.Willpower = Willpower;
    }

    //Intelligence
    public Integer Get_Intelligence()
    {
        return this.Intelligence;
    }

    public void Set_Intelligence(Integer Intelligence)
    {
        this.Intelligence = Intelligence;
    }

    //Allow_Basic
    public Boolean Get_Allow_Basic()
    {
        return this.Allow_Basic;
    }

    public void Set_Allow_Basic(Boolean Allow_Basic)
    {
        this.Allow_Basic = Allow_Basic;
    }

    //Allow_Close_Combat
    public Boolean Get_Allow_Close_Combat()
    {
        return this.Allow_Close_Combat;
    }

    public void Set_Allow_Close_Combat(Boolean Allow_Close_Combat)
    {
        this.Allow_Close_Combat = Allow_Close_Combat;
    }

    //Allow_Pistols
    public Boolean Get_Allow_Pistols()
    {
        return Allow_Pistols;
    }

    public void Set_Allow_Pistols(Boolean Allow_Pistols)
    {
        this.Allow_Pistols = Allow_Pistols;
    }

    //Allow_Special
    public Boolean Get_Allow_Special()
    {
        return this.Allow_Special;
    }

    public void Set_Allow_Special(Boolean Allow_Special)
    {
        this.Allow_Special = Allow_Special;
    }

    //Allow_Heavy
    public Boolean Get_Allow_Heavy()
    {
        return this.Allow_Heavy;
    }

    public void Set_Allow_Heavy(Boolean Allow_Heavy)
    {
        this.Allow_Heavy = Allow_Heavy;
    }

    //Allow_Grenades
    public Boolean Get_Allow_Grenades()
    {
        return this.Allow_Grenades;
    }

    public void Set_Allow_Grenades(Boolean Allow_Grenades)
    {
        this.Allow_Grenades = Allow_Grenades;
    }

    //Allow_Wargear
    public Boolean Get_Allow_Wargear()
    {
        return this.Allow_Wargear;
    }

    public void Set_Allow_Wargear(Boolean Allow_Wargear)
    {
        this.Allow_Wargear = Allow_Wargear;
    }

    //Allow_Adept_Weapons
    public Boolean Get_Allow_Adept_Weapons()
    {
        return this.Allow_Adept_Weapons;
    }

    public void Set_Allow_Adept_Weapons(Boolean Allow_Adept_WeaponsBoolean)
    {
        this.Allow_Adept_Weapons = Allow_Adept_Weapons;
    }

    //Allow_Acolyte_Weapons
    public Boolean Get_Allow_Acolyte_Weapons()
    {
        return this.Allow_Acolyte_Weapons;
    }

    public void Set_Allow_Acolyte_Weapons(Boolean Allow_Acolyte_Weapons)
    {
        this.Allow_Acolyte_Weapons = Allow_Acolyte_Weapons;
    }

    //Allow_Aberrant_Weapons
    public Boolean Get_Allow_Aberrant_Weapons()
    {
        return this.Allow_Aberrant_Weapons;
    }

    public void Set_Allow_Aberrant_Weapons(Boolean Allow_Aberrant_Weapons)
    {
        this.Allow_Aberrant_Weapons = Allow_Aberrant_Weapons;
    }

    //Allowed_Skills
    public String Get_Allowed_Skills()
    {
        return Allowed_Skills;
    }

    public void Set_Allowed_Skills(String Allowed_Skills)
    {
        this.Allowed_Skills = Allowed_Skills;
    }

    //Current_Skills
    public String Get_Current_Skills()
    {
        return Current_Skills;
    }

    public void Set_Current_Skills(String Current_Skills)
    {
        this.Current_Skills = Current_Skills;
    }

    //Get Ready status
    public String getReady() {
        return Ready;
    }

    //Set Ready Status
    public void setReady(String ready) {
        Ready = ready;
    }

    public String getCurrent_Weapons() {
        return Current_Weapons;
    }

    public void setCurrent_Weapons(String current_Weapons) {
        Current_Weapons = current_Weapons;
    }

    public String getCurrent_Wargear() {
        return Current_Wargear;
    }

    public void setCurrent_Wargear(String current_Wargear) {
        Current_Wargear = current_Wargear;
    }

    //Constructor
    public Table_Fighters (String Fighter_Name,
                           String Gang_Name,
                           String Fighter_Type,
                           Integer Base_Cost,
                           Integer Advancements,
                           Integer Movement,
                           Integer Weapon_Skill,
                           Integer Ballistic_Skill,
                           Integer Strength,
                           Integer Toughness,
                           Integer Wounds,
                           Integer Initiative,
                           Integer Attacks,
                           Integer Leadership,
                           Integer Cool,
                           Integer Willpower,
                           Integer Intelligence,
                           Boolean Allow_Basic,
                           Boolean Allow_Close_Combat,
                           Boolean Allow_Pistols,
                           Boolean Allow_Special,
                           Boolean Allow_Heavy,
                           Boolean Allow_Grenades,
                           Boolean Allow_Wargear,
                           Boolean Allow_Adept_Weapons,
                           Boolean Allow_Acolyte_Weapons,
                           Boolean Allow_Aberrant_Weapons,
                           String Allowed_Skills,
                           String Current_Skills)
    {
        this.Set_Fighter_Name(Fighter_Name);
        this.Set_Gang_Name(Gang_Name);
        this.Set_Fighter_Type(Fighter_Type);
        this.Set_Base_Cost(Base_Cost);
        this.Set_Total_Value(Base_Cost);
        this.Set_Experience(0);
        this.Set_Advancements(Advancements);
        this.Set_In_Recovery("Healthy");
        this.Set_Captured_By("Not Captured");
        this.Set_Movement(Movement);
        this.Set_Weapon_Skill(Weapon_Skill);
        this.Set_Ballistic_Skill(Ballistic_Skill);
        this.Set_Strength(Strength);
        this.Set_Toughness(Toughness);
        this.Set_Wounds(Wounds);
        this.Set_Initiative(Initiative);
        this.Set_Attacks(Attacks);
        this.Set_Leadership(Leadership);
        this.Set_Cool(Cool);
        this.Set_Willpower(Willpower);
        this.Set_Intelligence(Intelligence);
        this.Set_Allow_Basic(Allow_Basic);
        this.Set_Allow_Close_Combat(Allow_Close_Combat);
        this.Set_Allow_Pistols(Allow_Pistols);
        this.Set_Allow_Special(Allow_Special);
        this.Set_Allow_Heavy(Allow_Heavy);
        this.Set_Allow_Grenades(Allow_Grenades);
        //this.Set_Allow_Wargear(Allow_Wargear);
        this.Set_Allow_Wargear(true); //All fighters are now allowed to use Wargear as of Gang War 3.
        this.Set_Allow_Adept_Weapons(Allow_Adept_Weapons);
        this.Set_Allow_Acolyte_Weapons(Allow_Acolyte_Weapons);
        this.Set_Allow_Aberrant_Weapons(Allow_Aberrant_Weapons);
        this.Set_Allowed_Skills(Allowed_Skills);
        this.Set_Current_Skills(Current_Skills);
        this.setReady("Ready");
        this.setCurrent_Wargear("");
        this.setCurrent_Weapons("");
    }

}
