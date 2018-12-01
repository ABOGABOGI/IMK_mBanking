package petra.tugas.imk_mbanking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mAdmin extends AppCompatActivity {
    Button gantipin, blokirkartu;
    int pinCounter;SharedPreferences appData;Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_admin);
        gantipin = findViewById( R.id.tGantiPin );
        blokirkartu = findViewById( R.id.tBlokirKartu );
        appData = getSharedPreferences("appData",MODE_PRIVATE);
        pinCounter = appData.getInt("pinCounter",0);
        context = mAdmin.this;

        gantipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mAdmin.this,adminGantiPin.class);
                startActivity(i);
            }
        });
        blokirkartu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder errorBuilder = new AlertDialog.Builder(mAdmin.this);
                errorBuilder.setTitle("Pemblokiran Kartu ATM");
                errorBuilder.setMessage("\nBlokir Kartu ATM\nNomor Kartu: 002525465489\nJenis Kartu: Gold\n\nDengan ini saya setuju untuk memblokir kartu ATM diatas.\nDengan diblokirnya kartu ATM diatas maka segala aktivitas yang melibatkan kartu ATM tidak dapat dilakukan sementara hingga dilakukan penggantian kartu.\nUntuk Info lebih lanjut hubungi:\nCustomer Service (CS:123456789)");
                errorBuilder.setCancelable(false);
                errorBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (pinCounter < 3) {
                                    LayoutInflater li = LayoutInflater.from(context);
                                    View pinView = li.inflate(R.layout.pin, null);
                                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                    final EditText etPin = (EditText) pinView.findViewById(R.id.etPin);
                                    builder.setView(pinView);
                                    builder.setCancelable(false);
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            final ProgressDialog progressDialog = new ProgressDialog(context,
                                                    R.style.Theme_AppCompat_Light_Dialog);
                                            progressDialog.setIndeterminate(true);
                                            progressDialog.setCancelable(false);
                                            progressDialog.setMessage("Please Wait...");
                                            progressDialog.show();
                                            new android.os.Handler().postDelayed(
                                                    new Runnable() {
                                                        public void run() {
                                                            progressDialog.dismiss();
                                                            String mpin = etPin.getText().toString();
                                                            if (mpin.equals("123456")) {
                                                                AlertDialog.Builder errorBuilder = new AlertDialog.Builder(mAdmin.this);
                                                                errorBuilder.setMessage("Kartu ATM Anda telah berhasil di blokir");
                                                                errorBuilder.setCancelable(false);
                                                                errorBuilder.setNegativeButton("OK", null);
                                                                errorBuilder.show();
                                                            }else{
                                                                pinCounter+=1;
                                                                SharedPreferences.Editor editor = appData.edit();
                                                                editor.putInt("pinCounter",pinCounter);
                                                                editor.commit();
                                                                AlertDialog.Builder myBuilder = new AlertDialog.Builder(context);
                                                                myBuilder.setMessage("m-PIN yang Anda masukan Salah!");
                                                                myBuilder.setCancelable(false);
                                                                myBuilder.setNegativeButton("OK", null);
                                                                myBuilder.show();
                                                            }
                                                        }
                                                    },3000);


                                        }
                                    });
                                    builder.show();
                                } else {
                                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(context);
                                    myBuilder.setMessage("m-Banking Anda di Blokir\nHubungi Kantor Cabang Terdekat");
                                    myBuilder.setCancelable(false);
                                    myBuilder.setNegativeButton("OK", null);
                                    myBuilder.show();
                                }
                            }
                        });
                errorBuilder.setNegativeButton("Cancel",null);
                errorBuilder.show();
            }
        });
    }
}
