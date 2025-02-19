/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ucai.superwechat.db;

import java.util.List;
import java.util.Map;

import android.content.Context;

import cn.ucai.superwechat.domain.RobotUser;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.domain.User;

public class UserDao {
	public static final String TABLE_NAME = "uers";
	public static final String COLUMN_NAME_ID = "username";
	public static final String COLUMN_NAME_NICK = "nick";
	public static final String COLUMN_NAME_AVATAR = "avatar";
	
	public static final String PREF_TABLE_NAME = "pref";
	public static final String COLUMN_NAME_DISABLED_GROUPS = "disabled_groups";
	public static final String COLUMN_NAME_DISABLED_IDS = "disabled_ids";

	public static final String ROBOT_TABLE_NAME = "robots";
	public static final String ROBOT_COLUMN_NAME_ID = "username";
	public static final String ROBOT_COLUMN_NAME_NICK = "nick";
	public static final String ROBOT_COLUMN_NAME_AVATAR = "avatar";

	public static final String USER_TABLE_NAME = "t_super_user";
	public static final String USER_COLUMN_NAME = "m_user_name";
	public static final String USER_COLUMN_NAME_NICK = "m_user_nick";
	public static final String USER_COLUMN_NAME_AVATAR_ID = "m_avatar_id";					//主键
	public static final String USER_COLUMN_NAME_AVATAR_NAME ="m_avatar_user_name";			//用户账号或者群组账号
	public static final String USER_COLUMN_NAME_AVATAR_SUFFIX  ="m_avatar_suffix";              //头像后缀名
	public static final String USER_COLUMN_NAME_AVATAR_PATH = "m_avatar_path";				//保存路径
	public static final String USER_COLUMN_NAME_AVATAR_TYPE = "m_avatar_type";				//头像类型：\n0:用户头像\n1:群组头像
	public static final String USER_COLUMN_NAME_AVATAR_UPDATE_TIME = "m_avatar_last_update_time";	//最后更新时间

	
	public UserDao(Context context) {
	}

	/**
	 * save contact list
	 * 
	 * @param contactList
	 */
	public void saveContactList(List<EaseUser> contactList) {
	    SuperWeChatDBManager.getInstance().saveContactList(contactList);
	}

	/**
	 * get contact list
	 * 
	 * @return
	 */
	public Map<String, EaseUser> getContactList() {
		
	    return SuperWeChatDBManager.getInstance().getContactList();
	}
	
	/**
	 * delete a contact
	 * @param username
	 */
	public void deleteContact(String username){
	    SuperWeChatDBManager.getInstance().deleteContact(username);
	}
	
	/**
	 * save a contact
	 * @param user
	 */
	public void saveContact(EaseUser user){
	    SuperWeChatDBManager.getInstance().saveContact(user);
	}
	
	public void setDisabledGroups(List<String> groups){
	    SuperWeChatDBManager.getInstance().setDisabledGroups(groups);
    }
    
    public List<String>  getDisabledGroups(){       
        return SuperWeChatDBManager.getInstance().getDisabledGroups();
    }
    
    public void setDisabledIds(List<String> ids){
        SuperWeChatDBManager.getInstance().setDisabledIds(ids);
    }
    
    public List<String> getDisabledIds(){
        return SuperWeChatDBManager.getInstance().getDisabledIds();
    }
    
    public Map<String, RobotUser> getRobotUser(){
    	return SuperWeChatDBManager.getInstance().getRobotList();
    }
    
    public void saveRobotUser(List<RobotUser> robotList){
    	SuperWeChatDBManager.getInstance().saveRobotList(robotList);
    }
	/**
	 * save contact list
	 *
	 * @param contactList
	 */
	public void saveAppContactList(List<User> contactList) {
		SuperWeChatDBManager.getInstance().saveAppContactList(contactList);
	}

	/**
	 * get contact list
	 *
	 * @return
	 */
	public Map<String, User> getAppContactList() {

		return SuperWeChatDBManager.getInstance().getAppContactList();
	}

	/**
	 * delete a contact
	 * @param username
	 */
	public void deleteAppContact(String username){
		SuperWeChatDBManager.getInstance().deleteAppContact(username);
	}

	/**
	 * save a contact
	 * @param user
	 */
	public void saveAppContact(User user){
		SuperWeChatDBManager.getInstance().saveAppContact(user);
	}
}
