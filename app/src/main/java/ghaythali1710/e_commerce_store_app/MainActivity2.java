package ghaythali1710.e_commerce_store_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private SNavigationDrawer sNavigationDrawer;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //
        chipNavigationBar = findViewById(R.id.bottomBarId);
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> itemList = new ArrayList<>();
        itemList.add(new MenuItem("Home",R.drawable.ic_home));
        itemList.add(new MenuItem("Camera",R.drawable.ic_camera));
        itemList.add(new MenuItem("Search",R.drawable.ic_search));
        sNavigationDrawer.setMenuItemList(itemList);
        //
        getSupportFragmentManager()
                .beginTransaction().replace(
                        R.id.fragmentesContainerId,
                        new HomeFragment()
                ).commit();
        //
        sNavigationDrawer.setAppbarTitleTV("gh");
        //
        bottomBarMenu();
        //
        fab();
        //
        navBar();
    }
    //
    @SuppressLint("NonConstantResourceId")
    private void bottomBarMenu() {
        chipNavigationBar.setOnItemSelectedListener(i -> {
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
    //
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
    //
    @SuppressLint("NonConstantResourceId")
    public void menuSelector(){
        sNavigationDrawer.setOnMenuItemClickListener(position -> {
            switch (position){
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new CameraFragment();
                    break;
                case 2:
                    fragment = new SearchFragment();
                    break;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragmentesContainerId,
                            Objects.requireNonNull(fragment)
                    )
                    .commit();
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