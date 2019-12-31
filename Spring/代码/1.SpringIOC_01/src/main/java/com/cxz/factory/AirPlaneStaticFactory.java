package com.cxz.factory;

import com.cxz.bean.AirPlane;

/**
 * 飞机的静态工厂
 * 
 * @author 22527
 *
 */
public class AirPlaneStaticFactory {

	// 飞机的工厂方法
	public static AirPlane getAirPlane(String jzName) {
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行");
		airPlane.setFjsName("刘亦菲");
		airPlane.setJzName(jzName);
		airPlane.setPersonNum(300);
		airPlane.setYc("198.98cm");
		System.out.println("AirPlaneStaticFactory调用静态工厂方法，完成飞机的建造");
		return airPlane;
	}
}
