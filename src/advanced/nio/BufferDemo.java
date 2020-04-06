package advanced.nio;

import java.nio.ByteBuffer;

public class BufferDemo {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);

        System.out.println("初始化：capacity 容量：" + byteBuffer.capacity() + ", position位置： " + byteBuffer.position()
        + ", limit限制： " + byteBuffer.limit());

        byteBuffer.put((byte)1);
        byteBuffer.put((byte)2);
        byteBuffer.put((byte)3);
        System.out.println("写入3字节后：capacity 容量：" + byteBuffer.capacity() + ", position位置： " + byteBuffer.position()
                + ", limit限制： " + byteBuffer.limit());
        System.out.println("开始读取");
        byteBuffer.flip();
        byte b = byteBuffer.get();
        System.out.println(b);
        byte b1 = byteBuffer.get();
        System.out.println(b1);
        System.out.println("读取2字节后：capacity 容量：" + byteBuffer.capacity() + ", position位置： " + byteBuffer.position()
                + ", limit限制： " + byteBuffer.limit());
    }
}
