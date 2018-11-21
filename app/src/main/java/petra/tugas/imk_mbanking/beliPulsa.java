package petra.tugas.imk_mbanking;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class beliPulsa extends AppCompatActivity {
    Button bJenis,bNominal,bNomor,bOk;
    String transaksi;
    int pinCounter;
    SharedPreferences appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_pulsa);
        bJenis = findViewById(R.id.bJenis);
        bNominal = findViewById(R.id.bNominal);
        bNomor = findViewById(R.id.bNomor);
        bOk =findViewById(R.id.bOk);
        transaksi = "isi pulang pulsa: ";
        appData = getSharedPreferences("appData",MODE_PRIVATE);
        pinCounter = appData.getInt("pinCounter",0);
        bJenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(beliPulsa.this);
                View jenisView = li.inflate(R.layout.jenispulsa, null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(beliPulsa.this);
                final Button button1 = (Button) jenisView.findViewById(R.id.bTsel);
                final Button button2 = (Button) jenisView.findViewById(R.id.bSmarfren);
                final Button button3 = (Button) jenisView.findViewById(R.id.bIndosat);
                final Button button4 = (Button) jenisView.findViewById(R.id.bXl);
                builder.setView(jenisView);
                final AlertDialog dialog = builder.create();
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bJenis.setText("TSEL");
                        dialog.cancel();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bJenis.setText("SMARTFREN");
                        dialog.cancel();
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bJenis.setText("INDOSAT");
                        dialog.cancel();
                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bJenis.setText("XL/AXIS");
                        dialog.cancel();
                    }
                });

                dialog.show();


            }
        });
        bNominal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(beliPulsa.this);
                View jenisView = li.inflate(R.layout.layoutnominal, null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(beliPulsa.this);
                final Button button1 = (Button) jenisView.findViewById(R.id.b25);
                final Button button2 = (Button) jenisView.findViewById(R.id.b50);
                final Button button3 = (Button) jenisView.findViewById(R.id.b100);
                final Button button4 = (Button) jenisView.findViewById(R.id.b200);
                builder.setView(jenisView);
                final AlertDialog dialog = builder.create();
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("25000");
                        dialog.cancel();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("50000");
                        dialog.cancel();
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bNominal.setText("100000");
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
        bNomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(beliPulsa.this);
                View inputView = li.inflate(R.layout.inputnohp, null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(beliPulsa.this);
                final EditText userInput = inputView.findViewById(R.id.etInput);
                builder.setTitle("No. Handphone");
                builder.setView(inputView);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bNomor.setText(userInput.getText().toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        bOk.setOnClickListener(new View.OnClickListener() {
            String _jenis;
            int _nominal;
            String _nomor;
            @Override
            public void onClick(View v) {
                try {

                    _jenis = bJenis.getText().toString();
                    _nominal = Integer.parseInt(bNominal.getText().toString());
                    _nomor = bNomor.getText().toString();
                    if(_jenis.isEmpty()||_nomor.isEmpty()){
                        AlertDialog.Builder errorBuilder = new AlertDialog.Builder(beliPulsa.this);
                        errorBuilder.setMessage("Tolong isi semua input");
                        errorBuilder.setCancelable(false);
                        errorBuilder.setNegativeButton("OK", null);
                        errorBuilder.show();
                    }else{
                        LayoutInflater li = LayoutInflater.from(beliPulsa.this);
                        final View konfirmasiView = li.inflate(R.layout.layoutkonfirmasi, null);
                        final AlertDialog.Builder builder = new AlertDialog.Builder(beliPulsa.this);
                        final TextView tvJudul1 = konfirmasiView.findViewById(R.id.tvJudul);
                        final TextView tv11 = konfirmasiView.findViewById(R.id.tv1);
                        final TextView tv21 = konfirmasiView.findViewById(R.id.tv2);
                        final TextView tv31 = konfirmasiView.findViewById(R.id.tv3);
                        final TextView tv41 = konfirmasiView.findViewById(R.id.tv4);
                        final TextView tv51 = konfirmasiView.findViewById(R.id.tv5);
                        final TextView tv61 = konfirmasiView.findViewById(R.id.tv6);
                        tvJudul1.setText("KONFIRMASI");
                        tv11.setText(transaksi);
                        tv21.setText(_jenis);
                        tv31.setText(_nomor);
                        tv41.setText("Rp. "+_nominal);
                        tv51.setText("Biaya Admin: Rp. 1500");
                        tv61.setText("Total Bayar: Rp. "+(_nominal+=1500));
                        builder.setView(konfirmasiView);
                        builder.setCancelable(false);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (pinCounter < 3) {
                                    LayoutInflater li = LayoutInflater.from(beliPulsa.this);
                                    View pinView = li.inflate(R.layout.pin, null);
                                    final AlertDialog.Builder builder = new AlertDialog.Builder(beliPulsa.this);
                                    final EditText etPin = (EditText) pinView.findViewById(R.id.etPin);
                                    builder.setView(pinView);
                                    builder.setCancelable(false);
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            final ProgressDialog progressDialog = new ProgressDialog(beliPulsa.this,
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
                                                                if ((appData.getInt("saldo",0)-( Integer.parseInt(bNominal.getText().toString())+1500))<0){
                                                                    AlertDialog.Builder errorBuilder = new AlertDialog.Builder(beliPulsa.this);
                                                                    errorBuilder.setMessage("Saldo Anda Tidak Mencukupi");
                                                                    errorBuilder.setCancelable(false);
                                                                    errorBuilder.setNegativeButton("OK", null);
                                                                    errorBuilder.show();
                                                                }else{
                                                                    String _jenis = bJenis.getText().toString();
                                                                    int _nominal = Integer.parseInt(bNominal.getText().toString());
                                                                    String _nomor = bNomor.getText().toString();
                                                                    Date date = Calendar.getInstance().getTime();
                                                                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                                                    String formattedDate = df.format(date);
                                                                    int random =new Random().nextInt((99999999 - 10000000) + 1) + 10000000;
                                                                    int newSaldo = appData.getInt("saldo",0);
                                                                    newSaldo = newSaldo-(_nominal+1500);

                                                                    SharedPreferences.Editor editor = appData.edit();
                                                                    editor.putInt("pinCounter",0);
                                                                    editor.putInt("saldo",newSaldo);
                                                                    editor.commit();

                                                                    LayoutInflater liResi = LayoutInflater.from(beliPulsa.this);
                                                                    View resiView = liResi.inflate(R.layout.layoutkonfirmasi, null);
                                                                    AlertDialog.Builder resiBuilder = new AlertDialog.Builder(beliPulsa.this);
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
                                                                    tv4.setText("Jenis Transaksi: Isi Ulang Pulsa");
                                                                    tv5.setText("Nominal : Rp. "+_nominal);
                                                                    tv6.setText("Biaya Admin: Rp. 1500");
                                                                    tv7.setText("Total Bayar: Rp. "+(_nominal+=1500));
                                                                    tv8.setText("No. Referensi: "+random);


                                                                    resiBuilder.setPositiveButton("Kembali ke Menu Awal", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            dialog.cancel();
                                                                            Intent iMain = new Intent(beliPulsa.this,mainMenu.class);
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
                                                                AlertDialog.Builder myBuilder = new AlertDialog.Builder(beliPulsa.this);
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
                                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(beliPulsa.this);
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
                }catch (Exception e){
                    AlertDialog.Builder errorBuilder = new AlertDialog.Builder(beliPulsa.this);
                    errorBuilder.setMessage("Tolong isi semua input");
                    errorBuilder.setCancelable(false);
                    errorBuilder.setNegativeButton("OK", null);
                    errorBuilder.show();
                }

            }

        });
    }
}
