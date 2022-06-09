package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
//            if (True){
//                go to HomeActivity
//            }else{
//                go to InfoActivity + PermissionActivity
//            }
            startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            finish();
        },2100);
    }
}