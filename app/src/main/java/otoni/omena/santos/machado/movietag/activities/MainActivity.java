package otoni.omena.santos.machado.movietag.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.fragments.HomeFragment;
import otoni.omena.santos.machado.movietag.fragments.MinhasListasFragment;
import otoni.omena.santos.machado.movietag.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criar ViewModel

        bottomNavigationView = findViewById(R.id.btNavPrincipal);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.inicioViewOp){
                    HomeFragment homeFragment = HomeFragment.newInstance();
                    setFragment(homeFragment);
                }
                if (itemId == R.id.minhasListasViewOp){
                    MinhasListasFragment minhasListasFragment = MinhasListasFragment.newInstance();
                    setFragment(minhasListasFragment);
                }

                if (itemId == R.id.perfilUsuarioOp){
                    // Testar se a pessoa está logada
                    PerfilFragment perfilFragment = PerfilFragment.newInstance();
                    setFragment(perfilFragment);
                }
                return true;

            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flPrincipal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}