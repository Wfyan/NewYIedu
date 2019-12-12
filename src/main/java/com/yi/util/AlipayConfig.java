package com.yi.util;

/**
 * @ClassName: AliPayConfig
 * @Description: 需要传给支付宝SDK的公共基本参数
 * @author: 引用原作者Linn
 * @Date: 2019/12/10 20:42
 */
public class AlipayConfig {

    /**
     * 1.商户appid
     * 这个就是在沙箱环境下你看到你的appId的那一串数字
     */
    public static String APPID = "2016101600701664";

    /**
     * 私钥 pkcs8格式的
     * 这个就是我上面说的应用私钥生成 注意这里是私钥
     */
    public static String RSA_PRIVATE_KEY ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC3J9QBBZLnNNZx82+fTmeS9CpcKMMq+B+3GCJgqT5PwqOspcPpUqZUdprUkA3eddU0gvymewnBpRqvzV9Plv102OBNtz6Ppf+oswdWmBMqzY0wjxe5pYMeyfdhxNHgYgGNxyQBSbKQO3p5FIJ/hs1gNGhmvraypPwVaMNKdb390ceVhNMQ4KlFOansYAsAlxjYz18SZlaDTbRyHhNEPW2eR5vEi4iDbWAbNCSoozJqPhWf/v9ZDxu17S7EcR8vdTxyOULBnLe4KnXgC++S0L0k/cd9OMIIqYLV3OmpVodJg+b0HMI2sqs+xZcO+j/HtuLWIBbP+VrlMhkzpU4MQ3FHAgMBAAECggEAfrbKYO6XROh0WJ/gIOoglDXivKHi7O5/GrBS0Gcm2g3CKScCFIF+2762vcrwHXGOUOcynodPJ67veKNwhmLi9Z06Cep2GPHyn6dEs29BC4LsZKUK+AB/Z6S5RuXhggisJIea7F0tccYEpJJA+rOrkRyRAkx9n7ivQqyZOAGfsWLrPodyclfTE5enon+dLfvX3JFPn/hr9XxYzSOI70IK0cv7jrCI74zhJdkyXfa41ClqURfuxnb9WL288X+pe+7J8xcGAOBAXJiAqywH4+056QqZOe2RQFkI8lY/WOGEbkFKIbNEeYGfi3YS4NIs8Ba6nd3GmFMyKZaFgHZsZT3oYQKBgQD8S/eelYvcYy4hj5nWiIN1mAU28iXuaDbbFpHTpaD1yru6qc7ammIOgabV0nIYAa+fUGO6MyuqqCEpKgR4kLZLfxwh05YLlVZLrNKOWecn3OpkMNta6diVd6Rbs/1a6FluK5ou8IUiCEbPpclpYaN9Oh/LKJbLnWpzIOEdwZqJlwKBgQC52A4q9T2KqcKzySTnOhrdl4qEtwCW0nv5jIgTXGZD2WcMOzIqY7ZnLkYpAcMlfgzB1JOWJQ9OqMsXkVp1jshkuUUEkHf7k91SQtN2K2rnBMhYELKvquq74LrBZjnbueso7MAJrJj/fKrLR3GWn98FCPlxtrLLMUJk/xQthAFr0QKBgQCV9emG30i0hFclJ5++/oF04hknYaLeJB+G9dFTxbz4m7od51TGZsEl8jZiHaYnUsk6nqPIRyYLV8fuGcVyjEFuem0URhmHZQpYDK9SYWmeLhc72jZnwVs07FpLD57l6/lMHKqWf+wCIH1GazpeYuS0SFohfUy0Viqxp7dm4m6inQKBgCcc6rZt0Nr7KYgvID4uA3N5rmSKI2yatg7qXcU9YCSNf9uaJc+4Fq6WlZuRzGF6qvKsa7dg61zRt5SpOdGeEFzqhTUVtrrS/vSOLfUj5Cbk4clvEjxYi3ipLoT/n9O3yF9fnHcsxTKYKVYJHkXmNcjYf69IFU8geenJqZR+wNHRAoGBAOq3GwW52yLeGwK2CdGgKd1Xl+7/JuHGHb11pD5pQzHW7VBaQCjnziNz/zwue4w2+5bXe9Qz5xRFclv+XcGmSfUM3WtgW+tau3oDaoXEnwLrUd/EchICJEX+tsAWpfMRgc2ARv3h2LZRdzbUwNYUzbM6heCdwpL08NfrAti1SmwJ";

    /**
     * 3.支付宝公钥
     * 这个就是你把生成的应用公钥在沙箱网页哪里输入后,就可以查看到支付宝公钥..把看到的支付宝公钥copy过来放这里就ok
     */
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArEo+8IYmtA/JKG633NTJQQOWNGaPckiUMfWxJm3Vx/YTNHkC7beX8d4mWXFNMOuzENzdPGRLh2nWxa4lKFj0sYi1Ksx8/3r0Z+5uQFd2NPWsWZlFEiXr2AtOSjm8satTec9ikm8mcNMjwemVdwB5e2HCpkY0AvlsJ0EziSSMceRYEHMZlkPtFjw0SF2jEj4kH8v+JLCi5fpBraOf+DGDCa4dSocPd+WzoJs1/JFuXTWkZjvlGel2cNNgCdE4q21yVQyjsGAcZuTXjKdB1LLRLa6A5g5N3jdcr2cyRLXcdVkiLnPANNWh+p38nfKOJa6hwGPzVk31b3XGIRWzMBnrcQIDAQAB";

    /**
     * 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
//这个着重讲一下..支付完成后,支付宝会通过这个url请求到你的服务端..
//这个url一定是要公网可以访问才行...如果需要测试的话..我后面有讲到..
//这里你可以先写你本地项目的url 例如:localhost:8080/项目名/访问路径
//    public static String notify_url = "http://2hu4349021.wicp.vip/pay/aliNotify";
    public static String notify_url = "http://172.16.15.3:8080/YIedu_war_exploded/orderInfo/notify_url.do";
//    public static String notify_url = "localhost:8080/alipay/notify_url";

    /**
     * 5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    //这里同上..不做详细说明了..
//    public static String return_url = "http://2hu4349021.wicp.vip/pay/returnUrl";
    public static String return_url = "http://172.16.15.3:8080/YIedu_war_exploded/orderInfo/return_url";

    /**
     * 正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do
     */
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 7.编码
     */
    public static String CHARSET = "UTF-8";

    /**
     * 私钥 pkcs8格式的
     */
    // 8.返回格式
    public static String FORMAT = "json";

    /**
     * //签名方式 加密类型
     */
    public static String SIGNTYPE = "RSA2";

}
