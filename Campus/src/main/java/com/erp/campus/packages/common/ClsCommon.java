package com.erp.campus.packages.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class ClsCommon {
	
//	To Copy one Class values into another class
	
	public static void copyProperties(Object fromObj, Object toObj) {
	    Class<? extends Object> fromClass = fromObj.getClass();
	    Class<? extends Object> toClass = toObj.getClass();

	    try {
	        BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
	        BeanInfo toBean = Introspector.getBeanInfo(toClass);

	        PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
	        
	        List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());
	        System.out.println("\n List<PropertyDescriptor> has set");
	        
	        for (PropertyDescriptor propertyDescriptor : toPd) {
	            propertyDescriptor.getDisplayName();
	            System.out.println("in for-->>"+fromPd.get(fromPd.indexOf(propertyDescriptor)));
	            PropertyDescriptor pd = fromPd.get(fromPd
	                    .indexOf(propertyDescriptor));
	            if (pd.getDisplayName().equals(
	                    propertyDescriptor.getDisplayName())
	                    && !pd.getDisplayName().equals("class")) {
	               /*  if(propertyDescriptor.getWriteMethod() != null)                
	                         propertyDescriptor.getWriteMethod().invoke(toObj,pd.getReadMethod().invoke(fromObj, null));
	           */ }

	        }
	    } catch (IntrospectionException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } /*catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (InvocationTargetException e) {
	        e.printStackTrace();
	    }*/
	}
}
