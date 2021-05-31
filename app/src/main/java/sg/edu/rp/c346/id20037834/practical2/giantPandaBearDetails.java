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

public class giantPandaBearDetails extends AppCompatActivity {

    ImageView giantPandaBearImage;
    TextView giantPandaBearDetails;
    TextView giantPandaBearQ1;
    TextView giantPandaBearQ2;
    TextView giantPandaBearQ3;
    TextView giantPandaBearA1;
    TextView giantPandaBearA2;
    TextView giantPandaBearA3;
    Button toGiantPandaBearWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giant_panda_bear_details);

        giantPandaBearDetails = findViewById(R.id.tvGiantPandaBearDetails);
        giantPandaBearQ1 = findViewById(R.id.tvGiantPandaBearQ1);
        giantPandaBearQ2 = findViewById(R.id.tvGiantPandaBearQ2);
        giantPandaBearQ3 = findViewById(R.id.tvGiantPandaBearQ3);
        giantPandaBearA1 = findViewById(R.id.tvGiantPandaBearA1);
        giantPandaBearA2 = findViewById(R.id.tvGiantPandaBearA2);
        giantPandaBearA3 = findViewById(R.id.tvGiantPandaBearA3);
        toGiantPandaBearWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(giantPandaBearDetails);
        registerForContextMenu(giantPandaBearQ1);
        registerForContextMenu(giantPandaBearQ2);
        registerForContextMenu(giantPandaBearQ3);
        registerForContextMenu(giantPandaBearA1);
        registerForContextMenu(giantPandaBearA2);
        registerForContextMenu(giantPandaBearA3);

        //calling for grey seal intent
        Intent getGiantPandaIntent = getIntent();
        //to find the intent string
        String imagePandaBear = getGiantPandaIntent.getStringExtra("pandaBear");

        //set image
        if(!imagePandaBear.isEmpty()) {
            giantPandaBearImage = findViewById(R.id.ivGiantPandaBear);
            giantPandaBearImage.setImageResource(R.drawable.giant_panda_bear);
        }


        //Allow user to click on the the text to enter the web page
        toGiantPandaBearWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGiantPandaBear = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/giant-panda-bear/"));
                startActivity(toGiantPandaBear);
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
                    giantPandaBearDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearQ1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearQ2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearQ3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearA1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearA2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearA3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    giantPandaBearDetails.setTextSize(25);
                    giantPandaBearQ1.setTextSize(25);
                    giantPandaBearQ2.setTextSize(25);
                    giantPandaBearQ3.setTextSize(25);
                    giantPandaBearA1.setTextSize(25);
                    giantPandaBearA2.setTextSize(25);
                    giantPandaBearA3.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    giantPandaBearDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearQ1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearQ2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearQ3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearA1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearA2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantPandaBearA3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    giantPandaBearDetails.setTextSize(25);
                    giantPandaBearQ1.setTextSize(25);
                    giantPandaBearQ2.setTextSize(25);
                    giantPandaBearQ3.setTextSize(25);
                    giantPandaBearA1.setTextSize(25);
                    giantPandaBearA2.setTextSize(25);
                    giantPandaBearA3.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }

}