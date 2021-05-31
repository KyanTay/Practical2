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

public class GriffonshireDetails extends AppCompatActivity {

    ImageView griffonshireImage;
    TextView griffonshireDetails;
    TextView griffonshireQ1;
    TextView griffonshireQ2;
    TextView griffonshireQ3;
    TextView griffonshireA1;
    TextView griffonshireA2;
    TextView griffonshireA3;
    Button toGriffonshireWebsite;

    int currentTextSize = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_griffonshire_details);

        griffonshireDetails = findViewById(R.id.tvGriffonshireDetails);
        griffonshireQ1 = findViewById(R.id.tvGriffonshireQ1);
        griffonshireQ2 = findViewById(R.id.tvGriffonshireQ2);
        griffonshireQ3 = findViewById(R.id.tvGriffonshireQ3);
        griffonshireA1 = findViewById(R.id.tvGriffonshireA1);
        griffonshireA2 = findViewById(R.id.tvGriffonshireA2);
        griffonshireA3 = findViewById(R.id.tvGriffonshireA3);
        toGriffonshireWebsite = findViewById(R.id.btnToPage);

        registerForContextMenu(griffonshireDetails);
        registerForContextMenu(griffonshireQ1);
        registerForContextMenu(griffonshireQ2);
        registerForContextMenu(griffonshireQ3);
        registerForContextMenu(griffonshireA1);
        registerForContextMenu(griffonshireA2);
        registerForContextMenu(griffonshireA3);

        //calling for grey seal intent
        Intent getGriffonshireIntent = getIntent();
        //to find the intent string
        String imageGriffonshire = getGriffonshireIntent.getStringExtra("griffonshire");

        //set image
        if(!imageGriffonshire.isEmpty()) {
            griffonshireImage = findViewById(R.id.ivGriffonshire);
            griffonshireImage.setImageResource(R.drawable.griffonshire);
        }


        //Allow user to click on the the text to enter the web page
        toGriffonshireWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGriffonshirePage = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/griffonshire/"));
                startActivity(toGriffonshirePage);
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
                    griffonshireDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireQ1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireQ2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireQ3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireA1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireA2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireA3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size increased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(currentTextSize > 40){
                    griffonshireDetails.setTextSize(25);
                    griffonshireQ1.setTextSize(25);
                    griffonshireQ2.setTextSize(25);
                    griffonshireQ3.setTextSize(25);
                    griffonshireA1.setTextSize(25);
                    griffonshireA2.setTextSize(25);
                    griffonshireA3.setTextSize(25);
                    Toast.makeText(this, "Text too big reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return true;
            case R.id.option2:
                //Able to decrease till a certain amount before going back to default
                if(currentTextSize > 14){
                    currentTextSize -= 2;
                    griffonshireDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireQ1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireQ2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireQ3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireA1.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireA2.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    griffonshireA3.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentTextSize);
                    Toast.makeText(this, "Text size decreased", Toast.LENGTH_SHORT).show();
                    return true;
                }
                //Set back to default when lower than a certain amount
                else if(currentTextSize < 14){
                    griffonshireDetails.setTextSize(25);
                    griffonshireQ1.setTextSize(25);
                    griffonshireQ2.setTextSize(25);
                    griffonshireQ3.setTextSize(25);
                    griffonshireA1.setTextSize(25);
                    griffonshireA2.setTextSize(25);
                    griffonshireA3.setTextSize(25);
                    Toast.makeText(this, "Text too small reverting back to normal", Toast.LENGTH_SHORT).show();
                    return true;
                }

            default:
                return super.onContextItemSelected(item);
        }
    }
}