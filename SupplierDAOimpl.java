package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOimpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Supplier supplier)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
Session session=sessionFactory.getCurrentSession();
session.saveOrUpdate(supplier);
	}

	@Transactional
	 public void delete(String id){
		 Supplier supplierToDelete=new Supplier();
		 supplierToDelete.setID(id);
		 sessionFactory.getCurrentSession().delete(supplierToDelete);
	 }
	@Transactional
	public Supplier get(String id){
	String hql="From Supplier where id="+"*"+id+"*";
	Query query=(Query)sessionFactory.getCurrentSession().createQuery(hql);
	List<Supplier>listSupplier=(List<Supplier>)query.list();
	if(listSupplier!=null&&!listSupplier.isEmpty())
	{
		return listSupplier.get(0);
	}
	return null;
	}
	@Transactional
	public List<Supplier>list(){
		@SuppressWarnings("unchecked")
		List<Supplier> ListSupplier=(List<Supplier>)
		sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return ListSupplier;
	}

	public com.niit.shoppingcart.model.Supplier get() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveorUpdate(com.niit.shoppingcart.model.Supplier Supplier) {
		// TODO Auto-generated method stub
		
	}
}