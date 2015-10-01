package com.halo.wechat.capabilities.abilities;

import org.aspectj.lang.JoinPoint;

import com.halo.wechat.capabilities.CapabilityException;

public interface SecurityAbility {

	public void messageSecurityCheck(JoinPoint jp) throws CapabilityException;

}
