package shread.robert.tabletopgangroster;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rob on 18/07/2018.
 */

@Entity
public class Table_Weapons
{
    @PrimaryKey(autoGenerate = true)
    public int ID;

    public String Type; //Weapon Type, e.g. Pistol, Close Combat, etc.

    public String Name; //Weapon Name

    public String ShortRange; //Weapon's Short Range

    public String LongRange; //Weapon's Long Range

    public String ShortAccuracy; //Weapon's Short Range accuracy modifier

    public String LongAccuracy; //Weapon's long range accuracy modifier

    public String Strength; //Weapon's strength

    public String ArmourPenetration; //Weapon's Armour Penetration

    public String Damage; //Weapon's Damage

    public String Ammo; //Weapon's Ammo roll

    public String Traits; //Weapon's Traits - CSV, could be parsed later for a glossary

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShortRange()
    {
        return ShortRange;
    }

    public void setShortRange(String shortRange) {
        ShortRange = shortRange;
    }

    public String getLongRange()
    {
        return LongRange;
    }

    public void setLongRange(String longRange) {
        LongRange = longRange;
    }

    public String getShortAccuracy()
    {
        return ShortAccuracy;
    }

    public void setShortAccuracy(String shortAccuracy) {
        ShortAccuracy = shortAccuracy;
    }

    public String getLongAccuracy()
    {
        return LongAccuracy;
    }

    public void setLongAccuracy(String longAccuracy) {
        LongAccuracy = longAccuracy;
    }

    public String getStrength() {
        return Strength;
    }

    public void setStrength(String strength) {
        Strength = strength;
    }

    public String getArmourPenetration() {
        return ArmourPenetration;
    }

    public void setArmourPenetration(String armourPenetration) {
        ArmourPenetration = armourPenetration;
    }

    public String getDamage() {
        return Damage;
    }

    public void setDamage(String damage) {
        Damage = damage;
    }

    public String getAmmo() {
        return Ammo;
    }

    public void setAmmo(String ammo) {
        Ammo = ammo;
    }

    public String getTraits() {
        return Traits;
    }

    public void setTraits(String traits) {
        Traits = traits;
    }

    public Table_Weapons(String Type,
                         String Name,
                         String ShortRange,
                         String LongRange,
                         String ShortAccuracy,
                         String LongAccuracy,
                         String Strength,
                         String ArmourPenetration,
                         String Damage,
                         String Ammo,
                         String Traits)
    {
        this.setType(Type);
        this.setName(Name);
        this.setShortRange(ShortRange);
        this.setLongRange(LongRange);
        this.setShortAccuracy(ShortAccuracy);
        this.setLongAccuracy(LongAccuracy);
        this.setStrength(Strength);
        this.setArmourPenetration(ArmourPenetration);
        this.setDamage(Damage);
        this.setAmmo(Ammo);
        this.setTraits(Traits);
    }

    public String getStatBlock()
    {
        String statBlock = "";
        //Stat Header
        statBlock += String.format("%1$-4s","S");

        statBlock += String.format("%1$-4s","L");

        statBlock += String.format("%1$-4s","S");

        statBlock += String.format("%1$-4s","L");

        statBlock += String.format("%1$-4s","Str");

        statBlock += String.format("%1$-4s","AP");

        statBlock += String.format("%1$-4s","D");

        statBlock += String.format("%1$-4s","Ammo");

        statBlock += "\n";

        //Stat Line
        statBlock += String.format("%1$-4s", this.getShortRange());

        statBlock += String.format("%1$-4s", this.getLongRange());

        statBlock += String.format("%1$-4s", this.getShortAccuracy());

        statBlock += String.format("%1$-4s", this.getLongAccuracy());

        statBlock += String.format("%1$-4s", this.getStrength());

        statBlock += String.format("%1$-4s", this.getArmourPenetration());

        statBlock += String.format("%1$-4s", this.getDamage());

        statBlock += String.format("%1$-4s", this.getAmmo());

        statBlock += "\n";

        //new line for traits
        statBlock += this.getTraits();

        return statBlock;
    }
}
