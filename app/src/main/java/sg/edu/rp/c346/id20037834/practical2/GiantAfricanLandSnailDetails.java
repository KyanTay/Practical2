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

public class GiantAfricanLandSnailDetails extends AppCompatActivity {

    ImageView africanSnailImage;
    TextView africanSnailDetails;
    TextView africanSnailFact1;
    TextView africanSnailFact2;
    TextView africanSnailFact3;
    TextView africanSnailFact4;
    Button toAfricanSnailWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giant_african_land_snail_details);

        africanSnailDetails = findViewById(R.id.tvAfricanSnailDetails);
        africanSnailFact1 = findViewById(R.id.tvAfricanSnailFact1);
        africanSnailFact2 = findViewById(R.id.tvAfricanSnailFact2);
        africanSnailFact3 = findViewById(R.id.tvAfricanSnailFact3);
        africanSnailFact4 = findViewById(R.id.tvAfricanSnailFact3);
        toAfricanSnailWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(africanSnailDetails);
        registerForContextMenu(africanSnailFact1);
        registerForContextMenu(africanSnailFact2);
        registerForContextMenu(africanSnailFact3);
        registerForContextMenu(africanSnailFact4);

        //calling for grey seal intent
        Intent getAfricanSnailIntent = getIntent();
        //to find the intetn string
        String ImageAfricanSnail = getAfricanSnailIntent.getStringExtra("giantAfricanLandSnail");

        //set image
        if(!ImageAfricanSnail.isEmpty()) {
            africanSnailImage = findViewById(R.id.ivAfricanSnail);
            africanSnailImage.setImageResource(R.drawable.giant_african_land_snail);
        }


        //Allow user to click on the the text to enter the web page
        toAfricanSnailWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageAfricanSnail = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/giant-african-land-snail/"));
                startActivity(goWebPageAfricanSnail);
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
                    africanSnailDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    africanSnailDetails.setTextSize(25);
                    africanSnailFact1.setTextSize(25);
                    africanSnailFact2.setTextSize(25);
                    africanSnailFact3.setTextSize(25);
                    africanSnailFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    africanSnailDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    africanSnailFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    africanSnailDetails.setTextSize(25);
                    africanSnailFact1.setTextSize(25);
                    africanSnailFact2.setTextSize(25);
                    africanSnailFact3.setTextSize(25);
                    africanSnailFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}