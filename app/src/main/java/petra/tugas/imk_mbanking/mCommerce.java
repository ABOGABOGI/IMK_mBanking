package petra.tugas.imk_mbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mCommerce extends AppCompatActivity {
    Button bPulsa,bPlnPra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_commerce);
        bPulsa = findViewById(R.id.VocIsiUlang);
        bPlnPra = findViewById(R.id.PLNPra);
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
    }
}
