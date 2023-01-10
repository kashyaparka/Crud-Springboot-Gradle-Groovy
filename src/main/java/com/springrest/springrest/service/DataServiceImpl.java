package com.springrest.springrest.service;
import java.util.List;
import java.util.ArrayList;
import com.springrest.springrest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.dao.UserDao;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private UserDao userDao;
    //    List<User> list;
    public DataServiceImpl(){
    //            list = new ArrayList<>();
    //            list.add(new User(12,"Nitin","ar@gmail.com","12345678"));
    }

    @Override
    public List<User> getUser(){
        return userDao.findAll();
    }

    public User getUser(long id) {
    //              User c=null;
    //              for(User user:list){
    //                  if(user.getId()==id)
    //                      c=user;
    //              }
    //              return c;
        return userDao.getOne(id);
    }
    @Override
    public User addUser(User user) {
//            list.add(user);
//            return user;
        userDao.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
//            for(User userr:list){
//                if(userr.getId()==user.getId())
//                    userr.setName(user.getName());
//            }
//            return user;
        userDao.save(user);
        return user;
    }

    @Override
    public void deleteUser(long id) {
//            list.remove(id);
        User entity = userDao.getOne(id);
        userDao.delete(entity);
    }
}
