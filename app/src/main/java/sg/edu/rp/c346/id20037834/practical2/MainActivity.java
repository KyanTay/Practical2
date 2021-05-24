package sg.edu.rp.c346.id20037834.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView greySealText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greySealText = findViewById(R.id.tvGreySeal);

        greySealText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent greySealDetails = new Intent(MainActivity.this, showAnimalDetails.class);
                greySealDetails.putExtra("greySeal", "1");
                startActivity(greySealDetails);
            }
        });
    }
}