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

public class GiantClamDetails extends AppCompatActivity {

    ImageView greySealImage;
    TextView greySealDetails;
    TextView greySealFact1;
    TextView greySealFact2;
    TextView greySealFact3;
    TextView greySealFact4;
    Button toGreySealWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giant_clam_details);

        greySealDetails = findViewById(R.id.tvGreySealDetails);
        greySealFact1 = findViewById(R.id.tvGreySealFact1);
        greySealFact2 = findViewById(R.id.tvGreySealFact2);
        greySealFact3 = findViewById(R.id.tvGreySealFact3);
        greySealFact4 = findViewById(R.id.tvGreySealFact4);
        toGreySealWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(greySealDetails);
        registerForContextMenu(greySealFact1);
        registerForContextMenu(greySealFact2);
        registerForContextMenu(greySealFact3);
        registerForContextMenu(greySealFact4);

        //calling for grey seal intent
        Intent getSealIntent = getIntent();
        //to find the intetn string
        String firstImageGreySeal = getSealIntent.getStringExtra("greySeal");

        //set image
        if (!firstImageGreySeal.isEmpty()) {
            greySealImage = findViewById(R.id.ivGreySeal);
            greySealImage.setImageResource(R.drawable.grey_seal);
        }


        //Allow user to click on the the text to enter the web page
        toGreySealWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGreySeal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/grey-seal/"));
                startActivity(goWebPageGreySeal);
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
        switch (item.getItemId()) {
            case R.id.option1:
                //Able to increase till a certain amount before going back to default
                if (currentTextSize < 40) {
                    currentTextSize += 2;
                    greySealDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (currentTextSize > 40) {
                    greySealDetails.setTextSize(25);
                    greySealFact1.setTextSize(25);
                    greySealFact2.setTextSize(25);
                    greySealFact3.setTextSize(25);
                    greySealFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if (currentTextSize > 14) {
                    currentTextSize -= 2;
                    greySealDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greySealFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if (currentTextSize < 14) {
                    greySealDetails.setTextSize(25);
                    greySealFact1.setTextSize(25);
                    greySealFact2.setTextSize(25);
                    greySealFact3.setTextSize(25);
                    greySealFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}