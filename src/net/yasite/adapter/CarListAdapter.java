package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;
import net.yasite.entity.CarItemEntity;
import net.yasite.test.R;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CarListAdapter extends YasiteAdapter {

	List<CarItemEntity> list = new ArrayList<CarItemEntity>();
	double sum;

	public CarListAdapter(Context context) {
		super(context);
		setImageLoader();
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
		myHolder.cb = (CheckBox) convertView.findViewById(R.id.cb_carlist_item);
		myHolder.image = (ImageView) convertView
				.findViewById(R.id.image_carlist_item);
		myHolder.tv_name = (TextView) convertView
				.findViewById(R.id.text_carlist_name);
		myHolder.tv_price = (TextView) convertView
				.findViewById(R.id.text_carlist_price);
		myHolder.tv_num = (TextView) convertView
				.findViewById(R.id.text_carlist_num);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, final int position,
			Object obj) {
		// TODO Auto-generated method stub
		MyHolder myHolder = (MyHolder) holder;
		CarItemEntity carItemEntity = (CarItemEntity) obj;
		if (!carItemEntity.getGoods_id().equals("0")) {
			myHolder.tv_name.setText(carItemEntity.getGoods_name());
			myHolder.tv_price.setText(carItemEntity.getGoods_price());
			myHolder.tv_num.setText(carItemEntity.getGoods_number());
			myHolder.cb
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							sum = 0;
							list.get(position).setChecked(isChecked);
							for (CarItemEntity item : list) {
								if (item.isChecked()) {
									sum += Double.parseDouble(item
											.getGoods_price())
											* Double.parseDouble(item
													.getGoods_number());
								}
							}
							Intent intent = new Intent("net.yasite.adapter.sum");
							intent.putExtra("sum", sum);
							context.sendBroadcast(intent);
						}
					});
			myHolder.cb.setChecked(list.get(position).isChecked());
		}
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MyHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.carlist_item;
	}

	class MyHolder extends ViewHolder {
		CheckBox cb;
		ImageView image;
		TextView tv_name, tv_price, tv_num;
	}

}
