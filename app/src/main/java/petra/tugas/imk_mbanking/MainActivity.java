package petra.tugas.imk_mbanking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etId;
    EditText etPass;
    Button butLogin;
    TextView tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = (EditText)findViewById(R.id.input_id);
        etPass = (EditText)findViewById(R.id.input_password);
        butLogin = (Button)findViewById(R.id.btn_login);
        tvLink = (TextView)findViewById(R.id.link_web);

        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(i);
            }
        });

    }
    public void login() {
        Log.d("Login", "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        butLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,
                R.style.Theme_AppCompat_DayNight_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String sId = etId.getText().toString();
        String sPass = etPass.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }
    public void onLoginSuccess() {
        butLogin.setEnabled(true);
        Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_LONG).show();
    }
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        butLogin.setEnabled(true);
    }
    public boolean validate() {
        boolean valid = true;

        String sId = etId.getText().toString();
        String sPass = etPass.getText().toString();

        if (sId.isEmpty() ) {
            etId.setError("enter a valid user ID");
            valid = false;
        } else {
            etId.setError(null);
        }

        if (sPass.isEmpty() || sPass.length() != 6) {
            etPass.setError("6 digit number");
            valid = false;
        } else {
            etPass.setError(null);
        }

        return valid;
    }
}
