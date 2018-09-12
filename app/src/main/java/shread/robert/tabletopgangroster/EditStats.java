package shread.robert.tabletopgangroster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditStats extends AppCompatActivity
{

    String FighterBeingViewed;
    Table_Fighters thisFighter;
    TextView textMovement;
    TextView textWeaponSkill;
    TextView textBallisticSkill;
    TextView textStrength;
    TextView textToughness;
    TextView textWounds;
    TextView textInitiative;
    TextView textAttacks;
    TextView textLeadership;
    TextView textCool;
    TextView textWill;
    TextView textIntelligence;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stats);

        Bundle extras = getIntent().getExtras();

        if(extras.getString("Fighter_Name")!= null)
        {
            FighterBeingViewed = extras.getString("Fighter_Name");
        }

        setTitle(FighterBeingViewed + "'s Stats");

        //Get this fighter's data
        thisFighter = AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().getThisFighterByName(FighterBeingViewed);

        textMovement = findViewById(R.id.textMovement);
        textMovement.setText(Integer.toString(thisFighter.Get_Movement())+"\"");
        textWeaponSkill = findViewById(R.id.textWeaponSkill);
        textWeaponSkill.setText(Integer.toString(thisFighter.Get_Weapon_Skill())+"+");
        textBallisticSkill = findViewById(R.id.textBallisticSkill);
        textBallisticSkill.setText(Integer.toString(thisFighter.Get_Ballistic_Skill())+"+");
        textStrength = findViewById(R.id.textStrength);
        textStrength.setText(Integer.toString(thisFighter.Get_Strength()));
        textToughness = findViewById(R.id.textToughness);
        textToughness.setText(Integer.toString(thisFighter.Get_Toughness()));
        textWounds = findViewById(R.id.textWounds);
        textWounds.setText(Integer.toString(thisFighter.Get_Wounds()));
        textInitiative = findViewById(R.id.textInitiative);
        textInitiative.setText(Integer.toString(thisFighter.Get_Initiative())+"+");
        textAttacks = findViewById(R.id.textAttacks);
        textAttacks.setText(Integer.toString(thisFighter.Get_Attacks()));
        textLeadership = findViewById(R.id.textLeadership);
        textLeadership.setText(Integer.toString(thisFighter.Get_Leadership())+"+");
        textCool = findViewById(R.id.textCool);
        textCool.setText(Integer.toString(thisFighter.Get_Cool())+"+");
        textWill = findViewById(R.id.textWill);
        textWill.setText(Integer.toString(thisFighter.Get_Willpower())+"+");
        textIntelligence = findViewById(R.id.textIntelligence);
        textIntelligence.setText(Integer.toString(thisFighter.Get_Intelligence())+"+");
    }

    public void clickMovementIncrease(View view)
    {
        thisFighter.Set_Movement(thisFighter.Get_Movement()+1);
        textMovement = findViewById(R.id.textMovement);
        textMovement.setText(Integer.toString(thisFighter.Get_Movement())+"\"");
        SaveFighter(thisFighter);
    }

    public void clickMovementDecrease(View view)
    {
        if(thisFighter.Get_Movement() > 1)
        {
            thisFighter.Set_Movement(thisFighter.Get_Movement()-1);
            textMovement.setText(Integer.toString(thisFighter.Get_Movement())+"\"");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickWSIncrease(View view)
    {
        if(thisFighter.Get_Weapon_Skill() >2)
        {
            thisFighter.Set_Weapon_Skill(thisFighter.Get_Weapon_Skill()-1);
            textWeaponSkill.setText(Integer.toString(thisFighter.Get_Weapon_Skill())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickWSDecrease(View view)
    {
        if(thisFighter.Get_Weapon_Skill()<6)
        {
            thisFighter.Set_Weapon_Skill(thisFighter.Get_Weapon_Skill()+1);
            textWeaponSkill.setText(Integer.toString(thisFighter.Get_Weapon_Skill())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickBSIncrease(View view)
    {
        if(thisFighter.Get_Ballistic_Skill()>2)
        {
            thisFighter.Set_Ballistic_Skill(thisFighter.Get_Ballistic_Skill()-1);
            textBallisticSkill.setText(Integer.toString(thisFighter.Get_Ballistic_Skill())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickBSDecrease(View view)
    {
        if(thisFighter.Get_Ballistic_Skill()<6)
        {
            thisFighter.Set_Ballistic_Skill(thisFighter.Get_Ballistic_Skill()+1);
            textBallisticSkill.setText(Integer.toString(thisFighter.Get_Ballistic_Skill())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickSIncrease(View view)
    {
        if(thisFighter.Get_Strength()<10)
        {
            thisFighter.Set_Strength(thisFighter.Get_Strength()+1);
            textStrength.setText(Integer.toString(thisFighter.Get_Strength()));
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickSDecrease(View view)
    {
        if(thisFighter.Get_Strength()>1)
        {
            thisFighter.Set_Strength(thisFighter.Get_Strength()-1);
            textStrength.setText(Integer.toString(thisFighter.Get_Strength()));
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickTIncrease(View view)
    {
        if(thisFighter.Get_Toughness()<10)
        {
            thisFighter.Set_Toughness(thisFighter.Get_Toughness()+1);
            textToughness.setText(Integer.toString(thisFighter.Get_Toughness()));
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickTDecrease(View view)
    {
        if(thisFighter.Get_Toughness() > 1)
        {
            thisFighter.Set_Toughness(thisFighter.Get_Toughness()-1);
            textToughness.setText(Integer.toString(thisFighter.Get_Toughness()));
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickWIncrease(View view)
    {
        if(thisFighter.Get_Wounds()<10)
        {
            thisFighter.Set_Wounds(thisFighter.Get_Wounds()+1);
            textWounds.setText(Integer.toString(thisFighter.Get_Wounds()));
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickWDecrease(View view)
    {
        if(thisFighter.Get_Wounds()>1)
        {
            thisFighter.Set_Wounds(thisFighter.Get_Wounds()-1);
            textWounds.setText(Integer.toString(thisFighter.Get_Wounds()));
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickIIncrease(View view)
    {
        if(thisFighter.Get_Initiative() > 2)
        {
            thisFighter.Set_Initiative(thisFighter.Get_Initiative()-1);
            textInitiative.setText(Integer.toString(thisFighter.Get_Initiative())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickIDecrease(View view)
    {
        if(thisFighter.Get_Initiative() < 6)
        {
            thisFighter.Set_Initiative(thisFighter.Get_Initiative()+1);
            textInitiative.setText(Integer.toString(thisFighter.Get_Initiative())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickAIncrease(View view)
    {
        if(thisFighter.Get_Attacks()<10)
        {
            thisFighter.Set_Attacks(thisFighter.Get_Attacks()+1);
            textAttacks.setText(Integer.toString(thisFighter.Get_Attacks()));
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickADecrease(View view)
    {
        if(thisFighter.Get_Attacks()>1)
        {
            thisFighter.Set_Attacks(thisFighter.Get_Attacks()-1);
            textAttacks.setText(Integer.toString(thisFighter.Get_Attacks()));
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickLIncrease(View view)
    {
        if(thisFighter.Get_Leadership()>3)
        {
            thisFighter.Set_Leadership(thisFighter.Get_Leadership()-1);
            textLeadership.setText(Integer.toString(thisFighter.Get_Leadership())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickLDecrease(View view)
    {
        if(thisFighter.Get_Leadership()<12)
        {
            thisFighter.Set_Leadership(thisFighter.Get_Leadership()+1);
            textLeadership.setText(Integer.toString(thisFighter.Get_Leadership())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickCIncrease(View view)
    {
        if(thisFighter.Get_Cool()>3)
        {
            thisFighter.Set_Cool(thisFighter.Get_Cool()-1);
            textCool.setText(Integer.toString(thisFighter.Get_Cool())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickCDecrease(View view)
    {
        if(thisFighter.Get_Cool()<12)
        {
            thisFighter.Set_Cool(thisFighter.Get_Cool()+1);
            textCool.setText(Integer.toString(thisFighter.Get_Cool())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickWillIncrease(View view)
    {
        if(thisFighter.Get_Willpower()>3)
        {
            thisFighter.Set_Willpower(thisFighter.Get_Willpower()-1);
            textWill.setText(Integer.toString(thisFighter.Get_Willpower())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickWillDecrease(View view)
    {
        if(thisFighter.Get_Willpower()<12)
        {
            thisFighter.Set_Willpower(thisFighter.Get_Willpower()+1);
            textWill.setText(Integer.toString(thisFighter.Get_Willpower())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void clickIntIncrease(View view)
    {
        if(thisFighter.Get_Intelligence()>3)
        {
            thisFighter.Set_Intelligence(thisFighter.Get_Intelligence()-1);
            textIntelligence.setText(Integer.toString(thisFighter.Get_Intelligence())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            maxToast();
        }
    }

    public void clickIntDecrease(View view)
    {
        if(thisFighter.Get_Intelligence()<12)
        {
            thisFighter.Set_Intelligence(thisFighter.Get_Intelligence()+1);
            textIntelligence.setText(Integer.toString(thisFighter.Get_Intelligence())+"+");
            SaveFighter(thisFighter);
        }
        else
        {
            minToast();
        }
    }

    public void SaveFighter(Table_Fighters thisFighter)
    {
        AppDatabase.getInstance(getApplicationContext()).get_Table_Fighters_Dao().updateFighter(thisFighter);
    }

    public void maxToast()
    {
        Toast.makeText(getApplicationContext(),"Maximum Reached", Toast.LENGTH_SHORT).show();
    }

    public void minToast()
    {
        Toast.makeText(getApplicationContext(),"Minimum Reached", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(getApplicationContext(), View_Fighter.class);
        String FighterName = FighterBeingViewed;
        intent.putExtra("Fighter_Name", FighterName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}


