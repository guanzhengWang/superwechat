package cn.ucai.superwechat.net;

import android.content.Context;

import com.hyphenate.chat.EMGroup;
import com.hyphenate.easeui.domain.User;

import java.io.File;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.utils.MD5;
import cn.ucai.superwechat.utils.OkHttpUtils;

/**
 * Created by Administrator on 2017/2/8 0008.
 */

public class NetDao {
    public static void register(Context context, String username, String nick, String password, OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_REGISTER)
                .addParam(I.User.USER_NAME,username)
                .addParam(I.User.NICK,nick)
                .addParam(I.User.PASSWORD, MD5.getMessageDigest(password))
                .targetClass(String.class)
                .post()
                .execute(listener);
    }
    public static void unRegister(Context context, String username,  OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UNREGISTER)
                .addParam(I.User.USER_NAME,username)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void Login(Context context, String username, String password, OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_LOGIN)
                .addParam(I.User.USER_NAME,username)
                .addParam(I.User.PASSWORD,MD5.getMessageDigest(password))
                .targetClass(String.class)
                .execute(listener);

    }
    public static void GetUserByUsername(Context context, String username ,OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_FIND_USER)
                .addParam(I.User.USER_NAME,username)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void updateUsernick(Context context, String username, String usernick, OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UPDATE_USER_NICK)
                .addParam(I.User.USER_NAME,username)
                .addParam(I.User.NICK,usernick)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void uploadUserAvatar(Context context, String username, File file, OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UPDATE_AVATAR)
                .addParam(I.NAME_OR_HXID,username)
                .addParam(I.AVATAR_TYPE,I.AVATAR_TYPE_USER_PATH)
                .addFile2(file)
                .targetClass(String.class)
                .post()
                .execute(listener);

    }
    public static void addContact(Context context, String username, String cname,OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_ADD_CONTACT)
                .addParam(I.Contact.USER_NAME,username)
                .addParam(I.Contact.CU_NAME,cname)
                .targetClass(String.class)
                .execute(listener);
    }

    public static void loadContact(Context context, String username, OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_DOWNLOAD_CONTACT_ALL_LIST)
                .addParam(I.Contact.USER_NAME,username)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void removeContact(Context context, String username, String cname, OnCompleteListener<String> listener){
        OkHttpUtils<String>utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_DELETE_CONTACT)
                .addParam(I.Contact.USER_NAME,username)
                .addParam(I.Contact.CU_NAME,cname)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void createAppGroup(Context context, EMGroup group, File file, OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_CREATE_GROUP)
                .addParam(I.Group.HX_ID,group.getGroupId())
                .addParam(I.Group.NAME,group.getGroupName())
                .addParam(I.Group.DESCRIPTION,group.getDescription())
                .addParam(I.Group.OWNER,group.getOwner())
                .addParam(I.Group.IS_PUBLIC, String.valueOf(group.isPublic()))
                .addParam(I.Group.ALLOW_INVITES, String.valueOf(group.isAllowInvites()))
                .addFile2(file)
                .targetClass(String.class)
                .post()
                .execute(listener);
    }
    public static void addGroupMembers(Context context, String members, String hxid, OnCompleteListener<String> listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_ADD_GROUP_MEMBERS)
                .addParam(I.Member.USER_NAME,members)
                .addParam(I.Member.GROUP_HX_ID,hxid)
                .targetClass(String.class)
                .execute(listener);

    }
    public static void removeGroupMember(Context context, String hxid, String username , OnCompleteListener<String>listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_DELETE_GROUP_MEMBER)
                .addParam(I.Member.GROUP_HX_ID,hxid)
                .addParam(I.Member.USER_NAME,username)
                .targetClass(String.class)
                .execute(listener);

    }
    public static  void updateGroupName(Context context , String hxid, String groupName, OnCompleteListener<String>listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UPDATE_GROUP_NAME)
                .addParam(I.Group.HX_ID,hxid)
                .addParam(I.Group.NAME,groupName)
                .targetClass(String.class)
                .execute(listener);


    }
    public static void deleteGroup(Context context, String hxid, OnCompleteListener<String>listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_DELETE_GROUP_BY_HXID)
                .addParam(I.Group.HX_ID,hxid)
                .targetClass(String.class)
                .execute(listener);
    }
}
