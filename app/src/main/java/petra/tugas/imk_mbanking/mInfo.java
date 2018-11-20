package petra.tugas.imk_mbanking;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mInfo extends AppCompatActivity {
    Button bSaldo,bMutasi;
    SharedPreferences appData;
    int pinCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_info);
        appData = getSharedPreferences("appData",MODE_PRIVATE);
        bSaldo = findViewById(R.id.bSaldo);
        bMutasi = findViewById(R.id.bMutasi);
        Intent i = getIntent();
        final Intent backMainMenu = new Intent(this,mainMenu.class);
        pinCounter = appData.getInt("pinCounter",0);
        getSupportActionBar().setTitle("MNHMobile");
        bSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pinCounter < 3) {
                    LayoutInflater li = LayoutInflater.from(mInfo.this);
                    View pinView = li.inflate(R.layout.pin, null);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(mInfo.this);

                    final EditText etPin = (EditText) pinView.findViewById(R.id.etPin);
                    builder.setView(pinView);
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String mpin = etPin.getText().toString();
                            if (mpin.equals("123456")) {
                                SharedPreferences.Editor editor = appData.edit();
                                editor.putInt("pinCounter",0);
                                editor.commit();

                                LayoutInflater liSaldo = LayoutInflater.from(mInfo.this);
                                View saldoView = liSaldo.inflate(R.layout.saldo, null);
                                AlertDialog.Builder saldoBuilder = new AlertDialog.Builder(mInfo.this);
                                saldoBuilder.setView(saldoView);
                                saldoBuilder.setCancelable(false);

                                final TextView tvSaldo =(TextView)saldoView.findViewById(R.id.tvSaldo);
                                tvSaldo.setText("Rp. "+appData.getInt("saldo",-1));

                                saldoBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                saldoBuilder.show();

                            } else {
                                pinCounter+=1;
                                SharedPreferences.Editor editor = appData.edit();
                                editor.putInt("pinCounter",pinCounter);
                                editor.commit();
                                AlertDialog.Builder myBuilder = new AlertDialog.Builder(mInfo.this);
                                myBuilder.setMessage("m-PIN yang Anda masukan Salah!");
                                myBuilder.setCancelable(false);
                                myBuilder.setNegativeButton("OK", null);
                                myBuilder.show();

                            }
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                }else {
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(mInfo.this);
                    myBuilder.setMessage("m-Banking Anda di Blokir\nHubungi Kantor Cabang Terdekat");
                    myBuilder.setCancelable(false);
                    myBuilder.setNegativeButton("OK", null);
                    myBuilder.show();
                }
            }
        });

    }
}
