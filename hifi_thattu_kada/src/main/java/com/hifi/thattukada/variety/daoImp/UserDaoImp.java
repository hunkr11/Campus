package com.hifi.thattukada.variety.daoImp;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hifi.thattukada.variety.dao.UserDao;
import com.hifi.thattukada.variety.entity.UserEntity;
import com.hifi.thattukada.variety.pojo.UserDetailsPojo;
import com.hifi.thattukada.variety.vo.UserVO;


@Repository
public class UserDaoImp implements UserDao{

	/*@Autowired
	private HibernateTemplate  hibernateTemplate;*/
	
	@Autowired
    private SessionFactory sessionFactory;

	 /* public UserDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	   private Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }*/
    
	public UserDaoImp() {
		// TODO Auto-generated constructor stub
	}

	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional	
	public List<UserEntity> userList() {
		
		System.out.println("INSIDE userList USERDAO IMP");
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		 List<UserEntity> listUser = sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
		/* if (listUser.size()>0){
			 
			 for(int i = 0;i<listUser.size();i++){
				 System.out.println("list UserDao IMP-->>>"+listUser[i]<UserEntity>);
			 }
			 
		 }*/
		return listUser;
	}
	
	@Override
	@Transactional	
	public boolean userLogin(UserVO userVo){
		System.out.println("\n\n INSIDE userLogin DAO IMP \n\n");
		boolean userFlag = false;
		System.out.println("VO user Name-->>"+userVo.getUser_name()+"\n VO PASS -->  " + userVo.getUser_password());
	/*	
		from User where username=?")
		.setParameter(0, username)
		.list(); */
		
		String hql = "from UserEntity where uvc_email = ?  and vc_passwd = ? ";
		
		List<UserEntity> query = this.sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,userVo.getUser_name()).setParameter(1, userVo.getUser_password()).list();
		
		System.out.println("\n\n usr_query-->>"+query);
		
		if (query.size() > 0) {
			userFlag = true;
		} 
		
		System.out.println("\n \n userLogin RETURN--->>> "+userFlag);
		return userFlag;
	}
	
	@Override
	@Transactional
	public String userRegister(UserVO userVo,UserEntity userPojo){
		System.out.println("\n\n INSIDE userLogin DAO IMP \n\n");
		String userMessage = null;
		System.out.println("VO user Name-->>"+userVo.getUser_name()+"\n EMAIL -->  " + userVo.getUser_email());
		
		String hql = "from UserEntity where uvc_email = ? "/* + userVo.getUser_name()  +" and usr_passwd = "+userVo.getUser_password() */;
		
		List<UserEntity> query = this.sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,userVo.getUser_email()).list();
		System.out.println("\n\n usr_query-->>"+query);
		
		if (query.size() > 0) {
			userMessage = "USER ALREADY EXIST";
		} 
		else{
		//	UserEntity userEntity= new UserEntity();
		//	copyProperties(userVo, userEntity);
			System.out.println("\n\n ---INSIDE ELSE, CREATING USER--- \n\n");
			sessionFactory.getCurrentSession().save(userPojo);			
			
			
			userMessage = "USER CREATED" ;
		}
		
		return userMessage;
	}

	// not using now, but ll be useful for copy one 
	public static void copyProperties(Object fromObj, Object toObj) {
	    Class<? extends Object> fromClass = fromObj.getClass();
	    Class<? extends Object> toClass = toObj.getClass();

	    try {
	        BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
	        BeanInfo toBean = Introspector.getBeanInfo(toClass);

	        PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
	        List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());

	        for (PropertyDescriptor propertyDescriptor : toPd) {
	            propertyDescriptor.getDisplayName();
	            PropertyDescriptor pd = fromPd.get(fromPd
	                    .indexOf(propertyDescriptor));
	            if (pd.getDisplayName().equals(
	                    propertyDescriptor.getDisplayName())
	                    && !pd.getDisplayName().equals("class")) {
	                 if(propertyDescriptor.getWriteMethod() != null)                
	                         propertyDescriptor.getWriteMethod().invoke(toObj,pd.getReadMethod().invoke(fromObj, null));
	            }

	        }
	    } catch (IntrospectionException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (InvocationTargetException e) {
	        e.printStackTrace();
	    }
	}

}
