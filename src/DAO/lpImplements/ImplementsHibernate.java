package DAO.lpImplements;

import DAO.link.JDBC.LinkDatabase;
import DAO.lpInterface.HibernateInterface;
import DAO.valueObject.Hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplementsHibernate implements HibernateInterface {

    @Override
    public void insert(DAO.valueObject.Hibernate hibernate) throws Exception {
        String sql = "insert into hibernate(user_id, user_name, user_password) values (?, ?, ?);";

        PreparedStatement preparedStatement = null;

        LinkDatabase linkDatabase = null;

        try {
            linkDatabase = new LinkDatabase();

            preparedStatement = linkDatabase.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, (hibernate.getUser_id() + ""));

            preparedStatement.setString(2, hibernate.getUser_name());

            preparedStatement.setString(3, hibernate.getUser_password());

            //数据库更新操作
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            throw new Exception("操作异常！");
        } finally {
            linkDatabase.close();
        }
    }

    @Override
    public void delete(DAO.valueObject.Hibernate hibernate) throws Exception {
        String sql = "delete from hibernate where user_id = ?;";

        PreparedStatement preparedStatement = null;

        LinkDatabase linkDatabase = null;

        try {

            linkDatabase = new LinkDatabase();

            preparedStatement = linkDatabase.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, (hibernate.getUser_id() + ""));

            //数据库更新操作
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            throw new Exception("操作异常！");
        } finally {
            linkDatabase.close();
        }
    }

    @Override
    public void update(DAO.valueObject.Hibernate hibernate) throws Exception {
        String sql = "update hibernate set user_name = ?, user_password = ? where user_id = ?;";

        PreparedStatement preparedStatement = null;

        LinkDatabase linkDatabase = null;

        try {

            linkDatabase = new LinkDatabase();

            preparedStatement = linkDatabase.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, hibernate.getUser_name());

            preparedStatement.setString(2, hibernate.getUser_password());

            preparedStatement.setString(3, (hibernate.getUser_id() + ""));

            //数据库更新操作
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            throw new Exception("操作异常！");
        } finally {
            linkDatabase.close();
        }

    }

    @Override
    public DAO.valueObject.Hibernate queryById(int userid) throws Exception {

        String sql = "select * from hibernate where user_id = ?;";

        LinkDatabase linkDatabase = null;

        PreparedStatement preparedStatement = null;

        Hibernate hibernateValue = null;

        try {

            linkDatabase = new LinkDatabase();

            preparedStatement = linkDatabase.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, userid + "");

            //数据库更新操作
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                hibernateValue = new Hibernate();
                hibernateValue.setUser_id(resultSet.getInt(1));
                hibernateValue.setUser_name(resultSet.getString(2));
                hibernateValue.setUser_password(resultSet.getString(3));
            }

            resultSet.close();

            preparedStatement.close();

        } catch (Exception e) {
            throw new Exception("操作异常！");
        } finally {
            linkDatabase.close();
        }

        return hibernateValue;
    }

    @Override
    public ArrayList queryAll() throws Exception {

        ArrayList<Hibernate> list = new ArrayList();

        String sql = "select * from hibernate";

        LinkDatabase linkDatabase = null;

        PreparedStatement preparedStatement = null;

        Hibernate hibernateValue = null;

        try {

            linkDatabase = new LinkDatabase();

            preparedStatement = linkDatabase.getConnection().prepareStatement(sql);

            //数据库更新操作
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hibernateValue = new Hibernate();
                hibernateValue.setUser_id(resultSet.getInt(1));
                hibernateValue.setUser_name(resultSet.getString(2));
                hibernateValue.setUser_password(resultSet.getString(3));
                list.add(hibernateValue);
            }

            resultSet.close();

            preparedStatement.close();

        } catch (Exception e) {
            throw new Exception("操作异常！");
        } finally {
            linkDatabase.close();
        }
        return list;
    }
}
