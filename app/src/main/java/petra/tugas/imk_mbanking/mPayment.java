package petra.tugas.imk_mbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mPayment extends AppCompatActivity {
    Button bTelepon, bVacc, bInternet, bCc, bAir, bHp, bAsuransi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_payment);
        getSupportActionBar().setTitle("MNHMobile");
        bTelepon = findViewById(R.id.bTelepon);
        bVacc = findViewById(R.id.bVacc);
        bInternet = findViewById(R.id.bInternet);
        bCc = findViewById(R.id.bCc);
        bAir = findViewById(R.id.bAir);
        bHp = findViewById(R.id.bHandPhone);
        bAsuransi = findViewById(R.id.bAsuransi);

        bHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPulsa = new Intent(mPayment.this,beliPulsa.class);
                startActivity(iPulsa);
            }
        });
    }
}
