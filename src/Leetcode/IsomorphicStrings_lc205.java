package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * cache主要是记录相同的值
 * 固定的模式即两个相似字符串出现相同单词的地方一定是一样的
 * 但是不同单词之间的关系却没有要求
 */

public class IsomorphicStrings_lc205 {
/*    private static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for(int index = 0; index < s.length() ; index++) {
            int idxS = mapS.getOrDefault(s.charAt(index), -1);
            int idxT = mapT.getOrDefault(t.charAt(index), -1);

            if (idxS != idxT) return false;

            mapS.put(s.charAt(index), index);
            mapT.put(t.charAt(index), index);
        }

        return true;
    }*/

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;

        Map<Character,Character> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (cache.containsKey(c1) ) {
                if (cache.get(c1) == c2 ) {
                    continue;
                }
                return false;
            }else {

                if (!cache.containsValue(c2)) {
                    cache.put(c1, c2);
                } else {
                    // 如果cache中包含c1却不包含c2的话，就是说c1出现过而c2没有出现过
                    // 即可断定字符串不是同构的
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //test1
        String s1 = "add";
        String t1 = "egg";

        //test2
        String s2 = "foo";
        String t2 = "bar";

        //test3
        String s3 = "paper";
        String t3 = "title";

        //test4
        String s4 = "12";
        String t4 = "34";

        //test5
        String s5 = "";
        String t5 = "";

        //test6
        String s6 = "abc";
        String t6 = "deh";

        System.out.println(isIsomorphic(s1, t1));
        System.out.println(isIsomorphic(s2, t2));
        System.out.println(isIsomorphic(s3, t3));
        System.out.println(isIsomorphic(s4, t4));
        System.out.println(isIsomorphic(s5, t5));
        System.out.println(isIsomorphic(s6, t6));
    }
}

/* Output:
true
false
true
true
true
true
*///:~
