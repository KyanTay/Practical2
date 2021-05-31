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

public class glass_lizard_details extends AppCompatActivity {

    ImageView glassLizardImage;
    TextView glassLizardDetails;
    TextView glassLizardFact1;
    TextView glassLizardFact2;
    TextView glassLizardFact3;
    TextView glassLizardFact4;
    Button toGlassLizardWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass_lizard_details);

        glassLizardDetails = findViewById(R.id.tvGlassLizardDetails);
        glassLizardFact1 = findViewById(R.id.tvGlassLizardFact1);
        glassLizardFact2 = findViewById(R.id.tvGlassLizardFact2);
        glassLizardFact3 = findViewById(R.id.tvGlassLizardFact3);
        glassLizardFact4 = findViewById(R.id.tvGlassLizardFact4);
        toGlassLizardWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(glassLizardDetails);
        registerForContextMenu(glassLizardFact1);
        registerForContextMenu(glassLizardFact2);
        registerForContextMenu(glassLizardFact3);
        registerForContextMenu(glassLizardFact4);

        //calling for grey seal intent
        Intent getGlassLizardIntent = getIntent();
        //to find the intent string
        String glassLizardImageIntent = getGlassLizardIntent.getStringExtra("glassLizard");

        //set image
        if(!glassLizardImageIntent.isEmpty()) {
            glassLizardImage = findViewById(R.id.ivGlassLizard);
            glassLizardImage.setImageResource(R.drawable.glass_lizard);
        }


        //Allow user to click on the the text to enter the web page
        toGlassLizardWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWebPageGlassLizard = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/glass-lizard/"));
                startActivity(goWebPageGlassLizard);
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
                    glassLizardDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    glassLizardDetails.setTextSize(25);
                    glassLizardFact1.setTextSize(25);
                    glassLizardFact2.setTextSize(25);
                    glassLizardFact3.setTextSize(25);
                    glassLizardFact4.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    glassLizardDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    glassLizardFact4.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    glassLizardDetails.setTextSize(25);
                    glassLizardFact1.setTextSize(25);
                    glassLizardFact2.setTextSize(25);
                    glassLizardFact3.setTextSize(25);
                    glassLizardFact4.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}