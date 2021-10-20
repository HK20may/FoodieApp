package my.foodfetish.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.foodfetish.app.chefFoodPanel.ChefHomeFragment;
import my.foodfetish.app.chefFoodPanel.ChefOrderFragment;
import my.foodfetish.app.chefFoodPanel.ChefPendingOrderFragment;
import my.foodfetish.app.deliveryFoodPanel.DeliveryPendingOrderFragment;
import my.foodfetish.app.deliveryFoodPanel.DeliveryShipOrderFragment;

public class DeliveryFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        String name = getIntent().getStringExtra("PAGE");
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(name!=null){
            if(name.equalsIgnoreCase("Orderpage")){
                loaddeliveryfragment(new DeliveryPendingOrderFragment());
            }
        }else{
            loaddeliveryfragment(new DeliveryPendingOrderFragment());
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.shiporders:
                fragment=new DeliveryShipOrderFragment();
                break;
        }
        switch (item.getItemId()){
            case R.id.pendingorders:
                fragment=new DeliveryPendingOrderFragment();
                break;
        }
        return loaddeliveryfragment(fragment);
    }

    private boolean loaddeliveryfragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}