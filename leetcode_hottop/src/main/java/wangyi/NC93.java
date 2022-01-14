package wangyi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC
 * @description :TODO 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 k ，并有如下两个功能
 * 1. set(key, value)：将记录(key, value)插入该结构
 * 2. get(key)：返回key对应的value值
 * @date 2022/1/11 13:09
 */




public class NC93 {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        List<Integer> list = new ArrayList<>();
        NC93 lru = new NC93(k);
        for (int[] op : operators) {
            int type = op[0];
            if (type == 1) {
                // set(k,v) 操作
                lru.put(op[1], op[2]);
            } else {
                // get(k) 操作
                list.add(lru.get(op[1]));
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }


    class Node {
        int k, v;
        Node l, r;
        Node(int _k, int _v) {
            k = _k;
            v = _v;
        }
    }
    int n;
    Node head, tail;
    Map<Integer, Node> map;
    public NC93(int capacity) {
        n = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.v = value;
        } else {
            if (map.size() == n) {
                Node del = tail.l;
                map.remove(del.k);
                delete(del);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        refresh(node);
    }

    // refresh 操作分两步：
    // 1. 先将当前节点从双向链表中删除（如果该节点本身存在于双向链表中的话）
    // 2. 将当前节点添加到双向链表头部
    void refresh(Node node) {
        delete(node);
        node.r = head.r;
        node.l = head;
        head.r.l = node;
        head.r = node;
    }

    // delete 操作：将当前节点从双向链表中移除
    // 由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.l 不为空，则代表了 node 本身存在于双向链表（不是新节点）
    void delete(Node node) {
        if (node.l != null) {
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }
    }
}
