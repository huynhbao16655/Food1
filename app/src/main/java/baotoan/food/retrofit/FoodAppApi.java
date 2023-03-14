package baotoan.food.retrofit;

import baotoan.food.model.CategoryModel;
import baotoan.food.model.MealModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FoodAppApi {
    @GET("category.php")
    Call<CategoryModel> getCategory();

    @POST("meal.php")
    @FormUrlEncoded
    Call<MealModel> getMeals( // truyền giá trị dô cho nó rồi nó sẽ đẩy lên
            @Field("idcate") int idcate
    );

    @POST("mealdetail.php")
    @FormUrlEncoded
    Call<MealModel> getMealDetail(
            @Field("id") int id
            );
}
