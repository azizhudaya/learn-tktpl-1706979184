package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DateModelDao {
    @Insert
    void insert(DateModel dateModel);

    @Query("SELECT * FROM datemodel_table")
    LiveData<List<DateModel>> getAllDateModel();

    @Query("DELETE FROM datemodel_table")
    void deleteAll();
}
