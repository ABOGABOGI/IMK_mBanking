package petra.tugas.imk_mbanking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class mAdmin extends AppCompatActivity {
    Button gantipin, blokirkartu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_admin);
        gantipin = findViewById( R.id.tGantiPin );
        blokirkartu = findViewById( R.id.tBlokirKartu );

    }
}
