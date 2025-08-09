package com.run;

import com.bean.Business;
import com.bean.Customer;
import com.bean.Movie;
import com.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MovieSystem {
    private static final Logger LOGGER = LoggerFactory.getLogger("电影程序");

    public static final List<User> ALL_USERS = new ArrayList<>();

    public static final Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();

    public static final Scanner SC = new Scanner(System.in);
    static {
        // =====================客户数据========================
        Customer c = new Customer();
        c.setLoginName("ldh888");
        c.setPassWord("123456");
        c.setUserName("黑马刘德华");
        c.setSex('男');
        c.setMoney(10000);
        c.setPhone("110110");
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassWord("123456");
        c1.setUserName("黑马关之琳");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone("111111");
        ALL_USERS.add(c1);

        // =====================商家数据========================
        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);

        // 为包租公影城添加更多电影
        List<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setName("七品芝麻官");
        movie1.setActor("周星驰、吴孟达、张敏");
        movie1.setTime(100);
        movie1.setPrice(200);
        movie1.setNumber(100);  // 剩余票数
        movie1.setStartTime(LocalDateTime.of(2025, 8, 9, 16, 6, 0)); // 2025-08-09 16:06:00
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setName("功夫");
        movie2.setActor("周星驰、元秋、元华");
        movie2.setTime(120);
        movie2.setPrice(180);
        movie2.setNumber(150);  // 剩余票数
        movie2.setStartTime(LocalDateTime.of(2025, 8, 10, 14, 30, 0)); // 2025-08-10 14:30:00
        movies.add(movie2);

        Movie movie3 = new Movie();
        movie3.setName("大话西游");
        movie3.setActor("周星驰、朱茵、吴孟达");
        movie3.setPrice(150);
        movie3.setTime(110);
        movie3.setNumber(80);  // 剩余票数
        movie3.setStartTime(LocalDateTime.of(2025, 8, 11, 19, 0, 0)); // 2025-08-11 19:00:00
        movies.add(movie3);

        Movie movie4 = new Movie();
        movie4.setName("唐伯虎点秋香");
        movie4.setActor("周星驰、巩俐、郑佩佩");
        movie4.setPrice(160);
        movie4.setTime(95);
        movie4.setNumber(120);  // 剩余票数
        movie4.setStartTime(LocalDateTime.of(2025, 8, 12, 13, 15, 0)); // 2025-08-12 13:15:00
        movies.add(movie4);

        ALL_MOVIES.put(b, movies);

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassWord("123456");
        b2.setUserName("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);

        // 为包租婆影城添加更多电影
        List<Movie> movies3 = new ArrayList<>();

        Movie movie5 = new Movie();
        movie5.setName("无间道");
        movie5.setActor("刘德华、梁朝伟、黄秋生");
        movie5.setPrice(220);
        movie5.setTime(130);
        movie5.setNumber(90);  // 剩余票数
        movie5.setStartTime(LocalDateTime.of(2025, 8, 13, 20, 30, 0)); // 2025-08-13 20:30:00
        movies3.add(movie5);

        Movie movie6 = new Movie();
        movie6.setName("英雄本色");
        movie6.setActor("周润发、狄龙、张国荣");
        movie6.setPrice(190);
        movie6.setTime(105);
        movie6.setNumber(70);  // 剩余票数
        movie6.setStartTime(LocalDateTime.of(2025, 8, 14, 18, 45, 0)); // 2025-08-14 18:45:00
        movies3.add(movie6);

        Movie movie7 = new Movie();
        movie7.setName("东成西就");
        movie7.setActor("张国荣、林青霞、梁朝伟");
        movie7.setPrice(170);
        movie7.setTime(100);
        movie7.setNumber(110);  // 剩余票数
        movie7.setStartTime(LocalDateTime.of(2025, 8, 15, 15, 20, 0)); // 2025-08-15 15:20:00
        movies3.add(movie7);

        Movie movie8 = new Movie();
        movie8.setName("少林足球");
        movie8.setActor("周星驰、赵薇、吴孟达");
        movie8.setPrice(160);
        movie8.setTime(115);
        movie8.setNumber(130);  // 剩余票数
        movie8.setStartTime(LocalDateTime.of(2025, 8, 16, 16, 10, 0)); // 2025-08-16 16:10:00
        movies3.add(movie8);

        ALL_MOVIES.put(b2, movies3);
    }


    public static void main(String[] args) {
        showMain();
    }

    private static void showMain(){
        boolean running = true;
        while(running){
            System.out.println("===============黑马电影首页=================");
            System.out.println("1、登录");
            System.out.println("2、用户注册");
            System.out.println("3、商家注册");
            System.out.println("4、关闭系统");
            System.out.println("请输入操作命令：");

            String choice = SC.nextLine();

            switch (choice){
                case "1":
                    login();
                    LOGGER.info("用户登录");
                    break;
                case "2":
                    customerRegister();
                    LOGGER.info("用户注册");
                    break;
                case "3":
                    businessRegister();
                    LOGGER.info("商家登录");
                    break;
                case "4":
                    System.out.println("系统正在关闭...");
                    running = false; // 退出循环
                    LOGGER.info("系统关闭");
                    break;//一种更加 优雅的处理方法
                default:
                    System.out.println("命令有误，请确认！");
                    break;
            }
        }
    }
    private static void login() {
        while(true){
            System.out.println("请您输入登录名称：");
            String loginName = SC.nextLine();
            System.out.println("请您输入登录密码：");
            String passWord = SC.nextLine();
            User user  = getUserByLoginName(loginName);
            if(user != null){
                if(user.getPassWord().equals(passWord)){
                    System.out.println(user.getUserName() + "登录了系统~~~");
                    if( user instanceof Customer){
                        showCustomerMain(user);
                    } else{
                        showBusinessMain(user);
                    }
                    return;
                }else{
                    System.out.println("密码错误！");
                }
            }else{
                System.out.println("名称错误");
            }
        }
    }


    private static void customerRegister(){
        System.out.println("=====================用户注册=====================");
        Customer customer = new Customer();
        while (true){
            System.out.println("请输入用户名:");
            String loginName = SC.nextLine().trim();
            if(loginName.length()<3 || loginName.length()>30){
                System.out.println("用户名字应在3到30字符之间！");
                continue;
            }
            if(getUserByLoginName(loginName) !=null){
                System.out.println("用户名重复 ！");
                continue;
            }
            customer.setUserName(loginName);
            break;
        }

        while (true) {
            System.out.println("请输入密码：");
            String password = SC.nextLine().trim();
            if (password.length() < 6 || password.length() > 20) {
                System.out.println("密码长度必须在6-20个字符之间！");
                continue;
            }
            System.out.println("请再次输入密码：");
            String confirmPassword = SC.nextLine().trim();
            if (!password.equals(confirmPassword)) {
                System.out.println("两次输入的密码不一致！");
                continue;
            }
            customer.setPassWord(password);
            break;
        }
        while (true) {
            System.out.println("请输入真实姓名：");
            String userName = SC.nextLine().trim();
            if (userName.isEmpty()) {
                System.out.println("真实姓名不能为空！");
                continue;
            }
            customer.setUserName(userName);
            break;
        }

        while (true) {
            System.out.println("请输入性别(男/女)：");
            String sexStr = SC.nextLine().trim();
            if (sexStr.equals("男") || sexStr.equals("女")) {
                customer.setSex(sexStr.charAt(0));
                break;
            }
            System.out.println("性别输入不合法！");
        }


        // 输入电话
        while (true) {
            System.out.println("请输入电话号码：");
            String phone = SC.nextLine().trim();
            if (phone.length() < 6 || phone.length() > 15) {
                System.out.println("电话号码长度必须在6-15位之间！");
                continue;
            }
            customer.setPhone(phone);
            break;
        }

        // 初始金额设置为0
        customer.setMoney(0);

        // 添加到用户列表
        ALL_USERS.add(customer);
        System.out.println("恭喜" + customer.getUserName() + "，注册成功！");

    }
    private static void businessRegister(){
        System.out.println("===============商家注册===============");
        Business business = new Business();

        // 输入登录名
        while (true) {
            System.out.println("请输入登录名称：");
            String loginName = SC.nextLine().trim();
            if (loginName.length() < 3 || loginName.length() > 20) {
                System.out.println("登录名长度必须在3-20个字符之间！");
                continue;
            }
            if (getUserByLoginName(loginName) != null) {
                System.out.println("该登录名已被使用，请重新输入！");
                continue;
            }
            business.setLoginName(loginName);
            break;
        }

        // 输入密码
        while (true) {
            System.out.println("请输入密码：");
            String password = SC.nextLine().trim();
            if (password.length() < 6 || password.length() > 20) {
                System.out.println("密码长度必须在6-20个字符之间！");
                continue;
            }
            System.out.println("请再次输入密码：");
            String confirmPassword = SC.nextLine().trim();
            if (!password.equals(confirmPassword)) {
                System.out.println("两次输入的密码不一致！");
                continue;
            }
            business.setPassWord(password);
            break;
        }

        // 输入用户名
        while (true) {
            System.out.println("请输入真实姓名：");
            String userName = SC.nextLine().trim();
            if (userName.isEmpty()) {
                System.out.println("真实姓名不能为空！");
                continue;
            }
            business.setUserName(userName);
            break;
        }

        // 输入性别
        while (true) {
            System.out.println("请输入性别(男/女)：");
            String sexStr = SC.nextLine().trim();
            if (sexStr.equals("男") || sexStr.equals("女")) {
                business.setSex(sexStr.charAt(0));
                break;
            }
            System.out.println("性别输入不合法！");
        }

        // 输入电话
        while (true) {
            System.out.println("请输入电话号码：");
            String phone = SC.nextLine().trim();
            if (phone.length() < 6 || phone.length() > 15) {
                System.out.println("电话号码长度必须在6-15位之间！");
                continue;
            }
            business.setPhone(phone);
            break;
        }

        // 输入店铺地址
        while (true) {
            System.out.println("请输入店铺地址：");
            String address = SC.nextLine().trim();
            if (address.isEmpty()) {
                System.out.println("店铺地址不能为空！");
                continue;
            }
            business.setAddress(address);
            break;
        }

        // 输入店铺名称
        while (true) {
            System.out.println("请输入店铺名称：");
            String shopName = SC.nextLine().trim();
            if (shopName.isEmpty()) {
                System.out.println("店铺名称不能为空！");
                continue;
            }
            business.setShopName(shopName);
            break;
        }

        // 初始金额设置为0
        business.setMoney(0);

        // 添加到用户列表和商家列表
        ALL_USERS.add(business);
        ALL_MOVIES.put(business, new ArrayList<>());
        System.out.println("恭喜" + business.getUserName() + "，商家注册成功！");

    }

    private static void showCustomerMain(User loginUser){
        while (true) {
            System.out.println("============黑马电影客户界面===================");
            System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男' ? "先生" : "女士" + "欢迎您进入系统" +
                    "\t余额：" + loginUser.getMoney()));
            System.out.println("请您选择要操作的功能：");
            System.out.println("1、展示全部影片信息功能:");
            System.out.println("2、根据电影名称查询电影信息:");
            System.out.println("3、评分功能:");
            System.out.println("4、购票功能:");
            System.out.println("5、退出系统:");
            System.out.println("请输入您要操作的命令：");
            String command = SC.nextLine();
            switch (command) {
                case "1":
                    //TODO 第五步 : 展示全部排片信息
                    showAllMovie();
                    break;
                case "2":
                    selectMovieByName();
                    break;
                case "3":
                    break;
                case "4":
                    //TOdo 第六步 :  购票功能
                    buyTicket(loginUser);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    public static void showAllMovie(){//遍历：ALL_MOVIES集合[Map集合]
        Set<Map.Entry<Business, List<Movie>>> entries = ALL_MOVIES.entrySet();
        for(Map.Entry<Business, List<Movie>> entry : entries){
            //Key :   Business
            //Value:  List<Movie>

            //获取商家对象（key元素）
            Business business = entry.getKey();
            System.out.println("===========================================");
            System.out.print(business.getUserName() + "\t\t");
            System.out.print("电话: " + business.getPhone() + "\t\t");
            System.out.println("地址:" + business.getAddress());

            System.out.println("片名\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
            //获取商家下的电影列表
            List<Movie> movies = entry.getValue();
            //遍历：List集合
            for (Movie movie: movies){
                System.out.print(movie.getName() + "\t");
                System.out.print(movie.getActor() + "\t");
                System.out.print(movie.getTime() + "\t");
                System.out.print(movie.getName() + "\t");
                System.out.print(movie.getPrice() + "\t");
                System.out.print(movie.getNumber() + "\t");
                System.out.println(movie.getStartTime());
            }
        }
    }

    public static void selectMovieByName(){}

    public static void buyTicket(User loginUser){
    }
    private static void showBusinessMain(User loginUser){
        while(true){
            System.out.println("============黑马电影商家界面===================");
            System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男' ? "先生" : "女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");

            System.out.println("请输入您要操作的命令：");
            String command = SC.nextLine();
            switch (command){
                case "1":
                    showBusinessInfo(loginUser);
                    break;
                case "2":
                    addMovie(loginUser);
                    break;
                case "3":
                    removeMovie(loginUser);
                    break;
                case "4":
                    updateMovie(loginUser);
                    break;
                case "5":
                    System.out.println(loginUser.getUserName() + "请您下次再来啊~~~");
                    return;
                default:
                    System.out.println("录入指令有误,请重新选择...");
                    break;

            }
        }
    }

    public static void showBusinessInfo(User loginUser){
        System.out.println("============商家详情界面===================");

        LOGGER.info(loginUser.getUserName() + "商家，正在看自己的详情~~");

        System.out.print(loginUser.getUserName() + "\t\t");
        System.out.print("电话: " + loginUser.getPhone() + "\t\t");
        //要访问子类中特有的成员：向下转型
        Business business = (Business) loginUser;
        System.out.println("地址:" + business.getAddress());


        System.out.println("片名\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
        //遍历集合（电影列表）
        List<Movie> movies = ALL_MOVIES.get(business);
        LOGGER.trace(String.valueOf(movies));

        for (Movie movie : movies) {
            System.out.print(movie.getName() + "\t");
            System.out.print(movie.getActor() + "\t");
            System.out.print(movie.getTime() + "\t");
            System.out.print(movie.getName() + "\t");
            System.out.print(movie.getPrice() + "\t");
            System.out.print(movie.getNumber() + "\t");
            System.out.println(movie.getStartTime());
        }
    }


    public static void addMovie(User loginUser){
        System.out.println("============商家添加电影界面===================");
        LOGGER.info(loginUser.getUserName() + "商家，正在添加电影信息");
        Business business  =(Business) loginUser;

        System.out.println("请输入电影名称");
        String name = SC.nextLine();
        List<Movie> movies = ALL_MOVIES.get(business);
        LOGGER.trace(String.valueOf(movies));
        for (Movie movie : movies) {
            if(movie.getName().equals(name)){
                System.out.println("电影已经存在，请不要重复添加");
                return;
            }
        }


        System.out.println("请输入电影主演");
        String actor = SC.nextLine();


        System.out.println("请输入电影票价");
        double price ;
        while(true){
            try {
                price = Double.parseDouble(SC.nextLine());
                if(price<=0){
                    System.out.println("票价必须大于零！");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("请输入有效票价！");
            }
        }

        System.out.println("请输入电影时长");
        double  time ;
        while (true){
            try {
                time = Double.parseDouble(SC.nextLine());
                if(time<0){
                    System.out.println("电影时长必须大于零！");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("请输入正确的时间格式");
            }
        }

        System.out.println("请输入剩余票数");
        int number ;
        while (true){
            try {
                number = Integer.parseInt(SC.nextLine());
                if (number<0){
                    System.out.println("剩余票数必须大于零");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("请输入正确的票数");
            }
        }


        System.out.println("请输入电影开始时间（格式：yyyy-MM-dd HH:mm）");
        LocalDateTime startTime ;
        while (true) {
            try {
                String timeInput = SC.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                startTime = LocalDateTime.parse(timeInput, formatter);
                break;
            } catch (Exception e) {
                System.out.println("时间格式不正确，请按 yyyy-MM-dd HH:mm 格式输入，例如：2025-08-15 14:30");
            }
        }


        Movie movie = new Movie();
        movie.setName(name);
        movie.setActor(actor);
        movie.setPrice(price);
        movie.setTime(time);
        movie.setNumber(number);
        movie.setStartTime(startTime); // 使用LocalDateTime

        movies.add(movie);
        System.out.println("电影《" + name + "》添加成功！");
    }
    public static void removeMovie(User loginUser){}
    public static void updateMovie(User loginUser){}
    public static User getUserByLoginName(String loginName){
        for (User user : ALL_USERS) {
            if(user.getLoginName().equals(loginName)){
                return user ;
            }
        }
        return null;
    }
}
