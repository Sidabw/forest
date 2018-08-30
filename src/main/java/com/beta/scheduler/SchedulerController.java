package com.beta.scheduler;

import com.beta.scheduler.Iservice.ISchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 *  Created by shao.guangze on 2018/8/8
 */
@RestController
@RequestMapping("scheduler")
public class SchedulerController {

    @Autowired
    private ISchedulerService schedulerService;

    /***
     * 更改现有的scheduler
     * @return
     */
    @RequestMapping(value = "editSchduler", method = RequestMethod.POST)
    public String createScheduler(){
        System.out.println("Controller In!");
        schedulerService.schedulerJob();
        return "{\"result\":\"create scheduler success!\"}";
    }
}
