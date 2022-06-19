package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    /****/
    private static final int SPLASH_SCREEN = 2100;
//    private static final int SPLASH_SCREEN = 0;
    private Animation topAnim,bottomAnim;
    private ImageView logoApp;
    private TextView nameApp, categoryApp, versionApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**/
        Initialize();
        /**/
        Action();
    }
    /****/
    private void Initialize(){
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**/
        logoApp=findViewById(R.id.logo_app);
        nameApp=findViewById(R.id.name_app);
        categoryApp=findViewById(R.id.category_app);
        versionApp=findViewById(R.id.version_app);
        /**/
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
    }
    /****/
    private void Action(){
        logoApp.setAnimation(topAnim);
        nameApp.setAnimation(bottomAnim);
        categoryApp.setAnimation(bottomAnim);
        versionApp.setAnimation(bottomAnim);
        /**/
        new Handler().postDelayed(() -> {
//                if(checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
//                    startActivity(new Intent(SplashScreenActivity.this,PermissionActivity.class));
//                }
//                else{
//                    startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
//                }
            startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            finish();
        },SPLASH_SCREEN);
    }
}