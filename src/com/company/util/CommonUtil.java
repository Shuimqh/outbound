package com.company.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.jfree.util.Log;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 寻常工具类
 * 
 * User: wxw Date: 2007-5-14 Time: 17:10:48 To change this template use File |
 * Settings | File Templates.
 */
public class CommonUtil {
    
   // private static final Log log = LogFactory.getLog(CommonUtil.class);
	/**
	 * 把日期字符串转化成日期对象<code>java.util.Date</code>
	 * 
	 * @param strDate
	 * @return  date
	 */
	public static Date parseDate(String strDate) {
		String splitSign = "";
		if (strDate == null)
			return new Date();
		if (strDate.length() < 8 || strDate.length() > 10)
			throw new java.lang.IllegalArgumentException("Wrong Date Format [ "
					+ strDate + " ]");
		String[] splitSignArray = new String[] { "/", "\\", "-", "," };
		for (int i = 0; i < splitSignArray.length; i++)
			if (strDate.indexOf(splitSignArray[i]) > 0) {
				splitSign = splitSignArray[i];
			}
		String format = "yyyy" + splitSign + "MM" + splitSign + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + strDate
					+ " ]");
		}
	}

	/**
	 * 把日期字符串转化成日期对象<code>java.util.Date</code>
	 * 
	 * @param strDate
	 * @return date
	 */
	public static Date parseDateTime(String strDate) {
		String splitSign = "";
		if (strDate == null)
			return new Date();
		String[] splitSignArray = new String[] { "/", "\\", "-", "," };
		for (int i = 0; i < splitSignArray.length; i++)
			if (strDate.indexOf(splitSignArray[i]) > 0) {
				splitSign = splitSignArray[i];
			}
		String format = "yyyy" + splitSign + "MM" + splitSign + "dd" + "HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + strDate
					+ " ]");
		}
	}

	/**
	 * 转化成日期对象
	 * 
	 * @param da
	 * @param format
	 * @return date
	 */
	public static String formatDate(Date da, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(da);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + da
					+ " ]");
		}
	}

    /**
	 * 转化成日期对象
	 *
	 * @param da
	 * @param format
	 * @return date
	 */
	public static Date formatDate(String da, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(da);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + da
					+ " ]");
		}
	}

    /**
	 * 获得当前日期 yyyy:mm:dd hh:mm:ss
	 */
	public static java.sql.Timestamp getCurDate() {
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}

	/**
	 * 将字符串转换为 Integer ，空字符串转为 0
	 * @param str
	 * @return Integer
	 */
	public static Integer getInteger(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return new Integer(0);
		} else {
			return new Integer(str);
		}
	}

	/**
	 * 将object转换为 Integer ，空字符串转为 0
	 * @param obj
	 * @return Integer
	 */
	public static Integer getInteger(Object obj) {
		try {
			String str = obj.toString();

			return new Integer(str);

		} catch (Exception e) {
			return new Integer(0);
		}
	}

	/**
	 * 将 null 转化为 ""
	 * @param str
	 * @return String
	 */
	public static String checkNull(String str) {
		if (str == null || "null".equals(str)) {
			return "";
		} else {
			return str;
		}

	}

	/**
	 * 检查是否为整型
	 * @param str
	 * @return boolean
	 */
	public static boolean checkInt(String str) {
		try {
			new Integer(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 将 null 转化为 ""
	 * @param obj
	 * @return String
	 */
	public static String checkNull(Object obj) {
		if (obj == null || "null".equals(obj.toString())) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * 判断字符是否为空
	 * @param str
	 * @return true false
	 */
	public static boolean isNull(String str) {
		if (str == null || "".equals(str) ||"null".equals(str) )
			return true;
		else
			return false;
	}

	/**
	 * 对字符串进行 gb2312 转码，主要用于中文处理
	 * @param str
	 * @return String
	 */
	public static String parseGB2312(String str) {
		String newStr = null;

		try {
			newStr = new String(str.getBytes("ISO-8859-1"), "GB2312");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return newStr;
	}

	/**
	 * 为字符串补足前导'0'
	 * 
	 * @param input
	 *            需要加'0'的字符串
	 * @param length
	 *            补"0"后字符串的长度
	 * @return 补足前导'0'的字符串 例如:addZero("04", 4),返回"0004"
	 */
	public static String addZero(String input, int length) {
		int inputLength = input.length();
		if (inputLength == length) {
			return input;
		} else if (inputLength < length) {
			for (int i = 0; i < length - inputLength; i++) {
				input = "0" + input;
			}
		}
		if (inputLength > length) {
			input = input.substring(0, length);
		}
		return input;
	}

	/**
	 * 根据日期计算病人的年龄
	 * @param oBirthDay
	 * @return int (年龄)
	 */

	public static int getAge(Date oBirthDay) {
		int iAge;
		Calendar oCalendarToday = Calendar.getInstance();
		oCalendarToday.setTime(new java.util.Date());

		Calendar oCalendarBirthday = Calendar.getInstance();
		oCalendarBirthday.setTime(oBirthDay);

		Calendar oCalendarTemp = Calendar.getInstance();
		oCalendarTemp.set(oCalendarToday.get(Calendar.YEAR), oCalendarBirthday
				.get(Calendar.MONTH), oCalendarBirthday.get(Calendar.DATE));

		iAge = oCalendarToday.get(Calendar.YEAR)
				- oCalendarBirthday.get(Calendar.YEAR);
		if (!oCalendarToday.after(oCalendarTemp)) {
			iAge--;
		}
		return iAge + 1;
	}

	public static String getValueFromSelectKey(HashMap Select, int key) {

		return "";
	}

	/**
	 * 将字符串转换为 Integer ，空字符串转为 null
	 * @param str
	 * @return Integer
	 */
	public static Integer getInte(String str) {
		if (str == null || "".equals(str)) {
			return null;
		} else {
			try {

				return new Integer(str);

			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
	}

	/**
	 * 将字符串解析为int ,null 转为 0
	 * 
	 * @param str
	 * @return   int
	 */
	public static int parseInt(String str) {
		try {
			Integer inte = new Integer(str);
			return inte.intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 将字符串转换为 Float ，空字符串转为 null
	 * 
	 * @param str
	 * @return Integer
	 */
	public static Float getFloat(String str) {
		if (str == null || "".equals(str)) {
			return null;
		} else {
			try {
				return new Float(str);
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
	}

	/**
	 * 运行指定方法名的方法(此处特指 pojo 类的 getXX() 方法)
	 * 
	 * @param obj
	 * @param className
	 * @return Object
	 */
	public static Object runMethod(Object obj, String className, String fieldNam)
			throws Exception {
		String firstChar = fieldNam.substring(0, 1).toUpperCase();
		String methodNam = "get" + firstChar + fieldNam.substring(1);

		Class cls = obj.getClass();
		Method method = cls.getDeclaredMethod(methodNam, new Class[0]);
		return method.invoke(obj, new Object[0]);
	}

	/*
	 * 时间转化
	 */
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static String dateFormat(Date date) {
		return (date == null) ? null : dateFormat.format(date);
	}
	
	static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static String dateTimeFormat(Date date) {
		return (date == null) ? null : dateTimeFormat.format(date);
	}

	public static Date dateFormat(String str) {
		try {
			return (str == null || str == "") ? null : dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	
	public static String timeFormat(Date date) {
		return (date == null) ? null : timeFormat.format(date);
	}
	
	public static Date timeFormat(String str) {
		try {
			return (str == null || str == "") ? null : timeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过年龄得到出生日期(只算年数)
	 * @param age
	 * @return String
	 */
	public static String getCsrq(int age) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -age);
		return dateFormat(cal.getTime());
	}
	
	/**
     * 字符串编码转换
     * 
     * @param str
     * @return
     * @tzhli
     * @Time 2007-09-13
     */
    public static String characterEncodingChange(String str) {
    	String name = null;
    	try {
			name = new String(str.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return name;
    }
    
    /** 从会话中取得主键值 
     * 
     * @param sess 会话
     * @param bean 用于判定的对象
     * @return bean对象的主键值.
     */
//    public static Serializable getIdentifier(Session sess, Object bean) {
//        Serializable id = null;
//        if (bean == null) {
//            throw new NullPointerException("参数bean不可以为空.");
//        }
//        Class clazz = bean.getClass();
//        ClassMetadata cm = sess.getSessionFactory().getClassMetadata(clazz);
//        //只处理表对象.
//        if (cm != null) {
//            if (sess.contains(bean)) {
//                id = sess.getIdentifier(bean);
//            } else {
//                
//                
//                if (log.isDebugEnabled()) {
//                    log.debug("clazz=" + clazz);
//                }
//                String idName = cm.getIdentifierPropertyName();
//                try {
//                    idName = idName.substring(0, 1).toUpperCase() + idName.substring(1);
//                    Method m = clazz.getMethod("get" + idName, null);
//                    id = (Serializable) m.invoke(bean, null);
//                } catch (Exception ex) {
//                    id = null;
//                    log.info("从对象中取不到相应的主键值:" + bean, ex);
//                }
//            }
//        }
//        return id;
//    }
    /**
	 * 压缩图片方法
	 * 
	 * @param oldFile
	 *            将要压缩的图片
	 * @param width
	 *            压缩宽
	 * @param height
	 *            压缩高
	 * @param quality
	 *            压缩清晰度 建议为1.0
	 * @param smallIcon
	 *            压缩图片后,添加的扩展名（在图片后缀名前添加）
	 * @param percentage
	 *            是否等比压缩 若true宽高比率将将自动调整
	 * @author zhengsunlei
	 * @return 如果处理正确返回压缩后的文件名 null则参数可能有误
	 */
	public static String doCompress(File oldFile, int width, int height,
			float quality, String smallIcon, boolean percentage) {
		if (oldFile != null && width > 0 && height > 0) {
			String newImage = null;
			try {
				File file = oldFile;

				/* 读取图片信息 */
				
				Image srcFile = null;
				
				try
				{
					srcFile = ImageIO.read(file);
				}catch(Exception e)
				{
					srcFile = null;
				}
				
				if(srcFile!=null)
				{
					int new_w = width;
					int new_h = height;
					if (percentage) {
						// 为等比缩放计算输出的图片宽度及高度
						double rate1 = ((double) srcFile.getWidth(null))
								/ (double) width + 0.1;
						double rate2 = ((double) srcFile.getHeight(null))
								/ (double) height + 0.1;
						double rate = rate1 > rate2 ? rate1 : rate2;
						new_w = (int) (((double) srcFile.getWidth(null)) / rate);
						new_h = (int) (((double) srcFile.getHeight(null)) / rate);
					}
					/* 宽高设定 */
					BufferedImage tag = new BufferedImage(new_w, new_h,
							BufferedImage.TYPE_INT_RGB);
					tag.getGraphics().drawImage(srcFile, 0, 0, new_w, new_h, null);
					
					/* 压缩后的文件名 */
					String fileNam = oldFile.getPath();
					String filePrex = fileNam.substring(0, fileNam.lastIndexOf('.'));
					newImage = filePrex + smallIcon	+ fileNam.substring(filePrex.length());
					
					/* 压缩之后临时存放位置 */
					FileOutputStream out = new FileOutputStream(newImage);
					JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
					JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
					/* 压缩质量 */
					jep.setQuality(quality, true);
					encoder.encode(tag, jep);
					out.close();
					srcFile.flush();
					
					Log.info("压缩图片生成成功");					
				}else
				{
					Log.info("压缩图片生成失败");		
					return null;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return newImage;
		} else {
			return null;
		}
	}
	/**根据车龄算购买日期(年）
     */
    public static String getyear(String s)throws Exception {
    	
    	 Calendar   mycalendar=Calendar.getInstance();//获取现在时间
    	 String year=String.valueOf(mycalendar.get(Calendar.YEAR));//获取年份
    	 int birth= Integer.parseInt(year)-Integer.parseInt(s);
    	 year=birth+"";
//    	 String month=String.valueOf(mycalendar.get(Calendar.MONTH)+1);//获取月份
//    	 String day=String.valueOf(mycalendar.get(Calendar.DATE));
//    	 if(month.length()<2){
//    		 month="0"+month;
//    	 }
//    	 if(day.length()<2){
//    		 day="0"+day;
//    	 }    	
    	// Date d=parseDate(birth+"-"+month+"-"+day);
    	 return (year);
    	//return (birth+"-"+month+"-"+day);
    }
    /**
     */
//    public static String getmonth()throws Exception {
//    	
//    	 Calendar   mycalendar=Calendar.getInstance();//获取现在时间
////    	 String year=String.valueOf(mycalendar.get(Calendar.YEAR));//获取年份
////    	 int birth= Integer.parseInt(year)-Integer.parseInt(s);
//    	 String month=String.valueOf(mycalendar.get(Calendar.MONTH)+1);//获取月份
//    	// String day=String.valueOf(mycalendar.get(Calendar.DATE));
//    	 if(month.length()<2){
//    		 month="0"+month;
//    	 }
////    	 if(day.length()<2){
////    		 day="0"+day;
////    	 }    	
//    	// Date d=parseDate(birth+"-"+month+"-"+day);
//    	 return (month);
//    	//return (birth+"-"+month+"-"+day);
//    }
    
    /**
     * 获取当前月第一天
     * 
     * @return yyyy-MM-dd
     */
    public static Date getdayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天        
        c.getTime();        
      
        return c.getTime();
       }
    /**
     * 获取当前月最后天
     * 
     * @return yyyy-MM-dd
     */
    public static Date getdaysOfMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
      
        return c.getTime();
       }
    /**
     * 得到本周周一
     * 
     * @return yyyy-MM-dd
     */
    public static Date getMondayOfThisWeek() {
     Calendar c = Calendar.getInstance();
     int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
     if (day_of_week == 0)
      day_of_week = 7;
     c.add(Calendar.DATE, -day_of_week + 1);
     return c.getTime();
    }

    /**
     * 得到本周周日
     * 
     * @return yyyy-MM-dd
     */
    public static Date getSundayOfThisWeek() {
     Calendar c = Calendar.getInstance();
     int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
     if (day_of_week == 0)
      day_of_week = 7;
     c.add(Calendar.DATE, -day_of_week + 7);
     return c.getTime();
    }
	 /**
     * 给图片添加水印
     * 
     * @param filePath
     *            需要添加水印的图片的路径
     * @param markContent
     *            水印的文字
     * @param markContentColor
     *            水印文字的颜色
     * @param qualNum
     *            图片质量
     * @return
     */
//	public static String PICMARK = null;
//	private boolean _createMark(String filePath) {
//		
//		if(null == PICMARK)
//		{
//			PICMARK = SpringUtil.getConfigVal("PIC_MARK");
//			if(null == PICMARK)
//			{
//				PICMARK = "WWW.0016888.COM";
//			}
//		}	
//		
//		final Color markContentColor = Color.yellow;
//		final float qualNum = 1f;
//		int   fontSize= 60;
//
//		ImageIcon imgIcon = new ImageIcon(filePath);
//		
//		if(imgIcon.getImageLoadStatus()==4)
//		{
//			//log.error("图片格式有问题，水印制作失败");
//			return false;
//		}
//		
//		Image theImg = imgIcon.getImage();
//		int width = theImg.getWidth(null);
//		int height = theImg.getHeight(null);
//		BufferedImage bimage = new BufferedImage(width, height,
//				BufferedImage.TYPE_INT_RGB);
//		Graphics2D g = bimage.createGraphics();
//		g.setColor(markContentColor);
//		g.setBackground(Color.white);
//				
//		if(width>=1000)
//		{
//			fontSize = 80;
//		}else if(width>=800 && width<1000)
//		{
//			fontSize = 60;
//		}else if(width>=600 && width<800)
//		{
//			fontSize = 40;
//		}else if(width>=300  && width<600)
//		{
//			fontSize = 20;
//		}else if(width<300)
//		{
//			fontSize = 1;
//		}
//		
//		Font font = new Font("宋体",Font.BOLD, fontSize);
//		
//		FontMetrics fm = g.getFontMetrics(font); // 创建一个FontMetrics对象
//		int h = fm.getHeight();
//		int w = fm.stringWidth(PICMARK);
//		
//		g.setFont(font);
//		g.drawImage(theImg, 0, 0, null);
//		g.drawString(PICMARK, width-w-10, height-h); // 添加水印的文字和设置水印文字出现的内容
//		g.dispose();
//		try {
//			FileOutputStream out = new FileOutputStream(filePath);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
//			param.setQuality(qualNum, true);
//			encoder.encode(bimage, param);
//			out.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}    
    
    /**
	 * 把日期字符串转化成日期对象<code>java.util.Date</code>
	 * 
	 * @param strDate
	 * @return  date
	 */
	public static Date parseDate2(String strDate) {
		String splitSign = "";
		System.out.println("strDate = " + strDate);
		if (strDate == null)
			return new Date();
		System.out.println("该语句不会被打印出来。");
//		if (strDate.length() < 8 || strDate.length() > 10)
//			throw new java.lang.IllegalArgumentException("Wrong Date Format [ "
//					+ strDate + " ]");
		String[] splitSignArray = new String[] { "/", "\\", "-", "," };
		for (int i = 0; i < splitSignArray.length; i++)
			if (strDate.indexOf(splitSignArray[i]) > 0) {
				splitSign = splitSignArray[i];
			}
		String format =null;
		if (strDate.length() ==4){
			format = "yyyy";
		}else if (strDate.length() ==7){
			format = "yyyy" + splitSign + "MM";
		}else if (strDate.length() ==10){
			format = "yyyy" + splitSign + "MM" + splitSign + "dd";
		}else if (strDate.length() ==13){
			format = "yyyy" + splitSign + "MM" + splitSign + "dd" + "hh";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + strDate
					+ " ]");
		}
	}

}