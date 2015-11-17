package com.halo.json.utils;

import java.util.Map;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T getComplexJsonBean(String jsonStr, Map<String, Class> classMap) {
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		return (T) JSONObject.toBean(jsonObj, this.clazz, classMap);
	}

	public String getJsonStr(T jsonBean) {
		JSONObject jsonObj = JSONObject.fromObject(jsonBean);
		return jsonObj.toString();
	}
}
