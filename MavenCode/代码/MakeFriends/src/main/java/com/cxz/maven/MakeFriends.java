package com.cxz.maven;
import com.cxz.maven.HelloFriend;

public class MakeFriends {

	public String makeFriends(String name) {
		HelloFriend friend = new HelloFriend();
		friend.sayHelloToFriend("cxz");
		String str = "Hey," + friend.getMyName() + " make a friend please";
		System.out.println(str);
		return str;
	}
}
