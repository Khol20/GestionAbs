package ma.school.service;

import java.util.List;
import ma.school.beans.Absence;
import ma.school.dao.IDao;
import ma.school.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class AbsenceService implements IDao<Absence> {

    @Override
    public void create(Absence o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Absence o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Absence o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Absence> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List<Absence> abs = session.createQuery("from Absence").list();
        session.getTransaction().commit();
        session.close();
        return abs;

    }

    @Override
    public Absence findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Absence e = (Absence) session.get(Absence.class, id);
        session.getTransaction().commit();
        session.close();
        return e;
    }

    public List<Absence> findAbsencesByModuleAndStudent(String module, String etudiant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        String hql = "FROM Absence a WHERE a.etudiant = :etudiant AND a.module = :module";
        Query query = session.createQuery(hql);
        query.setParameter("etudiant", etudiant);
        query.setParameter("module", module);
        session.getTransaction().commit();
        session.close();
        return query.list();

    }
}
