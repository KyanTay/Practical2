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

public class GekcoDetails extends AppCompatActivity {

    ImageView geckoImage;
    TextView geckoDetails;
    TextView geckoFact1;
    TextView geckoFact2;
    TextView geckoFact3;
    TextView geckoFact4;
    Button toGeckoWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gekco_details);

        geckoDetails = findViewById(R.id.tvGeckoDetails);
        geckoFact1 = findViewById(R.id.tvGeckoFact1);
        geckoFact2 = findViewById(R.id.tvGeckoFact2);
        geckoFact3 = findViewById(R.id.tvGeckoFact3);
        geckoFact4 = findViewById(R.id.tvGeckoFact4);
        toGeckoWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(geckoDetails);
        registerForContextMenu(geckoFact1);
        registerForContextMenu(geckoFact2);
        registerForContextMenu(geckoFact3);
        registerForContextMenu(geckoFact4);

        //calling for grey seal intent
        Intent getGeckoIntent = getIntent();
        //to find the intetn string
        String ImageGecko = getGeckoIntent.getStringExtra("gekco");

        //set image
        if(!ImageGecko.isEmpty()) {
            geckoImage = findViewById(R.id.ivGecko);
            geckoImage.setImageResource(R.drawable.gekco);
        }


        //Allow user to click on the the text to enter the web page
        toGeckoWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGecko = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/gecko/"));
                startActivity(goWebPageGecko);
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
                    geckoDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    geckoDetails.setTextSize(25);
                    geckoFact1.setTextSize(25);
                    geckoFact2.setTextSize(25);
                    geckoFact3.setTextSize(25);
                    geckoFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    geckoDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    geckoFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    geckoDetails.setTextSize(25);
                    geckoFact1.setTextSize(25);
                    geckoFact2.setTextSize(25);
                    geckoFact3.setTextSize(25);
                    geckoFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}