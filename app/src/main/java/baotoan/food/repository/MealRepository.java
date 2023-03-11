package baotoan.food.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import baotoan.food.model.MealModel;
import baotoan.food.retrofit.FoodAppApi;
import baotoan.food.retrofit.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {

    private FoodAppApi foodAppApi;

    public MealRepository() {
        foodAppApi = RetrofitInstance.getRetrofit().create(FoodAppApi.class);
    }
    public MutableLiveData<MealModel> getMeals(int idcate){
        MutableLiveData<MealModel> data = new MutableLiveData<>();
        foodAppApi.getMeals(idcate).enqueue(new Callback<MealModel>() {
            @Override// neu thanh cong
            public void onResponse(Call<MealModel> call, Response<MealModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MealModel> call, Throwable t) {
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
