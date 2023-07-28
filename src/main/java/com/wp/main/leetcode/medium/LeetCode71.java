package com.wp.main.leetcode.medium;

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
public class LeetCode71 {
    public static void main(String[] args) {
        System.out.println(individualExecution("/home/"));
        System.out.println(individualExecution("/../"));
        System.out.println(individualExecution("/home//foo/"));
        System.out.println(individualExecution("/a/./b/../../c/"));
    }

    /**
     * 个人思路：遍历字符串，记录/和.出现的记录，按照规则简化路径
     * 1、出现'.'和'..'则要进行简化处理：
     * （1）出现'.'需要连带清除其下一位的'/'，即清除'./'
     * （2）出现'..'需要连带清除其下一位的'/'，即清除'../'，然后将记录的目录清除最近添加的目录，判断如果只剩下'/'则已到达根目录，不要清除'/'
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
            if (pathCharArray[pathCharArray.length - 1] == '/') {
                continue;
            }
            // 3、出现'.'需要连带清除其下一位的'/'，即清除'./'
            if (pathCharArray[i] == '.' && i < pathCharArray.length - 2 && pathCharArray[i + 1] != '.') {
                i = i + 1;
                continue;
            }
            // 4、出现'..'需要连带清除其下一位的'/'，即清除'../'，然后将记录的目录清除最近添加的目录，判断如果只剩下'/'则已到达根目录，不要清除'/'
            if (pathCharArray[i] == '.' && i < pathCharArray.length - 2 && pathCharArray[i + 1] == '.') {
                i = i + 2;
                stringBuilder.delete(stringBuilder.lastIndexOf("/") + 1, stringBuilder.length());
                continue;
            }
            // 记录有效的路径字符
            stringBuilder.append(pathCharArray[i]);
        }

        return stringBuilder.toString();
    }
}
