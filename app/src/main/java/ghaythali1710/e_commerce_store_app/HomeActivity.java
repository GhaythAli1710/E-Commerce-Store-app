package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        chipNavigationBar = findViewById(R.id.bottomBarId);
        getSupportFragmentManager()
                .beginTransaction().replace(
                        R.id.fragmentesContainerId,
                        new HomeFragment()
                ).commit();
        bottomBarMenu();
        fab();

    }

    @SuppressLint("SetTextI18n")
    private void fab() {
        TextView textView;
        textView = findViewById(R.id.fabCounter);
        ImageButton imageButton;
        imageButton = findViewById(R.id.fabBtn);
        imageButton.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction().replace(
                            R.id.fragmentesContainerId,
                            new StoreFragment()
                    ).commit();
            textView.setText("30");
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void bottomBarMenu() {
        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i){
                case R.id.itemHomeBottomBar:
                    fragment = new HomeFragment();
                    break;
                case R.id.itemCameraBottomBar:
                    fragment = new CameraFragment();
                    break;
                case R.id.itemSearchBottomBar:
                    fragment = new SearchFragment();
                    break;
            }
            getSupportFragmentManager()
                    .beginTransaction().replace(
                            R.id.fragmentesContainerId,
                            Objects.requireNonNull(fragment)
                    ).commit();
        });
    }
}