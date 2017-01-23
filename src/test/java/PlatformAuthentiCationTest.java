import com.djccm.Util.ExcelReader;
import com.djccm.entity.CcRechargeHistory;
import com.djccm.entity.InsertModel;
import com.djccm.entity.PlatformAuthentiCation;
import com.djccm.service.ImportCcmService;
import com.seeyon.framework.exception.BaseException;
import jxl.Workbook;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.*;


/**
 * Created by Administrator on 2016/11/30 0030.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/*.xml")
public class PlatformAuthentiCationTest {
    @Autowired
    private ImportCcmService importCcmService;
    @Test
    public void getPlatformAuthentiCation() throws BaseException {
        PlatformAuthentiCation platformAuthentiCation=new PlatformAuthentiCation();
        platformAuthentiCation.setUserName("oWcKys81XUWYbNiKQRKGLWDsyB_4_weixin");
        PlatformAuthentiCation firstRentals = importCcmService.selectPlatformAuthentiCation(platformAuthentiCation);
        System.out.println(firstRentals);
    }

    /**
     * 读取Excel表，并取出所需要的字段进行sql插入操作
     * @throws BaseException
     */
    @Test
    public void insertCc() throws BaseException {
        try {
            // 对读取Excel表格标题测试
            InputStream is = new FileInputStream("c:\\chengdu1212.xls");
            ExcelReader excelReader = new ExcelReader();
            String[] title = excelReader.readExcelTitle(is);

            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream("c:\\chengdu1212.xls");
            Map<Integer, String> map = excelReader.readExcelContent(is2);
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
                String[] strs=map.get(i).split("    ");

                //PlatformAuthentiCation platformAuthentiCation=new PlatformAuthentiCation();
                //platformAuthentiCation.setUserName(strs[1]);
                //PlatformAuthentiCation p=importCcmService.selectPlatformAuthentiCation(platformAuthentiCation);
                InsertModel insertModel=new InsertModel();
                insertModel.setName(strs[2]);
                insertModel.setRechargeid(strs[3]);

                    if(strs[1].matches("^(13|15|18)\\d{9}$")) {
                        insertModel.setMobilephone(strs[1]);
                    }
                    insertModel.setUserid(strs[0]);
                    boolean firstRentals = importCcmService.insertCcrechargeInfo(insertModel);
                    System.out.println(firstRentals);

            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }


    }


    /**
     * 根据一张Excel表的内容读取所需字段在数据库中查询,返回结果用于制作为另一张Excel表,用于在另一个数据库中插入
     * 实现跨数据库操作
     * @throws BaseException
     */
    @Test
    public void getPlatformAuthentiCation02() throws BaseException {
        try {
            // 对读取Excel表格标题测试
            InputStream is = new FileInputStream("d:\\1212.xls");
            ExcelReader excelReader = new ExcelReader();
            String[] title = excelReader.readExcelTitle(is);

            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream("d:\\1212.xls");
            Map<Integer, String> map = excelReader.readExcelContent(is2);
            String targetfile = "c:/chengdu1212.xls";//输出的excel文件名
            String worksheet = "List";//输出的excel文件工作表名
            String[] title1 = {"userID","NAME","姓名"};//excel工作表的标题


            WritableWorkbook workbook;
            try {
                System.out.println("begin");
                OutputStream os = new FileOutputStream(targetfile);
                workbook = Workbook.createWorkbook(os);
                WritableSheet sheet = workbook.createSheet(worksheet, 0); //添加第一个工作表
                jxl.write.Label label;
                for (int j = 0; j < title1.length; j++) {
                    label = new jxl.write.Label(j, 0, title1[j]); //put the title in row1
                    sheet.addCell(label);
                }
            for (int i = 1; i <= map.size(); i++) {
                String[] strs=map.get(i).split("    ");
                PlatformAuthentiCation platformAuthentiCation=new PlatformAuthentiCation();
                platformAuthentiCation.setUserName(strs[1]);
                PlatformAuthentiCation p=new PlatformAuthentiCation();
                p = importCcmService.selectPlatformAuthentiCation(platformAuthentiCation);

                    if(p!=null) {
                        jxl.write.WritableFont wf = new jxl.write.WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, true);
                        jxl.write.Label labelCF = new jxl.write.Label(1, i, p.getUserName());
                        jxl.write.Label labelCF1 = new jxl.write.Label(0, i, p.getPersonID());
                        jxl.write.Label labelCF2 = new jxl.write.Label(2, i, strs[2]);
                        sheet.addCell(labelCF);
                        sheet.addCell(labelCF1);
                        sheet.addCell(labelCF2);
                    }
                }
                    workbook.write();
                    workbook.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                //String cmd[]={"C:\\Program Files\\Microsoft Office\\Office\\EXCEL.EXE","out.xls"};
                try{

                }
                catch(Exception e){
                   // System.out.println("error executing: "+cmd[0]);
                }


        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }

    /**
     * 根据查询条件获取结果,将结果返回为一张Excel表
     * @throws BaseException
     */
    @Test
    public void getCcinfo() throws BaseException {
        /* // 对读取Excel表格标题测试
         InputStream is = new FileInputStream("d:\\1212.xls");
         ExcelReader excelReader = new ExcelReader();
         String[] title = excelReader.readExcelTitle(is);

         // 对读取Excel表格内容测试
         InputStream is2 = new FileInputStream("d:\\1212.xls");
         Map<Integer, String> map = excelReader.readExcelContent(is2);*/
        String targetfile = "c:/chengdu1230.xls";//输出的excel文件名
        String worksheet = "List";//输出的excel文件工作表名
        String[] title1 = {"userID","电话","姓名","rechargid"};//excel工作表的标题


        WritableWorkbook workbook;
        try {
            System.out.println("begin");
            OutputStream os = new FileOutputStream(targetfile);
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet(worksheet, 0); //添加第一个工作表
            jxl.write.Label label;
            for (int j = 0; j < title1.length; j++) {
                label = new jxl.write.Label(j, 0, title1[j]); //put the title in row1
                sheet.addCell(label);
            }
            List<CcRechargeHistory> p=new ArrayList<CcRechargeHistory>();
            p = importCcmService.getCcinfo();
            for (int i = 1; i < p.size(); i++) {
                if(p.get(i)!=null) {
                    WritableFont wf = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, true);
                    jxl.write.Label labelCF = new jxl.write.Label(1, i, p.get(i).getMobilephone());
                    jxl.write.Label labelCF1 = new jxl.write.Label(0, i, p.get(i).getUserid());
                    jxl.write.Label labelCF2 = new jxl.write.Label(2, i, p.get(i).getName());
                    jxl.write.Label labelCF3 = new jxl.write.Label(3, i, p.get(i).getRechargeid());
                    sheet.addCell(labelCF);
                    sheet.addCell(labelCF1);
                    sheet.addCell(labelCF2);
                    sheet.addCell(labelCF3);
                }
            }
            workbook.write();
            workbook.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        //String cmd[]={"C:\\Program Files\\Microsoft Office\\Office\\EXCEL.EXE","out.xls"};
        try{

        }
        catch(Exception e){
            // System.out.println("error executing: "+cmd[0]);
        }


    }

    public void getCcinfo(List exportList) throws BaseException {
        String targetfile = "/Users/lihuanzhong/chengduTest1.xls";//输出的excel文件名
        String worksheet = "List";//输出的excel文件工作表名
        //String[] title1 = {"userID","电话","姓名","rechargid"};//excel工作表的标题

        WritableWorkbook workbook;
        try {
            System.out.println("begin");
            OutputStream os = new FileOutputStream(targetfile);
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet(worksheet, 0); //添加第一个工作表
            jxl.write.Label label;
            Map listMap1 = (Map) exportList.get(0);
            Iterator ii1=listMap1.entrySet().iterator();
            while(ii1.hasNext()) {
                for (int j = 0; j < listMap1.size(); j++) {
                    Map.Entry entry = (Map.Entry) ii1.next();
                    label = new jxl.write.Label(j, 0,entry.getKey().toString()); //put the title in row1
                    sheet.addCell(label);
                }
            }
//            for (int j = 0; j < title1.length; j++) {
//                label = new jxl.write.Label(j, 0, title1[j]); //put the title in row1
//                sheet.addCell(label);
//            }
            for (int i = 0; i < exportList.size(); i++) {
                Map listMap = (Map) exportList.get(i);
                Iterator ii=listMap.entrySet().iterator();
                while(ii.hasNext()) {
                    for (int j = 0; j < listMap.size(); j++) {
                        Map.Entry entry = (Map.Entry) ii.next();
                        jxl.write.Label labelCF = new jxl.write.Label(j,i+1,entry.getValue().toString());
                        sheet.addCell(labelCF);
                    }
                }
            }

            workbook.write();
            workbook.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void insertRe() throws BaseException {
        List<Map<String,String>> movies = new ArrayList<Map<String,String>>();
        Map jsonMap = new HashMap();
        jsonMap.put("startTime", "1111");
        jsonMap.put("name", "2222");
        jsonMap.put("sex", "3333");
        jsonMap.put("number", "4444");

        Map jsonMap1 = new HashMap();
        jsonMap1.put("startTime", "2111");
        jsonMap1.put("name", "3222");
        jsonMap1.put("sex", "4333");
        jsonMap1.put("number", "5444");
        movies.add(jsonMap);
        movies.add(jsonMap1);
        //Collections.reverse();
        getCcinfo(movies);
    }
    /*@Test
    public void insertRe() throws BaseException {
        CcRechargeHistory ccRechargeHistory =new CcRechargeHistory();
        ccRechargeHistory.setCompanyid("1001");
        ccRechargeHistory.setRechargeid("1001");
        ccRechargeHistory.setUserid("1001");
        ccRechargeHistory.setFeeamount(100.00);
        ccRechargeHistory.setGivenamount(0.00);
        ccRechargeHistory.setGiventime("2015-06-09");
        ccRechargeHistory.setHistoryid("1001");
        ccRechargeHistory.setMobilephone("13548263041");
        ccRechargeHistory.setName("lili");
        ccRechargeHistory.setOrderamount(100.00);
        ccRechargeHistory.setOrderid("1001");
        ccRechargeHistory.setOrderno("1001");
        ccRechargeHistory.setPaystatus(1);
        ccRechargeHistory.setPaytime("2015-08-09");
        ccRechargeHistory.setPaytype(1);
        ccRechargeHistory.setPresentamount(100.00);
        ccRechargeHistory.setRechargeamount(0.00);
        ccRechargeHistory.setPayamount(100.00);
        ccRechargeHistory.setShopid("1001");
        ccRechargeHistory.setShopname("lilili");
        ccRechargeHistory.setTradeno("1001");
        ccRechargeHistory.setType(1);
        boolean firstRentals = importCcmService.insertCcRechargeHistory(ccRechargeHistory);
        System.out.println(firstRentals);

    }*/

    /*@Test
    public void insertRe2() throws BaseException {
        CcRechargeHistory ccRechargeHistory =new CcRechargeHistory();
        ccRechargeHistory.setCompanyid("1001");
        ccRechargeHistory.setRechargeid("1001");
        ccRechargeHistory.setUserid("1001");
        ccRechargeHistory.setFeeamount(100.00);
        ccRechargeHistory.setGivenamount(0.00);
        ccRechargeHistory.setHistoryid("1002");
        boolean firstRentals = importCcmService.insertCcRechargeHistory(ccRechargeHistory);
        System.out.println(firstRentals);

    }*/

}
