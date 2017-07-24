package com.bbd.wtyh.excel.imp.utils;

import java.awt.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFColor;

/**
 * ColorUtil
 *
 * @author Created by LiYao on 2017-05-03 14:46.
 */
public class ColorUtil {

	/**
	 * 获得主机IP
	 *
	 * @return String
	 */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().contains("windows")) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	/**
	 * 获取本机ip地址，并自动区分Windows还是linux操作系统
	 *
	 * @return String
	 */
	public static String getLocalIP() throws Exception {
		InetAddress ip = null;
		// 如果是Windows操作系统
		if (isWindowsOS()) {
			ip = InetAddress.getLocalHost();
			return ip.getHostAddress();
		}
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		level1: while (netInterfaces.hasMoreElements()) {
			NetworkInterface ni = netInterfaces.nextElement();
			// ----------特定情况，可以考虑用ni.getName判断
			// 遍历所有ip
			Enumeration<InetAddress> ips = ni.getInetAddresses();
			while (ips.hasMoreElements()) {
				ip = ips.nextElement();
				if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() // 127.开头的都是lookback地址
						&& !ip.getHostAddress().contains(":")) {
					break level1;
				}
			}

		}
		if (null != ip) {
			return ip.getHostAddress();
		}
		return "";
	}

	private static Map<String, XSSFColor> colorMap = new ConcurrentHashMap<>();

	static {
		getColor(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue());
		getColor(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue());
		getColor(Color.BLUE.getRed(), Color.BLUE.getGreen(), Color.BLUE.getBlue());
		getColor(Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue());
	}

	public static XSSFColor getColorByRGBOrHex(String color) {
		if (StringUtils.isBlank(color)) {
			return null;
		}
		if (color.startsWith("#")) {
			return getColorByHex(color);
		}
		if (color.contains(",")) {
			return getColor(color);
		}
		return null;
	}

	public static XSSFColor getColor(String rgb) {
		if (StringUtils.isBlank(rgb)) {
			return null;
		}
		String[] rgbs = rgb.split(",");
		if (rgbs.length < 3) {
			return null;
		}
		int r = StringUtils.isBlank(rgbs[0]) ? 0 : Integer.parseInt(rgbs[0]);
		int g = StringUtils.isBlank(rgbs[1]) ? 0 : Integer.parseInt(rgbs[1]);
		int b = StringUtils.isBlank(rgbs[2]) ? 0 : Integer.parseInt(rgbs[2]);
		return getColor(r, g, b);
	}

	public static XSSFColor getColor(int r, int g, int b) {
		return getColorByHex(RGBToHex(r, g, b));
	}

	public static XSSFColor getColorByHex(String hexColor) {
		hexColor = hexColor.substring(1);
		XSSFColor color = colorMap.get(hexColor);
		if (color != null) {
			return color;
		}
		color = new XSSFColor(new Color(Integer.parseInt(hexColor, 16)));
		colorMap.put(hexColor, color);
		return color;
	}

	public static String RGBToHex(int r, int g, int b) {
		StringBuilder su = new StringBuilder();
		String red = Integer.toHexString(r);
		String green = Integer.toHexString(g);
		String blue = Integer.toHexString(b);
		red = red.length() == 1 ? "0" + red : red;
		green = green.length() == 1 ? "0" + green : green;
		blue = blue.length() == 1 ? "0" + blue : blue;
		su.append("#");
		su.append(red.toUpperCase());
		su.append(green.toUpperCase());
		su.append(blue.toUpperCase());
		return su.toString();

	}

}
