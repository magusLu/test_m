import java.util.ArrayList;
import java.util.List;

public class Mianshi {

    /**1.
     * 思路： 将字符串s和t分解为一个个单词存到数组中
     * 遍历每一个s中的单词在t中的单词是否存在，第一次出现相同的就结束函数，遍历结束没有相同的就输出null
     * 时间复杂度：O(n方)
     * 空间复杂度：O（n）
     */
    private static void getSameWord(String s, String t) {
        String[] sWords = getChars(s);//获取s单词
        String[] tWords = getChars(t);//获取t单词
        for (String sWord : sWords) {
            for (String tWord : tWords) {
                //如果出现相同的，就直接返回结果，结束函数
                if (sWord.equals(tWord)) {
                    System.out.println("返回结果：" + sWord);
                    return;
                }
            }
        }
        System.out.println("无结果：NULL");
    }

    /**
     * 获取字符串中包含的单词
     * 第一个字符是字符串长度
     *
     * @param word
     * @return
     */
    private static String[] getChars(String word) {
        char[] chars = word.toCharArray();
        String words[] = new String[chars.length];
        int wordsNum = 0;
        StringBuilder splitWord = new StringBuilder();
        for (int charIndex = 0; charIndex < chars.length; charIndex++) {
            if (chars[charIndex] != ' ') {
                splitWord.append(chars[charIndex]);
            } else {
                words[wordsNum++] = splitWord.toString();
                splitWord.delete(0, splitWord.length());
            }
        }
        //去掉words中多余的长度
        String[] resultWords = new String[wordsNum+1];
        while(wordsNum >= 0){
            resultWords[wordsNum] = words[wordsNum];
            wordsNum--;
        }
        return resultWords;
    }

    /**2.
     * 思路：范围首先缩小：在n/2+1 左半部分 因为右半部分一加就超界了
     * 循环遍历从头开始相加与num相等的数字，记录i 和j   也就是起始和终止的点，在输出。
     * 时间复杂度为：O（n（n-1））
     * 空间复杂度为：O（2n）
     *
     * @param num
     */
    private static void getNumList(int num) {
        if (num > 10000) {
            System.out.println("不能超过10000");
            return;
        }
        //存放结果的数组
        List<int[]> numList = new ArrayList<int[]>();
        //最大值不会超过num/2+2
        int maxNum = num / 2 + 2;
        int count = 0;
        for (int startNumIndex = num; startNumIndex < maxNum; startNumIndex++) {
            count = startNumIndex;
            int[] result = new int[2];
            for (int lastNumIndex = startNumIndex + 1; startNumIndex < maxNum; lastNumIndex++) {
                count = count + lastNumIndex;
                if (count == num) {
                    //记录起始点
                    result[0] = startNumIndex;
                    result[1] = lastNumIndex;
                    numList.add(result);
                } else if (count > num) {
                    break;
                }
            }
        }
        //如果有连续整数结果就输出，否则返回none
        if (numList.size() > 0) {
            //遍历所有满足的数组
            for (int[] resultNum : numList) {
                System.out.print(resultNum[0] + " ");
                int cycle = resultNum[0] + 1;
                while (cycle < resultNum[1]) {
                    System.out.print(cycle + " ");
                    cycle++;
                }
                System.out.println(resultNum[1]);
            }
        } else {
            System.out.println("none");
        }

    }

    /** 3.
     * 在线预览word
     * @param args
     */
//  1.直接访问：  <iframe src='https://view.officeapps.live.com/op/view.aspx?src=http://storage.xuetangx.com/public_assets/xuetangx/PDF/1.xls' width='100%' height='100%' frameborder='1'></iframe>
//    2. 将word转换成pdf，在通过pdf的预览方法进行预览 转换方法如 调用openOffice服务

//    在线预览pdf：
//    目前我司使用pdf.js进行预览，之前公司购买的i do view 服务。


    public static void main(String[] args) {
//        getNumList(123);
//        getSameWord("his s C for programming text", "This is a text for C programming");
    }

}
