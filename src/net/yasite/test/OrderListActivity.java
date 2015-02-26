package net.yasite.test;

import net.yasite.adapter.OrderListAdapter;
import net.yasite.entity.OrderListEntity;
import net.yasite.model.OrderModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.os.Message;
import android.widget.ListView;

public class OrderListActivity extends BaseNewActivity {
	/**
	 * 订单列表
	 */
	ListView listView;
	OrderModel orderModel;
	OrderListEntity orderListEntity;
	OrderListAdapter adapter;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listView = getListView(R.id.listView_orderlist);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_orderlist);
	}

	@Override
	public void setModel() {
		orderModel = new OrderModel(context);
		new OrderListHandler(context).execute();
		adapter = new OrderListAdapter(context);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class OrderListHandler extends HandlerHelp {

		public OrderListHandler(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(orderListEntity.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String id = new RegistModel(context).getSp("user_id");
			orderListEntity = (OrderListEntity) orderModel.getOrderList(id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}
}
