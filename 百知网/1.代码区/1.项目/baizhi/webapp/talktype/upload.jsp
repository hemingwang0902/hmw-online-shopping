<%@ page contentType="text/html;charset=gb2312" language="java" import="java.io.*,java.awt.Image,java.awt.image.*,com.sun.image.codec.jpeg.*,java.sql.*,com.jspsmart.upload.*,java.util.*"%>


<html>
<head>
<title>�ļ��ϴ�����ҳ��</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<%

SmartUpload mySmartUpload =new SmartUpload();

long file_size_max=4000000;

String fileName2="",ext="",testvar="";

String url="upload/";         //Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ���

//��ʼ��

mySmartUpload.initialize(pageContext);

//ֻ�������ش����ļ�

try {

mySmartUpload.setAllowedFilesList("jpg,gif,png");

//�����ļ�

mySmartUpload.upload();

} catch (Exception e){

%>

<SCRIPT language=javascript>

alert("ֻ�����ϴ�.jpg��.gif����ͼƬ�ļ�");

window.location=''talktypeform.jsp'';

</script>

<%

}

try{

com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0);

if (myFile.isMissing()){%>

<SCRIPT language=javascript>

alert("����ѡ��Ҫ�ϴ����ļ�");

window.location=''talktypeform.jsp'';

</script>

<%}

else{

//String myFileName=myFile.getFileName(); //ȡ�����ص��ļ����ļ���

ext= myFile.getFileExt();         //ȡ�ú�׺��

int file_size=myFile.getSize();        //ȡ���ļ��Ĵ�С 

String str1=mySmartUpload.getRequest().getParameter("name"); //����ϴ��������ƣ�

String saveurl="";

if(file_size<file_size_max){

//�����ļ�����ȡ�õ�ǰ�ϴ�ʱ��ĺ�����ֵ

Calendar calendar = Calendar.getInstance();

String filename = String.valueOf(calendar.getTimeInMillis());

saveurl=this.getServletContext().getRealPath("/")+url;
/*request.getRealPath("/")+url;*/

saveurl+=filename+"."+ext;             //����·��

myFile.saveAs(saveurl,mySmartUpload.SAVE_PHYSICAL);

//out.print(filename);

//-----------------------�ϴ���ɣ���ʼ��������ͼ-------------------------   

java.io.File file = new java.io.File(saveurl);           //����ղ��ϴ����ļ�
String url2="uploads/";
String newurl=this.getServletContext().getRealPath("/")+url2+filename+"."+ext;
/*request.getRealPath("/")+url2+filename+"."+ext; */    //�µ�����ͼ�����ַ
String weburl=filename+"."+ext; //�������ݿ�·��

Image src = javax.imageio.ImageIO.read(file);                        //����Image����

float tagsize=100;

int old_w=src.getWidth(null);                                        //�õ�Դͼ��

int old_h=src.getHeight(null);  

int new_w=0;

int new_h=0;                               //�õ�Դͼ��

int tempsize;

float tempdouble;

if(old_w>old_h){

tempdouble=old_w/tagsize;

}else{

tempdouble=old_h/tagsize;

}

new_w=Math.round(old_w/tempdouble);

new_h=Math.round(old_h/tempdouble);//������ͼ����

BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);

tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);          //������С���ͼ

FileOutputStream newimage=new FileOutputStream(newurl);             //������ļ���

JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);      

encoder.encode(tag);                                                  //��JPEG����

newimage.close();
Class.forName("com.mysql.jdbc.Driver").newInstance();        
	String dburl="jdbc:mysql://localhost:3306/baizhi";
//�ɸ����Լ������ݿ����ã�urlΪ·����picΪ���ݿ����ƣ����õ���mysql��root��rootΪ���ݿ��û���������
	Connection conn = DriverManager.getConnection(dburl,"root","as");
    PreparedStatement ps; 
  
String sql="insert into t_talktype(type_name,piclogo,create_time) values ('"+str1+"','"+ weburl +"',NOW())";
         ps=conn.prepareStatement(sql);
         ps.executeUpdate(sql);
      
%>
    yes ok!!
<%   
}else{
out.print("<SCRIPT language=''javascript''>");

out.print("alert(''�ϴ��ļ���С���ܳ���"+(file_size_max/1000)+"K'');");

out.print("window.location=''talktypeform.jsp;''");

out.print("</SCRIPT>");

}

}

}catch (Exception e){

e.toString();

}

%> 
</body>
</html>