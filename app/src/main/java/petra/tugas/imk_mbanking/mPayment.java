package petra.tugas.imk_mbanking;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mPayment extends AppCompatActivity {
    Button bTelepon, bVacc, bCc, bAir, bHp, bPln;
    //Button bInternet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo_size_32);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("MnH M-Banking");
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#18305b")));


        setContentView(R.layout.activity_m_payment);
        getSupportActionBar().setTitle("MNHMobile");
        bTelepon = findViewById(R.id.bTelepon);
        bVacc = findViewById(R.id.bVacc);
        //bInternet = findViewById(R.id.bInternet);
        bCc = findViewById(R.id.bCc);
        bAir = findViewById(R.id.bAir);
        bHp = findViewById(R.id.bHandPhone);
        bPln = findViewById(R.id.bPln);


        bCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icc = new Intent(mPayment.this,bayarcc.class);
                startActivity(icc);
            }
        });
        bTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(mPayment.this,tlpn.class);
                startActivity(i);
            }
        });
        bHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mPayment.this,hpprabayar.class);
                startActivity(i);
            }
        });
        bVacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mPayment.this,vacc.class);
                startActivity(i);
            }
        });
        bAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mPayment.this, air.class);
                startActivity(i);
            }
        });
        bPln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mPayment.this,plnpascabayar.class);
                startActivity(i);
            }
        });
    }
}
