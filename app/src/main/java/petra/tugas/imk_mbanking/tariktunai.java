package petra.tugas.imk_mbanking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class tariktunai extends AppCompatActivity {
    Button bOk,bNominal;
    Context context;
    int pinCounter;
    int bayar;
    SharedPreferences appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tariktunai);
        context = tariktunai.this;
        appData = getSharedPreferences("appData",MODE_PRIVATE);
        pinCounter = appData.getInt("pinCounter",0);
        bayar=0;
        bNominal = findViewById(R.id.bNominal);
        bOk = findViewById(R.id.bOk);
        bNominal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View jenisView = li.inflate(R.layout.layoutnominal, null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final Button button1 = (Button) jenisView.findViewById(R.id.b25);
                final Button button2 = (Button) jenisView.findViewById(R.id.b50);
                final Button button3 = (Button) jenisView.findViewById(R.id.b100);
                final Button button4 = (Button) jenisView.findViewById(R.id.b200);
                builder.setView(jenisView);
                final AlertDialog dialog = builder.create();
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("50000");
                        dialog.cancel();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("100000");
                        dialog.cancel();
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("150000");
                        dialog.cancel();
                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("200000");
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bNominal.getText().toString().isEmpty()){
                    AlertDialog.Builder errorBuilder = new AlertDialog.Builder(context);
                    errorBuilder.setMessage("Tolong isi semua input");
                    errorBuilder.setCancelable(false);
                    errorBuilder.setNegativeButton("OK", null);
                    errorBuilder.show();
                }else{
                    bayar=Integer.parseInt(bNominal.getText().toString());
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
                                                    if ((appData.getInt("saldo", 0) - (bayar) < 0)) {
                                                        AlertDialog.Builder errorBuilder = new AlertDialog.Builder(context);
                                                        errorBuilder.setMessage("Saldo Anda Tidak Mencukupi");
                                                        errorBuilder.setCancelable(false);
                                                        errorBuilder.setNegativeButton("OK", null);
                                                        errorBuilder.show();
                                                    } else {
                                                        Date date = Calendar.getInstance().getTime();
                                                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                                        final String formattedDate = df.format(date);
                                                        final int random = new Random().nextInt((99999999 - 10000000) + 1) + 10000000;
                                                        int newSaldo = appData.getInt("saldo", 0);
                                                        newSaldo = newSaldo - (bayar);
                                                        SharedPreferences.Editor editor = appData.edit();
                                                        editor.putInt("pinCounter", 0);
                                                        editor.putInt("saldo", newSaldo);
                                                        editor.commit();

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
                                                                                    tv4.setText("Jenis Transaksi : Tarik Tunai");
                                                                                    tv5.setText("Jumlah : " + bayar);
                                                                                    tv6.setText("Kode Tarik Tunai : 290876");
                                                                                    resiBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                                                                        @Override
                                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                                            dialog.cancel();
                                                                                        }
                                                                                    });
                                                                                    resiBuilder.show();
                                                                                }
                                                                            }
                                                                        }, 3000);
                                                            }
                                                        });
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
                    }



        });
    }
}
