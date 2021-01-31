package sword_009_yong_liang_ge_zhan_shi_xian_dui_lie_lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    private final Deque<Integer> queueIn;
    private final Deque<Integer> queueOut;

    public CQueue() {
        this.queueIn = new LinkedList<>();
        this.queueOut = new LinkedList<>();
    }

    public void appendTail(int value) {
        this.queueIn.push(value);
    }

    public int deleteHead() {
        if (queueOut.isEmpty()) {
            while (!queueIn.isEmpty()) {
                queueOut.push(queueIn.pop());
            }
        }
        if (queueOut.isEmpty()) {
            return -1;
        }
        return queueOut.pop();
    }
}
