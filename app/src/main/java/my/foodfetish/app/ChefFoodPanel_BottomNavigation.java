package my.foodfetish.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.foodfetish.app.chefFoodPanel.ChefHomeFragment;
import my.foodfetish.app.chefFoodPanel.ChefOrderFragment;
import my.foodfetish.app.chefFoodPanel.ChefPendingOrderFragment;
import my.foodfetish.app.chefFoodPanel.ChefProfileFragment;
import my.foodfetish.app.customerFoodPanel.CustomerHomeFragment;
import my.foodfetish.app.customerFoodPanel.CustomerTrackFragment;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);

        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        String name = getIntent().getStringExtra("PAGE");
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(name!=null){
            if(name.equalsIgnoreCase("Orderpage")){
                loadcheffragment(new ChefPendingOrderFragment());
            }else if(name.equalsIgnoreCase("Confirmpage")){
                loadcheffragment(new ChefOrderFragment());
            }else if(name.equalsIgnoreCase("AcceptOrderpage")){
                loadcheffragment(new ChefOrderFragment());
            }else if(name.equalsIgnoreCase("Deliveredpage")){
                loadcheffragment(new ChefOrderFragment());
            }
        }else{
            loadcheffragment(new ChefHomeFragment());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.chefHome:
                fragment=new ChefHomeFragment();
                break;
            case R.id.PendingOrders:
                fragment=new ChefPendingOrderFragment();
                break;
            case R.id.Orders:
                fragment=new ChefOrderFragment();
                break;
            case R.id.chefProfile:
                fragment=new ChefProfileFragment();
                break;
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
            return true;
        }
        return false;
    }
}