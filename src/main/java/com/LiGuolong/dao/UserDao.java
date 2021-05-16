package com.LiGuolong.dao;

import com.LiGuolong.model.Category;
import com.LiGuolong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public int saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into userdb.dbo.usertable(username,password,email,gender,birthDate) " +
                "values(?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setDate(5, (java.sql.Date) user.getBirthDate());
        return st.executeUpdate();
    }

    @Override
    public int deleteUserById(Connection con, Integer id) throws SQLException {
        String sql = "delete userdb.dbo.usertable where id= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        return st.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update userdb.dbo.usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setDate(5, (java.sql.Date) user.getBirthDate());
        st.setInt(6,user.getId());
        return st.executeUpdate();

    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where id=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        return getUser(st);
    }

    private User getUser(PreparedStatement st) throws SQLException {
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where username= ? and password= ? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        return getUser(st);
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where username= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        return getUsers(st);
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where password= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        return getUsers(st);
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where email= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        return getUsers(st);
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where gender= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        return getUsers(st);
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from userdb.dbo.usertable where birthdate= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        return getUsers(st);
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.usertable";
        PreparedStatement st=con.prepareStatement(sql);
        return getUsers(st);
    }

    private List<User> getUsers(PreparedStatement st) throws SQLException {
        ResultSet rs= st.executeQuery();
        List<User> list= new ArrayList<>();
        if (rs.next()) {
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }
}
