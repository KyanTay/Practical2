package sg.edu.rp.c346.id20037834.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView greySealText;
    TextView giantPandaBearText;
    TextView glassLizardText;
    TextView gilaMonsterText;
    TextView giantClamText;
    TextView greenBeeEaterText;
    TextView griffonshireText;
    TextView giantAfricanLandSnailText;
    TextView glassFrogText;
    TextView gekcoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        greySealText = findViewById(R.id.tvGreySeal);
        giantPandaBearText = findViewById(R.id.tvGiantPanda);
        glassLizardText = findViewById(R.id.tvGlassLizard);
        gilaMonsterText = findViewById(R.id.tvGilaMonster);
        giantClamText = findViewById(R.id.tvGiantClam);
        greenBeeEaterText = findViewById(R.id.tvGreenBeeEater);
        griffonshireText = findViewById(R.id.tvGriffonshire);
        giantAfricanLandSnailText = findViewById(R.id.tvGiantAfricanLandSnail);
        glassFrogText = findViewById(R.id.tvGlassFrog);
        gekcoText = findViewById(R.id.tvGekco);

        greySealText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent greySealDetails = new Intent(MainActivity.this, showAnimalDetails.class);
                greySealDetails.putExtra("greySeal", "1");
                startActivity(greySealDetails);
            }
        });

        giantPandaBearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giantPandaBearDetails = new Intent(MainActivity.this, giantPandaBearDetails.class);
                giantPandaBearDetails.putExtra("pandaBear", "2");
                startActivity(giantPandaBearDetails);
            }
        });

        glassLizardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent glassLizardIntent = new Intent(MainActivity.this, glass_lizard_details.class);
                glassLizardIntent.putExtra("glassLizard", "3");
                startActivity(glassLizardIntent);
            }
        });

        gilaMonsterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gilaMonsterDetails = new Intent(MainActivity.this, Gila_Monster_Details.class);
                gilaMonsterDetails.putExtra("gilaMonster", "4");
                startActivity(gilaMonsterDetails);
            }
        });

        giantClamText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giantClamDetails = new Intent(MainActivity.this, GiantClamDetails.class);
                giantClamDetails.putExtra("giantClam", "5");
                startActivity(giantClamDetails);
            }
        });

        greenBeeEaterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent greenBeeEaterDetails = new Intent(MainActivity.this, GreenBeeEater.class);
                greenBeeEaterDetails.putExtra("greenBeeEater", "6");
                startActivity(greenBeeEaterDetails);
            }
        });

        griffonshireText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent griffonshireDetails = new Intent(MainActivity.this, GriffonshireDetails.class);
                griffonshireDetails.putExtra("griffonshire", "7");
                startActivity(griffonshireDetails);
            }
        });

        giantAfricanLandSnailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giantAfricanSnailDetails = new Intent(MainActivity.this, GiantAfricanLandSnailDetails.class);
                giantAfricanSnailDetails.putExtra("giantAfricanLandSnail", "8");
                startActivity(giantAfricanSnailDetails);
            }
        });

        glassFrogText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent glassFrogDetails = new Intent(MainActivity.this, GlassFrogDetails.class);
                glassFrogDetails.putExtra("glassFrog", "9");
                startActivity(glassFrogDetails);
            }
        });

        gekcoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gekcoDetails = new Intent(MainActivity.this, GekcoDetails.class);
                gekcoDetails.putExtra("gekco", "10");
                startActivity(gekcoDetails);
            }
        });
    }
}