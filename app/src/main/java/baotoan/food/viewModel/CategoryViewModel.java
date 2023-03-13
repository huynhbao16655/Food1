package baotoan.food.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import baotoan.food.model.MealModel;
import baotoan.food.repository.MealRepository;

public class CategoryViewModel extends ViewModel {
    private MealRepository mealRepository;

    public CategoryViewModel() {
        mealRepository = new MealRepository();
    }

    public MutableLiveData<MealModel> mealModelMutableLiveData(int idcate){
        return mealRepository.getMeals(idcate);
    }
}
