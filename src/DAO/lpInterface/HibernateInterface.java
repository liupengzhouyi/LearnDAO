package DAO.lpInterface;

import DAO.valueObject.Hibernate;

import java.util.List;

public interface HibernateInterface {

    //增
    public void insert(Hibernate hibernate) throws Exception;


    //删
    public void delete(Hibernate hibernate) throws Exception;


    //改
    public void update(Hibernate hibernate) throws Exception;


    //查
    public Hibernate queryById(int userid) throws Exception;

    //获取所有
    public List queryAll() throws Exception;
}
