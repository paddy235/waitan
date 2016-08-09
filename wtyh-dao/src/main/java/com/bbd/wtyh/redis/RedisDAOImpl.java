package com.bbd.wtyh.redis;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Wen Jie
 *
 */
@Repository("redisDao")
public class RedisDaoImpl implements RedisDao {
	@Override
	public boolean addObject(String key, Object object, Long timeout, Class<?> clazz) {
		return false;
	}

	@Override
	public Object getObject(String key) {
		return null;
	}

	@Override
	public boolean addString(String key, String value, Long timeout) {
		return false;
	}

	@Override
	public boolean addString(Map<String, String> keyValueList, Long timeout) {
		return false;
	}

	@Override
	public String getString(String key) {
		return null;
	}

	@Override
	public boolean addHash(String key, String field, String value, Long timeout) {
		return false;
	}

	@Override
	public boolean addHash(String key, Map<String, String> fieldValueList, Long timeout) {
		return false;
	}

	@Override
	public Object getHashField(String key, String field) {
		return null;
	}

	@Override
	public Map<byte[], byte[]> getHashAll(String key) {
		return null;
	}

	@Override
	public void delete(String key) {

	}

	@Override
	public Long push(String key, String value) {
		return null;
	}

	@Override
	public String pop(String key) {
		return null;
	}

	@Override
	public Long in(String key, String value) {
		return null;
	}

	@Override
	public String out(String key) {
		return null;
	}

	@Override
	public Long length(String key) {
		return null;
	}

	@Override
	public List<Object> range(String key, int start, int end) {
		return null;
	}

	@Override
	public void remove(String key, long i, String value) {

	}

	@Override
	public String index(String key, long index) {
		return null;
	}

	@Override
	public void set(String key, long index, String value) {

	}

	@Override
	public void trim(String key, long start, int end) {

	}

	@Override
	public Long addSet(String key, String value, Long timeout) {
		return null;
	}

