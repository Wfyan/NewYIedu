package com.yi.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.yi.entity.CrouseInfo;
import com.yi.entity.OrderInfo;
import com.yi.mapper.CrouseInfoMapper;
import com.yi.mapper.OrderInfoMapper;
import com.yi.service.CrouseInfoService;
import com.yi.service.OrderInfoService;
import com.yi.util.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private CrouseInfoMapper crouseInfoMapper;

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderInfoMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    @Override
    public OrderInfo selectByPrimaryKey(String orderId) {
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderInfo> selectAll() {
        return orderInfoMapper.selectAll();
    }

    @Override
    public List<OrderInfo> multiCriteriaQuery(String cname, Double price, Integer onpay,
                                              String beforeDate, String afterDate, String tecname) {
        return orderInfoMapper.multiCriteriaQuery(cname, price, onpay, beforeDate, afterDate, tecname);
    }

    @Override
    public int count() {
        return orderInfoMapper.count();
    }

    @Override
    public int counts(String cname, Double price, Integer onpay, String beforeDate, String afterDate, String tecname) {
        return orderInfoMapper.counts(cname, price, onpay, beforeDate, afterDate, tecname);
    }

    @Override
    public String order(OrderInfo record) {
        //这里你可以做一些存表操作..具体根据你们自己的业务来操作...
        record.setOrderId("1");
        this.insertSelective(record);
        CrouseInfo crouseInfo = crouseInfoMapper.selectByPrimaryKey(record.getCid());
        String cname = crouseInfo.getCname();
        String price = crouseInfo.getPrice().toString();
        String orderString = "";//这个字符串是用来返回给前端的
//        String orderNo = record.getOrderNum();//这行代码是生成一个商户的订单号..根据你们自己的业务需求去生成就可以了..

        try {
            AlipayConfig alipayConfig= new AlipayConfig(); //实例化上面的那个配置类..
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                    AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                    AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest request  = new AlipayTradeAppPayRequest();

            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

            //业务参数传入,可以传很多，参考API
            //model.setPassbackParams(URLEncoder.encode(request.getBody().toString())); //公用参数（附加数据）
            //对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。如：Iphone6 16G
            model.setBody(cname);
            //商品名称。商品的标题/交易标题/订单标题/订单关键字等。如：大乐透
            model.setSubject(cname);
            //商户订单号(根据业务需求自己生成)。商户网站唯一订单号 。如：70501111111S001111119
            model.setOutTradeNo(record.getOrderId());
            //交易超时时间 这里的30m就是30分钟。该笔订单允许的最晚付款时间，逾期将关闭交易。
            // 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
            // 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
            model.setTimeoutExpress("30m");
            //支付金额 后面保留2位小数点..不能超过2位。订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 。如： 9.00
            model.setTotalAmount(price);
            //销售产品码（固定值） //这个不做多解释..看文档api接口参数解释。销售产品码，商家和支付宝签约的产品码 。如：QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            request.setBizModel(model);
            //异步回调地址（后台）//这里我在上面的aliPayConfig有讲..自己去看
//            request .setNotifyUrl(AlipayConfig.notify_url);

            //同步回调地址（APP）同上
            request.setReturnUrl(AlipayConfig.return_url);

            // 这里和普通的接口调用不同，使用的是sdkExecute
            //返回支付宝订单信息(预处理)
            AlipayTradeAppPayResponse response  = alipayClient.sdkExecute(request);
            //就是orderString 可以直接给APP请求，无需再做处理。
            orderString = response.getBody();
            System.out.println(orderString);

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return orderString;
    }

}
