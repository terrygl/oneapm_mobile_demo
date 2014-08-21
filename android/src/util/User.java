package util;

import java.io.IOException;
import java.io.InputStream;

 

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

/**
 
 */
public class User  {
	
	public final static int	RELATION_ACTION_DELETE = 0x00;//取消关注
	public final static int	RELATION_ACTION_ADD = 0x01;//加关注
	
	public final static int	RELATION_TYPE_BOTH = 0x01;//双方互为粉丝
	public final static int	RELATION_TYPE_FANS_HIM = 0x02;//你单方面关注他
	public final static int	RELATION_TYPE_NULL = 0x03;//互不关注
	public final static int	RELATION_TYPE_FANS_ME = 0x04;//只有他关注我
	
	private int uid;
	private String location;
	private String name;
	private int followers;
	private int fans;
	private int score;
	private String face;
	private String account;
	private String pwd;
 
	private boolean isRememberMe;
	
	private String jointime;
	private String gender;
	private String devplatform;
	private String expertise;
	private int relation;
	private String latestonline;
	
	
	public boolean isRememberMe() {
		return isRememberMe;
	}
	public void setRememberMe(boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}
	public String getJointime() {
		return jointime;
	}
	public void setJointime(String jointime) {
		this.jointime = jointime;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDevplatform() {
		return devplatform;
	}
	public void setDevplatform(String devplatform) {
		this.devplatform = devplatform;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public String getLatestonline() {
		return latestonline;
	}
	public void setLatestonline(String latestonline) {
		this.latestonline = latestonline;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	 
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	 
}
