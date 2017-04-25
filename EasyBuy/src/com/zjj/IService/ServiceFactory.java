package com.zjj.IService;

import java.util.WeakHashMap;

import com.zjj.Serviceimpl.GoodsServiceImpl;

@SuppressWarnings("rawtypes")
public final class ServiceFactory {
	private final static WeakHashMap<String, ICommonService> map = new WeakHashMap<String, ICommonService>();
	
	public static ICommonService getService(String name){
		ICommonService Service = map.get(name);
		if(Service !=null)
			return Service;
		return createService(name);
		
	}

	private synchronized static ICommonService createService(String name) {
		ICommonService service = null;
		if("Goods".equals(name)){
			service = new GoodsServiceImpl();
			map.put(name, service);
		}
		return service;
	}
}
