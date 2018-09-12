package shread.robert.tabletopgangroster;

import android.os.AsyncTask;
import android.util.Log;

import java.security.KeyStore;
import java.util.ArrayList;

/**
 * Created by Rob on 08/03/2018.
 */

public class DatabaseInitialiser
{
    //public class DatabaseInitializer {

        public void populateAsync(final AppDatabase database)
        {
            new PopulateDbAsync(database).execute();
        }

        private class PopulateDbAsync extends AsyncTask<Void, Void, Void>
        {

            private final AppDatabase database;

            PopulateDbAsync(AppDatabase database)
            {
                this.database = database;
            }

            @Override
            protected Void doInBackground(final Void... params)
            {
                // If the Database isn't fully populated, rewrite the initial data.
                //Log.i("DBInit", "DbInit Started");
                if (database.get_Table_Fighter_Types_Dao().rowCount() == 0)
                {
                    //Log.i("DBInit","DbInit confirmed as needed - get_Table_Fighter_Types_Dao().rowCount() == 0 ");

                    //House Goliath
                    //Log.i("DBInit","House Goliath Insertion Started");
                    //Leader
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Goliath", "Leader", 145, 1, 4, 3, 3, 4, 4, 2, 3, 3, 5, 4, 8, 7, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Combat,Ferocity,Leadership,Shooting",""));
                    //Log.i("DBInit","Goliath Leader Inserted");
                    //Champion
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Goliath", "Champion", 110, 1, 4, 3, 4, 4, 4, 2, 4, 2, 6, 5, 8, 8, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Combat,Ferocity,Leadership,Shooting",""));
                    //Log.i("DBInit","Goliath Champion Inserted");
                    //Juve
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Goliath", "Juve", 25, 0, 5, 4, 5, 3, 3, 1, 3, 1, 9, 5, 10, 9, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Brawn,Ferocity",""));
                    //Log.i("DBInit","Goliath Juve Inserted");
                    //Ganger
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Goliath", "Ganger", 60, 0, 4, 4, 4, 4, 4, 1, 4, 1, 8, 5, 9, 8, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Combat,Ferocity,Shooting",""));
                    //Log.i("DBInit","Goliath Ganger Inserted");
                    //Log.i("DBInit","House Goliath Insertion Completed");

                    //House Escher
                    //Leader
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Escher", "Leader", 120, 1, 5, 3, 3, 3, 3, 2, 2, 3, 5, 6, 6, 7, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning,Ferocity,Leadership",""));
                    //Log.i("DBInit","Escher Leader Inserted");
                    //Champion
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Escher", "Champion", 95, 1, 5, 3, 3, 3, 3, 2, 2, 2, 6, 7, 6, 6, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning,Ferocity,Leadership",""));
                    //Log.i("DBInit","Escher Champion Inserted");
                    //Juve
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Escher", "Juve", 20, 0, 6, 4, 5, 2, 3, 1, 2, 1, 8, 9, 8, 8, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning",""));
                    //Log.i("DBInit","Escher Juve Inserted");
                    //Ganger
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Escher", "Ganger", 50, 0, 5, 4, 4, 3, 3, 1, 3, 1, 7, 8, 7, 7, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning,Ferocity",""));
                    //Log.i("DBInit","Escher Ganger Inserted");

                    //House Orlock
                    //Leader
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Orlock","Leader",120,1,5,3,3,3,3,3,4,2,4,5,5,5,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Ferocity,Leadership,Shooting,Savant",""));
                    //Champion
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Orlock","Champion",95,1,5,4,3,3,3,2,4,2,5,6,6,6,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Ferocity,Leadership,Shooting,Savant",""));
                    //Juve
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Orlock","Juve",30,0,6,5,5,3,3,1,3,1,7,8,8,8,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Ferocity,Shooting,Savant",""));
                    //Ganger
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Orlock","Ganger",55,0,5,4,4,3,3,1,4,1,6,7,7,7,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Ferocity,Shooting,Savant",""));

                    //House Cawdor
                    //Leader
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Cawdor","Leader",115,1,5,3,4,3,3,2,4,2,4,6,5,5,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Brawn,Combat,Ferocity,Leadership,Savant",""));
                    //Champion
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Cawdor","Champion",95,1,5,4,3,3,3,2,4,2,5,6,7,6,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Brawn,Combat,Ferocity,Leadership",""));
                    //Juve
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Cawdor","Juve",20,0,6,5,5,3,3,1,3,1,8,8,8,9,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Ferocity",""));
                    //Ganger
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Cawdor","Ganger",45,0,5,4,4,3,3,1,4,1,7,7,7,7,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Brawn,Combat,Ferocity",""));

                    //House Van Saar
                    //Leader
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Van Saar","Leader",110,1,5,4,2,3,3,2,4,2,6,5,6,6,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Cunning,Leadership,Shooting,Savant",""));
                    //Champion
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Van Saar","Champion",105,1,5,3,3,3,3,2,4,2,6,5,7,5,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Combat,Cunning,Leadership,Shooting,Savant",""));
                    //Juve
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Van Saar","Juve",25,0,6,5,5,3,3,1,3,1,8,8,8,6,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Shooting,Savant",""));
                    //Ganger
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Van Saar","Ganger",55,0,5,4,4,3,3,1,4,1,6,7,7,5,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Combat,Cunning,Shooting,Savant",""));

                    //House Delaque
                    //Leader
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Delaque","Leader",105,1,5,3,3,3,3,2,3,2,6,6,5,6,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Cunning,Leadership,Shooting,Savant",""));
                    //Champion
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Delaque","Champion",95,1,5,3,3,3,3,2,4,2,7,6,6,6,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Cunning,Leadership,Shooting,Savant",""));
                    //Juve
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Delaque","Juve",20,0,6,5,5,3,3,1,3,1,9,8,8,8,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Cunning,Shooting",""));
                    //Ganger
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Delaque","Ganger",55,0,5,4,4,3,3,1,4,1,7,7,6,7,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning,Shooting",""));

                    //Genestealer Cult
                    //Adept
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Genestealer Cult","Adept",120,1,4,3,3,3,3,2,3,2,3,5,5,4,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning,Ferocity,Leadership",""));
                    //Acolyte
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Genestealer Cult","Acolyte",85,1,4,3,3,4,3,1,3,1,4,5,7,6,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.FALSE,"Agility,Combat,Cunning,Ferocity,Leadership",""));
                    //Aberrant
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Genestealer Cult","Aberrant",90,1,4,3,6,5,4,2,5,2,9,4,6,10,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,Boolean.TRUE,"","Unstoppable"));
                    //Neophyte
                    database.get_Table_Fighter_Types_Dao().insertFighterType(new Table_Fighter_Types("Genestealer Cult","Neophyte",45,0,4,4,4,3,3,1,4,1,7,5,6,8,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE,Boolean.FALSE,"Agility,Combat,Cunning,Ferocity",""));

                    //Chaos Cult

                    //Venators

                    //Log.i("DBInit","Current Total Rows: " + database.get_Table_Fighter_Types_Dao().rowCount());
                }

                if(database.get_Table_Skills_Dao().rowCount() == 0)
                {
                    //Time to insert some skills
                    //Agility
                    String thisSkill;
                    thisSkill = "Agility";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Catfall", thisSkill, "When this fighter falls or jumps down from a ledge, they count as having moved half the vertical distance. In addition, if they are not Seriously Injured, or taken Out of Action by a fall, make an Initiative test for them – if it is passed, they remain standing rather than being Pinned."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Climber", thisSkill, "When the fighter climbs, the vertical distance they move is not halved. In other words, they always count as climbing up or down a ladder."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Dodge", thisSkill, "If this fighter suffers a wound from a ranged or close combat attack, roll a D6. On a 6, the attack is dodged and has no effect, otherwise continue to make a save roll as normal. If the model dodges a weapon that uses a Blast marker or Flame template, a roll of 6 does not automatically cancel the attack – instead, it allows the fighter to move up to 2’’ before seeing whether they are hit. They cannot move within 1’’ of an enemy fighter."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Mighty Leap", thisSkill, "When measuring the distance of a gap this fighter wishes to leap across, ignore the first 2\" of the distance. This means a fighter with this skill may leap over gaps of 2\" or less without testing against their Initiative. All other rules for leaping over gaps still apply."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Spring Up", thisSkill, "If this fighter is Pinned when they are activated, make an Initiative check for them. If the check is passed the fighter can make a free Stand Up action."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Sprint", thisSkill, "If this fighter makes two Move (Simple) actions in a turn, they can use the second one to Sprint. This lets them make a Double Move instead of a Standard Move for that action."));

                    //Brawn
                    thisSkill = "Brawn";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Bull Charge", thisSkill,"When this fighter makes close combat attacks as part of a Charge action, any Melee weapons they use gain the Knockback Trait and are resolved at +1 Strength."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Bulging Biceps", thisSkill, "This fighter may wield an Unwieldy weapon in one hand rather than the usual two. Note that Unwieldy weapons still take up the space of two weapons with regards to how many a fighter may carry."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Crushing Blow", thisSkill, "Before rolling to hit for a fighter's close combat attacks, the controlling player can nominate one dice to make a Crushing Blow. This cannot be a dice that is rolling to hit for a pistol. If that dice hits, the attack’s Strength and Damage are each increased by 1."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Headbutt", thisSkill, "If the fighter is Engaged, they can use the following action: Headbutt (Basic) – Pick an engaged enemy fighter and roll two D6. If either result is equal to or higher than their Toughness, they suffer a hit with a Strength equals to this fighter's Strength +2 resolved at Damage 2. However, if both dice score lower than the enemy fighter's Toughness, this fighter instead suffers a hit equal to their own Strength."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Hurl", thisSkill, "If the fighter is Active or Engaged, they can make the following action: Throw Opponent (Basic) – Pick an Engaged enemy fighter or a Seriously Injured enemy fighter in base contact. If that fighter is standing, the opposing player can make an Initiative check for them; if this is failed, or if the fighter was Seriously Injured, the enemy fighter is hurled. Pick a direction, then move the enemy fighter D3’’ in that direction – if they were standing, they are Pinned after moving. If they hit a standing fighter or piece of terrain (other than a low obstruction), they stop moving and suffer a Strength 3 hit. If they hit another fighter, that fighter also suffers a Strength 3 hit and is Pinned."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Iron Jaw", thisSkill, "This fighter's Toughness is treated as being 2 higher than normal when another fighter makes unarmed attacks against them in close combat."));

                    //Combat
                    thisSkill = "Combat";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Combat Master", thisSkill, "The fighter never suffers penalties to their hit rolls for interference and can always grant assists regardless of how many enemy fighters they are engaged with."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Counter-Attack", thisSkill, "When the fighter makes Reaction attacks in close combat, they roll one additional Attack dice for each of the attacker’s attacks that failed to hit (whether they missed, they were parried, etc)."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Disarm", thisSkill, "Any Melee weapons used by the fighter gain the Disarm trait. If a weapon already has that trait, then the target will be disarmed on a natural roll of 5 or 6, not just 6."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Parry", thisSkill, "The fighter can parry attacks as though they were carrying a weapon with the Parry Trait. If they already have one ore more weapons with this Trait, they can parry one additional attack."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Rain of Blows", thisSkill, "This fighter treats the Fight action as Simple rather than Basic."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Step Aside", thisSkill, "If the fighter is hit in close combat, the fighter can attempt to step aside. Make an Initiative check for them. If the check is passed, the attack misses. This skill can only be used once per enemy in each round or close combat – in other words, if an enemy makes more than one attack, the fighter can only attempt to step aside from one of them."));

                    //Cunning
                    thisSkill = "Cunning";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Backstab", thisSkill, "Any close combat weapons used by this fighter gain the Backstab Trait. If they already have the Trait, add 3 to the attacker's Strength rather than 1 when the Trait is used."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Escape Artist", thisSkill, "When this fighter makes a Retreat action, add 2 to the result of the Initiative check (a natural 1 still fails). In addition, if this fighter is Captured at the end of a battle, roll a D6. On a result of 2 or more, they slip away and are not captured."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Evade", thisSkill, "If an enemy targets this fighter with a ranged attack, and this fighter is Active and not in Partial cover or Full cover, there is an additional -1 modifier to the hit roll, or a -2 modifier if they are at Long range."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Infiltrate", thisSkill, "If this fighter should be set up at the start of a battle, they are instead placed to one side. Then, immediately before the start of the first round, their controlling player sets them up anywhere on the battlefield that is not visible to any enemy fighters, and not within 6’’ of any of them. If both players have fighters with this skill, take turns to set one up, starting with the winner of a roll-off."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Lie Low", thisSkill, "While this fighter is Prone, enemy fighters cannot target them with ranged attacks unless they are within the attacking weapon's Short range. Weapons that do not have a Short range are unaffected by this rule."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Overwatch", thisSkill, "If this fighter is Active and Readied, they can interrupt a visible enemy fighter’s action as soon as it is declared but before it is carried out. This fighter loses their Ready marker, then immediately makes a Shoot action, targeting the enemy fighter whose action has been declared. If the enemy is Pinned or Seriously Injured, their turn ends immediately – their action is not made."));

                    //Ferocity
                    thisSkill = "Ferocity";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Berserker", thisSkill, "When this fighter makes close combat attacks as part of a Charge action, they roll an additional Attack dice."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Fearsome", thisSkill, "If an enemy makes a Charge action that targets this fighter, they must make a Willpower check before moving. If the check is failed, they cannot move and their action ends immediately."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Impetuous", thisSkill, "When this fighter Consolidates at the end of a close combat, they can move up to 4’’ instead of up to 2’’."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Nerves of Steel", thisSkill, "When the fighter is hit by a ranged attack, make a Cool check for them, if it is passed they are not Pinned."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("True Grit", thisSkill, "When making an Injury roll for the fighter, roll one less Injury dice (for example, a Damage 2 weapon would roll one dice). Against attacks with Damage 1, roll two dice – the player controlling the fighter with True Grit, can then choose to discard one before resolving the dice effects."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Unstoppable", thisSkill, "Before making a Recovery test for this fighter in the End phase, roll a D6. On a result of 4 or more, one Flesh Wound they have suffered is discarded. If they do not have any Flesh Wounds, and the results is 4 or more, roll one additional dice for their Recovery test."));

                    //Leadership
                    thisSkill = "Leadership";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Commanding Presence", thisSkill, "If a group is activated, and this fighter is chosen to lead the group, it can include one more fighter than normal (ie, a Champion could activate two other fighters instead of one, or a Leader could activate three)"));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Inspirational", thisSkill, "If a friendly fighter within 6’’ of this fighter fails a Cool check, make a Leadership check for this fighter. If it passes, the Cool check is also treated as having been passed."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Iron Will", thisSkill, "Subtract 1 from the result of any Bottle rolls while the Leader is on the battlefield and not Seriously Injured."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Mentor", thisSkill, "Make a Leadership check for this fighter each time another fighter within 6’’ gains a point of Experience. If the check passes, that fighter gains 2 Experience instead of 1."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Overseer", thisSkill, "If the fighter is Active, they can attempt to make the following action: Order (Double) – Pick a friendly fighter within 12’’. That fighter can immediately make two actions as though it were their turn, even if they are not Ready. If they are Ready, these actions do not remove their Ready status."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Regroup", thisSkill, "If this fighter is Active at the end of their turn, make a Leadership check for them. If it passes, each friendly Broken fighter within 6’’ recovers from being Broken."));

                    //Savant
                    thisSkill = "Savant";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Ballistics Expert", thisSkill, "When this fighter makes an Aim action, make an Intelligence check for them. If it passes, they gain an additional +1 modifier to their hit roll."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Connected", thisSkill, "This fighter can make a Trade action in the post-battle sequence, in addition to any other actions they make (meaning they could even make two Trade actions). They cannot do this if they are not able to make any actions."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Fixer", thisSkill, "In the Receive Rewards step of the post-battle sequence, as long as the fighter is not captured or in recovery, their gang earns an additional D3x10 credits. Note that they do not need to have taken part in the battle."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Medicae", thisSkill, "When this fighter assists a friendly fighter who is making a Recovery test, re-roll any Out of Action results. If the result of a re-rolled dice is also Out of Action, the result stands."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Munitioneer", thisSkill, "Whenever an Ammo check is failed for this fighter or another fighter from the same gang within 6’’, it can be rerolled."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Savvy Trader", thisSkill, "When this fighter makes a Trade post-battle action, add 1 to the result of the roll to see whether the item is available and reduce the cost of the item by 20 credits (to a minimum of 10)."));

                    //Shooting
                    thisSkill = "Shooting";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Fast Shot", thisSkill, "This fighter treats the Shoot action as Simple rather than Basic, as long as they do not attack with an Unwieldy weapon for either action."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Gunfighter", thisSkill, "If the fighter attacks with two pistols, they do not suffer the -1 penalty to the hit rolls and can, if they wish, target a different enemy with each pistol."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Hip Shooting", thisSkill, "If the fighter is Active, they can make the following action: Run and Gun (Double) – The fighter makes a Double Move then makes an attack with a Ranged weapon. The hit roll has an additional -1 modifier, and Unwieldy weapons cannot be used."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Marksman", thisSkill, "The fighter is not affected by the rules for target Priority. In addition, if they score a 6 to hit when making a ranged attack that does not use a Blast marker, they score a critical hit, and the attack’s Damage is doubled (if they are firing a Rapid Fire weapon, only the first hit’s Damage is doubled)."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Precision Shot", thisSkill, "If the hit roll for a ranged attack made by the fighter is a natural 6 (when using a weapon that does not have the Blast Trait), the shot hits an exposed area and the opponent cannot make an armour save."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Trick Shot", thisSkill, "When this fighter makes ranged attacks, they do not suffer a penalty to the hit roll for the target being Engaged or in Partial Cover. In addition, if the target is in Full Cover, they suffer a -1 penalty instead of -2."));

                    //Acolyte
                    thisSkill = "Adept";
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Familiar", thisSkill, "The Adept is accompanied by a familiar – a psychic manifestation of their will. This ability can be taken up to twice by an Adept, granting them up to two Familiars. Each Familiar must be represented by a miniature and has the following profile: M 4\" WS 5+ BS - S 2 T 2 W 1 I 2+ A 1 Ld - Cl - Wil - Int - Familiars have the Catfall and Climber skills. If a Leadership, Cool, Willpower or Intelligence check ever needs to be made for a Familiar, use the Adept’s characteristic value instead. The familiar is always activated at the same time as the Adept, in the same way that a Group Activation, the Familiar does not count towards the two fighters they can activate. If the Adept goes Out of Action, the familiar is removed from play. Familiars never suffer serious injuries and cannot gain Experience."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Hypnosis", thisSkill, "With little more than a piercing stare, the Adept can dominate the minds of the weaker-willed. Once per round, when an enemy fighter within 9’’ of the Adept makes an ranged or close combat attack, the Adept can use this ability – its use must be declared before the hit roll is made. The opposing player makes a Willpower check for the attacking fighter. If the check is failed, the attack is not made – no hit roll is made and no ammo roll is required – but the action still counts as having been used."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Unbreakable Will", thisSkill, "The Adept channels some measure of the Patriarch’s control over nearby cult members. Whenever a Nerve or Willpower test is made for another fighter from the gang who is within 9’’ of the Adept, use the Adept’s characteristic value."));
                    database.get_Table_Skills_Dao().insertSkill(new Table_Skills("Zealot", thisSkill, "The mere presence of the Adept can drive their cult brethren to aggressive acts of hatred. When another fighter from the same gang who is within 9’’ of the Adept makes close combat attacks, you can re-roll any dice that roll a natural 1."));
                }

                //Populate the Weapons Table if it's empty
                if(database.get_Table_Weapons_Dao().rowCount() == 0)
                {
                    //Pistols
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol","Autopistol","4\"","12\"","+1","-","3","-","1","4+","Pistol, Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Bolt Pistol","6\"","12\"","+2","-","4","-1","2","6+","Pistol"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Hand Flamer", "-", "T", "-", "-", "3", "-", "1", "5+", "Blaze, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Laspistol", "8\"", "12\"","+1","-", "3", "-", "1","2+","Pistol, Plentiful"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Las sub-carbine", "4\"", "12\"", "+1", "-", "3", "-", "1", "4+", "Pistol, Plentiful, Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Needle Pistol", "4\"", "9\"", "+2", "-", "4", "-1", "-", "6+", "Pistol, Scarce, Toxin"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Plasma Pistol - Low Power", "6\"", "12\"", "+2", "-", "5", "-1", "2", "5+", "Pistol, Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Plasma Pistol - Maximal Power", "6\"", "12\"", "+1", "-", "7", "-2", "3", "5+", "Pistol, Scarce, Unstable"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Stub Gun", "6\"", "12\"", "+2", "-","3","-","1","4+","Pistol, Plentiful"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Stub Gun - Dumdum Rounds","5\"","10\"","+1","-","4","-","1","4+","Pistol, Limited"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Pistol", "Web Pistol", "-", "T", "-", "-", "4", "-", "-", "6+", "Template, Web"));

                    //Basic Weapons
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Autogun","8\"","24\"","+1","-","3","-","1","4+","Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Boltgun","12\"","24\"","+1","-","4","-1","2","6+","Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Combat Shotgun - Salvo Fire","4\"","12\"","+1","-","4","-","2","4+","Knockback, Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Combat Shotgun - Shredder Blast", "-", "T", "-", "-", "2", "-", "1", "4+", "Scattershot, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Combat Shotgun - Firestorm", "-", "T", "-", "-", "5", "-1", "1", "6+", "Blaze, Limited, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Lasgun","18\"","24\"","+1","-","3","-","1","2+","Plentiful"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Las Carbine","10\"","24\"","+1","-","3","-","1","4+","Plentiful, Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Sawn-off Shotgun","4\"","8\"","+2","-","3","-","1","6+","Plentiful, Scattershot"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Shotgun - Acid Rounds","4\"","16\"","+1","-","3","-1","1","4+","Blaze, Scattershot"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Shotgun - Executioner", "4\"", "16\"","-1","+1","4","-2","2","6+","Knockback, Limited"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Shotgun - Inferno","4\"","16\"","+1","-","3","-","1","5+","Blaze, Limited"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Shotgun - Scatter Shell","4\"","8\"","+2","-","2","-","1","4+","Scattershot"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Shotgun - Solid Slug","8\"","16\"","+1","-","4","-","2","4+","Knockback"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Stub Cannon","9\"","18\"","-","-","5","-","1","3+","Knockback"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Suppression Laser - Broad Burst","4\"","8\"","+2","-","2","-","1","4+","Plentiful, Scattershot"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Basic","Suppression Laser - Short Burst","8\"","16\"","+1","-","4","-","2","4+","Knockback, Plentiful"));

                    //Heavy Weapons
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Harpoon Launcher","6\"","18\"","+2","-","5","-3","1","5+","Drag, Impale, Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Heavy Bolter","18\"","36\"","+1","-","5","-2","2","6+","Rapid Fire (2), Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Heavy Flamer","-","T","-","-","5","-2","1","5+","Blaze, Template, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Heavy Stubber","20\"","40\"","-","-1","4","-1","1","4+","Rapid Fire (2), Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","'Krumper' Rivet Cannon - Rapid Fire","3\"","9\"","+2","-","4","-1","2","3+","Rapid Fire (1), Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","'Krumper' Rivet Cannon - Super-heated Rivet","3\"","9\"","+2","-","6","-2","2","3+","Blaze, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Lascannon","24\"","48\"","-","+1","10","-3","3","4+","Knockback, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Mining Laser","18\"","24\"","-","-1","9","-3","3","3+","Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Missile Launcher - Frag","24\"","48\"","+1","-","4","-1","1","6+","Blast (5\"), Knockback, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Missile Launcher - Krak","24\"","48\"","+1","-","6","-2","3","6+","Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Multi-melta","12\"","24\"","+1","-","8","-4","3","4+","Blast (3\"), Melta, Scarce, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Plasma Cannon - Low Power","18\"","36\"","+1","-","6","-1","2","5+","Rapid Fire (1), Scarce, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Plasma Cannon - Max Power","18\"","36\"","+1","-","8","-2","1","5+","Blast (3\"), Scarce, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Rad Cannon","16\"","32\"","-","-1","2","-2","1","4+","Blast (3\"), Rad-phage, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Seismic Cannon - Short Wave","12\"","24\"","-","-1","6","-1","2","5+","Knockback, Rapid Fire (1), Seismic, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Heavy","Seismic Cannon - Long Wave","12\"","24\"","-1","-","3","-","1","5+","Knockback, Rapid Fire (2), Seismic, Unwieldy"));

                    //Special Weapons
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Combi - Bolter","12\"","24\"","+1","-","4","-1","2","6+","Combi, Rapid Fire (1)"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Combi - Lasgun","18\"","24\"","+1","-","3","-","1","2+","Combi, Plentiful"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Combi - Flamer","-","T","-","-","4","-1","1","5+","Combi, Blaze, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Combi - Melta","6\"","12\"","+1","-","8","-4","3","4+","Combi, Melta, Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Combi - Needler","9\"","18\"","+1","-","4","-1","-","6+","Combi, Scarce, Toxin"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Combi - Plasma","12\"","24\"","+2","-","5","-1","2","5+","Combi, Rapid Fire (1), Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Flamer","-","T","-","-","4","-1","1","5+","Blaze, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Grav-gun","9\"","18\"","+1","-","*","-1","2","5+","Blast (3\"), Concussion, Graviton Pulse"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Grenade Launcher - Frag","6\",","24\"","-1","-","3","-","1","6+","Blast (3\"), Knockback"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Grenade Launcher - Krak","6\"","24\"","-1","-","6","-2","2","6+","-"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Grenade Launcher - Choke","6\"","24\"","-1","-","-","-","-","5+","Blast (3\"), Gas, Limited"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Grenade Launcher - Scare Gas","6\"","24\"","-1","-","-","-","-","6+","Blast (3\"), Fear, Gas, Limited"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Grenade Launcher - Smoke","6\"","24\"","-1","-","-","-","-","4+","Smoke"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Long Las","18\"","36\"","-","+1","4","-","1","2+","Plentiful"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Meltagun","6\"","12\"","+1","-","8","-4","3","4+","Melta, Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Needle Rifle","9\"","18\"","+2","-","4","-2","-","6+","Scarce, Toxin"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","'Nightshade' Chem-thrower","-","T","-","-","-","-","-","5+","Gas, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Plasma Gun - Low Power","12\"","24\"","+2","-","5","-1","2","5+","Rapid Fire (1), Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Plasma Gun - Max Power","12\"","24\"","+1","-","7","-2","3","5+","Scarce, Unstable"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Rad Gun","-","T","-","-","2","-2","1","4+","Rap-phage, Template"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Special","Web Gun","-","T","-","-","5","-","-","5+","Template, Web"));

                    //Grenades
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Blasting Charge","-","Sx2","-","-","5","-1","2","5+","Blast (5\"), Knockback, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Choke Gas Grenade","-","Sx3","-","-","-","-","-","5+","Blast (3\"), Gas, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Demolitions Charge","-","Sx2","-","-","6","-3","3","*","Blast (5\"), Grenade, Single Shot"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Frag Grenade","-","Sx3","-","-","3","-","1","4+","Blast (3\"), Knockback, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Incendiary Charge","-","Sx3","-","-","3","-","1","5+","Blast (5\"), Blaze, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Krak Grenade","-","Sx3","-","-1","6","-2","2","4+","Demolitions, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Melta Bomb","-","Sx3","-","-1","8","-4","3","6+","Demolitions, Grenade, Melta, Scarce"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Photon Flash Flare","-","Sx3","-","-","-","-","-","5+","Blast (5\"), Flash, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Rad Grenade","-","Sx3","-","-","3","-2","1","4+","Blast (3\"), Grenade, Rad-phage"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Scare Gas Grenade","-","Sx3","-","-","-","-","-","6+","Blast (3\"), Fear, Gas, Grenade"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Grenade","Smoke Grenade","-","Sx3","-","-","-","-","-","4+","Smoke, Grenade"));

                    //Close Combat
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Axe","-","E","-","-","+1","-","1","-","Melee, Disarm"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Bonesword","-","E","-","+1","S","-2","1","-","Melee, Parry"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Brute Cleaver","-","E","-","+1","S","-1","1","-","Melee, Disarm"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Chainaxe","-","E","-","+1","+1","-1","1","-","Melee, Disarm, Parry, Rending"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Chainsword","-","E","-","+1","S","-1","1","-","Melee, Parry, Rending"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Digi Laser","E","3\"","-","-","1","-","1","-","Melee, Digi, Versatile"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Fighting Knife","-","E","-","-","S","-1","1","-","Melee, Backstab"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Flail","-","E","-","+1","+1","-","1","-","Melee, Entangle"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Flensing Claw","-","E","-","+1","S","-","1","-","Melee, Disarm"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Grab Hook","E","2\"","-","-","S","-","1","-","Melee, Disarm, Versatile"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Heavy Rock Cutter","-","E","-","-","+4","-4","3","-","Melee, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Heavy Rock Drill","-","E","-","-","+2","-3","2","-","Melee, Pulverise, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Heavy Rock Saw","-","E","-","+1","+3","-3","2","-","Melee, Rending, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","'Hystrar' Pattern Energy Shield","-","E","-","-","S","-","1","-","Melee, Energy Shield, Knockback"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Las Cutter","E","2\"","+1","-","9","-3","2","6+","Melee, Scarce, Versatile"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Lash Whip","E","2\"","-","-","S","-","1","-","Melee, Versatile"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Maul (Club)","-","E","-","-","S","-","2","-","Melee"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Power Axe","-","E","-","-","+2","-2","1","-","Melee, Power, Disarm"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Power Hammer","-","E","-","-","+1","-1","2","-","Melee, Power"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Power Knife","-","E","-","-","+1","-2","1","-","Melee, Backstab, Power"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Power Maul","-","E" ,"-","-","+2","-1","1","-","Melee, Power"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Power Pick","-","E","-","-","+1","-3","1","-","Melee, Power, Pulverise"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Aberrant","Power Maul","-","E" ,"-","-","+2","-1","1","-","Melee, Power"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Aberrant","Power Pick","-","E","-","-","+1","-3","1","-","Melee, Power, Pulverise"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Power Sword","-","E","-","-","+1","-2","1","-","Melee, Parry, Power"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","'Renderizer' Serrated Axe","-","E","-","-","+2","-1","2","-","Melee, Pulverise, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Servo-claw","-","E","-","-","+2","-","2","-","Melee"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Shock Baton","-","E","-","-","S","-","1","-","Melee, Parry, Shock"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Shock Stave","E","2\"","-","-","+1","-","1","-","Melee, Shock, Versatile"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Shock Whip","E","3\"","-","-","+1","-","1","-","Melee, Shock, Versatile"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Spud-jacker","-","E","-","-","+1","-","1","-","Melee, Knockback"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Staff of Office","-","E","-","-","S","-","1","-","Melee, Parry"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Stiletto Knife","-","E","-","+1","S","-","1","-","Melee, Toxin"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Stiletto Sword","-","E","-","-","S","-1","1","-","Melee, Parry, Toxin"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Sword","-","E","-","+1","S","-1","1","-","Melee, Parry"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Thunder Hammer","-","E","-","-","+1","-1","3","-","Melee, Power, Shock"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Toxin Injector Claw","-","E","-","-","S","-1","1","-","Melee, Toxin"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Two-handed Axe","-","E","-","-1","+2","-","2","-","Melee, Unwieldy"));
                    database.get_Table_Weapons_Dao().insertWeapon(new Table_Weapons("Close Combat","Two-handed Hammer","-","E","-","-1","+1","-","3","-","Melee, Knockback, Unwieldy"));
                }

                if(database.get_Table_Wargear_Dao().rowCount() == 0)
                {
                    //Armour
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Armoured Bodyglove",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Light Carapace",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Heavy Carapace",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Flak Armour",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Furnace Plates",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Hazard Suit",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Mesh Armour",""));
                    //Force fields
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Conversion Field",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Displacer Field",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Refractor Field",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Ammo Cache",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Armoured Undersuit",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Bio-booster",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Bio-scanner",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Chem-Synth",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Cult Icon",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Drop Rig",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Extra Arm",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Filter Plugs",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Grapnel-Launcher",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Grav-chute",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Medicae Kit",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Photo-goggles",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Respirator",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Servo Harness - Partial",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Servo Harness - Full",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Skinblade",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Stimm-Slug Stash",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Strip Kit",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Web Solvent",""));
                    //Status Items
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Gold-Plated Gun",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Exotic Furs",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Opulent Jewellery",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Uphive Raiments",""));
                    //Servo Skulls
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Sensor Skull",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Medi Skull",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Gun Skull",""));
                    //Exotic Beasts
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Caryatid",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Cyber-mastiff",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Cyberarachnid",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Phyrr Cat",""));
                    database.get_Table_Wargear_Dao().insertWargear(new Table_Wargear("Sumpkroc",""));
                }

                return null;
            }
        }
    //}
}
