package com.techsoft.timetask;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import com.techsoft.service.bill.BillWarehouseService;

public class BillPickTimeTask {
	// 此标志的作用是当前一个任务没有执行完， 下一下定时任务就不执行
	private static AtomicBoolean isRun = new AtomicBoolean(false);
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseService billWarehouseService;

	public void execute() throws Exception {
		if (isRun.get())
			return;
		if (isRun.compareAndSet(false, true)) {
			try {
				billWarehouseService.insertPickTimeTask();
				System.out.println("已执行当前时间" + new Date());
			} finally {
				isRun.set(false);
			}
		}
	}

}
