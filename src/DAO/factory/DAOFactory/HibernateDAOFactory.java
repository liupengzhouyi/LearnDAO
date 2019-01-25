package DAO.factory.DAOFactory;

import DAO.lpImplements.ImplementsHibernate;

public class HibernateDAOFactory {

    public static ImplementsHibernate getImplementsHibernate() {
        return new ImplementsHibernate();
    }

}
