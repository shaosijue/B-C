package net.yasite.model;

import net.yasite.api.params.AddressParams;
import net.yasite.service.AddressService;
import android.content.Context;

public class AddressModel extends Model {

	AddressService addressService;

	public AddressModel(Context context) {
		this.context = context;
		addressService = new AddressService(context);
	}

	public Object addAddress(AddressParams ap, String token) {
		return addressService.addAddress(ap, token);
	}

	public Object getAddressList(String token, String user_id) {
		return addressService.getAddressList(token, user_id);
	}

	public Object getAddressInfo(String user_id, String address_id, String token) {
		return addressService.getAddressInfo(user_id, address_id, token);
	}

	public Object deleteAddress(String id, String token) {
		return addressService.deleteAddress(id, token);
	}
}
