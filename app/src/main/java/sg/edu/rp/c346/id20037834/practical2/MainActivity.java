package sg.edu.rp.c346.id20037834.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView greySealText;
    TextView giantPandaBearText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        greySealText = findViewById(R.id.tvGreySeal);
        giantPandaBearText = findViewById(R.id.tvGiantPanda);

        tvTitle.setPaintFlags(tvTitle.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        greySealText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent greySealDetails = new Intent(MainActivity.this, showAnimalDetails.class);
                greySealDetails.putExtra("greySeal", "1");
                startActivity(greySealDetails);
            }
        });

        giantPandaBearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giantPandaBearDetails = new Intent(MainActivity.this, giantPandaBearDetails.class);
                giantPandaBearDetails.putExtra("pandaBear", "2");
                startActivity(giantPandaBearDetails);
            }
        });
    }
}