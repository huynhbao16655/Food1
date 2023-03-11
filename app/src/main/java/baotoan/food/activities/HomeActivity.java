package baotoan.food.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import baotoan.food.R;
import baotoan.food.adapters.CategoryAdapter;
import baotoan.food.databinding.ActivityHomeBinding;
import baotoan.food.viewModel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {
    HomeViewModel homeViewModel;
    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        intiVew();
        intiData();
    }

    private void intiVew(){
        binding.rcCategory.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rcCategory.setLayoutManager(layoutManager);
    }

    private void intiData(){
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this, categoryModel -> {
            if( categoryModel.isSuccess()){
                CategoryAdapter adapter = new CategoryAdapter(categoryModel.getResult());
                binding.rcCategory.setAdapter(adapter);
            }
        });
    }
}