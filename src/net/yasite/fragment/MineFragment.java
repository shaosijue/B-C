package net.yasite.fragment;

import net.yasite.model.LoginModel;
import net.yasite.test.LoginActivity;
import net.yasite.test.OrderListActivity;
import net.yasite.test.R;
import net.yasite.test.SettingActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MineFragment extends Fragment {
	/**
	 * 个人页面
	 */
	boolean flag = false;
	TextView name;
	ImageView user_icon;
	Button btn_mine, btn_exit;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_mine, null);
		String token = new LoginModel(getActivity()).getToken();
		// Log.e("`````", token + "```");
		if (!token.equals("")) {
			flag = true;
		}
		RelativeLayout order = (RelativeLayout) view
				.findViewById(R.id.mine_order);
		RelativeLayout setting = (RelativeLayout) view
				.findViewById(R.id.mine_setting);
		name = (TextView) view.findViewById(R.id.text_minename);
		user_icon = (ImageView) view.findViewById(R.id.image_userIcon);
		btn_mine = (Button) view.findViewById(R.id.btn_mine);
		btn_exit = (Button) view.findViewById(R.id.btn_exit);
		if (flag) {
			name.setVisibility(View.VISIBLE);
			user_icon.setVisibility(View.VISIBLE);
			name.setText("你好："
					+ new LoginModel(getActivity()).getSp("user_name"));
			btn_mine.setVisibility(View.GONE);
			btn_exit.setVisibility(View.VISIBLE);
		}
		btn_mine.setOnClickListener(listener);
		order.setOnClickListener(listener);
		setting.setOnClickListener(listener);
		btn_exit.setOnClickListener(listener);
		return view;
	}

	OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.mine_order:
				Toast.makeText(getActivity(), "order", 0).show();
				Intent intent2 = new Intent(getActivity(),OrderListActivity.class);
				startActivity(intent2);
				break;
			case R.id.mine_setting:
				Toast.makeText(getActivity(), "setting", 0).show();
				Intent intent = new Intent(getActivity(), SettingActivity.class);
				startActivity(intent);
				break;
			case R.id.btn_mine:
				Intent intent1 = new Intent(getActivity(), LoginActivity.class);
				startActivityForResult(intent1, 1);
			case R.id.btn_exit:
				Toast.makeText(getActivity(), "exit", 0).show();
				new LoginModel(getActivity()).clearSp();
				name.setVisibility(View.GONE);
				user_icon.setVisibility(View.GONE);
				btn_exit.setVisibility(View.GONE);
				btn_mine.setVisibility(View.VISIBLE);
			default:
				break;
			}
		}
	};

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && resultCode == 1) {
			name.setVisibility(View.VISIBLE);
			user_icon.setVisibility(View.VISIBLE);
			name.setText("你好："
					+ new LoginModel(getActivity()).getSp("user_name"));
			btn_mine.setVisibility(View.GONE);
			btn_exit.setVisibility(View.VISIBLE);
		}
	};
}
