/**
 * 
 */
package com.halo.wechat.mvc.services.impls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.NullSaoException;
import com.halo.wechat.capabilities.abilities.MessageAbility;
import com.halo.wechat.capabilities.abilities.SignatureAbility;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.mvc.commands.Command;
import com.halo.wechat.mvc.services.MessageService;
import com.halo.wechat.mvc.services.ServiceException;

/**
 * @file MessageServiceImpl.java
 * @author Junior
 * @date 2015年8月9日 上午10:43:15
 * @version 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private Command command;

	@Override
	public void checkSignature(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		SignatureAbility signatureAbility = (SignatureAbility) SpringUtils.getBean("signatureAbility");
		if (null == signatureAbility) {
			throw new ServiceException("Get bean signatureAbility failed, applicationContext-wechat.xml may be damaged.");
		}
		try {
			signatureAbility.checkSignature(request, response);
		} catch (CapabilityException e) {
			throw new ServiceException("Check signature failed.", e);
		}
	}

	@Override
	public void processMessage(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		MessageAbility messageAbility = (MessageAbility) SpringUtils.getBean("messageAbility");
		if (null == messageAbility) {
			throw new ServiceException("Get bean messageAbility failed, applicationContext-wechat.xml may be damaged.");
		}

		MsgType receiveMessage = null;
		try {
			receiveMessage = messageAbility.receiveMessage(request);
		} catch (CapabilityException | NullSaoException e) {
			throw new ServiceException("Receive message process failed. ", e);
		}

		Message responseMessage = null;
		try {
			responseMessage = messageAbility.executeCommand(command, receiveMessage);
		} catch (CapabilityException e) {
			throw new ServiceException("Execute user command failed. ", e);
		}

		try {
			messageAbility.responseMessage(response, responseMessage);
		} catch (CapabilityException | NullSaoException e) {
			throw new ServiceException("Response message failed. ", e);
		}
	}

}
