package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DateModelRepository {
    private DateModelDao dateModelDao;

    public DateModelRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        dateModelDao = db.dateModelDao();
    }
    public LiveData<List<DateModel>> getAllDateModel() {
        return dateModelDao.getAllDateModel();
    }
    public void insert(DateModel dateModel) {
        AppDatabase.databaseWriteExecutor.execute(() -> {dateModelDao.insert(dateModel);});
    }
}
