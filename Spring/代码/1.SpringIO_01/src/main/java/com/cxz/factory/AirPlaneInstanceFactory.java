package com.cxz.factory;

import com.cxz.bean.AirPlane;

/**
 * 飞机的实例工厂
 * @author 22527
 *
 */
public class AirPlaneInstanceFactory {

	// 飞机的工厂方法
	public AirPlane getAirPlane(String jzName) {
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行");
		airPlane.setFjsName("刘亦菲");
		airPlane.setJzName(jzName);
		airPlane.setPersonNum(300);
		airPlane.setYc("198.98cm");
		System.out.println("AirPlaneInstanceFactory调用实例工厂方法，完成飞机的建造");
		return airPlane;
	}
}
