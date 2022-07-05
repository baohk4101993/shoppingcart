package com.hkb.global;

import java.util.ArrayList;
import java.util.List;

import com.hkb.model.Product;

public class GlobalData {

	public static List<Product> cart;
	static {
		cart = new ArrayList<>();
	}
	
}
