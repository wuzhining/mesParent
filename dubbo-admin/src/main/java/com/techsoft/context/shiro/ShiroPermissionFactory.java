package com.techsoft.context.shiro;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.techsoft.client.service.sys.ClientAdminMenuService;
import com.techsoft.client.service.sys.ClientAdminRoleMenuService;
import com.techsoft.client.service.sys.ClientAdminRoleUserService;
import com.techsoft.client.service.sys.ClientUserPassportService;
import com.techsoft.client.service.sys.ClientUserPassportServiceImpl;
import com.techsoft.common.utils.SpringContextUtil;

public class ShiroPermissionFactory extends ShiroFilterFactoryBean {

//	@Autowired
//	private ClientAdminMenuService clientAdminMenuService; 
//	@Autowired
//	private ClientAdminRoleUserService clientAdminRoleUserService;
//	@Autowired
//	private ClientAdminRoleMenuService clientAdminRoleMenuService;

	/** 记录配置中的过滤链 */
	public static String definitions = "";

	@Override
	protected AbstractShiroFilter createInstance() throws Exception {

		ClientUserPassportService clientUserPassportService = SpringContextUtil
				.getBean(ClientUserPassportServiceImpl.class);
 
		return super.createInstance();
	}

	/**
	 * 从数据库动态读取权限 增删改权限数据库时,setFilterChainDefinitions（）方法需要重新加载
	 */
	@Override
	public void setFilterChainDefinitions(String definitions) {
//		System.out.println("clientAdminMenuService==="+clientAdminMenuService);
//		System.out.println("clientAdminRoleUserService==="+clientAdminRoleUserService);
//		System.out.println("clientAdminRoleMenuService==="+clientAdminRoleMenuService);
		
		ShiroPermissionFactory.definitions = definitions;
		// 数据库动态权限
		// List<PermissionsPo> permissions = permissionsService.findAll();
		// for (PermissionsPo po : permissions) {
		// 字符串拼接权限 
		  definitions = definitions + " /default/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /alarm/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /barcode/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /bill/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /config/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /equip/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /firm/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /flow/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /history/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /pda/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /product/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /quality/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /screen/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /stats/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /struct/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /track/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /view/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /warehouse/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /work/**  = "+"authc,perms[1111]\n";
		  definitions = definitions + " /sys/**  = "+"authc,perms[1111]\n";
		// }
		//System.out.println("definitions==" + definitions);
		// 从配置文件加载权限配置
		Ini ini = new Ini();
		ini.load(definitions);
		Ini.Section section = ini
				.getSection(IniFilterChainResolverFactory.URLS);
		if (CollectionUtils.isEmpty(section)) {
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		}

		// 加入权限集合
		setFilterChainDefinitionMap(section);
	}
}
