package otoni.omena.santos.machado.movietag.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.fragments.HomeFragment;
import otoni.omena.santos.machado.movietag.fragments.MinhasListasFragment;
import otoni.omena.santos.machado.movietag.fragments.PerfilFragment;
import otoni.omena.santos.machado.movietag.models.MainActivityViewModel;
import otoni.omena.santos.machado.movietag.utils.Config;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criar ViewModel
        final MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);


        bottomNavigationView = findViewById(R.id.btNavPrincipal);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                vm.setNavigationOpSelected(item.getItemId());
                int itemId = item.getItemId();
                if (itemId == R.id.inicioViewOp){
                    HomeFragment homeFragment = HomeFragment.newInstance(MainActivity.this);
                    setFragment(homeFragment);
                }
                if (itemId == R.id.minhasListasViewOp){
                    if(Config.getLogin(MainActivity.this).isEmpty()){
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                    }

                    MinhasListasFragment minhasListasFragment = MinhasListasFragment.newInstance();
                    setFragment(minhasListasFragment);
                }

                if (itemId == R.id.perfilUsuarioOp){

                    if(Config.getLogin(MainActivity.this).isEmpty()){
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                    }

                    PerfilFragment perfilFragment = PerfilFragment.newInstance();
                    setFragment(perfilFragment);
                }
                return true;

            }
        });

    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flPrincipal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}