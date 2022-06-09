package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button btn3, btn4, btn5;
    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        userName = findViewById(R.id.userNameId);
        password = findViewById(R.id.passwordId);

        btn3.setOnClickListener(v -> action());

        btn4.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            finish();
        });

        btn5.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        });
    }

    private void action() {
        final String myUserName = userName.getText().toString().trim();
        final String myPassword = password.getText().toString().trim();

        if (TextUtils.isEmpty(myUserName)){
            userName.setError("Enter your name please");
            userName.requestFocus();
            return;
        }if (TextUtils.isEmpty(myPassword)){
            password.setError("Enter your password please");
            password.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLs.URL_LOGIN,
                this::responseAction,
                this::errorAction
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("username", myUserName);
                params.put("password", myPassword);
                return params;
            }
        };
        VolleySingleton.getInstance(LoginActivity.this)
                .AddToRequestQueue(stringRequest);
    }

    private void errorAction(VolleyError Error) {
    }

    public void responseAction(String response){
        try {
            JSONObject obj = new JSONObject(response);
            if (obj.getBoolean("success")){
                JSONObject userJson = obj.getJSONObject("data");
                User user = new User(userJson.getString("token"));
                SessionManager.getInstance(getApplicationContext()).userLogin(user);
                finish();
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }else{
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}