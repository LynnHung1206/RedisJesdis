package ttl;

import redis.clients.jedis.Jedis;

public class TestJedisTTL {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);

		jedis.set("test", "Hello");
//		設定過期時間
		jedis.expire("test", 10);
		try {
			Thread.sleep(3000);

			System.out.println("First ttl: " + jedis.ttl("test"));

			Thread.sleep(3000);

			System.out.println("Second ttl: " + jedis.ttl("test"));

//			jedis.persist("test"); // 或 jedis.set("test", "World");
			
			Thread.sleep(4000);
//			操作資料期間異動資料會取消過期時間
			
			System.out.println(jedis.ttl("test"));
			
			System.out.println(jedis.get("test"));

		} catch (Exception e) {
		}

		jedis.close();
	}

}
