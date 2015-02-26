package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.CategoryEntity;
import net.yasite.test.R;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class SecondListAdapter extends YasiteAdapter{

	List<CategoryEntity> list = new ArrayList<CategoryEntity>();
	
	public List<CategoryEntity> getList() {
		return list;
	}

	public void setList(List<CategoryEntity> list) {
		this.list = list;
	}

	public SecondListAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
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
		myHolder.tv = (TextView) convertView.findViewById(R.id.text_seconditem);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = (CategoryEntity) obj;
		MyHolder myHolder = (MyHolder) holder;
		myHolder.tv.setText(categoryEntity.getCat_name());
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MyHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.secondlist_item;
	}
	
	class MyHolder extends ViewHolder{
		private TextView tv;
	}

}
