package com.example.competence;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;
import androidx.lifecycle.LiveData;

public class CompetenceRepository {
    private CompetenceDao maCompetenceDao;
    private LiveData<List<Competence>> mesCompetences;

    CompetenceRepository(Application application){
        CompetenceRoomDatabase database = CompetenceRoomDatabase.getDatabase(application);
        maCompetenceDao = database.competenceDao();
        mesCompetences = maCompetenceDao.getToutesCompetence();
    }
    LiveData<List<Competence>> getMesCompetences() { return mesCompetences;}
    public void insert (Competence uneCompetence){
        new insertAsyncTask(maCompetenceDao).execute(uneCompetence);
    }


    private static class insertAsyncTask extends AsyncTask<Competence, Void,Void> {
        private CompetenceDao maTacheDao;
        insertAsyncTask(CompetenceDao dao ) { maTacheDao = dao; }

        @Override
        protected Void doInBackground(final Competence... params){
            maTacheDao.insert(params[0]);
            return null;
        }
    }
}
