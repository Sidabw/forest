#   Decimal相关
### RoundingMode
* RoundingMode ：八种舍入模式。四舍五入选HALF_UP
* https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/math/RoundingMode.html
* UP:都往远离0的方向舍入。即：负数都入，正数都入。
* DOWN:都往0的方向舍入。即：负数都舍，正数都舍。
* CEILING：都往正无穷方向舍入。即：负数都舍，正数都入。
* FLOOR:都往负无穷方向舍入。即：负数都入，正数都舍。
* HALF_UP:towards the "nearest neighbor".四舍六入，五执行上边的UP.
* HALF_DOWN:towards the "nearest neighbor".四舍六入，五执行上班的DOWN.
* HALF_EVEN:towards the "nearest neighbor".四舍六入，五执行"奇偶约定".偶舍奇入。"银行家舍入模式"
* UNNECESSARY:断言计算是准确的，不会出现小数。否则跑异常。
 ### DecimalFormat
* 见test4 