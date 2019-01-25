package DAO.test.DAOImplements;

import DAO.lpImplements.ImplementsHibernate;
import DAO.valueObject.Hibernate;

public class TestDAOImplements {

    public static void main(String[] args) throws Exception {
        ImplementsHibernate implementsHibernate = new ImplementsHibernate();

        Hibernate hibernate = new Hibernate();
        hibernate.setUser_id(666);
        hibernate.setUser_name("test_01");
        hibernate.setUser_password("123456");

        implementsHibernate.insert(hibernate);
    }
}
