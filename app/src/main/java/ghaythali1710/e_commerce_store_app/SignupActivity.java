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

public class SignupActivity extends AppCompatActivity {

    Button btn6;
    EditText name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn6 = findViewById(R.id.button6);
        name = findViewById(R.id.nameId);
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.passId);

        btn6.setOnClickListener(v -> action());
    }

    private void action() {
        final String myName = name.getText().toString().trim();
        final String myEmail = email.getText().toString().trim();
        final String myPassword = password.getText().toString().trim();

        if (TextUtils.isEmpty(myName)){
            name.setError("Enter your name please");
            name.requestFocus();
            return;
        }if (TextUtils.isEmpty(myEmail)){
            email.setError("Enter your email please");
            email.requestFocus();
            return;
        }if (TextUtils.isEmpty(myPassword)){
            password.setError("Enter your password please");
            password.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLs.URL_SIGNUP,
                this::responseAction,
                this::errorAction
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("username", myName);
                params.put("email", myEmail);
                params.put("password", myPassword);
                return params;
            }
        };
        VolleySingleton.getInstance(SignupActivity.this)
                .AddToRequestQueue(stringRequest);
    }

    private void errorAction(VolleyError error) {
        Toast.makeText(SignupActivity.this,
                error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void responseAction(String response){
        try {
            JSONObject obj = new JSONObject(response);
            if (obj.getBoolean("success")){
                Toast.makeText(SignupActivity.this,
                        obj.getString("message"), Toast.LENGTH_SHORT).show();
                JSONObject userJson = obj.getJSONObject("data");
                User user = new User(userJson.getString("token"));
                SessionManager.getInstance(getApplicationContext()).userLogin(user);
                finish();
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }else{
                Toast.makeText(SignupActivity.this,
                        "register failed", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}