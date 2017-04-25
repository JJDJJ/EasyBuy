package com.zjj.IDAO;

import java.util.WeakHashMap;

import com.zjj.DAOimpl.GoodsDaoImpl;

@SuppressWarnings("rawtypes")
public final class DaoFactory {
	private final static WeakHashMap<String, ICommonDao> map = new WeakHashMap<String, ICommonDao>();
	
	public static ICommonDao getDao(String name){
		ICommonDao dao = map.get(name);
		if(dao !=null)
			return dao;
		return createDao(name);
		
	}

	private synchronized static ICommonDao createDao(String name) {
		ICommonDao dao = null;
		if("Goods".equals(name)){
			dao = new GoodsDaoImpl();
			map.put(name, dao);
		}
		return dao;
	}
}
