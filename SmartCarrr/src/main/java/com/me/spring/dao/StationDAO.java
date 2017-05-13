package com.me.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.spring.exception.AdException;
import com.me.spring.pojo.Station;



public class StationDAO extends DAO{

	public Station get(int stationid) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Station where Station_ID = :stationid");
            q.setInteger("stationid",stationid);
            Station station=(Station)q.uniqueResult();
            commit();
            return station;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named station " + stationid + " " + e.getMessage());
        }
    }
	public List getList() throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Station");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the stations", e);
        }
    }
}
