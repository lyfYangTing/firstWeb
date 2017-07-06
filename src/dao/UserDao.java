package dao;

import po.User;
import util.JdbcTemplate;
import util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 18435 on 2017/7/5.
 */
public class UserDao implements RowMapper{
    JdbcTemplate jdbc = new JdbcTemplate();

    //新增数据
    public void insert(User user){
        String sql = "insert into information(username,password,money) values(?,?,?)";
        this.jdbc.update(sql,new Object[]{user.getUsername(),user.getPassword(),user.getMoney()});
    }

    //更新数据
    public void update(User user){
        String sql = "update information set password=?,money=? where username=?";
        this.jdbc.update(sql,new Object[]{user.getPassword(),user.getMoney(),user.getUsername()});
    }

    //查询数据
    public User getOneUser(String username){
        String sql = "select * from information where username=?";
        User user =(User)this.jdbc.queryForOne(sql,new Object[]{username},this);
        return user;
    }

    //删除数据
    public void delete(String username){
        String sql = "delete from information where username=?";
        this.jdbc.update(sql,new Object[]{username});
    }

    @Override
    public User mapper(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setMoney(rs.getDouble("money"));
        return user;
    }
}
