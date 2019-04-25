###quartz定时框架
*   主要类有Scheduler、JobDetail、Trigger。Scheduler负责执行定时任务，JobDetail定义了具体的定时任务实现，Trigger定义定时规则。
demo可查看test/java/com/quartz
*   结合Spring：1个启动类(注入scheduler)、1个Job类定义具体做什么(TaskPerform)、一个Service定义了定时规则即怎么做(ScheduleService)

###动态创建定时任务思路

*   可以在ScheduleService中定义一个全局的定时器，定时读取数据库创建相应定时任务。
*   动态创建定时任务写在TaskPerform中，向Scheduler任务队列中添加JobDetail和CronTrigger
