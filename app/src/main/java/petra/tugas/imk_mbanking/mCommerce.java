package petra.tugas.imk_mbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mCommerce extends AppCompatActivity {
    Button bPulsa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_commerce);
        bPulsa = findViewById(R.id.VocIsiUlang);
        bPulsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPulsa = new Intent(mCommerce.this,beliPulsa.class);
                startActivity(iPulsa);
            }
        });
    }
}
