package petra.tugas.imk_mbanking;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mTransfer extends AppCompatActivity {
    Button bsesama,bbeda,binbox;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo_size_32);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("MnH M-Banking");
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#18305b")));


        setContentView(R.layout.activity_m_transfer);
        bsesama = findViewById(R.id.tAntRek);
        bbeda = findViewById(R.id.tAntBank);
        binbox = findViewById(R.id.InboxTrans);
        context = getApplicationContext();

        bsesama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,tsesama.class);
                startActivity(i);
            }
        });
        bbeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,tbeda.class);
                startActivity(i);
            }
        });
        binbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,tinbox.class);
                startActivity(i);
            }
        });

    }
}
