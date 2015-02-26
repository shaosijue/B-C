package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.api.params.Params;
import net.yasite.test.R;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends YasiteAdapter {

	List<Params> list = new ArrayList<Params>();

	public MyAdapter(Context context) {
		super(context);
		setImageLoader();
	}
	
	public MyAdapter(Context context, List<Params> list) {
		super(context);
		this.list = list;
	}

	public List<Params> getList() {
		return list;
	}

	public void setList(List<Params> list) {
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
		TestHolder test = (TestHolder) holder;
		test.imageview = (ImageView) convertView.findViewById(R.id.thumb);
		test.tv1 = (TextView) convertView.findViewById(R.id.name);
		test.tv2 = (TextView) convertView.findViewById(R.id.market_price);
		test.tv3 = (TextView) convertView.findViewById(R.id.promote_price);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
			Params p = (Params) obj;
			TestHolder test = (TestHolder) holder;
			test.tv1.setText(p.getAuthor_username());
			test.tv2.setText(p.getContent());
			test.tv3.setText(p.getCreated_at());
	}

	@Override
	protected TestHolder setHolder() {
		// TODO Auto-generated method stub
		return new TestHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.goods_item;
	}

	class TestHolder extends ViewHolder {
		@SuppressWarnings("unused")
		private ImageView imageview;
		private TextView tv1, tv2, tv3;
	}

}
