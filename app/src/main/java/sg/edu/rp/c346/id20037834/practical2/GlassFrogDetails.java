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

public class GlassFrogDetails extends AppCompatActivity {

    ImageView glassFrogImage;
    TextView glassFrogDetails;
    TextView glassFrogFact1;
    TextView glassFrogFact2;
    TextView glassFrogFact3;
    TextView glassFrogFact4;
    Button toGlassFrogPage;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass_frog_details);

        glassFrogDetails = findViewById(R.id.tvGlassFrogDetails);
        glassFrogFact1 = findViewById(R.id.tvGlassFrogFact1);
        glassFrogFact2 = findViewById(R.id.tvGlassFrogFact2);
        glassFrogFact3 = findViewById(R.id.tvGlassFrogFact3);
        glassFrogFact4 = findViewById(R.id.tvGlassFrogFact4);
        toGlassFrogPage = findViewById(R.id.btnToPage);

        registerForContextMenu(glassFrogDetails);
        registerForContextMenu(glassFrogFact1);
        registerForContextMenu(glassFrogFact2);
        registerForContextMenu(glassFrogFact3);
        registerForContextMenu(glassFrogFact4);

        //calling for grey seal intent
        Intent getGlassFrogIntent = getIntent();
        //to find the intetn string
        String ImageGlassFrog = getGlassFrogIntent.getStringExtra("glassFrog");

        //set image
        if(!ImageGlassFrog.isEmpty()) {
            glassFrogImage = findViewById(R.id.ivGlassFrog);
            glassFrogImage.setImageResource(R.drawable.glass_frog);
        }


        //Allow user to click on the the text to enter the web page
        toGlassFrogPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGlassFrog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/glass-frog/"));
                startActivity(goWebPageGlassFrog);
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
                    glassFrogDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    glassFrogDetails.setTextSize(25);
                    glassFrogFact1.setTextSize(25);
                    glassFrogFact2.setTextSize(25);
                    glassFrogFact3.setTextSize(25);
                    glassFrogFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    glassFrogDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassFrogFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    glassFrogDetails.setTextSize(25);
                    glassFrogFact1.setTextSize(25);
                    glassFrogFact2.setTextSize(25);
                    glassFrogFact3.setTextSize(25);
                    glassFrogFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}