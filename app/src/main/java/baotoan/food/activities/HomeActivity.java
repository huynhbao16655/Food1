package baotoan.food.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import baotoan.food.R;
import baotoan.food.viewModel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {
    HomeViewModel homeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intiData();
    }

    private void intiData(){
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this, categoryModel -> {
            if( categoryModel.isSuccess()){
                Log.d("logg", categoryModel.getResult().get(0).getCategory());
            }
        });
    }
}