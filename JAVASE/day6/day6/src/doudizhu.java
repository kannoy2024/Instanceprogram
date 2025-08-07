import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Logger;

public class doudizhu {
    private static final Logger logger = Logger.getLogger("LogBackDemo");

    public static void main(String[] args) {
        // 1.准备牌
        logger.info("准备牌");
        Map<Integer, String> poker = new HashMap<>();
        List<Integer> pokerNumber = new ArrayList<>();

        int index = 0;
        poker.put(index, "大王");
        pokerNumber.add(index);
        index++;
        poker.put(index, "小王");
        pokerNumber.add(index);
        index++;

        String[] colors = { "♠", "♥", "♣", "♦" };
        String[] numbers = { "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                poker.put(index, colors[j] + numbers[i]);
                pokerNumber.add(index);
                index++;
            }
        }

        System.out.println(poker);
        // 2.洗牌

        logger.info("开始洗牌");
        Collections.shuffle(pokerNumber);

        System.out.println(pokerNumber);
        // 3.发牌
        logger.info("开始发牌");
        TreeSet<Integer> player01 = new TreeSet<>();

        TreeSet<Integer> player02 = new TreeSet<>();

        TreeSet<Integer> player03 = new TreeSet<>();

        TreeSet<Integer> dipai = new TreeSet<>();

        for (int i = 0; i < pokerNumber.size(); i++) {
            if (i > 50) {
                dipai.add(pokerNumber.get(i));
            } else if (i % 3 == 0) {
                player01.add(pokerNumber.get(i));
            } else if (i % 3 == 1) {
                player02.add(pokerNumber.get(i));
            } else if (i % 3 == 2) {
                player03.add(pokerNumber.get(i));
            }
        }

        System.out.println("玩家1：" + player01);
        System.out.println("玩家2：" + player02);
        System.out.println("玩家3：" + player03);
        System.out.println("底牌：" + dipai);

        System.out.println("--------------------------------------");
        lookPoker("玩家1", player01, poker);
        lookPoker("玩家2", player02, poker);
        lookPoker("玩家3", player03, poker);
        lookPoker("底牌", dipai, poker);
        // 4.看牌

    }

    public static void lookPoker(String name, TreeSet<Integer> treeSet, Map<Integer, String> poker) {
        System.out.println(name + "的牌是：");
        for (Integer TreeSet : treeSet) {
            String poker1 = poker.get(TreeSet);
            System.out.print(poker1 + " ");
        }
        System.out.println("----------------------------");
    }
}
