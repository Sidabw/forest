
###     lambda/Interface的关系
Interface MyActionInterface can be called by a lambda expression, 
only because it contains exactly one abstract method declaration.
You can use annotation @FunctionInterface to ensure the interface 
meets your requirements of only contained one abstract method.

###     ::keyword
Java 8 enables you to pass references of methods or constructors 
to the only abstract method defined in your function interface 
via the :: keyword .
可以用:: 关键字替换lambda表达式

###     stream 的具体用法,	http://ifeve.com/stream/

####     map
接受的是Function	1进1出。可以写成User::getAge	此时User为进，getAge的结果为出
####    foreach
接受的是Consumer  只进不出。
但是需要 1个i++或者需要 1个boolean时，必须用AtomicInteger or AtomicBollean
####    distinct
对于Stream中包含的元素进行去重操作（去重逻辑依赖元素的equals方法），新生成的Stream中
没有重复的元素；
####    filter
过滤 对于Stream中包含的元素使用给定的过滤函数进行过滤操作，新生成的Stream只包含符合
条件的元素；
####    map
转换 对于Stream中包含的元素使用给定的转换函数进行转换操作，新生成的Stream只包含转换
生成的元素。
这个方法有三个对于原始类型的变种方法，分别是：mapToInt，mapToLong和mapToDouble。
这三个方法也比较好理解，比如mapToInt就是把原始Stream转换成一个新的Stream，
这个新生成的Stream中的元素都是int类型。之所以会有这样三个变种方法，
可以免除自动装箱/拆箱的额外消耗；
####    latMap
和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中；
####    peek
生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），
新Stream每个元素被消费的时候都会执行给定的消费函数；
####    limit
对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，
那就获取其所有的元素；
####    skip
返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素
个数小于N，那么返回空Stream；


