package info.xiaomo.core.network;

import io.netty.channel.ChannelHandler;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qq
 */
@Data
public class NetworkServiceBuilder {

    /**
     * 网络线程池线程数量
     */
    private int bossLoopGroupCount;
    /**
     * 工作线程池线程数量
     */
    private int workerLoopGroupCount;
    /**
     * 监听端口
     */
    private int port;

    /**
     * 网络消费者
     */
    private INetworkConsumer consumer;

    /**
     * 事件监听器
     */
    private INetworkEventListener listener;

    /**
     * 消息池
     */
    private IMessageAndHandler imessageandhandler;

    /**
     * 默认为false
     */
    private boolean isWebSocket = false;

    private boolean ssl;

    private String sslKeyCertChainFile;

    private String sslKeyFile;

    /**
     * 额外的handler
     */
    private List<ChannelHandler> extraHandlers = new ArrayList<>();

    /**
     * 添加一个handler，该handler由外部定义.</br>
     * 注意，所有handler都按照本方法调用顺序添加在默认handler的后面.</br>
     * 也就是说 对于 inbound来，该方法添加的handler是最后执行的，对于outbound该方法添加的handler是最先执行的.</br>
     *
     * @param handler handler
     */
    public void addChannelHandler(ChannelHandler handler) {
        if (handler == null) {
            throw new NullPointerException("指定的handler为空");
        }
        extraHandlers.add(handler);
    }

    /**
     * 創建網絡服務
     * @return 服務實例
     */
    public NetworkServiceImpl createService() {
        return new NetworkServiceImpl(this);
    }

	public int getBossLoopGroupCount() {
		return bossLoopGroupCount;
	}

	public void setBossLoopGroupCount(int bossLoopGroupCount) {
		this.bossLoopGroupCount = bossLoopGroupCount;
	}

	public int getWorkerLoopGroupCount() {
		return workerLoopGroupCount;
	}

	public void setWorkerLoopGroupCount(int workerLoopGroupCount) {
		this.workerLoopGroupCount = workerLoopGroupCount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public INetworkConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(INetworkConsumer consumer) {
		this.consumer = consumer;
	}

	public INetworkEventListener getListener() {
		return listener;
	}

	public void setListener(INetworkEventListener listener) {
		this.listener = listener;
	}

	public IMessageAndHandler getImessageandhandler() {
		return imessageandhandler;
	}

	public void setImessageandhandler(IMessageAndHandler imessageandhandler) {
		this.imessageandhandler = imessageandhandler;
	}

	public boolean isWebSocket() {
		return isWebSocket;
	}

	public void setWebSocket(boolean isWebSocket) {
		this.isWebSocket = isWebSocket;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getSslKeyCertChainFile() {
		return sslKeyCertChainFile;
	}

	public void setSslKeyCertChainFile(String sslKeyCertChainFile) {
		this.sslKeyCertChainFile = sslKeyCertChainFile;
	}

	public String getSslKeyFile() {
		return sslKeyFile;
	}

	public void setSslKeyFile(String sslKeyFile) {
		this.sslKeyFile = sslKeyFile;
	}

	public List<ChannelHandler> getExtraHandlers() {
		return extraHandlers;
	}

	public void setExtraHandlers(List<ChannelHandler> extraHandlers) {
		this.extraHandlers = extraHandlers;
	}
    
    
}
