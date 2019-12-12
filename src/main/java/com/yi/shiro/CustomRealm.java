package com.yi.shiro;

import com.yi.entity.Permission;
import com.yi.entity.TbManager;
import com.yi.service.ManagerService;
import com.yi.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: MyRealm
 * @Description: shiro 认证 + 授权   重写 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 授权Realm
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		TbManager account = (TbManager) principals.getPrimaryPrincipal();
		//pojo.setAccount(account);
		//根据用户user->2.获取角色id->3.根据角色id获取权限permission
		int userId = managerService.goLogin(account.getName(),account.getPassword()).getId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		if(userId != 0){
			/**根据用户ID查询角色（role），放入到Authorization里.*/
			String roleId = managerService.selectByPrimaryKey(userId).getRoleId().toString();
			info.addRole(roleId);
			/**根据用户ID查询权限（permission），放入到Authorization里.*/
			List<Permission> permissionsByUser = permissionService.selectByLevel(Integer.parseInt(roleId));
			if (permissionsByUser.size()!=0) {
				for (Permission p: permissionsByUser) {
					info.addStringPermission(p.getUrl());
				}
			}
		}
		return info;
	}

	/**
	 * 登录认证Realm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		String username = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		TbManager user = managerService.goLogin(username, password);
		if(null==user){
			throw new AccountException("帐号或密码不正确！");
		}
	/*	if(user.get()){
			throw new DisabledAccountException("帐号已经禁止登录！");
		}*/
		return new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes("3.14159"), getName());
	}


	/**
	 * 清空当前用户权限信息
	 */
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

}