package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    /**/
    private ChipNavigationBar chipNavigationBar;
    private SNavigationDrawer sNavigationDrawer;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**/
        chipNavigationBar = findViewById(R.id.bottomBarId);
        chipNavigationBar.setItemSelected(R.id.itemHomeBottomBar, true);
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        fragment = new HomeFragment(HomeActivity.this);
        List<MenuItem> itemList = new ArrayList<>();
        itemList.add(new MenuItem("HOME",R.drawable.ic_home));
        itemList.add(new MenuItem("CAMERA",R.drawable.ic_camera));
        itemList.add(new MenuItem("SEARCH",R.drawable.ic_search));
        itemList.add(new MenuItem("HOME",R.drawable.ic_home));
        itemList.add(new MenuItem("CAMERA",R.drawable.ic_camera));
        itemList.add(new MenuItem("SEARCH",R.drawable.ic_search));
        sNavigationDrawer.setMenuItemList(itemList);
        /**/
        getSupportFragmentManager()
                .beginTransaction().replace(
                        R.id.fragmentesContainerId,
                        fragment
                ).commit();
        //
        sNavigationDrawer.setAppbarTitleTV("HOME");
        //
        bottomBarMenu();
        //
        fab();
        //
        navBar();
    }

    @SuppressLint("SetTextI18n")
    private void fab() {
        TextView textView;
        textView = findViewById(R.id.fabCounter);
        ImageButton imageButton;
        imageButton = findViewById(R.id.fabBtn);
        imageButton.setOnClickListener(v -> {
            fragment = new StoreFragment();
            getSupportFragmentManager()
                    .beginTransaction().replace(
                            R.id.fragmentesContainerId,
                            fragment
                    ).commit();
            textView.setVisibility(View.VISIBLE);
            textView.setText("30");
            chipNavigationBar.setItemSelected(R.id.itemHomeBottomBar, false);
            chipNavigationBar.setItemSelected(R.id.itemCameraBottomBar, false);
            chipNavigationBar.setItemSelected(R.id.itemSearchBottomBar, false);
        });
    }
    //
    @SuppressLint("NonConstantResourceId")
    private void bottomBarMenu() {
        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i){
                case R.id.itemHomeBottomBar:
                    fragment = new HomeFragment(HomeActivity.this);
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
    //
    @SuppressLint("NonConstantResourceId")
    public void menuSelector(){
        sNavigationDrawer.setOnMenuItemClickListener(position -> {
            switch (position){
                case 0:
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
    //
    public void navBar(){
        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                menuSelector();
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}