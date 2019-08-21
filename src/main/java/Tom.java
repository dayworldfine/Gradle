import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

/**
 * @ClassName: Tom
 * @project:
 * @author: 13620
 * @Date: 2019/8/18
 * @Description:
 * @Version: V1.0
 */
public class Tom implements ActionListener{
    private static int totalTime = 40;
    private static float totalDiff = 0.0f;
    private TextField title,userName,passWord,other,find,del;
    private TextArea taLog;         //日志输出区域 不可以设置颜色相关
    private JButton jbtAll,jbtFind,jbtAdd,jbtdel;       //开始按钮

    public void run(){
        //创建窗体，JFrame
        JFrame jFrame = new JFrame("Tom密码管理");
        Font font = new Font("宋体",Font.BOLD,16);
        // 创建按钮
         jbtAll = new JButton("所有");
         jbtAll.addActionListener(this);
         jbtFind = new JButton("查找");
         jbtFind.addActionListener(this);
        jbtAdd = new JButton("添加");
        jbtAdd.addActionListener(this);
        jbtdel = new JButton("删除");
        jbtdel.addActionListener(this);
        // 创建相关的文本域
        title = new TextField("");
        userName = new TextField("");
        passWord = new TextField("");
        other = new TextField("");
        find = new TextField("");
        del = new TextField("");

        //创建日志
        taLog = new TextArea();
        taLog.setColumns(30);
        taLog.setRows(150);
        taLog.setBackground(Color.CYAN);
        taLog.setFont(new Font("宋体",Font.BOLD,16));
        taLog.setEditable(false);


        // 创建相关的Label标签
        JLabel jLabelTitle = new JLabel("标题");
        JLabel jLabelUserName = new JLabel("账号");
        JLabel jLabelPassWord = new JLabel("密码");
        JLabel jLabelOther = new JLabel("其他");
        JLabel jLabelUtil = new JLabel("功能");
        JLabel jLabelUtils = new JLabel("功能");
        JLabel jLabelUtilss = new JLabel("功能");
        JLabel jLabelJbtFind = new JLabel("根据标题查找");
        JLabel jLabelJbtDel = new JLabel("根据标题删除");
        JLabel labelLog = new JLabel("结果");
        JLabel tellYouOne = new JLabel("<html>Tom:特别制作:<br>数据保存路径为D:\\tomShow\\tomShow.txt<br>如果没有D盘无法使用此软件</html>");
        JLabel tellYouTwo = new JLabel("<html>Tom:简单说明:<br>如有bug请留言谢谢<br>邮箱:136207024@qq.com</html>");

        //添加账号
        JPanel jPaneAddText = new JPanel(new GridLayout(2, 5));
        jPaneAddText.add(jLabelTitle);
        jPaneAddText.add(jLabelUserName);
        jPaneAddText.add(jLabelPassWord);
        jPaneAddText.add(jLabelOther);
        jPaneAddText.add(jLabelUtil);
        jPaneAddText.add(title);
        jPaneAddText.add(userName);
        jPaneAddText.add(passWord);
        jPaneAddText.add(other);
        jPaneAddText.add(jbtAdd);

        //查找标题
        JPanel jPaneFind = new JPanel(new GridLayout(2,2));
        jPaneFind.add(jLabelJbtFind,BorderLayout.CENTER);
        jPaneFind.add(jLabelUtils);
        jPaneFind.add(find,BorderLayout.CENTER);
        jPaneFind.add(jbtFind);

        //根据标题删除
        JPanel jPaneDel = new JPanel(new GridLayout(2,2));
        jPaneDel.add(jLabelJbtDel,BorderLayout.CENTER);
        jPaneDel.add(jLabelUtilss);
        jPaneDel.add(del,BorderLayout.CENTER);
        jPaneDel.add(jbtdel);

        //查找结果
        JPanel jPaneLog = new JPanel(new GridLayout(2,1));
        jPaneLog.add(labelLog);
        jPaneLog.add(taLog);


        //所有按钮
        JPanel jPaneButton = new JPanel(new GridLayout(1,3));
        jPaneButton.add(tellYouOne);
        jPaneButton.add(jbtAll);
        jPaneButton.add(tellYouTwo);

        //最父级容器
        JPanel jPanelAll = new JPanel(new GridLayout(5,1));
        jPanelAll.add(jPaneAddText);
        jPanelAll.add(jPaneFind);
        jPanelAll.add(jPaneDel);
        jPanelAll.add(jPaneLog);
        jPanelAll.add(jPaneButton);

        jFrame.setLayout(new BorderLayout());
        jFrame.add(jPanelAll,BorderLayout.CENTER);

        // 初始化JFrame窗口
        jFrame.setLocation(800, 300);
        jFrame.setSize(700, 600);
        jFrame.setBackground(Color.darkGray);

        jFrame.setResizable(true);
        jFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent view) {
        //如果等于所有
         if (view.getSource() == jbtAll){
             taLog.setText("");
             //首先创建两个路径是否存在
             File folder = new File("D:\\tomShow");
             File txt = new File("D:\\tomShow\\tomShow.txt");
             FileInputStream fis = null;
             InputStreamReader isr = null;
             BufferedReader br =null;
             //如果他们都存在的话
             if (folder.exists() && txt.exists()){
                 try {
                     fis = new FileInputStream(txt);
                     isr = new InputStreamReader(fis, "GBK");
                     br = new BufferedReader(isr);
                     String line = "";
                     while ((line = br.readLine()) != null) {
                             taLog.append(line);
                             taLog.append("\n");
                     }
                 }catch (Exception e){
                     e.printStackTrace();
                 }finally {
                     try {
                        if (br != null){
                            br.close();
                        }
                        if (isr != null){
                            isr.close();
                        }
                        if (fis != null){
                            fis.close();
                        }

                     }catch (IOException e){
                         e.printStackTrace();
                     }
                 }
             }else {
                 JOptionPane.showMessageDialog(null, "找不到数据", "没有文件", JOptionPane.ERROR_MESSAGE);
             }
         }



        //如果等于查找
        if (view.getSource() == jbtFind){
            taLog.setText("");
            //首先创建两个路径是否存在
            File folder = new File("D:\\tomShow");
            File txt = new File("D:\\tomShow\\tomShow.txt");
            FileInputStream fis = null;
            InputStreamReader isr = null;
            BufferedReader br =null;
            //如果他们都存在的话
            if (folder.exists() && txt.exists()){
                try {
                    fis = new FileInputStream(txt);
                    isr = new InputStreamReader(fis, "UTF-8");
                    br = new BufferedReader(isr);
                    String line = "";
                    String findtext = find.getText();
                    while ((line = br.readLine()) != null) {
                        if ("".equals(line)){
                            break;
                        }
                        System.err.println("line:"+line);
                        int start =line.indexOf(";");
                        String str = line.substring(3,start);
                        System.err.println("str:"+str);
                        if (str.contains(findtext)){
                            taLog.append(line);
                            taLog.append("\n");
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (br != null){
                            br.close();
                        }
                        if (isr != null){
                            isr.close();
                        }
                        if (fis != null){
                            fis.close();
                        }

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "找不到数据", "没有文件", JOptionPane.ERROR_MESSAGE);
            }
        }



        //如果等于添加
        if (view.getSource() == jbtAdd){
            //创建文件夹
            File folder = new File("D:\\tomShow");
            //判断该文件夹是否存在
            if(!folder.exists()){
                //可以创建
                try {
                    folder.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            //创建文件
            File txt = new File("D:\\tomShow\\tomShow.txt");
            //判断该文件是否存在
            if(!txt.exists()){
                //可以创建
                try {
                    txt.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (!"".equals(title.getText())&&!"".equals(userName.getText())&&!"".equals(passWord.getText())){
                // 创建相关的文本域
                FileOutputStream fos = null;
                try {
                    //末尾/r/n表示换行
                    String All = "标题:"+title.getText()+";账号:"+userName.getText()+";密码:"+passWord.getText()+";其他:"+other.getText()+"\r\n";
                    //设置为追加
                    fos = new FileOutputStream(txt,true);
                    //写入文件
                    fos.write(All.getBytes());

                    JOptionPane.showMessageDialog(null, "添加成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "添加失败", "意外", JOptionPane.ERROR_MESSAGE);
                    //字节输出流
                }finally {
                    try {
                        if (fos != null) {
                            fos.close();
                        }

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "标题账号密码请填写完整", "添加失败", JOptionPane.WARNING_MESSAGE);
            }
        }



        //如果等于删除
        if (view.getSource() == jbtdel){
            taLog.setText("");
            //首先创建两个路径是否存在
            File folder = new File("D:\\tomShow");
            File txt = new File("D:\\tomShow\\tomShow.txt");
            FileInputStream fis = null;
            InputStreamReader isr = null;
            BufferedReader br =null;
            FileOutputStream fos = null;
            String[] strings =new String[]{};

            //如果他们都存在的话
            if (folder.exists() && txt.exists()){
                try {
                    fis = new FileInputStream(txt);
                    isr = new InputStreamReader(fis, "UTF-8");
                    br = new BufferedReader(isr);
                    String line = "";
                    String delText = del.getText();
                    int a =0;
                    int b =0;
                    while ((line = br.readLine()) != null) {
                        if ("".equals(line)){
                            break;
                        }
                        a++;
                        int start =line.indexOf(";");
                        String str = line.substring(3,start);
                        if (!str.equals(delText)){
                            strings = Arrays.copyOf(strings,strings.length+1);
                            strings[strings.length-1] =line;
                            b++;
                        }
                    }
                    //设置为覆盖
                    if (strings.length!=0){
                        fos = new FileOutputStream(txt);
                        String first = strings[0]+"\r\n";
                        fos.write(first.getBytes());
                        //设置为追加
                        if (strings.length>1){
                            fos = new FileOutputStream(txt,true);
                            //写入文件
                            for (int i=1;i<strings.length;i++){
                                String spend = strings[i]+"\r\n";
                                fos.write(spend.getBytes());
                            }
                        }
                    }else {
                        fos = new FileOutputStream(txt);
                        String p ="";
                        fos.write(p.getBytes());
                    }
                    if (a == b){
                        JOptionPane.showMessageDialog(null, "删除失败,没有此标题", "失败", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "删除成功,请按所有键刷新列表", "恭喜", JOptionPane.INFORMATION_MESSAGE);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (fos != null){
                            fos.close();
                        }
                        if (br != null){
                            br.close();
                        }
                        if (isr != null){
                            isr.close();
                        }
                        if (fis != null){
                            fis.close();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "找不到数据", "没有文件", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



}
