package com.wp.main.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 简化路径
 * 给你一个字符串 path，表示指向某一文件或目录的Unix风格绝对路径（以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点（..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 * 任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 请注意，返回的规范路径必须遵循下述格式：
 * 始终以斜杠'/'开头。
 * 两个目录名之间必须只有一个斜杠'/'。
 * 最后一个目录名（如果存在）不能 以'/'结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的规范路径。
 * <p>
 * 示例 1：
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * <p>
 * 示例 3：
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * 提示：
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 * @Author admin
 * @Date 2023/7/18 9:23
 */
public class LeetCode71_Failure {
    public static void main(String[] args) {
        System.out.println(standardExecution("/home/"));
        System.out.println(standardExecution("/../"));
        System.out.println(standardExecution("/home//foo/"));
        System.out.println(standardExecution("/a/./b/../../c/"));
    }

    /**
     * 官方解法：因为每个"/"后都是目录，因此以"/"为分隔符获取所有目录，不仅可以排除多个"/"，还可以直接获得"."或".."等目录结构进行处理
     * 利用双端队列结构装入目录，如果遇到"."则不作处理，如果遇到".."则弹出栈中的目录即可获得上一级目录
     *
     * @param path
     * @return
     */
    public static String standardExecution(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }


    /**
     * 个人思路：遍历字符串，记录/和.出现的记录，按照规则简化路径
     * 1、出现'.'和'..'则要进行简化处理：
     * （1）出现'.'需要连带清除其上一位的'/'，即清除'./'
     * （2）出现'..'需要连带清除其上一位的'/'，即清除'../'，然后将记录的目录清除最近添加的目录，判断如果只剩下'/'则已到达根目录，不要清除'/'
     * <p>
     * 2、简化规则：
     * （1）必须以'/'开头
     * （2）目录名之间必须有且只能有1个'/'
     * （3）最后一个目录名(如果存在)不能以'/'结尾
     * （4）路径中的'.'和'..'都要按规则简化掉
     * （5）多个'/'视为一个'/',多个'...'视为文件或目录名称
     * <p>
     * 3、记录有效的路径信息至StringBuilder
     *
     * @param path 路径参数
     * @return 标准路径
     */
    private static String individualExecution(String path) {
        char[] pathCharArray = path.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        /** path整体逻辑处理*/
        for (int i = 0; i < pathCharArray.length; i++) {
            // 1、首位不是'/'则非绝对路径，返回null
            if (pathCharArray[0] != '/') {
                return null;
            }
            // 2、最后一位是'/'则忽略
            if (i == pathCharArray.length - 1 && pathCharArray[i] == '/') {
                continue;
            }
            // 3、出现'.'需要连带清除其上一位的'/'，即清除'./'
            if (pathCharArray[i] == '.' && i < pathCharArray.length - 2 && pathCharArray[i + 1] != '.') {
                continue;
            }
            // 4、出现'..'需要连带清除其上一位的'/'和下一位的'.'，即清除'/..'
            // 然后将记录的目录清除最近添加的目录以及上一层的目录，判断如果只剩下'/'则已到达根目录，不要清除'/'
            if (pathCharArray[i] == '.' && i < pathCharArray.length - 2 && pathCharArray[i + 1] == '.') {
                i = i + 1;
                if (stringBuilder.lastIndexOf("/") != 0) {
                    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("/"));
                    stringBuilder.delete(stringBuilder.lastIndexOf("/") + 1, stringBuilder.length());
                }
                continue;
            }
            // 5、出现'///'则视为1个'/'，即如果除首位外，已拼接的stringBuilder中的最后一位已经是'/'，再出现'/'就忽略
            if (i > 0 && pathCharArray[i] == '/' && stringBuilder.charAt(stringBuilder.length() - 1) == '/') {
                continue;
            }
            // 记录有效的路径字符
            stringBuilder.append(pathCharArray[i]);
        }

        return stringBuilder.toString();
    }
}
