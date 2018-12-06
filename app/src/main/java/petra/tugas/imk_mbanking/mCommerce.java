package petra.tugas.imk_mbanking;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mCommerce extends AppCompatActivity {
    Button bPulsa,bPlnPra,bGopay,bMtix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_commerce);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo_size_32);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("MnH M-Banking");
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#18305b")));

        bPulsa = findViewById(R.id.VocIsiUlang);
        bPlnPra = findViewById(R.id.PLNPra);
        bGopay = findViewById(R.id.bGopay);
        bMtix=findViewById(R.id.bMtix);
        bPulsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPulsa = new Intent(mCommerce.this,beliPulsa.class);
                startActivity(iPulsa);
            }
        });
        bPlnPra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPra = new Intent(mCommerce.this,plnprabayar.class);
                startActivity(iPra);
            }
        });
        bGopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igopay = new Intent(mCommerce.this,gopay.class);
                startActivity(igopay);
            }
        });
        bMtix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCommerce.this,mtix.class);
                startActivity(i);
            }
        });
    }
}
