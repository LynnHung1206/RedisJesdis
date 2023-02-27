package basic;

import redis.clients.jedis.Jedis;

public class HelloJedis {

	public static void main(String[] args) {
		Jedis jedis = null;
//		要操作要先拿到Jedis物件 直接new就可以了,想成connection
		try {
			jedis = new Jedis("localhost", 6379);
			System.out.println(jedis.ping());
		} finally {
//		歸還連線
			if (jedis != null)
				jedis.close();
		}
	}
}
