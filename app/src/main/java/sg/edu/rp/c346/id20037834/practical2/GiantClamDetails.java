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

    ImageView giantClamImage;
    TextView giantClamDetails;
    TextView giantClamFact1;
    TextView giantClamFact2;
    TextView giantClamFact3;
    TextView giantClamFact4;
    Button toGiantClamWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giant_clam_details);

        giantClamDetails = findViewById(R.id.tvGiantClamDetails);
        giantClamFact1 = findViewById(R.id.tvGiantClamFact1);
        giantClamFact2 = findViewById(R.id.tvGiantClamFact2);
        giantClamFact3 = findViewById(R.id.tvGiantClamFact3);
        giantClamFact4 = findViewById(R.id.tvGiantClamFact4);
        toGiantClamWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(giantClamDetails);
        registerForContextMenu(giantClamFact1);
        registerForContextMenu(giantClamFact2);
        registerForContextMenu(giantClamFact3);
        registerForContextMenu(giantClamFact4);

        //calling for grey seal intent
        Intent getGiantClamIntent = getIntent();
        //to find the intetn string
        String imageGiantClam = getGiantClamIntent.getStringExtra("giantClam");

        //set image
        if (!imageGiantClam.isEmpty()) {
            giantClamImage = findViewById(R.id.ivGiantClam);
            giantClamImage.setImageResource(R.drawable.giant_clam);
        }


        //Allow user to click on the the text to enter the web page
        toGiantClamWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGreySeal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/giant-clam/"));
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
                    giantClamDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (currentTextSize > 40) {
                    giantClamDetails.setTextSize(25);
                    giantClamFact1.setTextSize(25);
                    giantClamFact2.setTextSize(25);
                    giantClamFact3.setTextSize(25);
                    giantClamFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if (currentTextSize > 14) {
                    currentTextSize -= 2;
                    giantClamDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    giantClamFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if (currentTextSize < 14) {
                    giantClamDetails.setTextSize(25);
                    giantClamFact1.setTextSize(25);
                    giantClamFact2.setTextSize(25);
                    giantClamFact3.setTextSize(25);
                    giantClamFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}