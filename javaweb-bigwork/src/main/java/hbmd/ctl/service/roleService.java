package hbmd.ctl.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hbmd.ctl.dao.roleDao;
import hbmd.ctl.domain.Role;

public class roleService {
		private roleService() {
		};
	
		private static roleService RoleService;
		static {
			RoleService = new roleService();
		}
		
	
		public static roleService getRoleInstance() {
			return RoleService;
		}
		
	
		public List<Role> getRoles(int i) throws SQLException {
	
			return roleDao.getRoleDaoInstance().getRoleListByUserId(i);
		}
		
	
		public boolean isRightOne(List<Role> roles) {
			Iterator<Role> iterator = roles.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getId().equals("1")) {
					return true;
				}
				
			}
			return false;
	
		}
		
		
		public boolean isRightTwo(List<Role> roles) {
			Iterator<Role> iterator = roles.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getId().equals("2")) {
					return true;
				}
				
			}
			return false;
		}
		
		
		public boolean isRightThree(List<Role> roles) {
			Iterator<Role> iterator = roles.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getId().equals("3")) {
					return true;
				}
				
			}
			return false;
	
		}
		
		
		public boolean isRightFour(List<Role> roles) {
			Iterator<Role> iterator = roles.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getId().equals("4")) {
					return true;
				}
				
			}
			return false;
	
		}
		
		
		public boolean isRightFive(List<Role> roles) {
			Iterator<Role> iterator = roles.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getId().equals("5")) {
					return true;
				}
				
			}
			return false;
		}
		
		
		public boolean isRightSix(List<Role> roles) {
			Iterator<Role> iterator = roles.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getId().equals("6")) {
					return true;
				}
				
			}
			return false;
	
		}
	
	
}
