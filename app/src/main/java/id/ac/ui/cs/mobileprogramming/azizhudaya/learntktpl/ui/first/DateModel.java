package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "datemodel_table")
public class DateModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "time_recorded")
    private long timeRecorded;

    @ColumnInfo(name = "time_created")
    private String timeCreated;

    public DateModel(long timeRecorded, String timeCreated) {
        this.timeCreated = timeCreated;
        this.timeRecorded = timeRecorded;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(long timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

