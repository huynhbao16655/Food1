package baotoan.food.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import baotoan.food.model.CategoryModel;
import baotoan.food.model.MealModel;
import baotoan.food.repository.CategoryRepository;
import baotoan.food.repository.MealRepository;

public class HomeViewModel extends ViewModel {
    private CategoryRepository categoryRepository;
    private MealRepository mealRepository;
    public HomeViewModel() {

        categoryRepository = new CategoryRepository();
        mealRepository = new MealRepository();
    }
    public MutableLiveData<CategoryModel> categoryModelMutableLiveData(){
        return categoryRepository.getCategory();
    }
    public MutableLiveData<MealModel> mealModelMutableLiveData(int idcate){
        return mealRepository.getMeals(idcate);
    }
}
