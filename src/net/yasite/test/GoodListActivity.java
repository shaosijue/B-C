package net.yasite.test;

import net.yasite.adapter.GoodsListAdapter;
import net.yasite.entity.GoodListEntity;
import net.yasite.model.GoodModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import net.yasite.view.XListView;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;

public class GoodListActivity extends BaseNewActivity {

	/**
	 * 商品列表
	 */
	XListView listview;
	GoodsListAdapter adapter;
	String id;
	GoodModel goodModel;
	GoodListEntity goodList;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listview = (XListView) findViewById(R.id.list_view);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		new MyHandler(context).execute();
		adapter = new GoodsListAdapter(context);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				ActivityUtil.showToast(context, position + "`````");
				Intent intent = new Intent(context, GoodInfoActivity.class);
				// intent.putExtra("info",
				// goodList.getData().get(position-1).getGoods_id()+"");
				intent.putExtra("info", goodList.getData().get(position - 1));
				// Log.e("``````",
				// goodList.getData().get(position-1).getGoods_id()+"");
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		id = getIntent().getStringExtra("info");
		if (id != null && !id.equals("")) {
			return true;
		} else {
			ActivityUtil.showToast(context, "没有相应的商品");
			return false;
		}
	}

	class MyHandler extends HandlerHelp {
		public MyHandler(Context context) {
			super(context);
			goodModel = new GoodModel(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(goodList.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			goodList = goodModel.RequestGoodList(1 + "", id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}

	}

}
