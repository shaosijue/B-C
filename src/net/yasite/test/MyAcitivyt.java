package net.yasite.test;

import java.util.List;

import net.yasite.adapter.MyAdapter;
import net.yasite.api.params.Params;
import net.yasite.model.MyModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.os.Message;
import android.widget.ListView;

public class MyAcitivyt extends BaseNewActivity {
	
	MyModel mymodel;
	List<Params> list;
	ListView listview;
	MyAdapter adapter;
	@Override
	public void setupView() {
		listview = getListView(R.id.listv);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.myactivity);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		new MyHandler(context).execute();
		adapter = new MyAdapter(context);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	
	class MyHandler extends HandlerHelp{

		public MyHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			mymodel = new MyModel(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(list);
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			list = mymodel.getMy();
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}

}
