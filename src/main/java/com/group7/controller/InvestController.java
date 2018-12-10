package com.group7.controller;

import com.group7.entity.InvestmentAmount;
import com.group7.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:InvestController
 * discriptoin:     投资页面显示 和 投资信息
 * author:ZHEN
 * createTime:2018-11-23 21:12
 */
//扫描控制层
@Transactional
@Controller
public class InvestController {

    @Autowired  //依赖注入
    private InvestService investService;

    @Autowired
    private HttpSession session;


    /**
     * 投资选择页面
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/invest")
    public Object invest(@RequestParam Map map){
        Map tempMap = new HashMap();
        map.put("pageSize",5);   //定义一页 页数
        List<Map> inves = investService.getInves(map);  //获取查询信息
        Map invesCount = investService.getInvesCount(map);  //获取页码信息
        tempMap.put("inves",inves);
        tempMap.put("invesCount",invesCount);
        //System.out.println(inves);
        return tempMap;
    }

    /**
     * 投资页面
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/investment")
    public Object investment(@RequestParam Map map){
        Map investment = investService.investment(map);
        System.out.println(investment);
        return investment;
    }

    /**
     * 贷款 投资详情信息
     * @param invest
     * @return
     */
    @ResponseBody
    @RequestMapping("/investmentAmount")
    public Object investmentAmount(@RequestBody InvestmentAmount invest){
        System.out.println(invest.toString());
        int i = investService.investmentAmount(invest);//添加投资信息
        System.out.println(i);
        if(i>0){
            int i1 = investService.investmentMoeny(invest);//修该投资表投资金额
            System.out.println(i1+"------------");
        }
        return i;
    }

    /**
     * 查询投资信息  不能重复投资
     * @param loansId
     * @return
     */
    @ResponseBody
    @RequestMapping("/investmentVerify")
    public Object investmentVerify(Integer loansId){
        Object userSession = session.getAttribute("userSession");
        String userName =userSession+"";
        Map map = investService.investmentVerify(userName, loansId);
        return map;
    }

    /**
     * 查询投资信息  不能重复投资
     * @param loansId
     * @return
     */
    @ResponseBody
    @RequestMapping("/investmentInformation")
    public Object investmentInformation(Integer loansId){
       // System.out.println(loansId);
        List<Map> maps = investService.investmentInformation(loansId);
      //  System.out.println(maps);
        return maps;
    }



















}
