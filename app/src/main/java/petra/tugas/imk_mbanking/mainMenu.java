package petra.tugas.imk_mbanking;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class mainMenu extends AppCompatActivity {
    TextView tvNama;
    Intent logout;
    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar().setTitle("MNHMobile");
        tvNama = (TextView)findViewById(R.id.tvNama);
        Intent i = getIntent();
        data=i.getStringArrayExtra("data");
        int a = Integer.parseInt(data[1]);
        tvNama.setText(""+a);
        logout = new Intent(this,MainActivity.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout){
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder.setMessage("Anda yakin ingin keluar?");
            myBuilder.setCancelable(true);
            myBuilder.setNegativeButton("Tidak",null);
            myBuilder.setPositiveButton("Ya",new Ok1OnClickListener());

            AlertDialog dialog = myBuilder.create();
            dialog.show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void mainMenuClick(View view) {
        switch (view.getId()){
            case R.id.mInfo:
                Intent iinfo = new Intent(this,mInfo.class);
                iinfo.putExtra("data",data);
                startActivity(iinfo);
                break;

            case R.id.mPayment:
                Intent ipayment = new Intent(this,mPayment.class);
                ipayment.putExtra("data",data);
                startActivity(ipayment);
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }

    private class Ok1OnClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            final ProgressDialog progressDialog = new ProgressDialog(mainMenu.this,
                    R.style.Theme_AppCompat_Light_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Please Wait....");
            progressDialog.show();
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            progressDialog.dismiss();
                        }
                    }, 3000);
            startActivity(logout);
        }
    }
}