	@Override
	public Set<byte[]> getSet(String key) {
		return null;
	}

//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//
//	/**
//	 * 设置对象
//	 *
//	 * @param key
//	 * @param object
//	 * @param timeout
//	 * @param clazz
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean addObject(final String key, final Object object, final Long timeout, Class<?> clazz) {
//		redisTemplate.opsForValue().set(key, clazz.cast(object));
//		return true;
//	}
//
//	/**
//	 * 获得对象
//	 *
//	 * @param key
//	 * @return
//	 */
//	public Object getObject(final String key) {
//		return redisTemplate.opsForValue().get(key);
//	}
//
//	// ---------------------------------------String-----------------------------------------
//
//	/**
//	 * 新增String ----setNX 不存在则增加 ------------------------------
//	 *
//	 * @param key
//	 *            键
//	 * @param value
//	 *            值
//	 * @param timeout
//	 *            超时(秒)
//	 * @return true 操作成功，false 已存在值
//	 */
//	public boolean addString(final String key, final String value, final Long timeout) {
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				Boolean result = false;
//				try {
//					result = connection.setNX(key.getBytes(Constants.CHARACTER_CODE), value.getBytes(Constants.CHARACTER_CODE));
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
//				if (result == false)
//					return result;
//				if (timeout != null && timeout > 0)
//					connection.expire(key.getBytes(), timeout);
//				return result;
//			}
//		});
//		return result;
//	}
//
//	/**
//	 * 批量新增String---setNx 不存在则增加
//	 *
//	 * @param keyValueList
//	 *            键值对的map
//	 * @param timeout
//	 *            超时处理
//	 * @return
//	 */
//	public boolean addString(final Map<String, String> keyValueList,
//			final Long timeout) {
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			public Boolean doInRedis(RedisConnection connection)
//					throws DataAccessException {
//				for (String key : keyValueList.keySet()) {
//					connection.setNX(key.getBytes(), keyValueList.get(key)
//							.getBytes());
//					if (timeout != null && timeout > 0)
//						connection.expire(key.getBytes(), timeout);
//				}
//				return true;
//			}
//		}, false, true);
//		return result;
//	}
//
//	/**
//	 * 通过key获取单个
//	 *
//	 * @param key
//	 * @return
//	 */
//	public String getString(final String key) {
//		String value = redisTemplate.execute(new RedisCallback<String>() {
//			public String doInRedis(RedisConnection connection) throws DataAccessException {
//				byte[] result;
//				try {
//					result = connection.get(key.getBytes(Constants.CHARACTER_CODE));
//					if (result != null && result.length > 0) {
//						return new String(result, Constants.CHARACTER_CODE);
//					}
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return null;
//			}
//		});
//		return value;
//	}
//
//	/**
//	 * 修改 String
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	/*
//	 * 重新Set等于Update public boolean updateString(final String key, final String
//	 * value) { if (getString(key) == null) { throw new
//	 * NullPointerException("数据行不存在, key = " + key); } boolean result =
//	 * redisTemplate.execute(new RedisCallback<Boolean>() { public Boolean
//	 * doInRedis(RedisConnection connection) throws DataAccessException {
//	 * connection.set(key.getBytes(), value.getBytes()); return true; } });
//	 * return result; } /
//	 *
//	 * //
//	 * ---------------------------------------List----------------------------
//	 * ------------- /** 新增Hash ----setNX 不存在则增加 ------------------------------
//	 *
//	 * @param key 键
//	 *
//	 * @param value 值
//	 *
//	 * @param timout 超时(秒)
//	 *
//	 * @return true 操作成功，false 已存在值
//	 */
//	public boolean addHash(final String key, final String field,
//			final String value, final Long timeout) {
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			public Boolean doInRedis(RedisConnection connection)
//					throws DataAccessException {
//				Boolean result = connection.hSetNX(key.getBytes(),
//						field.getBytes(), value.getBytes());
//				if (result == false)
//					return result;
//				if (timeout != null && timeout > 0)
//					connection.expire(key.getBytes(), timeout);
//				return result;
//			}
//		});
//		return result;
//	}
//
//	/**
//	 * 批量新增Hash ----setNX 不存在则增加 ------------------------------
//	 *
//	 * @param key
//	 *            键
//	 * @param fieldValueList
//	 *            值
//	 * @param timeout
//	 *            超时(秒)
//	 * @return true 操作成功，false 已存在值
//	 */
//	public boolean addHash(final String key,
//			final Map<String, String> fieldValueList, final Long timeout) {
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			public Boolean doInRedis(RedisConnection connection)
//					throws DataAccessException {
//				for (String hashKey : fieldValueList.keySet()) {
//					connection.hSetNX(key.getBytes(), hashKey.getBytes(),
//							fieldValueList.get(hashKey).getBytes());
//					if (timeout != null && timeout > 0)
//						connection.expire(key.getBytes(), timeout);
//				}
//				return true;
//			}
//		});
//		return result;
//	}
//
//	/**
//	 * 通过key获取单个
//	 *
//	 * @param key
//	 * @return
//	 */
//	public Object getHashField(final String key, final String field) {
//		String value = redisTemplate.execute(new RedisCallback<String>() {
//			public String doInRedis(RedisConnection connection)
//					throws DataAccessException {
//				return new String(connection.hGet(key.getBytes(),
//						field.getBytes()));
//			}
//		});
//		return value;
//	}
//
//	/**
//	 * 通过key获取整个Hash
//	 *
//	 * @param key
//	 * @return
//	 */
//	public Map<byte[], byte[]> getHashAll(final String key) {
//		Map<byte[], byte[]> value = redisTemplate
//				.execute(new RedisCallback<Map<byte[], byte[]>>() {
//					public Map<byte[], byte[]> doInRedis(
//							RedisConnection connection)
//							throws DataAccessException {
//						return connection.hGetAll(key.getBytes());
//					}
//				});
//		return value;
//	}
//
//	// ---------------------------------------------------通用删除-------------------------------------------------
//	/**
//	 * 删除keys
//	 *
//	 * @param key
//	 */
//	public void delete(final String key) {
//		redisTemplate.execute(new RedisCallback<Long>() {
//			public Long doInRedis(RedisConnection connection)
//					throws DataAccessException {
//				try {
//					return connection.del(key.getBytes(Constants.CHARACTER_CODE));
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
//				return 0l;
//			}
//		});
//	}
//
//	// ----------------------------------------------------队列操作--------------------------------------------------
//	/**
//	 * 压栈
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public Long push(String key, String value) {
//		return redisTemplate.opsForList().leftPush(key, value);
//	}
//
//	/**
//	 * 出栈
//	 *
//	 * @param key
//	 * @return
//	 */
//	public String pop(String key) {
//		return (String) redisTemplate.opsForList().leftPop(key);
//	}
//
//	/**
//	 * 入队
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public Long in(String key, String value) {
//		return redisTemplate.opsForList().rightPush(key, value);
//	}
//
//	/**
//	 * 出队
//	 *
//	 * @param key
//	 * @return
//	 */
//	public String out(String key) {
//		return (String) redisTemplate.opsForList().leftPop(key);
//	}
//
//	/**
//	 * 栈/队列长
//	 *
//	 * @param key
//	 * @return
//	 */
//	public Long length(String key) {
//		return redisTemplate.opsForList().size(key);
//	}
//
//	/**
//	 * 范围检索
//	 *
//	 * @param key
//	 * @param start
//	 * @param end
//	 * @return
//	 */
//	public List<Object> range(String key, int start, int end) {
//		return redisTemplate.opsForList().range(key, start, end);
//	}
//
//	/**
//	 * 移除
//	 *
//	 * @param key
//	 * @param i
//	 * @param value
//	 */
//	public void remove(String key, long i, String value) {
//		redisTemplate.opsForList().remove(key, i, value);
//	}
//
//	/**
//	 * 检索
//	 *
//	 * @param key
//	 * @param index
//	 * @return
//	 */
//	public String index(String key, long index) {
//		return (String) redisTemplate.opsForList().index(key, index);
//	}
//
//	/**
//	 * 置值
//	 *
//	 * @param key
//	 * @param index
//	 * @param value
//	 */
//	public void set(String key, long index, String value) {
//		redisTemplate.opsForList().set(key, index, value);
//	}
//
//	/**
//	 * 裁剪
//	 *
//	 * @param key
//	 * @param start
//	 * @param end
//	 */
//	public void trim(String key, long start, int end) {
//		redisTemplate.opsForList().trim(key, start, end);
//	}
//
//	// ---------------------------------------------------SET-----------------------------------------------
//	/**
//	 * 新增Set ----setNX 不存在则增加 ------------------------------
//	 *
//	 * @param key
//	 *            键
//	 * @param value
//	 *            值
//	 * @param timeout
//	 *            超时(秒)
//	 * @return true 操作成功，false 已存在值
//	 */
//	public Long addSet(final String key, final String value, final Long timeout) {
//		Long result = redisTemplate.execute(new RedisCallback<Long>() {
//			public Long doInRedis(RedisConnection connection)
//					throws DataAccessException {
//				Long result = connection.sAdd(key.getBytes(), value.getBytes());
//				if (result == 0)
//					return result;
//				if (timeout != null && timeout > 0)
//					connection.expire(key.getBytes(), timeout);
//				return result;
//			}
//		});
//		return result;
//	}
//
//	/**
//	 * 通过key获取单个Set
//	 *
//	 * @param key
//	 * @return
//	 */
//	public Set<byte[]> getSet(final String key) {
//		Set<byte[]> value = redisTemplate
//				.execute(new RedisCallback<Set<byte[]>>() {
//					public Set<byte[]> doInRedis(RedisConnection connection)
//							throws DataAccessException {
//						return connection.sMembers(key.getBytes());
//					}
//				});
//		return value;
//	}

}
