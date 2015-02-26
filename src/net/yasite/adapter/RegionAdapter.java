package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.RegionEntity;
import net.yasite.test.R;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class RegionAdapter extends YasiteAdapter {

	List<RegionEntity> list = new ArrayList<RegionEntity>();
	
	public RegionAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public List<RegionEntity> getList() {
		return list;
	}

	public void setList(List<RegionEntity> list) {
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
		myHolder.tv = (TextView) convertView.findViewById(R.id.text_item_region);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		MyHolder myHolder = (MyHolder) holder;
		RegionEntity regionEntity = (RegionEntity) obj;
		myHolder.tv.setText(regionEntity.getRegion_name());
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MyHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.region_item;
	}
	
	class MyHolder extends ViewHolder{
		TextView tv;
	}

}
