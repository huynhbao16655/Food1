package baotoan.food.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodAppApi {
    @GET("category.php")
    Call<CategoryModel> getCategory();
}
