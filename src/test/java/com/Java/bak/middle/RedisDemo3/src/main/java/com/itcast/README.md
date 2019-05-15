原文地址：https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/

cachedemo是自定义缓存，
cachedemo2是使用springcache
cachedemo3是使用springcache+自定义（Cache AbstractCacheManager）

@Cacheable
@CacheEvict
@CachePut
以上三个注解的部分解释见com.itcast.cachedemo2.AccountService

由于springcache是给予动态代理的aop实现，所以不支持方法的this内部调用 以及 非public方法的缓存设置。
