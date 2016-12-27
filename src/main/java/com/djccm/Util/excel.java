package com.djccm.Util;

import jxl.*;
import jxl.write.*;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class excel
{
    public static void main(String[] args)
    {
        String targetfile = "c:/out1.xls";//输出的excel文件名
        String worksheet = "List";//输出的excel文件工作表名
        String[] title = {"userName","NAME"};//excel工作表的标题
        WritableWorkbook workbook;
        try
        {
//创建可写入的Excel工作薄,运行生成的文件在tomcat/bin下
//workbook = Workbook.createWorkbook(new File("output.xls"));
            System.out.println("begin");

            OutputStream os=new FileOutputStream(targetfile);
            workbook=Workbook.createWorkbook(os);

            WritableSheet sheet = workbook.createSheet(worksheet, 0); //添加第一个工作表
//WritableSheet sheet1 = workbook.createSheet("MySheet1", 1); //可添加第二个工作

            jxl.write.Label label;
            for (int i=0; i<title.length; i++)
            {
//Label(列号,行号 ,内容 )
                label = new jxl.write.Label(i, 0, title[i]); //put the title in row1
                sheet.addCell(label);
            }
//下列添加的对字体等的设置均调试通过，可作参考用
//添加带有字型Formatting的对象
            jxl.write.WritableFont wf = new jxl.write.WritableFont(WritableFont.TIMES,10,WritableFont.BOLD,true);
            //jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf);
            jxl.write.Label labelCF = new jxl.write.Label(1,1,"22");
            jxl.write.Label labelCF1 = new jxl.write.Label(0,1,"11");
            sheet.addCell(labelCF);
            sheet.addCell(labelCF1);
            workbook.write();
            workbook.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("end");
        Runtime r=Runtime.getRuntime();
        Process p=null;
//String cmd[]={"notepad","exec.java"};
        String cmd[]={"C:\\Program Files\\Microsoft Office\\Office\\EXCEL.EXE","out.xls"};
        try{
            p=r.exec(cmd);
        }
        catch(Exception e){
            System.out.println("error executing: "+cmd[0]);
        }
    }
}
