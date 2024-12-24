package run.halo.starter;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * AlipayInitializer
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @version 1.0
 * 2024/12/22
 */
@Component
public class AlipayInitializer {

    @PostConstruct
    public void init() {
        // 设置参数（全局只需设置一次）
        Factory.setOptions(getAlipayOptions());
    }

    private Config getAlipayOptions() {
        Config config = new Config();
        config.protocol = "https";
        // config.gatewayHost = "openapi.alipay.com";
        config.gatewayHost = "openapi-sandbox.dl.alipaydev.com/gateway.do";
        config.signType = "RSA2";

        config.appId = "";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
        // config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
        // config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
        // config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = "";

        //可设置异步通知接收服务地址（可选）
        // config.notifyUrl = "<-- 请填写您的支付类接口异步通知接收服务地址，例如：https://www.test.com/callback -->";

        return config;
    }
}
