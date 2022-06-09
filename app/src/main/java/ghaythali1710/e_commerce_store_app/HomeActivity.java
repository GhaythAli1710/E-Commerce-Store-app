package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import java.util.Objects;
import ghaythali1710.e_commerce_store_app.Fragments.Camera;
import ghaythali1710.e_commerce_store_app.Fragments.Home;
import ghaythali1710.e_commerce_store_app.Fragments.Search;

public class HomeActivity extends AppCompatActivity {

    private String token = " no thing";
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (SessionManager.getInstance(this).isLoggedIn()){
            token = SessionManager.getInstance(this).getToken().getToken();
        }else{
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            finish();
            Toast.makeText(HomeActivity.this, token, Toast.LENGTH_SHORT).show();
            return;
        }

        Objects.requireNonNull(getSupportActionBar()).hide();
        BubbleNavigationLinearView bubbleNavigationLinearView = findViewById(R.id.bubbleNavigation);
        bubbleNavigationLinearView.setBadgeValue(0,"10");
        bubbleNavigationLinearView.setBadgeValue(1,null);
        bubbleNavigationLinearView.setBadgeValue(2,"30");
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new Home());
        fragmentTransaction.commit();
        bubbleNavigationLinearView.setNavigationChangeListener((view, position) -> {
            switch (position){
                case 0:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new Home());
                    fragmentTransaction.commit();
                    break;
                case 1:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new Camera());
                    fragmentTransaction.commit();
                    break;
                case 2:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new Search());
                    fragmentTransaction.commit();
                    break;
            }
        });
    }
}