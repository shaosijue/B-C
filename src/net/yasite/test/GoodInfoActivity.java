package net.yasite.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.CarItemEntity;
import net.yasite.entity.CarItemReEitity;
import net.yasite.entity.GoodEntity;
import net.yasite.entity.MyGoodEntity;
import net.yasite.model.CarModel;
import net.yasite.model.GoodModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class GoodInfoActivity extends BaseNewActivity {
	/**
	 * 商品详情
	 */
	ImageView thumb;
	TextView name;
	TextView market_price;
	TextView shop_price;
	String id;
	GoodModel goodModel;
	CarModel carModel;
	GoodEntity goodEntity;
	MyGoodEntity myGoodEntity;
	Button btn_buy, btn_car;
	CarItemReEitity carItemReEitity;

	@Override
	public void setupView() {
		thumb = getImageView(R.id.thumb);
		name = getTextView(R.id.name);
		market_price = getTextView(R.id.market_price);
		shop_price = getTextView(R.id.promote_price);
		btn_buy = getButton(R.id.button1);
		btn_car = getButton(R.id.button2);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.goods_info);
	}

	@Override
	public void setModel() {
		carModel = new CarModel(context);
		if (goodEntity.getGoods_name() != null) {
			name.setText(goodEntity.getGoods_name());
		} else {
			name.setText("");
		}
		if (goodEntity.getMarket_price() != null) {
			market_price.setText("市场价：" + goodEntity.getMarket_price());
		} else {
			market_price.setText("");
		}
		if (goodEntity.getShop_price() != null) {
			shop_price.setText("本店价：" + goodEntity.getShop_price());
		} else {
			shop_price.setText("");
		}
		ImageLoader.getInstance().displayImage(
				"http://www.yasite.net:80/ecshop/" + goodEntity.getGoods_img(),
				thumb);
		//加入购物车
		btn_car.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AddGoodHandler(context).execute();
				finish();
			}
		});
		//立即购买
		btn_buy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new BuyHandler(context).execute();
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		goodEntity = (GoodEntity) getIntent().getSerializableExtra("info");
		return true;
	}

	class AddGoodHandler extends HandlerHelp {

		public AddGoodHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
		}

		@Override
		public void doTask(Message msg) throws Exception {
			String token = new RegistModel(context).getToken();
			String user_id = new RegistModel(context).getSp("user_id");
			carItemReEitity = (CarItemReEitity) carModel.addGood(user_id, goodEntity.getGoods_id(),
					goodEntity.getGoods_sn(), goodEntity.getGoods_name(),
					goodEntity.getMarket_price(), goodEntity.getShop_price(),
					1 + "", token);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}
	
	class BuyHandler extends HandlerHelp {

		public BuyHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			Intent intent = new Intent(context,CheckOutActivity.class);
			List<CarItemEntity> list = new ArrayList<CarItemEntity>();
			list.add(carItemReEitity.getData());
			intent.putExtra("info", (Serializable)list);
			startActivity(intent);
			finish();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			String token = new RegistModel(context).getToken();
			String user_id = new RegistModel(context).getSp("user_id");
			carItemReEitity = (CarItemReEitity) carModel.addGood(user_id, goodEntity.getGoods_id(),
					goodEntity.getGoods_sn(), goodEntity.getGoods_name(),
					goodEntity.getMarket_price(), goodEntity.getShop_price(),
					1 + "", token);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}
}
