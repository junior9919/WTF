package com.halo.json.utils;

import net.sf.json.JSONObject;

public class JSONUtils<T> {

	private Class<T> clazz;

	public JSONUtils(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public T getJsonBean(String jsonStr) {
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		return (T) JSONObject.toBean(jsonObj, this.clazz);
	}

	public String getJsonStr(T jsonBean) {
		JSONObject jsonObj = JSONObject.fromObject(jsonBean);
		return jsonObj.toString();
	}
}
