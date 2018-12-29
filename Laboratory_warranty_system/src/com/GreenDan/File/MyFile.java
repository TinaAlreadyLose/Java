package com.GreenDan.File;

import com.sun.mail.imap.protocol.ID;

import java.io.*;


/**
 * 通过json 数组来存储信息
 *
 * @author GreenDan
 */
public class MyFile {


    /**
     * @return 返回左右数据的字符串集合
     */
    public String GetAllData_ByGson() {
        String encoding = "UTF-8";
        File file = new File("data.txt");
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read(filecontent);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.out.println("编码不符合规范");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param ID     订单账号
     * @param Name   产品名称
     * @param Date   发生日期
     * @param Place  发生地点
     * @param Type   故障类型
     * @param Reason 故障原因
     * @param Solve  处理策略
     * @return 插入数据是否成功
     */
    public boolean AddData_ByGson(String ID, String Name, String Date, String Place, String Type, String Reason, String Solve) {
        try {
            FileWriter fileWriter = new FileWriter("data.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(ID + "\t");
            bufferedWriter.write(Name + "\t");
            bufferedWriter.write(Date + "\t");
            bufferedWriter.write(Place + "\t");
            bufferedWriter.write(Type + "\t");
            bufferedWriter.write(Reason + "\t");
            bufferedWriter.write(Solve + "\t");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param id 根据订单号码来查询数据
     * @return 返回查询的字符串，null代表没找到
     */
    public String searchById_ByGson(String id) {
        int number = Integer.parseInt(id)+1;
        String txt = "";
        try {
            FileReader fileReader = new FileReader("data.txt");
            LineNumberReader reader = new LineNumberReader(fileReader);
            int lines = 0;

            while (txt != null) {
                lines++;

                txt = reader.readLine();
                if (lines == number) {
                    return txt;
                }
            }
            return txt;
        } catch (IOException e) {
            e.printStackTrace();
            return txt;
        }


    }

    public static void main(String[] args) {
        MyFile myFile = new MyFile();
        System.out.println(myFile.GetAllData_ByGson());
    }
}
