package baotoan.food.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import baotoan.food.R;
import baotoan.food.adapters.CategoryAdapter;
import baotoan.food.adapters.PopularAdapter;
import baotoan.food.databinding.ActivityHomeBinding;
import baotoan.food.listener.CategoryListener;
import baotoan.food.listener.EventClickListener;
import baotoan.food.model.Category;
import baotoan.food.model.Meals;
import baotoan.food.viewModel.HomeViewModel;

public class HomeActivity extends AppCompatActivity implements CategoryListener, EventClickListener {
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
        //category(Linear) hien hang ngang dai qua
        binding.rcCategory.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rcCategory.setLayoutManager(layoutManager);
        //popular(Grid) hien hang doc spanCount la dem san pham o day la 3 nen hien toi 3 xong xuong hang tuong tu
        binding.rcPopular.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this, 3);
        binding.rcPopular.setLayoutManager(layoutManager1);
    }

    private void intiData(){
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this, categoryModel -> {
            if( categoryModel.isSuccess()){
                CategoryAdapter adapter = new CategoryAdapter(categoryModel.getResult(), this);
                binding.rcCategory.setAdapter(adapter);
            }
        });
        homeViewModel.mealModelMutableLiveData(1).observe(this, mealModel -> {
            if( mealModel.isSuccess()){
                PopularAdapter adapter = new PopularAdapter(mealModel.getResult(), this);
                binding.rcPopular.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        intent.putExtra("idcate", category.getId());
        intent.putExtra("namecate", category.getCategory());
        startActivity(intent);
    }

    @Override
    public void onPopularClick(Meals meals) {
        Intent intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
        intent.putExtra("id", meals.getIdMeal());
        intent.putExtra("namecate", meals.getStrMeal());
        startActivity(intent);
    }
}