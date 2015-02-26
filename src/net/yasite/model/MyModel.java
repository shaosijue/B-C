package net.yasite.model;

import java.util.List;

import net.yasite.api.params.Params;
import net.yasite.service.MyService;
import android.content.Context;

public class MyModel extends Model {

	private MyService myService;
	
	public MyModel(Context context){
		this.context = context;
		myService = new MyService(context);
	}
	
	public List<Params> getMy(){
		return myService.getMy();
	}
}
