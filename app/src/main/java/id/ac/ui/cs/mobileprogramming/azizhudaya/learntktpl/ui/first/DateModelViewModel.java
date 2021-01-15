package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class DateModelViewModel extends AndroidViewModel {
        private DateModelRepository dateModelRepository;
        private LiveData<List<DateModel>> dateModel;

        public DateModelViewModel(@NonNull Application application) {
                super(application);
                dateModelRepository = new DateModelRepository(application);
                dateModel =dateModelRepository.getAllDateModel();
        }

        public LiveData<List<DateModel>> getAllDateModel() {return dateModel;};
        public void insert(DateModel dateModel) {dateModelRepository.insert(dateModel);}

}