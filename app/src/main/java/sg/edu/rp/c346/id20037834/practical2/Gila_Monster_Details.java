package sg.edu.rp.c346.id20037834.practical2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Gila_Monster_Details extends AppCompatActivity {

    ImageView gilaImageGet;
    TextView gilaMonsterDetails;
    TextView gilaMonsterFact1;
    TextView gilaMonsterFact2;
    TextView gilaMonsterFact3;
    TextView gilaMonsterFact4;
    Button toGilaMonsterWebPage;

    int currentTextSize = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gila__monster__details);

        gilaMonsterDetails = findViewById(R.id.tvGilaMonsterDetails);
        gilaMonsterFact1 = findViewById(R.id.tvGilaMonsterFact1);
        gilaMonsterFact2 = findViewById(R.id.tvGilaMonsterFact2);
        gilaMonsterFact3 = findViewById(R.id.tvGilaMonsterFact3);
        gilaMonsterFact4 = findViewById(R.id.tvGilaMonsterFact4);
        toGilaMonsterWebPage = findViewById(R.id.btnToPage);

        registerForContextMenu(gilaMonsterDetails);
        registerForContextMenu(gilaMonsterFact1);
        registerForContextMenu(gilaMonsterFact2);
        registerForContextMenu(gilaMonsterFact3);
        registerForContextMenu(gilaMonsterFact4);

        //calling for grey seal intent
        Intent gilaMonsterImageIntent = getIntent();
        //to find the intent string
        String getIntentGilaMonsterIntent = gilaMonsterImageIntent.getStringExtra("gilaMonster");

        //set image
        if(!getIntentGilaMonsterIntent.isEmpty()) {
            gilaImageGet = findViewById(R.id.ivGilaMonster);
            gilaImageGet.setImageResource(R.drawable.gila_monster);
        }


        //Allow user to click on the the text to enter the web page
        toGilaMonsterWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGilaMonster = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/gila-monster/"));
                startActivity(goWebPageGilaMonster);
            }
        });
    }

    //Pop out menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.text_change, menu);
    }

    //set the text size
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.option1:
                //Able to increase till a certain amount before going back to default
                if(currentTextSize < 40){
                    currentTextSize += 2;
                    gilaMonsterDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    gilaMonsterDetails.setTextSize(25);
                    gilaMonsterFact1.setTextSize(25);
                    gilaMonsterFact2.setTextSize(25);
                    gilaMonsterFact3.setTextSize(25);
                    gilaMonsterFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    gilaMonsterDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    gilaMonsterFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    gilaMonsterDetails.setTextSize(25);
                    gilaMonsterFact1.setTextSize(25);
                    gilaMonsterFact2.setTextSize(25);
                    gilaMonsterFact3.setTextSize(25);
                    gilaMonsterFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}

