package baotoan.food.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import baotoan.food.model.CategoryModel;
import baotoan.food.repository.CategoryRepository;

public class HomeViewModel extends ViewModel {
    private CategoryRepository categoryRepository;

    public HomeViewModel() {
        categoryRepository = new CategoryRepository();
    }

    public MutableLiveData<CategoryModel> categoryModelMutableLiveData(){
        return categoryRepository.getCategory();
    }
}
