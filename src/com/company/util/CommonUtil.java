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
 * Ѱ��������
 * 
 * User: wxw Date: 2007-5-14 Time: 17:10:48 To change this template use File |
 * Settings | File Templates.
 */
public class CommonUtil {
    
   // private static final Log log = LogFactory.getLog(CommonUtil.class);
	/**
	 * �������ַ���ת�������ڶ���<code>java.util.Date</code>
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
	 * �������ַ���ת�������ڶ���<code>java.util.Date</code>
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
	 * ת�������ڶ���
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
	 * ת�������ڶ���
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
	 * ��õ�ǰ���� yyyy:mm:dd hh:mm:ss
	 */
	public static java.sql.Timestamp getCurDate() {
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}

	/**
	 * ���ַ���ת��Ϊ Integer �����ַ���תΪ 0
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
	 * ��objectת��Ϊ Integer �����ַ���תΪ 0
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
	 * �� null ת��Ϊ ""
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
	 * ����Ƿ�Ϊ����
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
	 * �� null ת��Ϊ ""
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
	 * �ж��ַ��Ƿ�Ϊ��
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
	 * ���ַ������� gb2312 ת�룬��Ҫ�������Ĵ���
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
	 * Ϊ�ַ�������ǰ��'0'
	 * 
	 * @param input
	 *            ��Ҫ��'0'���ַ���
	 * @param length
	 *            ��"0"���ַ����ĳ���
	 * @return ����ǰ��'0'���ַ��� ����:addZero("04", 4),����"0004"
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
	 * �������ڼ��㲡�˵�����
	 * @param oBirthDay
	 * @return int (����)
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
	 * ���ַ���ת��Ϊ Integer �����ַ���תΪ null
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
	 * ���ַ�������Ϊint ,null תΪ 0
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
	 * ���ַ���ת��Ϊ Float �����ַ���תΪ null
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
	 * ����ָ���������ķ���(�˴���ָ pojo ��� getXX() ����)
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
	 * ʱ��ת��
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
	 * ͨ������õ���������(ֻ������)
	 * @param age
	 * @return String
	 */
	public static String getCsrq(int age) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -age);
		return dateFormat(cal.getTime());
	}
	
	/**
     * �ַ�������ת��
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
    
    /** �ӻỰ��ȡ������ֵ 
     * 
     * @param sess �Ự
     * @param bean �����ж��Ķ���
     * @return bean���������ֵ.
     */
