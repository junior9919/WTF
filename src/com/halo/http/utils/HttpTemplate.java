package com.halo.http.utils;

import java.io.File;
import java.util.Map;

import com.halo.json.utils.JSONUtils;

public interface HttpTemplate {

	public String get(String url, Map<String, String> args) throws HttpUtilsException;

	public File download(String url, Map<String, String> args) throws HttpUtilsException;

	public String post(String url, Map<String, String> args, String requestBody, String contentType)
			throws HttpUtilsException;

	public <P, R> R jsonPost(String url, Map<String, String> args, JSONUtils<P> postJsonUtils, P postJsonBean,
			JSONUtils<R> resultJsonUtils) throws HttpUtilsException;

	public File downloadUsePost(String url, Map<String, String> args, String requestBody, String contentType)
			throws HttpUtilsException;

}
