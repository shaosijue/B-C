package net.yasite.test;

import net.yasite.adapter.SecondListAdapter;
import net.yasite.entity.CategoryListEntity;
import net.yasite.model.GoodsCategoryModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SecondListActivity extends BaseNewActivity {
	/**
	 * 二级菜单
	 */
	GoodsCategoryModel goodsCategoryModel;
	ListView listview;
	CategoryListEntity categoryListEntity;
	SecondListAdapter adapter;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listview = getListView(R.id.listview_second);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_secondlist);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		new GoodsCategoryHandler(context).execute();
		adapter = new SecondListAdapter(context);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, ThirdListActivity.class);
				intent.putExtra("info",
						categoryListEntity.getData().get(position).getCat_id());
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class GoodsCategoryHandler extends HandlerHelp {

		public GoodsCategoryHandler(Context context) {
			super(context);
			goodsCategoryModel = new GoodsCategoryModel(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			if (categoryListEntity.getRes() == 1) {
				adapter.setList(categoryListEntity.getData());
				adapter.notifyDataSetChanged();
			} else {
				ActivityUtil.showToast(context, "sorry");
			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
			categoryListEntity = (CategoryListEntity) goodsCategoryModel
					.RequestPost(0 + "");
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}

	}

}
