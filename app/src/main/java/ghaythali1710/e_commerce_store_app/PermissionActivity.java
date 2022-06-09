package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            startActivity(new Intent(PermissionActivity.this, LoginActivity.class));
            finish();
        });
    }
}