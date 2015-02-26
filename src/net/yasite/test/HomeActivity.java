package net.yasite.test;

import net.yasite.fragment.ListFragment;
import net.yasite.fragment.MineFragment;
import net.yasite.model.GoodsCategoryModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeActivity extends BaseNewActivity {
	/**
	 * 主界面
	 */
	ImageView img_home, img_list, img_mine, img_car;
	GoodsCategoryModel goodsCategoryModel;
	FragmentManager fm;
	FragmentTransaction ft;
	RelativeLayout relative_jiadian, relative_fuzhuang, relative_meishi,
			relative_hufa;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		img_home = getImageView(R.id.img_home);
		img_list = getImageView(R.id.img_list);
		img_mine = getImageView(R.id.img_mine);
		img_car = getImageView(R.id.img_car);
		fm = getSupportFragmentManager();
		relative_jiadian = getRelativeLayout(R.id.relative1);
		relative_fuzhuang = getRelativeLayout(R.id.relative2);
		relative_meishi = getRelativeLayout(R.id.relative3);
		relative_hufa = getRelativeLayout(R.id.relative4);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_home);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		goodsCategoryModel = new GoodsCategoryModel(context);
		img_home.setOnClickListener(listener);
		img_list.setOnClickListener(listener);
		img_mine.setOnClickListener(listener);
		img_car.setOnClickListener(listener);
	}

	OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.img_home:
				ActivityUtil.showToast(context, "img_home");
				// new GoodsCategoryHandler(context).execute();
				break;
			case R.id.img_list:
				ActivityUtil.showToast(context, "img_list");
				ft = fm.beginTransaction();
				ft.replace(android.R.id.content, new ListFragment());
				ft.commit();
				break;
			case R.id.img_mine:
				ActivityUtil.showToast(context, "img_mine");
				// Intent intent = new Intent(context,LoginActivity.class);
				// startActivity(intent);
				ft = fm.beginTransaction();
				ft.replace(android.R.id.content, new MineFragment());
				ft.commit();
				break;
			case R.id.img_car:
				ActivityUtil.showToast(context, "car");
				Intent intent = new Intent(context, CarActivity.class);
				startActivity(intent);
				break;
			case R.id.relative1:
				ActivityUtil.showToast(context, "relative1");
				break;
			default:
				break;
			}
		}
	};

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class GoodsCategoryHandler extends HandlerHelp {

		public GoodsCategoryHandler(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub

		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			// goodsCategoryModel.RequestPost(0+"");
			// goodsCategoryModel.RequestPost(1+"");
			// goodsCategoryModel.RequestPost(2+"");
			// goodsCategoryModel.RequestPost(7+"");
			// goodsCategoryModel.RequestPost(8+"");
			// goodsCategoryModel.RequestPost(9+"");
			// goodsCategoryModel.RequestPost(11+"");
			// goodsCategoryModel.RequestPost(12+"");
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}

	}

}
