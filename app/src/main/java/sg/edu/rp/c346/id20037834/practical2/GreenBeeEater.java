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

public class GreenBeeEater extends AppCompatActivity {

    ImageView greenBeeEaterImage;
    TextView greenBeeEaterDetails;
    TextView greenBeeEaterFact1;
    TextView greenBeeEaterFact2;
    TextView greenBeeEaterFact3;
    TextView greenBeeEaterFact4;
    Button toGreenBeeEaterWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_bee_eater);

        greenBeeEaterDetails = findViewById(R.id.tvGreenBeeEaterDetails);
        greenBeeEaterFact1 = findViewById(R.id.tvGreenBeeEaterFact1);
        greenBeeEaterFact2 = findViewById(R.id.tvGreenBeeEaterFact2);
        greenBeeEaterFact3 = findViewById(R.id.tvGreenBeeEaterFact3);
        greenBeeEaterFact4 = findViewById(R.id.tvGreenBeeEaterFact4);
        toGreenBeeEaterWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(greenBeeEaterDetails);
        registerForContextMenu(greenBeeEaterFact1);
        registerForContextMenu(greenBeeEaterFact2);
        registerForContextMenu(greenBeeEaterFact3);
        registerForContextMenu(greenBeeEaterFact4);

        //calling for grey seal intent
        Intent getGreenBeeEaterIntent = getIntent();
        //to find the intetn string
        String ImageGreenBeeEater = getGreenBeeEaterIntent.getStringExtra("greenBeeEater");

        //set image
        if (!ImageGreenBeeEater.isEmpty()) {
            greenBeeEaterImage = findViewById(R.id.ivGreenBeeEater);
            greenBeeEaterImage.setImageResource(R.drawable.green_bee_eater);
        }


        //Allow user to click on the the text to enter the web page
        toGreenBeeEaterWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGreenBeeEater = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/green-bee-eater/"));
                startActivity(goWebPageGreenBeeEater);
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
                    greenBeeEaterDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (currentTextSize > 40) {
                    greenBeeEaterDetails.setTextSize(25);
                    greenBeeEaterFact1.setTextSize(25);
                    greenBeeEaterFact2.setTextSize(25);
                    greenBeeEaterFact3.setTextSize(25);
                    greenBeeEaterFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if (currentTextSize > 14) {
                    currentTextSize -= 2;
                    greenBeeEaterDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    greenBeeEaterFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if (currentTextSize < 14) {
                    greenBeeEaterDetails.setTextSize(25);
                    greenBeeEaterFact1.setTextSize(25);
                    greenBeeEaterFact2.setTextSize(25);
                    greenBeeEaterFact3.setTextSize(25);
                    greenBeeEaterFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}