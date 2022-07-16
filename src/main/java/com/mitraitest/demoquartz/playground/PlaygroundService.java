package com.mitraitest.demoquartz.playground;

import com.mitraitest.demoquartz.info.TimerInfo;
import com.mitraitest.demoquartz.jobs.HelloWorldJob;
import com.mitraitest.demoquartz.timerservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {this.scheduler = scheduler;}

    public void runHelloWorldJob() {
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(150);
        info.setRemainingFireCount(info.getTotalFireCount());
        info.setRepeatIntervalMs(5000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }
    public Boolean deleteTimer(final String timerId) {return scheduler.deleteTimer(timerId);}

    public List<TimerInfo> getAllRunningTimers() {return scheduler.getAllRunningTimers();}

    public TimerInfo getRunningTimer(final String timerId) {return scheduler.getRunningTimer(timerId);}
}
