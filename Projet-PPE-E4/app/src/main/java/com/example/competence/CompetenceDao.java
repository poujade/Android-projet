package com.example.competence;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CompetenceDao {
    @Insert
    void insert(Competence competence);

    @Query("DELETE FROM competence_table")
    void deleteAll();

    @Query("SELECT *FROM competence_table ORDER BY nomCompetence ASC")
    LiveData<List<Competence>>getToutesCompetence();
}
