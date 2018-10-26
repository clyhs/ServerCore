package info.xiaomo.core.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.xiaomo.core.base.concurrent.QueueExecutor;
import info.xiaomo.core.base.concurrent.command.IQueueDriverCommand;
import info.xiaomo.core.base.concurrent.queue.ICommandQueue;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaomo
 */
@Data
@Slf4j
public abstract class AbstractHandler<T> implements IQueueDriverCommand {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

    protected T message;

    protected Object session;

    protected int queueId;

    /**
     * 过滤器
     */
    protected IHandlerFilter filter;

    @Override
    public int getQueueId() {
        return queueId;
    }

    @Override
    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    @Override
    public ICommandQueue<IQueueDriverCommand> getCommandQueue() {
        return null;
    }

    @Override
    public void setCommandQueue(ICommandQueue<IQueueDriverCommand> commandQueue) {

    }

    @Override
    public Object getParam() {
        return session;
    }

    @Override
    public void setParam(Object session) {
        this.session = session;
    }

    @Override
    public void run() {
        try {
            long time = System.currentTimeMillis();
            if (filter != null && !filter.before(this)) {
                return;
            }
            doAction();
            log.warn(this.getClass().getSimpleName() + "耗时：" + (System.currentTimeMillis() - time) + "ms");
            if (filter != null) {
                filter.after(this);
            }
        } catch (Throwable e) {
            log.error("命令执行错误", e);
        }
    }

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	public Object getSession() {
		return session;
	}

	public void setSession(Object session) {
		this.session = session;
	}

	public IHandlerFilter getFilter() {
		return filter;
	}

	public void setFilter(IHandlerFilter filter) {
		this.filter = filter;
	}

	public Logger getLog() {
		return log;
	}

    
}
