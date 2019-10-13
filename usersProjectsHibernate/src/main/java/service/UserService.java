package service;

import dao.UsersDao;
import models.Project;
import models.User;

import java.util.List;

public class UserService {

    private UsersDao usersDao = new UsersDao();

    public UserService(){

    }

    public User findUser(int id){
        return usersDao.findById(id);
    }

    public void saveUser (User user){
        usersDao.save(user);
    }

    public void updateUser (User user){
        usersDao.update(user);
    }

    public void deleteUser (User user){
        usersDao.delete(user);
    }

    public List<User> findAllUsers(){
        return  usersDao.findAll();
    }

    public Project findProjectsById(int id){
        return usersDao.findProjectById(id);
    }
}
