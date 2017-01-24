package core;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;


/**
 * Created by lolik on 31.03.2016.
 */
public class BMProxyManager {

    private static ThreadLocal<BrowserMobProxy> SERVER = new ThreadLocal<BrowserMobProxy>();

    public static BrowserMobProxy server(){
        return SERVER.get();
    }

    public static Proxy getProxy(){
        return ClientUtil.createSeleniumProxy(server());
    }

    public static void startServer() {
        SERVER.set(new BrowserMobProxyServer());
        server().setTrustAllServers(true);
        server().start(0);
    }

    public static void stopServer() {
        if (server() != null) {
            if (server().isStarted()) {
                server().stop();
                SERVER.set(null);
            }
        }
    }

}