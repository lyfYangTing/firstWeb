package service;

import dao.UserDao;
import po.User;

/**
 * Created by 18435 on 2017/7/5.
 */
public class UserService {
     private UserDao userDao = new UserDao();

    //登陆验证
    public User login(String username,String password){
        User user = userDao.getOneUser(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    //存款
    public void cunMoney(User user,double money){
        user.setMoney(user.getMoney()+money);
        userDao.update(user);
    }

    //取款
    public void quMoney(User user,double money){
        user.setMoney(user.getMoney()-money);
        userDao.update(user);
    }

    //转账
    public void zhuanMoney(String zrUsername,User zcUser,double money){
        User zrUser = userDao.getOneUser(zrUsername);
        if(zrUser!=null){
            zcUser.setMoney(zcUser.getMoney()-money);
            zrUser.setMoney(zrUser.getMoney()+money);
        }
        userDao.update(zcUser);
        userDao.update(zrUser);
    }

    //查询余额
    public double chaYu(String username){
        User user = userDao.getOneUser(username);
        return user.getMoney();
    }
}
