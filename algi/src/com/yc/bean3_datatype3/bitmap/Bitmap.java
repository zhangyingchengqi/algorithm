package com.yc.bean3_datatype3.bitmap;

public class Bitmap {
    private byte[] bits;

    private int size;  //所有位的个数

    private int count = -1;  //被置位的元素个数

    public static void main(String[] args) {
        Bitmap b=new Bitmap( 16 );
        b.set(2);
        System.out.println(  b.get(2) );
    }

    /**
     *
     * @param n: 表示有多少个数字，相当于要置多少个位
     */
    public Bitmap(int n) {
        size = n;
        // 保存这么多数字的byte个数为n / 8 + 1
        //(size >> 3) + 1。右移3位相当于除以8
        bits = new byte[(size >> 3) + 1];
    }

    public  void set(int bit) {
        //set某个位的元素，需要找到元素所在的byte，然后再设置byte对应的位。
        // bit>>3相当于 n / 8,得到的就是对应byte的索引，

        // 而bit&7相当于 n % 8得到的是对应byte中的位,因为一个因为这里一个byte是8位，而8对应的二进制表示形式为1000，
        // 那么比它小1的7的二进制形式为0111。在将bit和7进行与运算的时候，所有大于第3位的高位都被置为0，只保留最低的3位。
        // 这样，最低的3位数字最小是0，最大是7.就相当于对数字8求模的运算效果
        bits[bit >> 3] |= 1 << (bit & 7);
        count = -1;
    }

    // 将特定的位置为0
    public final void clear(int bit) {
        bits[bit >> 3] &= ~(1 << (bit & 7));
        count = -1;
    }

    // 判断这一位是否被置为1。我们将这个byte和对应位为1的数字求与运算，如果结果不是0，则表示它被置为1
    public final boolean get(int bit) {
        return (  bits[bit >> 3]  &  (1 << (bit & 7)))    != 0;
    }

    /**
     * 本函数用于统计位图中总共有多少个1.
     * @return
     */
    public final int count() {
        // count==-1说明位图修改过，里面可能存有1.
        if (count == -1) {
            int c = 0;
            int end = bits.length; //有多少个 byte
            for (int i = 0; i < end; i++)
                // bit[i] && 0xff运算之后得到的是一个8位的数字，范围从0到255
                //而这个结果正好对应到BYTE_COUNTS数组中，可以出也这个数字转为二进制后包含的1的个数
                //然后累加即可
                c += BYTE_COUNTS[   bits[i] & 0xFF   ];
            count = c;
        }
        return count;
    }

    //BYTE_COUNTS的数组。里面记录了对应一个数字1的个数.
    //数字0有0个1， 1有1个1， 2有1个1，3有2个1...。在一个byte里面，最多有256种
    private static final byte[] BYTE_COUNTS = {
            0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4,
            1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
            1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
            2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
            1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
            2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
            2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
            3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
            1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
            2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
            2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
            3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
            2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
            3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
            3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
            4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8
    };


}
