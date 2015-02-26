package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;
import net.yasite.entity.OrderEntity;
import net.yasite.model.OrderModel;
import net.yasite.test.R;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderListAdapter extends YasiteAdapter {

	List<OrderEntity> list = new ArrayList<OrderEntity>();

	public OrderListAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public List<OrderEntity> getList() {
		return list;
	}

	public void setList(List<OrderEntity> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	protected void setupChildViews(View convertView, ViewHolder holder) {
		// TODO Auto-generated method stub
		OrderListHolder listHolder = (OrderListHolder) holder;
		listHolder.text_name = (TextView) convertView
				.findViewById(R.id.text_name_orderlist_item);
		listHolder.text_price = (TextView) convertView
				.findViewById(R.id.text_price_orderlist_item);
		listHolder.btn_cancel = (Button) convertView
				.findViewById(R.id.btn_cancel_orderlist_item);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		final OrderListHolder listHolder = (OrderListHolder) holder;
		final OrderEntity orderEntity = (OrderEntity) obj;
		String statue = orderEntity.getOrder_status();
		if (statue.equals("0")) {
			listHolder.text_name.setText("订单状态：待付款");
		} else {
			listHolder.text_name.setText("订单状态：已取消");
			listHolder.btn_cancel.setVisibility(View.GONE);
		}
		listHolder.text_price.setText(orderEntity.getOrder_amount());
		listHolder.btn_cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread() {
					@Override
					public void run() {
						new OrderModel(context).cancelOrder(orderEntity
								.getOrder_id());
					}
				}.start();
				listHolder.btn_cancel.setVisibility(View.GONE);
				notifyDataSetChanged();
			}
		});
//		Handler handler = new Handler() {
//			public void handleMessage(android.os.Message msg) {
//				if (msg.what == 1) {
//					listHolder.btn_cancel.setVisibility(View.GONE);
//					notifyDataSetChanged();
//				}
//			};
//		};
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new OrderListHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.orderlist_item;
	}

	class OrderListHolder extends ViewHolder {
		TextView text_name, text_price;
		Button btn_cancel;
	}

}
