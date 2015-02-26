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

public class ThirdListActivity extends BaseNewActivity {
	/**
	 * 三级菜单
	 */
	GoodsCategoryModel goodsCategoryModel;
	ListView listview;
	CategoryListEntity categoryListEntity;
	SecondListAdapter adapter;
	//分类id
	String cat_id;

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
//				ActivityUtil.showToast(context, "等待按类型查询接口开放");
				Intent intent = new Intent(context,GoodListActivity.class);
				intent.putExtra("info", categoryListEntity.getData().get(position).getCat_id()+"");
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		cat_id = getIntent().getStringExtra("info");
		if (cat_id != null && !cat_id.equals("")) {
			return true;
		} else {
			ActivityUtil.showToast(context, "未找到商品");
			return false;
		}
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
					.RequestPost(cat_id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}

	}

}
