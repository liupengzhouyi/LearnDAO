package DAO.test.DAOFactory;

import DAO.factory.DAOFactory.HibernateDAOFactory;
import DAO.lpImplements.ImplementsHibernate;
import DAO.valueObject.Hibernate;

public class TestDAOFactory {

    public static void main(String[] args) throws Exception {



        ImplementsHibernate implementsHibernate = HibernateDAOFactory.getImplementsHibernate();

        Hibernate hibernate = new Hibernate();
        hibernate.setUser_id(667);
        hibernate.setUser_name("test_02");
        hibernate.setUser_password("1234567");

        implementsHibernate.insert(hibernate);

    }
}
