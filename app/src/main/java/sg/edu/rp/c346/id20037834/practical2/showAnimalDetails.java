package sg.edu.rp.c346.id20037834.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class showAnimalDetails extends AppCompatActivity {

    Button testingBtn;
    ImageView greySealImage;
    TextView testing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animal_details);
        testing = findViewById(R.id.tvTest);
        testingBtn = findViewById(R.id.btnTest);

        Intent getSealIntent = getIntent();
        String firstImageGreySeal = getSealIntent.getStringExtra("greySeal");
        if(!firstImageGreySeal.isEmpty()) {
            greySealImage = findViewById(R.id.ivGreySeal);
            greySealImage.setImageResource(R.drawable.grey_seal);
            testing.setText("asdasd");
        }

        testing.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(showAnimalDetails.this, "Long press", Toast.LENGTH_SHORT).show();
                testingBtn.setVisibility(View.VISIBLE);

                return false;
            }
        });
    }
}