package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.CarItemEntity;
import net.yasite.test.R;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckOutAdapter extends YasiteAdapter {

	List<CarItemEntity> list = new ArrayList<CarItemEntity>();

	public CheckOutAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public List<CarItemEntity> getList() {
		return list;
	}

	public void setList(List<CarItemEntity> list) {
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
		MyHolder myHolder = (MyHolder) holder;
		myHolder.image = (ImageView) convertView
				.findViewById(R.id.image_checkout_item);
		myHolder.tv_name = (TextView) convertView
				.findViewById(R.id.text_checkou_name);
		myHolder.tv_aprice = (TextView) convertView
				.findViewById(R.id.text_aprice);
		myHolder.tv_prices = (TextView) convertView
				.findViewById(R.id.text_prices);
		myHolder.tv_num = (TextView) convertView
				.findViewById(R.id.text_checkout_num);
		myHolder.btn_reduce = (Button) convertView.findViewById(R.id.reduce);
		myHolder.btn_plus = (Button) convertView.findViewById(R.id.plus);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		MyHolder myHolder = (MyHolder) holder;
		final CarItemEntity carItemEntity = (CarItemEntity) obj;
		myHolder.tv_name.setText(carItemEntity.getGoods_name());
		myHolder.tv_aprice.setText(carItemEntity.getGoods_price());
		myHolder.tv_prices.setText(Double.parseDouble(carItemEntity
				.getGoods_price())
				* Double.parseDouble(carItemEntity.getGoods_number()) + "");
		myHolder.tv_num.setText(carItemEntity.getGoods_number());
		myHolder.btn_plus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int num = Integer.parseInt(carItemEntity.getGoods_number()) + 1;
				carItemEntity.setGoods_number(num + "");
				notifyDataSetChanged();
			}
		});
		myHolder.btn_reduce.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int num = Integer.parseInt(carItemEntity.getGoods_number());
				if (num > 1) {
					num = num - 1;
				}
				carItemEntity.setGoods_number(num + "");
				notifyDataSetChanged();
			}
		});
		double sum = 0;
		for (CarItemEntity c : list) {
			sum += Double.parseDouble(c.getGoods_price())
					* Double.parseDouble(c.getGoods_number());
		}
		Intent intent = new Intent("net.yasite.adapter.checkoutsum");
		intent.putExtra("sum", sum);
		context.sendBroadcast(intent);
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MyHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.ckeckout_item;
	}

	class MyHolder extends ViewHolder {
		ImageView image;
		TextView tv_name, tv_aprice, tv_prices, tv_num;
		Button btn_plus, btn_reduce;
	}

}
