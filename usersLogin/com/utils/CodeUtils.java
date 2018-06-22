package com.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeUtils {
	//8.随机验证码
	private static Random random =new Random();
	public static char[] chars = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ123456789".toCharArray();
	
	private static String getCode(int length) {
		StringBuffer sbf = new StringBuffer();
		for(int i=0; i<length; i++){
			sbf.append(chars[random.nextInt(chars.length)]+" ");
		}
		return sbf.toString();
	}
	
	
	public static void getCodeWirter(HttpServletRequest req,HttpServletResponse resp){
		try {
			//1.创建画布
			BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_BGR);
			//2.创建画笔
			Graphics2D graphics2d = bufferedImage.createGraphics();
			//5.设置画笔颜色并涂满整个画布——背景色
			graphics2d.setColor(new Color(164,190,217));
			graphics2d.fillRect(0, 0, 100, 30);
			//6.更新画笔颜色
			graphics2d.setColor(new Color(55,57,84));
			//7.设置字体
			graphics2d.setFont(new Font("MV Boli",Font.BOLD,20));
			//9.获得验证码
			String code = getCode(4);
			//3.写字
			graphics2d.drawString(code, 10, 20);
			//这个才是存取到服务器上的——去掉空格
			code = code.replace(" ", "");
			req.getSession().setAttribute("code", code);
			//4.关闭资源
			graphics2d.dispose();
			ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
