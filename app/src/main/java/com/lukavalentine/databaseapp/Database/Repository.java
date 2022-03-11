package com.lukavalentine.databaseapp.Database;

import android.app.Application;

import com.lukavalentine.databaseapp.DAO.AssessmentDAO;
import com.lukavalentine.databaseapp.DAO.CourseDAO;
import com.lukavalentine.databaseapp.DAO.LevelDAO;
import com.lukavalentine.databaseapp.DAO.UserDAO;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.LevelEntity;
import com.lukavalentine.databaseapp.Entities.UserEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    //Add userdata to the repo



    private AssessmentDAO mAssessmentDAO;
    private CourseDAO mCourseDAO;
    private LevelDAO mLevelDAO;
    private UserDAO mUserDAO;
    private List<AssessmentEntity> mAllAssessments;
    private List<CourseEntity> mAllCourses;
    private List<LevelEntity> mAllLevels;
    private List<UserEntity> mAllUsers;
    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){

        DatabaseBuilder db = DatabaseBuilder.getDatabase(application);
        mAssessmentDAO = db.assessmentDAO();
        mCourseDAO = db.courseDAO();
        mLevelDAO = db.LevelDAO();
        mUserDAO = db.userDAO();


    }

    public List<LevelEntity> getAllLevels(){
        databaseWriteExecutor.execute(() -> {
            mAllLevels = mLevelDAO.getAllLevels();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllLevels;
    }

    public List<CourseEntity> getAllCourses(){
        databaseWriteExecutor.execute(() -> {
            mAllCourses = mCourseDAO.getAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllCourses;
    }

    public List<AssessmentEntity> getAllAssessments(){
        databaseWriteExecutor.execute(() ->{
            mAllAssessments = mAssessmentDAO.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public List<UserEntity> getAllUsers(){
        databaseWriteExecutor.execute(() ->{
            mAllUsers = mUserDAO.getAllUsers();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllUsers;
    }



    public void insert(LevelEntity LevelEntity){
        databaseWriteExecutor.execute(() -> {
            mLevelDAO.insert(LevelEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insert(CourseEntity courseEntity){
        databaseWriteExecutor.execute(() -> {
            mCourseDAO.insert(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void insert(AssessmentEntity assessmentEntity){
        databaseWriteExecutor.execute(() -> {
            mAssessmentDAO.insert(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insert(UserEntity userEntity){
        databaseWriteExecutor.execute(() -> {
            mUserDAO.insert(userEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(LevelEntity LevelEntity){
        databaseWriteExecutor.execute(() -> {
            mLevelDAO.insert(LevelEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(CourseEntity courseEntity){
        databaseWriteExecutor.execute(() -> {
            mCourseDAO.insert(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(AssessmentEntity assessmentEntity){
        databaseWriteExecutor.execute(() -> {
            mAssessmentDAO.insert(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(UserEntity userEntity){
        databaseWriteExecutor.execute(() -> {
            mUserDAO.update(userEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(AssessmentEntity assessmentEntity){
        databaseWriteExecutor.execute(() -> {
            mAssessmentDAO.delete(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(CourseEntity courseEntity){
        databaseWriteExecutor.execute(() -> {
            mCourseDAO.delete(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(LevelEntity LevelEntity){
        databaseWriteExecutor.execute(() -> {
            mLevelDAO.delete(LevelEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(UserEntity userEntity){
        databaseWriteExecutor.execute(() -> {
            mUserDAO.delete(userEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllAssessments(){
        databaseWriteExecutor.execute(() -> {
            mAssessmentDAO.deleteAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllCourses(){
        databaseWriteExecutor.execute(() -> {
            mCourseDAO.deleteAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllLevels(){
        databaseWriteExecutor.execute(() -> {
            mLevelDAO.deleteAllLevels();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllUsers(){
        databaseWriteExecutor.execute(() -> {
            mUserDAO.deleteAllUsers();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}
