package petra.tugas.imk_mbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mInfo extends AppCompatActivity {
    Button bSaldo,bMutasi;
    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_info);

        bSaldo = findViewById(R.id.bSaldo);
        bMutasi = findViewById(R.id.bMutasi);

        Intent i = getIntent();
        final Intent backMainMenu = new Intent(this,mainMenu.class);
        data = i.getStringArrayExtra("data");
        int tmp = Integer.parseInt(data[1])-1;
        data[1]=""+tmp;
        getSupportActionBar().setTitle("MNHMobile");
        bSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mInfo.this,"toast",Toast.LENGTH_LONG).show();
                backMainMenu.putExtra("data",data);
                startActivity(backMainMenu);
            }
        });
    }
}
