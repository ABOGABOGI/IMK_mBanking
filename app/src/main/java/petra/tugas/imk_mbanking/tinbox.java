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

public class tinbox extends AppCompatActivity {
    Button b1, b2, b3;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinbox);
        context = tinbox.this;

        b1 = findViewById(R.id.bInbox1);
        b2 = findViewById(R.id.bInbox2);
        b3 = findViewById(R.id.bInbox3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                            String formattedDate = "04/11/2018 10:21:42";
                                            int random = 11892733;
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
                                            tv4.setText("Rekening Tujuan : 000564528594864");
                                            tv5.setText("                                 MARK ELIOT ZU");
                                            tv6.setText("Jumlah Transfer: Rp. 256000000");
                                            tv7.setText("Pesan : Uang Jajan");
                                            tv8.setText("No. Referensi: " + random);
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
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                            String formattedDate = "27/11/2018 07:53:12";
                                            int random = 95562733;
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
                                            tv4.setText("Rekening Tujuan : 000748528594874");
                                            tv5.setText("                                 TIMOTHY DONALD C");
                                            tv6.setText("Jumlah Transfer: Rp. 111000000");
                                            tv7.setText("Pesan : utang");
                                            tv8.setText("No. Referensi: " + random);
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
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                            String formattedDate = "03/12/2018 23:30:59";
                                            int random = 88542773;
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
                                            tv4.setText("Rekening Tujuan : 000748528594874");
                                            tv5.setText("                                 JACK MA YUN");
                                            tv6.setText("Jumlah Transfer: Rp. 10000");
                                            tv7.setText("Pesan : ");
                                            tv8.setText("No. Referensi: " + random);
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
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });
    }
}
