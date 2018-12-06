package petra.tugas.imk_mbanking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class gopay extends AppCompatActivity {
    Button bOk;
    EditText etNominal,etHp;
    int pinCounter;
    int bayar;
    SharedPreferences appData;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gopay);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo_size_32);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("MnH M-Banking");
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#18305b")));

        bOk = findViewById(R.id.bOk);
        etHp = findViewById(R.id.etNomor);
        etNominal = findViewById(R.id.etNominal);

        appData = getSharedPreferences("appData",MODE_PRIVATE);
        pinCounter = appData.getInt("pinCounter",0);
        bayar=0;
        context = gopay.this;

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etHp.getText().toString().isEmpty()||etNominal.getText().toString().isEmpty()){
                    AlertDialog.Builder errorBuilder = new AlertDialog.Builder(context);
                    errorBuilder.setMessage("Tolong isi semua input");
                    errorBuilder.setCancelable(false);
                    errorBuilder.setNegativeButton("OK", null);
                    errorBuilder.show();
                }else{
                    bayar=Integer.parseInt(etNominal.getText().toString());

                    LayoutInflater li = LayoutInflater.from(context);
                    final View konfirmasiView = li.inflate(R.layout.layoutkonfirmasi, null);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    final TextView tvJudul1 = konfirmasiView.findViewById(R.id.tvJudul);
                    final TextView tv11 = konfirmasiView.findViewById(R.id.tv1);
                    final TextView tv21 = konfirmasiView.findViewById(R.id.tv2);
                    final TextView tv31 = konfirmasiView.findViewById(R.id.tv3);
                    final TextView tv41 = konfirmasiView.findViewById(R.id.tv4);
                    final TextView tv51 = konfirmasiView.findViewById(R.id.tv5);
                    final TextView tv61 = konfirmasiView.findViewById(R.id.tv6);
                    tvJudul1.setText("KONFIRMASI");
                    tv11.setText("Top Up Gopay");
                    tv21.setText("no. HP: "+etHp.getText().toString());
                    tv31.setText("Nominal: Rp. "+bayar);
                    tv41.setText("Biaya Admin: Rp. 1500");
                    tv51.setText("Total Bayar: Rp. "+(bayar+1500));
                    tv61.setText("");

                    builder.setView(konfirmasiView);
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                                        // TODO: Implement your own authentication logic here.

                                        new android.os.Handler().postDelayed(
                                                new Runnable() {
                                                    public void run() {
                                                        progressDialog.dismiss();
                                                        String mpin = etPin.getText().toString();
                                                        if (mpin.equals("123456")) {
                                                            if ((appData.getInt("saldo",0)-(bayar+1500)<0)){
                                                                AlertDialog.Builder errorBuilder = new AlertDialog.Builder(context);
                                                                errorBuilder.setMessage("Saldo Anda Tidak Mencukupi");
                                                                errorBuilder.setCancelable(false);
                                                                errorBuilder.setNegativeButton("OK", null);
                                                                errorBuilder.show();
                                                            }else{
                                                                Date date = Calendar.getInstance().getTime();
                                                                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                                                String formattedDate = df.format(date);
                                                                int random =new Random().nextInt((99999999 - 10000000) + 1) + 10000000;
                                                                int newSaldo = appData.getInt("saldo",0);
                                                                newSaldo = newSaldo-(bayar+1500);

                                                                SharedPreferences.Editor editor = appData.edit();
                                                                editor.putInt("pinCounter",0);
                                                                editor.putInt("saldo",newSaldo);
                                                                editor.commit();

                                                                LayoutInflater liResi = LayoutInflater.from(context);
                                                                View resiView = liResi.inflate(R.layout.layoutkonfirmasi, null);
                                                                AlertDialog.Builder resiBuilder = new AlertDialog.Builder(context);
                                                                final TextView tvJudul = resiView.findViewById(R.id.tvJudul);
                                                                final TextView tv1 = resiView.findViewById(R.id.tv1);
                                                                final TextView tv2 = resiView.findViewById(R.id.tv2);
                                                                final TextView tv3 = resiView.findViewById(R.id.tv3);
                                                                final TextView tv4 = resiView.findViewById(R.id.tv4);
                                                                final TextView tv5 = resiView.findViewById(R.id.tv5);
                                                                final TextView tv6 = resiView.findViewById(R.id.tv6);
                                                                final TextView tv7 = resiView.findViewById(R.id.tv7);
                                                                final TextView tv8 = resiView.findViewById(R.id.tv8);
                                                                resiBuilder.setView(resiView);
                                                                resiBuilder.setCancelable(false);
                                                                tvJudul.setText("Bukti Transaksi");
                                                                tv1.setText("Transaksi Berhasil");
                                                                tv2.setText(formattedDate);
                                                                tv3.setText("");
                                                                tv4.setText("Jenis Transaksi: Top Up Gopay");
                                                                tv5.setText("No. HP: "+etHp.getText().toString());
                                                                tv6.setText("Total Bayar: "+(bayar+1500));
                                                                tv7.setText("No. Referensi: "+random);


                                                                resiBuilder.setPositiveButton("Kembali ke Menu Awal", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        dialog.cancel();
                                                                        Intent iMain = new Intent(context,mainMenu.class);
                                                                        startActivity(iMain);
                                                                    }
                                                                });
                                                                resiBuilder.show();
                                                            }
                                                        }else {
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
                                                }, 3000);


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
                                AlertDialog.Builder myBuilder = new AlertDialog.Builder(context);
                                myBuilder.setMessage("m-Banking Anda di Blokir\nHubungi Kantor Cabang Terdekat");
                                myBuilder.setCancelable(false);
                                myBuilder.setNegativeButton("OK", null);
                                myBuilder.show();
                            }
                        }
                    });
                    builder.setNegativeButton("Cancel",null);
                    builder.show();

                }
            }
        });
    }
}
