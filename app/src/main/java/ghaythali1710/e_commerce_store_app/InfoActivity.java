package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            startActivity(new Intent(InfoActivity.this, PermissionActivity.class));
            finish();
        });
    }
}