package com.ssm.block.mybatis.example3.handler;

import com.ssm.block.mybatis.example3.entity.User;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 批次抓取数据
 */
public class MyResultHandler implements ResultHandler<User> {
  // 这是每批处理的大小
  private final static int BATCH_SIZE = 1000;
  private AtomicInteger size = new AtomicInteger(0);
  // 存储每批数据的临时容器
  private Set<User> sets = new HashSet<>();

  @Override
  public void handleResult(ResultContext<? extends User> resultContext) {
//    System.out.println("--"+resultContext.getResultCount());

    // 这里获取流式查询每次返回的单条结果
    User user = resultContext.getResultObject();
    // 你可以看自己的项目需要分批进行处理或者单个处理，这里以分批处理为例
    sets.add(user);

    //模拟一批批数据处理
    int i = size.incrementAndGet();
    if (i%BATCH_SIZE==0) {
      //System.out.println("handle:"+resultContext.getResultCount());
      handle();
    }
    if(resultContext.isStopped()){
      System.out.println("stoped:"+resultContext.getResultCount());
    }
  }

  private void handle() {
    try {
      // 在这里可以对你获取到的批量结果数据进行需要的业务处理
    } finally {
      // 处理完每批数据后后将临时清空
      sets.clear();
    }
  }
}
