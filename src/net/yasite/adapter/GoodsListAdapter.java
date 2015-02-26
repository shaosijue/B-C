package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.GoodEntity;
import net.yasite.test.R;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodsListAdapter extends YasiteAdapter {

	List<GoodEntity> list = new ArrayList<GoodEntity>();

	public GoodsListAdapter(Context context) {
		super(context);
		setImageLoader();
	}

	public List<GoodEntity> getList() {
		return list;
	}

	public void setList(List<GoodEntity> list) {
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
		myHolder.thumb = (ImageView) convertView.findViewById(R.id.thumb);
		myHolder.name = (TextView)convertView.findViewById(R.id.name);
		myHolder.market_price = (TextView)convertView.findViewById(R.id.market_price);
		myHolder.promote_price = (TextView)convertView.findViewById(R.id.promote_price);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		MyHolder myHolder = (MyHolder) holder;
		GoodEntity goodEntity = (GoodEntity) obj;
		myHolder.name.setText(goodEntity.getGoods_name());
		myHolder.market_price.setText("市场价：" + goodEntity.getMarket_price());
		myHolder.promote_price.setText("本店价：" + goodEntity.getShop_price());
		mImageLoader.displayImage("http://www.yasite.net:80/ecshop/" + goodEntity.getGoods_thumb(),
				myHolder.thumb, options);
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MyHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.goods_item;
	}

	class MyHolder extends ViewHolder {
		private TextView name;
		private TextView market_price;
		private TextView promote_price;
		private ImageView thumb;
	}

}
