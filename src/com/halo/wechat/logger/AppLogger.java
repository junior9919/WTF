/**
 * 
 */
package com.halo.wechat.logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * @author zWX298166
 *
 */
public class AppLogger {

	private Logger logger = LogManager.getLogger(AppLogger.class.getName());

	private String[] getObjectFields(Object obj) {
		String colNames = "";
		String colValues = "";
		for (Method method : obj.getClass().getMethods()) {
			if (method.getName().substring(0, 3).equals("get")) {
				String fieldName = method.getName().substring(3, method.getName().length());
				Object fieldValue = null;
				try {
					fieldValue = method.invoke(obj);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					logger.error(e.getMessage());
				}
				colNames += fieldName + "|";
				if (null == fieldValue) {
					colValues += "null|";
				} else {
					colValues += fieldValue.toString() + "|";
				}
			}
		}

		String[] cols = new String[] { colNames.substring(0, colNames.length() - 1), colValues.substring(0, colValues.length() - 1) };
		return cols;
	}

	public Logger getLogger() {
		return this.logger;
	}

	public void beforeMethod(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String params = "";
		for (Object arg : args) {
			if (null != arg) {
				params += arg.toString() + ", ";
			} else {
				params += "null, ";
			}
		}
		params = (params.length() >= 2) ? params.substring(0, params.length() - 2) : "";

		logger.debug("Start " + jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName() + "(" + params + ")");
	}

	public void afterMethod(JoinPoint jp) {
		logger.debug("End " + jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName() + "()");
	}

	public void afterThrowing(Throwable e) {
		logger.error(e.getMessage(), e);
	}

	public void logBeforeHandleRequest(JoinPoint jp) {
		beforeMethod(jp);

		Object[] args = jp.getArgs();
		HttpServletRequest request = (HttpServletRequest) args[0];

		String host = request.getRemoteHost();
		logger.info("Request from " + host);
	}

	public void logAfterHandleRequest(JoinPoint jp) {
		afterMethod(jp);
		logger.info("Request handled.");
	}

	public void logBeforeServiceCheckSignature(JoinPoint jp) {
		beforeMethod(jp);
		logger.info("A get method from server, going to check signature.");
	}

	public void logBeforeServiceProcessMessage(JoinPoint jp) {
		beforeMethod(jp);
		logger.info("A post method from server, going to process message.");
	}

	public void logBeforeDomTemplateGet(JoinPoint jp) {
		Object[] args = jp.getArgs();
		@SuppressWarnings("rawtypes")
		Class clazz = ((null == args[0]) ? Object.class : (Class) args[0]);
		String xmlContent = ((null == args[1]) ? "null" : args[1].toString());

		logger.debug("Start " + jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName() + "(" + clazz.getName() + ", " + xmlContent + ")");
	}

	public void logBeforeCommandProcess(JoinPoint jp) {
		beforeMethod(jp);

		Object[] args = jp.getArgs();
		if (args.length > 0 && null != args[0]) {
			String[] cols = getObjectFields(args[0]);
			if (null != cols && cols.length > 1) {
				logger.info(cols[0]);
				logger.info(cols[1]);
			}
		}
	}

	public void logBeforeSignatureEncode(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String params = "";
		for (Object arg : args) {
			if (null != arg) {
				params += arg.toString() + "|";
			} else {
				params += "null|";
			}
		}
		params = (params.length() >= 1) ? params.substring(0, params.length() - 1) : "";

		logger.debug("Check parameters: " + params);
	}

	public void logBeforeSignatureCompare(JoinPoint jp) {
		Object[] args = jp.getArgs();
		if (args.length >= 3) {
			String orginSignature = (null == args[0]) ? "null" : args[0].toString();
			String compareToSignature = (null == args[1]) ? "null" : args[1].toString();
			String echoStr = (null == args[2]) ? "null" : args[2].toString();
			logger.debug("Compare parameters: " + orginSignature + "|" + compareToSignature + "|" + echoStr);
		}
	}

}
