package com.run;

import com.bean.Business;
import com.bean.Customer;
import com.bean.Movie;
import com.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        // 注意，商家一定需要加入到店铺排片信息中去
        // 后期在为此商家添加排片信息
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie();
        movie1.setName("七品芝麻官");
        movie1.setPrice(200);
        movie1.setTime(100);
        movies.add(movie1);
        ALL_MOVIES.put(b, movies); // b = []

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
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b2, movies3); // b2 = []
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
        LOGGER.trace(String.valueOf(movies));//仅在开发中使用（通过设置日志级别，可以关闭输出）

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
    public static void addMovie(User loginUser){}
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
