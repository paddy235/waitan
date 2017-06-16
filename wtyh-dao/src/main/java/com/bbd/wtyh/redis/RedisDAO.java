package com.bbd.wtyh.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis Dao
 * 
 * @author Wen Jie
 *
 */
public interface RedisDAO {

	void set(String key, String value, Long timeout);

	public boolean addObject(final String key, final Object object,
							 final Long timeout, Class<?> clazz);

	public Object getObject(final String key);

	public boolean addString(final String key, final String value,
							 final Long timeout);

	public boolean addString(final Map<String, String> keyValueList,
							 final Long timeout);

	public String getString(final String key);

	public boolean addHash(final String key, final String field,
						   final String value, final Long timeout);

	public boolean addHash(final String key,
						   final Map<String, String> fieldValueList, final Long timeout);

	public Object getHashField(final String key, final String field);

	public Map<byte[], byte[]> getHashAll(final String key);

	public void delete(final String key);

	public Long push(String key, String value);

	public String pop(String key);

	public Long in(String key, String value);

	public String out(String key);

	public Long length(String key);

	public List<Object> range(String key, int start, int end);

	public void remove(String key, long i, String value);

	public String index(String key, long index);

	public void set(String key, long index, String value);

	public void trim(String key, long start, int end);

	public Long addSet(final String key, final String value, final Long timeout);

	public Set<byte[]> getSet(final String key);
}
