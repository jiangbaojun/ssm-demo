package com.ssm.block.spring.life;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * 单纯使用Lifecycle接口，必须显示调用applicationContext的start和close方法，周期回调才会执行
 * 
 */
@Component
//public class HelloLifeCycle implements Lifecycle {
public class HelloLifeCycle implements SmartLifecycle {
    private volatile boolean running = false;

    public HelloLifeCycle() {
        System.out.println("构造方法!!!");
    }

   
    @Override
    public void start() {
        System.out.println("lifycycle start");
        running = true;

    }
   @Override
    public void stop() {
        System.out.println("lifycycle stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }


	@Override
	public int getPhase() {
		// TODO Auto-generated method stub
		return 0;
	}


	/**************************** 这两个方法是SmartLifecycle提供的 ****************************************/
	@Override
	public boolean isAutoStartup() {
		return true;
	}


	@Override
	public void stop(Runnable callback) {
		System.out.println("SmartLifecycle stop");
	}
}