//    public static Serializable getIdentifier(Session sess, Object bean) {
//        Serializable id = null;
//        if (bean == null) {
//            throw new NullPointerException("����bean������Ϊ��.");
//        }
//        Class clazz = bean.getClass();
//        ClassMetadata cm = sess.getSessionFactory().getClassMetadata(clazz);
//        //ֻ��������.
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
//                    log.info("�Ӷ�����ȡ������Ӧ������ֵ:" + bean, ex);
//                }
//            }
//        }
//        return id;
//    }
    /**
	 * ѹ��ͼƬ����
	 * 
	 * @param oldFile
	 *            ��Ҫѹ����ͼƬ
	 * @param width
	 *            ѹ����
	 * @param height
	 *            ѹ����
	 * @param quality
	 *            ѹ�������� ����Ϊ1.0
	 * @param smallIcon
	 *            ѹ��ͼƬ��,��ӵ���չ������ͼƬ��׺��ǰ��ӣ�
	 * @param percentage
	 *            �Ƿ�ȱ�ѹ�� ��true��߱��ʽ����Զ�����
	 * @author zhengsunlei
	 * @return ���������ȷ����ѹ������ļ��� null�������������
	 */
	public static String doCompress(File oldFile, int width, int height,
			float quality, String smallIcon, boolean percentage) {
		if (oldFile != null && width > 0 && height > 0) {
			String newImage = null;
			try {
				File file = oldFile;

				/* ��ȡͼƬ��Ϣ */
				
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
						// Ϊ�ȱ����ż��������ͼƬ��ȼ��߶�
						double rate1 = ((double) srcFile.getWidth(null))
								/ (double) width + 0.1;
						double rate2 = ((double) srcFile.getHeight(null))
								/ (double) height + 0.1;
						double rate = rate1 > rate2 ? rate1 : rate2;
						new_w = (int) (((double) srcFile.getWidth(null)) / rate);
						new_h = (int) (((double) srcFile.getHeight(null)) / rate);
					}
					/* ����趨 */
					BufferedImage tag = new BufferedImage(new_w, new_h,
							BufferedImage.TYPE_INT_RGB);
					tag.getGraphics().drawImage(srcFile, 0, 0, new_w, new_h, null);
					
					/* ѹ������ļ��� */
					String fileNam = oldFile.getPath();
					String filePrex = fileNam.substring(0, fileNam.lastIndexOf('.'));
					newImage = filePrex + smallIcon	+ fileNam.substring(filePrex.length());
					
					/* ѹ��֮����ʱ���λ�� */
					FileOutputStream out = new FileOutputStream(newImage);
					JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
					JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
					/* ѹ������ */
					jep.setQuality(quality, true);
					encoder.encode(tag, jep);
					out.close();
					srcFile.flush();
					
					Log.info("ѹ��ͼƬ���ɳɹ�");					
				}else
				{
					Log.info("ѹ��ͼƬ����ʧ��");		
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
	/**���ݳ����㹺������(�꣩
     */
    public static String getyear(String s)throws Exception {
    	
    	 Calendar   mycalendar=Calendar.getInstance();//��ȡ����ʱ��
    	 String year=String.valueOf(mycalendar.get(Calendar.YEAR));//��ȡ���
    	 int birth= Integer.parseInt(year)-Integer.parseInt(s);
    	 year=birth+"";
//    	 String month=String.valueOf(mycalendar.get(Calendar.MONTH)+1);//��ȡ�·�
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
//    	 Calendar   mycalendar=Calendar.getInstance();//��ȡ����ʱ��
////    	 String year=String.valueOf(mycalendar.get(Calendar.YEAR));//��ȡ���
////    	 int birth= Integer.parseInt(year)-Integer.parseInt(s);
//    	 String month=String.valueOf(mycalendar.get(Calendar.MONTH)+1);//��ȡ�·�
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
     * ��ȡ��ǰ�µ�һ��
     * 
     * @return yyyy-MM-dd
     */
    public static Date getdayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��        
        c.getTime();        
      
        return c.getTime();
       }
    /**
     * ��ȡ��ǰ�������
     * 
     * @return yyyy-MM-dd
     */
    public static Date getdaysOfMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
      
        return c.getTime();
       }
    /**
     * �õ�������һ
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
     * �õ���������
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
     * ��ͼƬ���ˮӡ
     * 
     * @param filePath
     *            ��Ҫ���ˮӡ��ͼƬ��·��
     * @param markContent
     *            ˮӡ������
     * @param markContentColor
     *            ˮӡ���ֵ���ɫ
     * @param qualNum
     *            ͼƬ����
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
//			//log.error("ͼƬ��ʽ�����⣬ˮӡ����ʧ��");
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
//		Font font = new Font("����",Font.BOLD, fontSize);
//		
//		FontMetrics fm = g.getFontMetrics(font); // ����һ��FontMetrics����
//		int h = fm.getHeight();
//		int w = fm.stringWidth(PICMARK);
//		
//		g.setFont(font);
//		g.drawImage(theImg, 0, 0, null);
//		g.drawString(PICMARK, width-w-10, height-h); // ���ˮӡ�����ֺ�����ˮӡ���ֳ��ֵ�����
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
	 * �������ַ���ת�������ڶ���<code>java.util.Date</code>
	 * 
	 * @param strDate
	 * @return  date
	 */
	public static Date parseDate2(String strDate) {
		String splitSign = "";
		System.out.println("strDate = " + strDate);
		if (strDate == null)
			return new Date();
		System.out.println("����䲻�ᱻ��ӡ������");
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