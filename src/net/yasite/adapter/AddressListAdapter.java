package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.AddressEntity;
import net.yasite.test.R;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class AddressListAdapter extends YasiteAdapter {

	List<AddressEntity> list = new ArrayList<AddressEntity>();

	public AddressListAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public List<AddressEntity> getList() {
		return list;
	}

	public void setList(List<AddressEntity> list) {
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
		myHolder.tv_name = (TextView) convertView.findViewById(R.id.text_name_item_addresslit);
		myHolder.tv_tel = (TextView) convertView.findViewById(R.id.text_tel_item_addresslit);
		myHolder.tv_address = (TextView) convertView.findViewById(R.id.text_address_item_addresslit);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		MyHolder myHolder = (MyHolder) holder;
		AddressEntity addressEntity = (AddressEntity) obj;
		myHolder.tv_name.setText("姓名："+addressEntity.getConsignee());
		myHolder.tv_tel.setText("联系电话："+addressEntity.getTel());
		myHolder.tv_address.setText("详细地址："+addressEntity.getAddress());
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MyHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.addresslist_item;
	}
	
	class MyHolder extends ViewHolder{
		TextView tv_name,tv_tel,tv_address;
	}

}
