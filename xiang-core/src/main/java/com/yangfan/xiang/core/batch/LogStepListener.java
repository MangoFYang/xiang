package com.yangfan.xiang.core.batch;

import java.util.List;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.yangfan.xiang.core.infrastructure.Infrastructure;

public class LogStepListener extends Infrastructure implements StepExecutionListener, 
	ChunkListener, ItemReadListener<Object>, ItemProcessListener<Object, Object>,
	ItemWriteListener<Object>, SkipListener<Object,Object> {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.debug("批处理Step监听器LogStepListener.beforeStep被调用，参数为：stepExecution[ {} ]", stepExecution);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.debug("批处理Step监听器LogStepListener.afterStep被调用，参数为：stepExecution[ {} ]", stepExecution);
		return stepExecution.getExitStatus();
	}

	@Override
	public void beforeChunk() {
		logger.debug("批处理Step监听器LogStepListener.beforeChunk被调用");
	}

	@Override
	public void afterChunk() {
		logger.debug("批处理Step监听器LogStepListener.afterChunk被调用");
	}

	@Override
	public void beforeRead() {
		logger.debug("批处理Step监听器LogStepListener.beforeRead被调用");
	}

	@Override
	public void afterRead(Object item) {
		logger.debug("批处理Step监听器LogStepListener.afterRead被调用，参数为：item[ {} ]", item);
	}

	@Override
	public void onReadError(Exception ex) {
		logger.debug("批处理Step监听器LogStepListener.onReadError被调用，参数为：exception[ {} ]", ex);
	}

	@Override
	public void beforeProcess(Object item) {
		logger.debug("批处理Step监听器LogStepListener.beforeProcess被调用，参数为：item[ {} ]", item);
	}

	@Override
	public void afterProcess(Object item, Object result) {
		logger.debug("批处理Step监听器LogStepListener.afterProcess被调用，参数为：item[ {} ], result[ {} ]", item, result);
	}

	@Override
	public void onProcessError(Object item, Exception e) {
		logger.debug("批处理Step监听器LogStepListener.onProcessError被调用，参数为：item[ {} ], exception[ {} ]", item, e);
	}

	@Override
	public void beforeWrite(List<? extends Object> items) {
		logger.debug("批处理Step监听器LogStepListener.beforeWrite被调用，参数为：items[ {} ]", items);
	}

	@Override
	public void afterWrite(List<? extends Object> items) {
		logger.debug("批处理Step监听器LogStepListener.afterWrite被调用，参数为：items[ {} ]", items);
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Object> items) {
		logger.debug("批处理Step监听器LogStepListener.onWriteError被调用，参数为：exception[ {} ], items[ {} ]", exception, items);
	}

	@Override
	public void onSkipInRead(Throwable t) {
		logger.debug("批处理Step监听器LogStepListener.onSkipInRead被调用，参数为：throwable[ {} ]", t);
	}

	@Override
	public void onSkipInWrite(Object item, Throwable t) {
		logger.debug("批处理Step监听器LogStepListener.onSkipInWrite被调用，参数为：item[ {} ], throwable[ {} ]", item, t);
	}

	@Override
	public void onSkipInProcess(Object item, Throwable t) {
		logger.debug("批处理Step监听器LogStepListener.onSkipInProcess被调用，参数为：item[ {} ], throwable[ {} ]", item, t);
	}

}
