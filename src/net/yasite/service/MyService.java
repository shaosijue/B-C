package net.yasite.service;

import java.util.List;

import net.yasite.api.BaseAPI;
import net.yasite.api.MyApi;
import net.yasite.api.params.Params;
import android.content.Context;

public class MyService extends BaseService {

	public MyService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public List<Params> getMy(){
		BaseAPI myapi = new MyApi(context);
		try {
			if(myapi.doGet()){
				return (List<Params>) myapi.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
