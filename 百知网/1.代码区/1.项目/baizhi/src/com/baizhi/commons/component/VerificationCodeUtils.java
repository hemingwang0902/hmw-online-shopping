package com.baizhi.commons.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerificationCodeUtils {
	private static final char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private int imageWidth = 68;
	private int imageHeight = 22;
	/** 图片类型， 请参考 java.awt.image.BufferedImage.TYPE_* */
	private int imageType = BufferedImage.TYPE_INT_RGB;
	private Color bgColor = new Color(200, 150, 255);
	private int charSize = 4;

	/**
	 * 生成图片验证码
	 * @param output an ImageOutputStream to be written to. 如：response.getOutputStream()
	 * @return 验证码的字符串
	 * @throws IOException
	 */
	public String generateImageCode(OutputStream output) throws IOException {
		BufferedImage img = new BufferedImage(imageWidth, imageHeight,
				imageType);
		// 得到该图片的绘图对象
		Graphics g = img.getGraphics();
		g.setColor(bgColor); // 填充整个图片的颜色
		g.fillRect(0, 0, imageWidth, imageHeight);

		StringBuffer sb = new StringBuffer(); // 向图片中输出数字和字母
		char c;
		Random r = new Random();
		for (int i = 0; i < charSize; i++) {
			c = ch[r.nextInt(ch.length)];
			// TODO 如果需要做得更加灵活一点，需要修改此循环中的代码
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));// 输出的字体和大小
			g.drawString("" + c, (i * 15) + 3, 18);// 写什么数字，在图片的什么位置画
			sb.append(c);
		}

		ImageIO.write(img, "JPG", output);
		return sb.toString();
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int getImageType() {
		return imageType;
	}

	public void setImageType(int imageType) {
		this.imageType = imageType;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public int getCharSize() {
		return charSize;
	}

	public void setCharSize(int charSize) {
		this.charSize = charSize;
	}
}
