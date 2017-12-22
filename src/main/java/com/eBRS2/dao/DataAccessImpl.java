package com.eBRS2.dao;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

import com.eBRS2.models.AddBusModel;
import com.eBRS2.models.RegModel;
import com.eBRS2.models.RoleModel;
import com.eBRS2.models.SearchModel;
import com.eBRS2.models.UserLog;
import com.eBRS2.models.printModel;

@Repository
public class DataAccessImpl implements DataAccess {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

		@Override
		public UserLog findUserInfo(String username) {
			UserLog ul = (UserLog) getSession().get(UserLog.class, username);
			return ul;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<String> getUserRoles(String username) {
			try {
				Query query = getSession().createNativeQuery("Select USER_ROLE from roles where USERNAME = ?");
				query.setParameter(1, username);
				return query.getResultList();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}

		@Override
		public void userSave(RegModel rm) {
			rm.setDatereg(dateNow());
			getSession().save(rm);
		}

		@Override
		public void addRole(String username) {
			RoleModel rm = new RoleModel();
			rm.setUsername(username);
			rm.setRole("CONFIRM");
			getSession().save(rm);
			
		}

		@Override
		public void saveBus(AddBusModel ab, Authentication authentication) {
			ab.setTxtg(getUserBrgy(authentication.getName()));
			ab.setTxth(String.valueOf(dateNow()));
			getSession().saveOrUpdate(ab);
		}

		@Override
		public Timestamp dateNow() {		
			@SuppressWarnings("deprecation")
			Timestamp query = (Timestamp) getSession().createSQLQuery("Select NOW()").setMaxResults(1).uniqueResult();
			return query;
		}

		@Override
		public String getUserBrgy(String username) {	
			Query query =  getSession().createNativeQuery("Select brgy from users where user_name = ?");
			query.setParameter(1, username);		
			return (String) query.getSingleResult();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<String> getBrgyList() {			
			try {
				return getSession().createNativeQuery("Select BRGY from brgy order by BRGY").list();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<SearchModel> getSearch(String category, String search, Authentication authentication) {		
			try {
				@SuppressWarnings("deprecation")
				Criteria criteria = getSession().createCriteria(SearchModel.class);
				criteria.add(Restrictions.like(category, "%" + search + "%"));
				criteria.add(Restrictions.eq("brgy", getUserBrgy(authentication.getName())));
				criteria.addOrder(Order.desc("busname"));
				return (List<SearchModel>) criteria.list();
			} catch (Exception e) {
				System.out.println(e);
				return null;
				
			}
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<SearchModel> getSearchAll(String category, String search) {
			
			try {
				@SuppressWarnings("deprecation")
				Criteria criteria = getSession().createCriteria(SearchModel.class);
				criteria.add(Restrictions.like(category, "%" + search + "%"));
				criteria.addOrder(Order.desc("bustype"));
				return (List<SearchModel>) criteria.list();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}

			
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<SearchModel> getPrintSearch(printModel pm) {
			try {
				@SuppressWarnings("deprecation")
				Criteria criteria = getSession().createCriteria(SearchModel.class);
				criteria.add(Restrictions.like(pm.getTxtcategory(), "%" + pm.getTxtsearch() + "%"));
				criteria.add(Restrictions.like("brgy", "%" + pm.getTxtbrgy() + "%"));
				criteria.add(Restrictions.between("BFROM", pm.getTxtfrom(), pm.getTxtto()));
				criteria.addOrder(Order.desc("busname"));
				return (List<SearchModel>) criteria.list();
			} catch (Exception e) {
				System.out.println(e);
				return null;
				
			}
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<SearchModel> getPrintSearchOne(printModel pm) {
			try {
				@SuppressWarnings("deprecation")
				Criteria criteria = getSession().createCriteria(SearchModel.class);
				criteria.add(Restrictions.like(pm.getTxtcategory(), "%" + pm.getTxtsearch() + "%"));
				criteria.add(Restrictions.eq("brgy", pm.getTxtbrgy()));
				criteria.add(Restrictions.between("BFROM", pm.getTxtfrom(), pm.getTxtto()));
				criteria.addOrder(Order.desc("busname"));
				return (List<SearchModel>) criteria.list();
			} catch (Exception e) {
				System.out.println(e);
				return null;
				
			}
		}


}
